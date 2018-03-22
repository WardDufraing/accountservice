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
public class AccountRestControllerTest {

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
    public void testGetGuitarChordsList() {
        String expected = "[{\"id\":1,\"name\":\"C\",\"category\":\"C\",\"statusString\":[\"open\",\"open\",\"open\",\"open\",\"open\",\"closed\"],\"chords\":[{\"fret\":3,\"string\":5,\"barre\":null},{\"fret\":2,\"string\":4,\"barre\":null},{\"fret\":1,\"string\":2,\"barre\":null}]},{\"id\":2,\"name\":\"Bm\",\"category\":\"B\",\"statusString\":[\"open\",\"open\",\"open\",\"open\",\"open\",\"closed\"],\"chords\":[{\"fret\":2,\"string\":0,\"barre\":{\"from\":1,\"to\":6}},{\"fret\":3,\"string\":2,\"barre\":null},{\"fret\":4,\"string\":3,\"barre\":null},{\"fret\":4,\"string\":4,\"barre\":null}]},{\"id\":3,\"name\":\"B\",\"category\":\"B\",\"statusString\":[\"open\",\"open\",\"open\",\"open\",\"closed\",\"closed\"],\"chords\":[{\"fret\":2,\"string\":1,\"barre\":null},{\"fret\":4,\"string\":2,\"barre\":null},{\"fret\":4,\"string\":3,\"barre\":null},{\"fret\":4,\"string\":4,\"barre\":null}]}]";
        try {
            MvcResult result = mvc.perform(get("/guitarchords")).andReturn();
            Assert.assertEquals(expected,result.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/
}