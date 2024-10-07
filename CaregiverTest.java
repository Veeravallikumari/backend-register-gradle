package com.cts.Registration.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CaregiverTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Caregiver#Caregiver()}
     *   <li>{@link Caregiver#setAddress(String)}
     *   <li>{@link Caregiver#setEmailId(String)}
     *   <li>{@link Caregiver#setFirstName(String)}
     *   <li>{@link Caregiver#setId(int)}
     *   <li>{@link Caregiver#setLastName(String)}
     *   <li>{@link Caregiver#setPhone(int)}
     *   <li>{@link Caregiver#setStatus(String)}
     *   <li>{@link Caregiver#toString()}
     *   <li>{@link Caregiver#getAddress()}
     *   <li>{@link Caregiver#getEmailId()}
     *   <li>{@link Caregiver#getFirstName()}
     *   <li>{@link Caregiver#getId()}
     *   <li>{@link Caregiver#getLastName()}
     *   <li>{@link Caregiver#getPhone()}
     *   <li>{@link Caregiver#getStatus()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Caregiver actualCaregiver = new Caregiver();
        actualCaregiver.setAddress("42 Main St");
        actualCaregiver.setEmailId("42");
        actualCaregiver.setFirstName("Jane");
        actualCaregiver.setId(1);
        actualCaregiver.setLastName("Doe");
        actualCaregiver.setPhone(1);
        actualCaregiver.setStatus("Status");
        String actualToStringResult = actualCaregiver.toString();
        assertEquals("42 Main St", actualCaregiver.getAddress());
        assertEquals("42", actualCaregiver.getEmailId());
        assertEquals("Jane", actualCaregiver.getFirstName());
        assertEquals(1, actualCaregiver.getId());
        assertEquals("Doe", actualCaregiver.getLastName());
        assertEquals(1, actualCaregiver.getPhone());
        assertEquals("Status", actualCaregiver.getStatus());
        assertEquals(
                "Caregiver [id=1, firstName=Jane, lastName=Doe, emailId=42, address=42 Main St, phone=1," + " status=Status]",
                actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Caregiver#Caregiver(int, String, String, String, String, int, String)}
     *   <li>{@link Caregiver#setAddress(String)}
     *   <li>{@link Caregiver#setEmailId(String)}
     *   <li>{@link Caregiver#setFirstName(String)}
     *   <li>{@link Caregiver#setId(int)}
     *   <li>{@link Caregiver#setLastName(String)}
     *   <li>{@link Caregiver#setPhone(int)}
     *   <li>{@link Caregiver#setStatus(String)}
     *   <li>{@link Caregiver#toString()}
     *   <li>{@link Caregiver#getAddress()}
     *   <li>{@link Caregiver#getEmailId()}
     *   <li>{@link Caregiver#getFirstName()}
     *   <li>{@link Caregiver#getId()}
     *   <li>{@link Caregiver#getLastName()}
     *   <li>{@link Caregiver#getPhone()}
     *   <li>{@link Caregiver#getStatus()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Caregiver actualCaregiver = new Caregiver(1, "Jane", "Doe", "42", "42 Main St", 1, "Status");
        actualCaregiver.setAddress("42 Main St");
        actualCaregiver.setEmailId("42");
        actualCaregiver.setFirstName("Jane");
        actualCaregiver.setId(1);
        actualCaregiver.setLastName("Doe");
        actualCaregiver.setPhone(1);
        actualCaregiver.setStatus("Status");
        String actualToStringResult = actualCaregiver.toString();
        assertEquals("42 Main St", actualCaregiver.getAddress());
        assertEquals("42", actualCaregiver.getEmailId());
        assertEquals("Jane", actualCaregiver.getFirstName());
        assertEquals(1, actualCaregiver.getId());
        assertEquals("Doe", actualCaregiver.getLastName());
        assertEquals(1, actualCaregiver.getPhone());
        assertEquals("Status", actualCaregiver.getStatus());
        assertEquals(
                "Caregiver [id=1, firstName=Jane, lastName=Doe, emailId=42, address=42 Main St, phone=1," + " status=Status]",
                actualToStringResult);
    }
}

