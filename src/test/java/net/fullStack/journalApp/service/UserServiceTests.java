package net.fullStack.journalApp.service;

import net.fullStack.journalApp.entity.User;
import net.fullStack.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    @Test
    public void testFindByUserName(){
        assertEquals(4, 3+1);
        assertNotNull(userRepository.findByUserName("ram"));
        assertTrue(5>3);
    }

    @ParameterizedTest
    @ValueSource(strings ={
            "ram",
            "shyam",
            "ghanshyam"
    })
    public void test(String name){
        User user1 = userRepository.findByUserName(name);
        assertTrue(!user1.getJournalEntries().isEmpty());
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 2",
            "2, 2, 4",
            "4, 2, 6"
    }
    )
    public void test1(int a, int b, int expected){
        assertEquals(expected, a + b );
    }
}
