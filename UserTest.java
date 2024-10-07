package com.cts.Registration.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class UserTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User()}
     *   <li>{@link User#setAddress(String)}
     *   <li>{@link User#setCaregiver(List)}
     *   <li>{@link User#setConfirmPassword(String)}
     *   <li>{@link User#setEmailId(String)}
     *   <li>{@link User#setId(int)}
     *   <li>{@link User#setPassword(String)}
     *   <li>{@link User#setfirstName(String)}
     *   <li>{@link User#setlatName(String)}
     *   <li>{@link User#getAddress()}
     *   <li>{@link User#getCaregiver()}
     *   <li>{@link User#getConfirmPassword()}
     *   <li>{@link User#getEmailId()}
     *   <li>{@link User#getId()}
     *   <li>{@link User#getPassword()}
     * </ul>
     */
    @Test
    void testConstructor() {
        User actualUser = new User();
        actualUser.setAddress("42 Main St");
        ArrayList<Caregiver> caregiverList = new ArrayList<>();
        actualUser.setCaregiver(caregiverList);
        actualUser.setConfirmPassword("iloveyou");
        actualUser.setEmailId("42");
        actualUser.setId(1);
        actualUser.setPassword("iloveyou");
        actualUser.setfirstName("Jane");
        actualUser.setlatName("Doe");
        assertEquals("42 Main St", actualUser.getAddress());
        assertSame(caregiverList, actualUser.getCaregiver());
        assertEquals("iloveyou", actualUser.getConfirmPassword());
        assertEquals("42", actualUser.getEmailId());
        assertEquals(1, actualUser.getId());
        assertEquals("iloveyou", actualUser.getPassword());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User(int, String, String, String, String, String, String, List)}
     *   <li>{@link User#setAddress(String)}
     *   <li>{@link User#setCaregiver(List)}
     *   <li>{@link User#setConfirmPassword(String)}
     *   <li>{@link User#setEmailId(String)}
     *   <li>{@link User#setId(int)}
     *   <li>{@link User#setPassword(String)}
     *   <li>{@link User#setfirstName(String)}
     *   <li>{@link User#setlatName(String)}
     *   <li>{@link User#getAddress()}
     *   <li>{@link User#getCaregiver()}
     *   <li>{@link User#getConfirmPassword()}
     *   <li>{@link User#getEmailId()}
     *   <li>{@link User#getId()}
     *   <li>{@link User#getPassword()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        ArrayList<Caregiver> caregiverList = new ArrayList<>();
        User actualUser = new User(1, "Jane", "Doe", "42", "iloveyou", "iloveyou", "42 Main St", caregiverList);
        actualUser.setAddress("42 Main St");
        ArrayList<Caregiver> caregiverList1 = new ArrayList<>();
        actualUser.setCaregiver(caregiverList1);
        actualUser.setConfirmPassword("iloveyou");
        actualUser.setEmailId("42");
        actualUser.setId(1);
        actualUser.setPassword("iloveyou");
        actualUser.setfirstName("Jane");
        actualUser.setlatName("Doe");
        assertEquals("42 Main St", actualUser.getAddress());
        List<Caregiver> caregiver = actualUser.getCaregiver();
        assertSame(caregiverList1, caregiver);
        assertEquals(caregiverList, caregiver);
        assertEquals("iloveyou", actualUser.getConfirmPassword());
        assertEquals("42", actualUser.getEmailId());
        assertEquals(1, actualUser.getId());
        assertEquals("iloveyou", actualUser.getPassword());
    }

    /**
     * Method under test: {@link User#getfirstName()}
     */
    @Test
    void testGetfirstName() {
        assertNull((new User()).getfirstName());
    }

    /**
     * Method under test: {@link User#getlastName()}
     */
    @Test
    void testGetlastName() {
        assertNull((new User()).getlastName());
    }
}

