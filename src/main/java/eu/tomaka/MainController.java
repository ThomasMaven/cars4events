package eu.tomaka;

import eu.tomaka.model.Person;
import eu.tomaka.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tomek on 01.04.18.
 */
@SpringBootApplication
@Controller
@EnableAutoConfiguration
@RequestMapping("/")
public class MainController {


    private Facebook facebook;
    private ConnectionRepository connectionRepository;
    private PersonService personService;

    public MainController(Facebook facebook, ConnectionRepository connectionRepository, PersonService personService) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
        this.personService = personService;
    }

    @GetMapping
    public String home(Model model) {
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null || !facebook.isAuthorized()) {
              return "redirect:/connect/facebook";
        }
        model.addAttribute("authorized", facebook.isAuthorized());
        String[] fields = {"id", "email", "first_name", "last_name"};
        User profile = facebook.fetchObject("me", User.class, fields);
        model.addAttribute("id", profile.getId());
        model.addAttribute("first_name", profile.getFirstName());
        model.addAttribute("last_name", profile.getLastName());
        model.addAttribute("email", profile.getEmail());
        Person person = new Person(profile.getFirstName(), profile.getLastName(), profile.getId(), profile.getEmail());
        personService.putPerson(person);
        return "hello";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainController.class, args);
    }
}
