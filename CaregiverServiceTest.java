package com.cts.Registration.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cts.Registration.model.Caregiver;
import com.cts.Registration.repository.CaregiverRepository;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CaregiverService.class})
@ExtendWith(SpringExtension.class)
class CaregiverServiceTest {
    @MockBean
    private CaregiverRepository caregiverRepository;

    @Autowired
    private CaregiverService caregiverService;

    /**
     * Method under test: {@link CaregiverService#saveCaregiver(Caregiver)}
     */
    @Test
    void testSaveCaregiver() {
        Caregiver caregiver = new Caregiver();
        caregiver.setAddress("42 Main St");
        caregiver.setEmailId("42");
        caregiver.setFirstName("Jane");
        caregiver.setId(1);
        caregiver.setLastName("Doe");
        caregiver.setPhone(1);
        caregiver.setStatus("Status");
        when(caregiverRepository.save((Caregiver) any())).thenReturn(caregiver);

        Caregiver caregiver1 = new Caregiver();
        caregiver1.setAddress("42 Main St");
        caregiver1.setEmailId("42");
        caregiver1.setFirstName("Jane");
        caregiver1.setId(1);
        caregiver1.setLastName("Doe");
        caregiver1.setPhone(1);
        caregiver1.setStatus("Status");
        assertSame(caregiver, caregiverService.saveCaregiver(caregiver1));
        verify(caregiverRepository).save((Caregiver) any());
    }

    /**
     * Method under test: {@link CaregiverService#fetchCaregiverList()}
     */
    @Test
    void testFetchCaregiverList() {
        ArrayList<Caregiver> caregiverList = new ArrayList<>();
        when(caregiverRepository.findAll()).thenReturn(caregiverList);
        List<Caregiver> actualFetchCaregiverListResult = caregiverService.fetchCaregiverList();
        assertSame(caregiverList, actualFetchCaregiverListResult);
        assertTrue(actualFetchCaregiverListResult.isEmpty());
        verify(caregiverRepository).findAll();
    }

    /**
     * Method under test: {@link CaregiverService#fetchCaregiverById(int)}
     */
    @Test
    void testFetchCaregiverById() {
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
        assertSame(caregiver, caregiverService.fetchCaregiverById(1));
        verify(caregiverRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link CaregiverService#fetchCaregiverById(int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFetchCaregiverById2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at com.cts.Registration.service.CaregiverService.fetchCaregiverById(CaregiverService.java:36)
        //   See https://diff.blue/R013 to resolve this issue.

        when(caregiverRepository.findById((Integer) any())).thenReturn(Optional.empty());
        caregiverService.fetchCaregiverById(1);
    }

    /**
     * Method under test: {@link CaregiverService#deleteCaregiverById(int)}
     */
    @Test
    void testDeleteCaregiverById() {
        doNothing().when(caregiverRepository).deleteById((Integer) any());
        caregiverService.deleteCaregiverById(1);
        verify(caregiverRepository).deleteById((Integer) any());
    }

    /**
     * Method under test: {@link CaregiverService#updateCaregiver(int, Caregiver)}
     */
    @Test
    void testUpdateCaregiver() {
        Caregiver caregiver = new Caregiver();
        caregiver.setAddress("42 Main St");
        caregiver.setEmailId("42");
        caregiver.setFirstName("Jane");
        caregiver.setId(1);
        caregiver.setLastName("Doe");
        caregiver.setPhone(1);
        caregiver.setStatus("Status");
        Optional<Caregiver> ofResult = Optional.of(caregiver);

        Caregiver caregiver1 = new Caregiver();
        caregiver1.setAddress("42 Main St");
        caregiver1.setEmailId("42");
        caregiver1.setFirstName("Jane");
        caregiver1.setId(1);
        caregiver1.setLastName("Doe");
        caregiver1.setPhone(1);
        caregiver1.setStatus("Status");
        when(caregiverRepository.save((Caregiver) any())).thenReturn(caregiver1);
        when(caregiverRepository.findById((Integer) any())).thenReturn(ofResult);

        Caregiver caregiver2 = new Caregiver();
        caregiver2.setAddress("42 Main St");
        caregiver2.setEmailId("42");
        caregiver2.setFirstName("Jane");
        caregiver2.setId(1);
        caregiver2.setLastName("Doe");
        caregiver2.setPhone(1);
        caregiver2.setStatus("Status");
        assertSame(caregiver1, caregiverService.updateCaregiver(1, caregiver2));
        verify(caregiverRepository).save((Caregiver) any());
        verify(caregiverRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link CaregiverService#updateCaregiver(int, Caregiver)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateCaregiver2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at com.cts.Registration.service.CaregiverService.updateCaregiver(CaregiverService.java:44)
        //   See https://diff.blue/R013 to resolve this issue.

        Caregiver caregiver = new Caregiver();
        caregiver.setAddress("42 Main St");
        caregiver.setEmailId("42");
        caregiver.setFirstName("Jane");
        caregiver.setId(1);
        caregiver.setLastName("Doe");
        caregiver.setPhone(1);
        caregiver.setStatus("Status");
        when(caregiverRepository.save((Caregiver) any())).thenReturn(caregiver);
        when(caregiverRepository.findById((Integer) any())).thenReturn(Optional.empty());

        Caregiver caregiver1 = new Caregiver();
        caregiver1.setAddress("42 Main St");
        caregiver1.setEmailId("42");
        caregiver1.setFirstName("Jane");
        caregiver1.setId(1);
        caregiver1.setLastName("Doe");
        caregiver1.setPhone(1);
        caregiver1.setStatus("Status");
        caregiverService.updateCaregiver(1, caregiver1);
    }

    /**
     * Method under test: {@link CaregiverService#updateCaregiver(int, Caregiver)}
     */
    @Test
    void testUpdateCaregiver3() {
        Caregiver caregiver = new Caregiver();
        caregiver.setAddress("42 Main St");
        caregiver.setEmailId("42");
        caregiver.setFirstName("Jane");
        caregiver.setId(1);
        caregiver.setLastName("Doe");
        caregiver.setPhone(1);
        caregiver.setStatus("Status");
        Optional<Caregiver> ofResult = Optional.of(caregiver);

        Caregiver caregiver1 = new Caregiver();
        caregiver1.setAddress("42 Main St");
        caregiver1.setEmailId("42");
        caregiver1.setFirstName("Jane");
        caregiver1.setId(1);
        caregiver1.setLastName("Doe");
        caregiver1.setPhone(1);
        caregiver1.setStatus("Status");
        when(caregiverRepository.save((Caregiver) any())).thenReturn(caregiver1);
        when(caregiverRepository.findById((Integer) any())).thenReturn(ofResult);
        Caregiver caregiver2 = mock(Caregiver.class);
        when(caregiver2.getPhone()).thenReturn(1);
        when(caregiver2.getStatus()).thenReturn("");
        when(caregiver2.getAddress()).thenReturn("42 Main St");
        when(caregiver2.getEmailId()).thenReturn("42");
        when(caregiver2.getLastName()).thenReturn("Doe");
        when(caregiver2.getFirstName()).thenReturn("Jane");
        doNothing().when(caregiver2).setAddress((String) any());
        doNothing().when(caregiver2).setEmailId((String) any());
        doNothing().when(caregiver2).setFirstName((String) any());
        doNothing().when(caregiver2).setId(anyInt());
        doNothing().when(caregiver2).setLastName((String) any());
        doNothing().when(caregiver2).setPhone(anyInt());
        doNothing().when(caregiver2).setStatus((String) any());
        caregiver2.setAddress("42 Main St");
        caregiver2.setEmailId("42");
        caregiver2.setFirstName("Jane");
        caregiver2.setId(1);
        caregiver2.setLastName("Doe");
        caregiver2.setPhone(1);
        caregiver2.setStatus("Status");
        assertSame(caregiver1, caregiverService.updateCaregiver(1, caregiver2));
        verify(caregiverRepository).save((Caregiver) any());
        verify(caregiverRepository).findById((Integer) any());
        verify(caregiver2, atLeast(1)).getPhone();
        verify(caregiver2, atLeast(1)).getAddress();
        verify(caregiver2, atLeast(1)).getEmailId();
        verify(caregiver2, atLeast(1)).getFirstName();
        verify(caregiver2, atLeast(1)).getLastName();
        verify(caregiver2).getStatus();
        verify(caregiver2).setAddress((String) any());
        verify(caregiver2).setEmailId((String) any());
        verify(caregiver2).setFirstName((String) any());
        verify(caregiver2).setId(anyInt());
        verify(caregiver2).setLastName((String) any());
        verify(caregiver2).setPhone(anyInt());
        verify(caregiver2).setStatus((String) any());
    }

    /**
     * Method under test: {@link CaregiverService#updateCaregiver(int, Caregiver)}
     */
    @Test
    void testUpdateCaregiver4() {
        Caregiver caregiver = new Caregiver();
        caregiver.setAddress("42 Main St");
        caregiver.setEmailId("42");
        caregiver.setFirstName("Jane");
        caregiver.setId(1);
        caregiver.setLastName("Doe");
        caregiver.setPhone(1);
        caregiver.setStatus("Status");
        Optional<Caregiver> ofResult = Optional.of(caregiver);

        Caregiver caregiver1 = new Caregiver();
        caregiver1.setAddress("42 Main St");
        caregiver1.setEmailId("42");
        caregiver1.setFirstName("Jane");
        caregiver1.setId(1);
        caregiver1.setLastName("Doe");
        caregiver1.setPhone(1);
        caregiver1.setStatus("Status");
        when(caregiverRepository.save((Caregiver) any())).thenReturn(caregiver1);
        when(caregiverRepository.findById((Integer) any())).thenReturn(ofResult);
        Caregiver caregiver2 = mock(Caregiver.class);
        when(caregiver2.getPhone()).thenReturn(1);
        when(caregiver2.getStatus()).thenReturn("Status");
        when(caregiver2.getAddress()).thenReturn("");
        when(caregiver2.getEmailId()).thenReturn("42");
        when(caregiver2.getLastName()).thenReturn("Doe");
        when(caregiver2.getFirstName()).thenReturn("Jane");
        doNothing().when(caregiver2).setAddress((String) any());
        doNothing().when(caregiver2).setEmailId((String) any());
        doNothing().when(caregiver2).setFirstName((String) any());
        doNothing().when(caregiver2).setId(anyInt());
        doNothing().when(caregiver2).setLastName((String) any());
        doNothing().when(caregiver2).setPhone(anyInt());
        doNothing().when(caregiver2).setStatus((String) any());
        caregiver2.setAddress("42 Main St");
        caregiver2.setEmailId("42");
        caregiver2.setFirstName("Jane");
        caregiver2.setId(1);
        caregiver2.setLastName("Doe");
        caregiver2.setPhone(1);
        caregiver2.setStatus("Status");
        assertSame(caregiver1, caregiverService.updateCaregiver(1, caregiver2));
        verify(caregiverRepository).save((Caregiver) any());
        verify(caregiverRepository).findById((Integer) any());
        verify(caregiver2, atLeast(1)).getPhone();
        verify(caregiver2).getAddress();
        verify(caregiver2, atLeast(1)).getEmailId();
        verify(caregiver2, atLeast(1)).getFirstName();
        verify(caregiver2, atLeast(1)).getLastName();
        verify(caregiver2, atLeast(1)).getStatus();
        verify(caregiver2).setAddress((String) any());
        verify(caregiver2).setEmailId((String) any());
        verify(caregiver2).setFirstName((String) any());
        verify(caregiver2).setId(anyInt());
        verify(caregiver2).setLastName((String) any());
        verify(caregiver2).setPhone(anyInt());
        verify(caregiver2).setStatus((String) any());
    }

    /**
     * Method under test: {@link CaregiverService#updateCaregiver(int, Caregiver)}
     */
    @Test
    void testUpdateCaregiver5() {
        Caregiver caregiver = new Caregiver();
        caregiver.setAddress("42 Main St");
        caregiver.setEmailId("42");
        caregiver.setFirstName("Jane");
        caregiver.setId(1);
        caregiver.setLastName("Doe");
        caregiver.setPhone(1);
        caregiver.setStatus("Status");
        Optional<Caregiver> ofResult = Optional.of(caregiver);

        Caregiver caregiver1 = new Caregiver();
        caregiver1.setAddress("42 Main St");
        caregiver1.setEmailId("42");
        caregiver1.setFirstName("Jane");
        caregiver1.setId(1);
        caregiver1.setLastName("Doe");
        caregiver1.setPhone(1);
        caregiver1.setStatus("Status");
        when(caregiverRepository.save((Caregiver) any())).thenReturn(caregiver1);
        when(caregiverRepository.findById((Integer) any())).thenReturn(ofResult);
        Caregiver caregiver2 = mock(Caregiver.class);
        when(caregiver2.getPhone()).thenReturn(1);
        when(caregiver2.getStatus()).thenReturn("Status");
        when(caregiver2.getAddress()).thenReturn("42 Main St");
        when(caregiver2.getEmailId()).thenReturn("");
        when(caregiver2.getLastName()).thenReturn("Doe");
        when(caregiver2.getFirstName()).thenReturn("Jane");
        doNothing().when(caregiver2).setAddress((String) any());
        doNothing().when(caregiver2).setEmailId((String) any());
        doNothing().when(caregiver2).setFirstName((String) any());
        doNothing().when(caregiver2).setId(anyInt());
        doNothing().when(caregiver2).setLastName((String) any());
        doNothing().when(caregiver2).setPhone(anyInt());
        doNothing().when(caregiver2).setStatus((String) any());
        caregiver2.setAddress("42 Main St");
        caregiver2.setEmailId("42");
        caregiver2.setFirstName("Jane");
        caregiver2.setId(1);
        caregiver2.setLastName("Doe");
        caregiver2.setPhone(1);
        caregiver2.setStatus("Status");
        assertSame(caregiver1, caregiverService.updateCaregiver(1, caregiver2));
        verify(caregiverRepository).save((Caregiver) any());
        verify(caregiverRepository).findById((Integer) any());
        verify(caregiver2, atLeast(1)).getPhone();
        verify(caregiver2, atLeast(1)).getAddress();
        verify(caregiver2).getEmailId();
        verify(caregiver2, atLeast(1)).getFirstName();
        verify(caregiver2, atLeast(1)).getLastName();
        verify(caregiver2, atLeast(1)).getStatus();
        verify(caregiver2).setAddress((String) any());
        verify(caregiver2).setEmailId((String) any());
        verify(caregiver2).setFirstName((String) any());
        verify(caregiver2).setId(anyInt());
        verify(caregiver2).setLastName((String) any());
        verify(caregiver2).setPhone(anyInt());
        verify(caregiver2).setStatus((String) any());
    }

    /**
     * Method under test: {@link CaregiverService#updateCaregiver(int, Caregiver)}
     */
    @Test
    void testUpdateCaregiver6() {
        Caregiver caregiver = new Caregiver();
        caregiver.setAddress("42 Main St");
        caregiver.setEmailId("42");
        caregiver.setFirstName("Jane");
        caregiver.setId(1);
        caregiver.setLastName("Doe");
        caregiver.setPhone(1);
        caregiver.setStatus("Status");
        Optional<Caregiver> ofResult = Optional.of(caregiver);

        Caregiver caregiver1 = new Caregiver();
        caregiver1.setAddress("42 Main St");
        caregiver1.setEmailId("42");
        caregiver1.setFirstName("Jane");
        caregiver1.setId(1);
        caregiver1.setLastName("Doe");
        caregiver1.setPhone(1);
        caregiver1.setStatus("Status");
        when(caregiverRepository.save((Caregiver) any())).thenReturn(caregiver1);
        when(caregiverRepository.findById((Integer) any())).thenReturn(ofResult);
        Caregiver caregiver2 = mock(Caregiver.class);
        when(caregiver2.getPhone()).thenReturn(1);
        when(caregiver2.getStatus()).thenReturn("Status");
        when(caregiver2.getAddress()).thenReturn("42 Main St");
        when(caregiver2.getEmailId()).thenReturn("42");
        when(caregiver2.getLastName()).thenReturn("");
        when(caregiver2.getFirstName()).thenReturn("Jane");
        doNothing().when(caregiver2).setAddress((String) any());
        doNothing().when(caregiver2).setEmailId((String) any());
        doNothing().when(caregiver2).setFirstName((String) any());
        doNothing().when(caregiver2).setId(anyInt());
        doNothing().when(caregiver2).setLastName((String) any());
        doNothing().when(caregiver2).setPhone(anyInt());
        doNothing().when(caregiver2).setStatus((String) any());
        caregiver2.setAddress("42 Main St");
        caregiver2.setEmailId("42");
        caregiver2.setFirstName("Jane");
        caregiver2.setId(1);
        caregiver2.setLastName("Doe");
        caregiver2.setPhone(1);
        caregiver2.setStatus("Status");
        assertSame(caregiver1, caregiverService.updateCaregiver(1, caregiver2));
        verify(caregiverRepository).save((Caregiver) any());
        verify(caregiverRepository).findById((Integer) any());
        verify(caregiver2, atLeast(1)).getPhone();
        verify(caregiver2, atLeast(1)).getAddress();
        verify(caregiver2, atLeast(1)).getEmailId();
        verify(caregiver2, atLeast(1)).getFirstName();
        verify(caregiver2).getLastName();
        verify(caregiver2, atLeast(1)).getStatus();
        verify(caregiver2).setAddress((String) any());
        verify(caregiver2).setEmailId((String) any());
        verify(caregiver2).setFirstName((String) any());
        verify(caregiver2).setId(anyInt());
        verify(caregiver2).setLastName((String) any());
        verify(caregiver2).setPhone(anyInt());
        verify(caregiver2).setStatus((String) any());
    }

    /**
     * Method under test: {@link CaregiverService#updateCaregiver(int, Caregiver)}
     */
    @Test
    void testUpdateCaregiver7() {
        Caregiver caregiver = new Caregiver();
        caregiver.setAddress("42 Main St");
        caregiver.setEmailId("42");
        caregiver.setFirstName("Jane");
        caregiver.setId(1);
        caregiver.setLastName("Doe");
        caregiver.setPhone(1);
        caregiver.setStatus("Status");
        Optional<Caregiver> ofResult = Optional.of(caregiver);

        Caregiver caregiver1 = new Caregiver();
        caregiver1.setAddress("42 Main St");
        caregiver1.setEmailId("42");
        caregiver1.setFirstName("Jane");
        caregiver1.setId(1);
        caregiver1.setLastName("Doe");
        caregiver1.setPhone(1);
        caregiver1.setStatus("Status");
        when(caregiverRepository.save((Caregiver) any())).thenReturn(caregiver1);
        when(caregiverRepository.findById((Integer) any())).thenReturn(ofResult);
        Caregiver caregiver2 = mock(Caregiver.class);
        when(caregiver2.getPhone()).thenReturn(1);
        when(caregiver2.getStatus()).thenReturn("Status");
        when(caregiver2.getAddress()).thenReturn("42 Main St");
        when(caregiver2.getEmailId()).thenReturn("42");
        when(caregiver2.getLastName()).thenReturn("Doe");
        when(caregiver2.getFirstName()).thenReturn("");
        doNothing().when(caregiver2).setAddress((String) any());
        doNothing().when(caregiver2).setEmailId((String) any());
        doNothing().when(caregiver2).setFirstName((String) any());
        doNothing().when(caregiver2).setId(anyInt());
        doNothing().when(caregiver2).setLastName((String) any());
        doNothing().when(caregiver2).setPhone(anyInt());
        doNothing().when(caregiver2).setStatus((String) any());
        caregiver2.setAddress("42 Main St");
        caregiver2.setEmailId("42");
        caregiver2.setFirstName("Jane");
        caregiver2.setId(1);
        caregiver2.setLastName("Doe");
        caregiver2.setPhone(1);
        caregiver2.setStatus("Status");
        assertSame(caregiver1, caregiverService.updateCaregiver(1, caregiver2));
        verify(caregiverRepository).save((Caregiver) any());
        verify(caregiverRepository).findById((Integer) any());
        verify(caregiver2, atLeast(1)).getPhone();
        verify(caregiver2, atLeast(1)).getAddress();
        verify(caregiver2, atLeast(1)).getEmailId();
        verify(caregiver2).getFirstName();
        verify(caregiver2, atLeast(1)).getLastName();
        verify(caregiver2, atLeast(1)).getStatus();
        verify(caregiver2).setAddress((String) any());
        verify(caregiver2).setEmailId((String) any());
        verify(caregiver2).setFirstName((String) any());
        verify(caregiver2).setId(anyInt());
        verify(caregiver2).setLastName((String) any());
        verify(caregiver2).setPhone(anyInt());
        verify(caregiver2).setStatus((String) any());
    }

    /**
     * Method under test: {@link CaregiverService#fetchCaregiverByfirstName(String)}
     */
    @Test
    void testFetchCaregiverByfirstName() {
        Caregiver caregiver = new Caregiver();
        caregiver.setAddress("42 Main St");
        caregiver.setEmailId("42");
        caregiver.setFirstName("Jane");
        caregiver.setId(1);
        caregiver.setLastName("Doe");
        caregiver.setPhone(1);
        caregiver.setStatus("Status");
        when(caregiverRepository.findByfirstName((String) any())).thenReturn(caregiver);
        assertSame(caregiver, caregiverService.fetchCaregiverByfirstName("Jane"));
        verify(caregiverRepository).findByfirstName((String) any());
    }

    /**
     * Method under test: {@link CaregiverService#fetchCaregiverByfirsName(String)}
     */
    @Test
    void testFetchCaregiverByfirsName() {
        Caregiver caregiver = new Caregiver();
        caregiver.setAddress("42 Main St");
        caregiver.setEmailId("42");
        caregiver.setFirstName("Jane");
        caregiver.setId(1);
        caregiver.setLastName("Doe");
        caregiver.setPhone(1);
        caregiver.setStatus("Status");
        when(caregiverRepository.findByfirstName((String) any())).thenReturn(caregiver);
        assertSame(caregiver, caregiverService.fetchCaregiverByfirsName("Jane"));
        verify(caregiverRepository).findByfirstName((String) any());
    }

    /**
     * Method under test: {@link CaregiverService#fetchByfirstName(String, Caregiver)}
     */
    @Test
    void testFetchByfirstName() {
        Caregiver caregiver = new Caregiver();
        caregiver.setAddress("42 Main St");
        caregiver.setEmailId("42");
        caregiver.setFirstName("Jane");
        caregiver.setId(1);
        caregiver.setLastName("Doe");
        caregiver.setPhone(1);
        caregiver.setStatus("Status");
        when(caregiverRepository.findByfirstName((String) any())).thenReturn(caregiver);

        Caregiver caregiver1 = new Caregiver();
        caregiver1.setAddress("42 Main St");
        caregiver1.setEmailId("42");
        caregiver1.setFirstName("Jane");
        caregiver1.setId(1);
        caregiver1.setLastName("Doe");
        caregiver1.setPhone(1);
        caregiver1.setStatus("Status");
        assertSame(caregiver, caregiverService.fetchByfirstName("Jane", caregiver1));
        verify(caregiverRepository).findByfirstName((String) any());
    }
}

