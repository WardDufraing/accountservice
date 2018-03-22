package kdg.superteam.userservice.services;

import kdg.superteam.userservice.dom.Account;
import kdg.superteam.userservice.dom.Student;
import kdg.superteam.userservice.repository.AccountRepository;
import kdg.superteam.userservice.repository.StudentRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

    @MockBean
    private IAccountService accountService;

    @MockBean
    private StudentRepository studentRepository;

    @Before
    public void setup() {
        String email = "test@test.be";
        Student testAccount1 = new Student();
        testAccount1.setEmail(email);
        testAccount1.setFirstName("tester");
        testAccount1.setLastName("test");

        given(studentRepository.findByEmail(email)).willReturn(testAccount1);
    }

    @Test
    public void testGetStudentByEmail(){
        Student studentResult = accountService.getStudentByEmail("test@test.be");

        Assert.assertEquals("test@test.be",studentResult.getEmail());
        Assert.assertEquals("tester",studentResult.getFirstName());
        Assert.assertEquals("test",studentResult.getLastName());
    }


}