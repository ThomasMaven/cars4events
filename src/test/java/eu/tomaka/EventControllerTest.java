package eu.tomaka;

import eu.tomaka.controller.EventController;
import eu.tomaka.service.EventService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class EventControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private EventController eventController;

    @Mock
    private EventService eventService;

    TestEvents testEvents = new TestEvents();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(eventController).build();
    }

    @Test
    public void testGetEventList() throws Exception {

        when(eventService.findAll()).thenReturn(testEvents.getEvents(3));

        mockMvc.perform(get("/api/v1/event")).andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$", hasSize(3)))
            .andExpect(jsonPath("$[0].departure", is("01.01.2018")))
            .andExpect(jsonPath("$[0].back", is("02.01.2018")))
            .andExpect(jsonPath("$[0].personList", Matchers.hasSize(4)));
        verify(eventService).findAll();
        verifyNoMoreInteractions(eventService);
    }

}
