package com.nnk.springboot.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest(classes = {User.class})
class UserTest {

    private final User user = new User(1, "username", "Password1*", "fullname", "role");
    private final User user1 = new User(1, "username", "Password1*", "fullname", "role");
    private final User user2 = new User(2, "username", "Password1*", "fullname", "role");

    @Test
    void testToString() {
        assertEquals("User{id = 1, username = 'username', password = 'Password1*', fullname = 'fullname', role = 'role'}", user.toString());
    }

    @Test
    void testEquals() {
        assertEquals(user, user1);
        assertNotEquals(user, user2);
    }
}