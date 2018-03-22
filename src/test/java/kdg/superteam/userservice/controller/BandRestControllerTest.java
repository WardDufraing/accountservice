package kdg.superteam.userservice.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BandRestControllerTest {

    @Autowired
    private WebApplicationContext applicationContext;
    private MockMvc mvc;

    @Before
    public void setup() {
        mvc= MockMvcBuilders
                .webAppContextSetup(applicationContext)
                .build();
    }
/*
    @Test
    public void testGetPianoChordsList() {
        String expected = "[{\"id\":1,\"name\":\"Cm\",\"key\":\"C\",\"notes\":[\"C\",\"E\",\"G\"]},{\"id\":2,\"name\":\"Em\",\"key\":\"E\",\"notes\":[\"E\",\"G\",\"B\"]},{\"id\":3,\"name\":\"B\",\"key\":\"B\",\"notes\":[\"D#\",\"F#\",\"B\"]}]";
        try {
            MvcResult result = mvc.perform(get("/pianochords")).andReturn();
            Assert.assertEquals(expected, result.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/
}