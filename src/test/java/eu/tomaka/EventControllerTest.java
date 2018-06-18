package eu.tomaka;

import eu.tomaka.controller.EventController;
import eu.tomaka.model.Event;
import eu.tomaka.model.Person;
import eu.tomaka.service.EventService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private EventController eventController;

    @Mock
    private EventService eventService;

    List<Person> mockedPersonList = getMockedPersonList();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(eventController).build();
    }

    @Test
    public void testGetEventList() throws Exception {
        List<Event> events = new ArrayList<>();
        for(int i=0;i<3;i++) {
            Event tmpEvent = new Event();
            tmpEvent.setDeparture("01.01.2018");
            tmpEvent.setBack("02.01.2018");
            tmpEvent.setPersonList(mockedPersonList);
            events.add(tmpEvent);
        }
        when(eventService.findAll()).thenReturn(events);
        mockMvc.perform(get("/api/v1/event")).andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$", hasSize(3)))
            .andExpect(jsonPath("$[0].departure", is("01.01.2018")))
            .andExpect(jsonPath("$[0].back", is("02.01.2018")))
            .andExpect(jsonPath("$[0].personList", Matchers.hasSize(4)));
        verify(eventService).findAll();
        verifyNoMoreInteractions(eventService);
    }

    private List<Person> getMockedPersonList(){
        List<Person> personList = new ArrayList<>();
        for(int i=0; i<4; i++) {
            Person person = new Person("name" + i, "surname" + i, "00" + i, i + "@example.com" );
            personList.add(person);
        }
        return personList;
    }
}
