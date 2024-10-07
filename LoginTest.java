package com.cts.Registration.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LoginTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Login#Login(String, String)}
     *   <li>{@link Login#setPassword(String)}
     *   <li>{@link Login#setUserName(String)}
     *   <li>{@link Login#getPassword()}
     *   <li>{@link Login#getUserName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Login actualLogin = new Login("janedoe", "iloveyou");
        actualLogin.setPassword("iloveyou");
        actualLogin.setUserName("janedoe");
        assertEquals("iloveyou", actualLogin.getPassword());
        assertEquals("janedoe", actualLogin.getUserName());
    }
}

