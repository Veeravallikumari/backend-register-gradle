package com.cts.Registration.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cts.Registration.model.Caregiver;
import com.cts.Registration.model.User;
import com.cts.Registration.repository.CaregiverRepository;
import com.cts.Registration.repository.RegistrationRepository;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {RegistrationService.class})
@ExtendWith(SpringExtension.class)
class RegistrationServiceTest {
    @MockBean
    private CaregiverRepository caregiverRepository;

    @MockBean
    private RegistrationRepository registrationRepository;

    @Autowired
    private RegistrationService registrationService;

    /**
     * Method under test: {@link RegistrationService#saveUser(User)}
     */
    @Test
    void testSaveUser() {
        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregiver(new ArrayList<>());
        user.setConfirmPassword("iloveyou");
        user.setEmailId("42");
        user.setId(1);
        user.setPassword("iloveyou");
        user.setfirstName("Jane");
        user.setlatName("Doe");
        when(registrationRepository.save((User) any())).thenReturn(user);

        User user1 = new User();
        user1.setAddress("42 Main St");
        user1.setCaregiver(new ArrayList<>());
        user1.setConfirmPassword("iloveyou");
        user1.setEmailId("42");
        user1.setId(1);
        user1.setPassword("iloveyou");
        user1.setfirstName("Jane");
        user1.setlatName("Doe");
        assertSame(user, registrationService.saveUser(user1));
        verify(registrationRepository).save((User) any());
    }

    /**
     * Method under test: {@link RegistrationService#saveUser(User)}
     */
    @Test
    void testSaveUser2() {
        when(registrationRepository.save((User) any())).thenThrow(new RuntimeException());

        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregiver(new ArrayList<>());
        user.setConfirmPassword("iloveyou");
        user.setEmailId("42");
        user.setId(1);
        user.setPassword("iloveyou");
        user.setfirstName("Jane");
        user.setlatName("Doe");
        assertThrows(RuntimeException.class, () -> registrationService.saveUser(user));
        verify(registrationRepository).save((User) any());
    }

    /**
     * Method under test: {@link RegistrationService#fetchUserByEmailId(String)}
     */
    @Test
    void testFetchUserByEmailId() {
        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregiver(new ArrayList<>());
        user.setConfirmPassword("iloveyou");
        user.setEmailId("42");
        user.setId(1);
        user.setPassword("iloveyou");
        user.setfirstName("Jane");
        user.setlatName("Doe");
        when(registrationRepository.findByEmailId((String) any())).thenReturn(user);
        assertSame(user, registrationService.fetchUserByEmailId("jane.doe@example.org"));
        verify(registrationRepository).findByEmailId((String) any());
    }

    /**
     * Method under test: {@link RegistrationService#fetchUserByEmailId(String)}
     */
    @Test
    void testFetchUserByEmailId2() {
        when(registrationRepository.findByEmailId((String) any())).thenThrow(new RuntimeException());
        assertThrows(RuntimeException.class, () -> registrationService.fetchUserByEmailId("jane.doe@example.org"));
        verify(registrationRepository).findByEmailId((String) any());
    }

    /**
     * Method under test: {@link RegistrationService#getUserById(int)}
     */
    @Test
    void testGetUserById() {
        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregiver(new ArrayList<>());
        user.setConfirmPassword("iloveyou");
        user.setEmailId("42");
        user.setId(1);
        user.setPassword("iloveyou");
        user.setfirstName("Jane");
        user.setlatName("Doe");
        when(registrationRepository.getReferenceById((Integer) any())).thenReturn(user);
        assertSame(user, registrationService.getUserById(1));
        verify(registrationRepository).getReferenceById((Integer) any());
    }

    /**
     * Method under test: {@link RegistrationService#getUserById(int)}
     */
    @Test
    void testGetUserById2() {
        when(registrationRepository.getReferenceById((Integer) any())).thenThrow(new RuntimeException());
        assertThrows(RuntimeException.class, () -> registrationService.getUserById(1));
        verify(registrationRepository).getReferenceById((Integer) any());
    }

    /**
     * Method under test: {@link RegistrationService#assignCareGiver(int, int)}
     */
    @Test
    void testAssignCareGiver() {
        Caregiver caregiver = new Caregiver();
        caregiver.setAddress("42 Main St");
        caregiver.setEmailId("42");
        caregiver.setFirstName("Jane");
        caregiver.setId(1);
        caregiver.setLastName("Doe");
        caregiver.setPhone(1);
        caregiver.setStatus("Status");
        Optional<Caregiver> ofResult = Optional.of(caregiver);
        when(caregiverRepository.findById((Integer) any())).thenReturn(ofResult);

        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregiver(new ArrayList<>());
        user.setConfirmPassword("iloveyou");
        user.setEmailId("42");
        user.setId(1);
        user.setPassword("iloveyou");
        user.setfirstName("Jane");
        user.setlatName("Doe");

        User user1 = new User();
        user1.setAddress("42 Main St");
        user1.setCaregiver(new ArrayList<>());
        user1.setConfirmPassword("iloveyou");
        user1.setEmailId("42");
        user1.setId(1);
        user1.setPassword("iloveyou");
        user1.setfirstName("Jane");
        user1.setlatName("Doe");
        when(registrationRepository.save((User) any())).thenReturn(user1);
        when(registrationRepository.getReferenceById((Integer) any())).thenReturn(user);
        Caregiver actualAssignCareGiverResult = registrationService.assignCareGiver(123, 123);
        assertSame(caregiver, actualAssignCareGiverResult);
        assertEquals("Assigned", actualAssignCareGiverResult.getStatus());
        verify(caregiverRepository).findById((Integer) any());
        verify(registrationRepository).getReferenceById((Integer) any());
        verify(registrationRepository).save((User) any());
    }

    /**
     * Method under test: {@link RegistrationService#assignCareGiver(int, int)}
     */
    @Test
    void testAssignCareGiver2() {
        Caregiver caregiver = new Caregiver();
        caregiver.setAddress("42 Main St");
        caregiver.setEmailId("42");
        caregiver.setFirstName("Jane");
        caregiver.setId(1);
        caregiver.setLastName("Doe");
        caregiver.setPhone(1);
        caregiver.setStatus("Status");
        Optional<Caregiver> ofResult = Optional.of(caregiver);
        when(caregiverRepository.findById((Integer) any())).thenReturn(ofResult);

        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregiver(new ArrayList<>());
        user.setConfirmPassword("iloveyou");
        user.setEmailId("42");
        user.setId(1);
        user.setPassword("iloveyou");
        user.setfirstName("Jane");
        user.setlatName("Doe");
        when(registrationRepository.save((User) any())).thenThrow(new RuntimeException());
        when(registrationRepository.getReferenceById((Integer) any())).thenReturn(user);
        assertThrows(RuntimeException.class, () -> registrationService.assignCareGiver(123, 123));
        verify(caregiverRepository).findById((Integer) any());
        verify(registrationRepository).getReferenceById((Integer) any());
        verify(registrationRepository).save((User) any());
    }

    /**
     * Method under test: {@link RegistrationService#assignCareGiver(int, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAssignCareGiver3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at com.cts.Registration.service.RegistrationService.assignCareGiver(RegistrationService.java:42)
        //   See https://diff.blue/R013 to resolve this issue.

        when(caregiverRepository.findById((Integer) any())).thenReturn(Optional.empty());

        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregiver(new ArrayList<>());
        user.setConfirmPassword("iloveyou");
        user.setEmailId("42");
        user.setId(1);
        user.setPassword("iloveyou");
        user.setfirstName("Jane");
        user.setlatName("Doe");

        User user1 = new User();
        user1.setAddress("42 Main St");
        user1.setCaregiver(new ArrayList<>());
        user1.setConfirmPassword("iloveyou");
        user1.setEmailId("42");
        user1.setId(1);
        user1.setPassword("iloveyou");
        user1.setfirstName("Jane");
        user1.setlatName("Doe");
        when(registrationRepository.save((User) any())).thenReturn(user1);
        when(registrationRepository.getReferenceById((Integer) any())).thenReturn(user);
        registrationService.assignCareGiver(123, 123);
    }
}

