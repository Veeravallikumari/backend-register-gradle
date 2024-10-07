package com.cts.Registration.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.cts.Registration.model.Caregiver;
import com.cts.Registration.model.User;
import com.cts.Registration.service.CaregiverService;
import com.cts.Registration.service.RegistrationService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {RegistrationController.class})
@ExtendWith(SpringExtension.class)
class RegistrationControllerTest {
    @MockBean
    private CaregiverService caregiverService;

    @Autowired
    private RegistrationController registrationController;

    @MockBean
    private RegistrationService registrationService;

    /**
     * Method under test: {@link RegistrationController#saveCaregiver(Caregiver)}
     */
    @Test
    void testSaveCaregiver() throws Exception {
        Caregiver caregiver = new Caregiver();
        caregiver.setAddress("42 Main St");
        caregiver.setEmailId("42");
        caregiver.setFirstName("Jane");
        caregiver.setId(1);
        caregiver.setLastName("Doe");
        caregiver.setPhone(1);
        caregiver.setStatus("Status");
        when(caregiverService.saveCaregiver((Caregiver) any())).thenReturn(caregiver);

        Caregiver caregiver1 = new Caregiver();
        caregiver1.setAddress("42 Main St");
        caregiver1.setEmailId("42");
        caregiver1.setFirstName("Jane");
        caregiver1.setId(1);
        caregiver1.setLastName("Doe");
        caregiver1.setPhone(1);
        caregiver1.setStatus("Status");
        String content = (new ObjectMapper()).writeValueAsString(caregiver1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/Caregiver")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(registrationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"emailId\":\"42\",\"address\":\"42 Main St\",\"phone\":1,\"status\""
                                        + ":\"Status\"}"));
    }

    /**
     * Method under test: {@link RegistrationController#fetchCaregiverList()}
     */
    @Test
    void testFetchCaregiverList() throws Exception {
        when(caregiverService.fetchCaregiverList()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/Caregiver");
        MockMvcBuilders.standaloneSetup(registrationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link RegistrationController#fetchCaregiverList()}
     */
    @Test
    void testFetchCaregiverList2() throws Exception {
        when(caregiverService.fetchCaregiverList()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/Caregiver");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(registrationController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link RegistrationController#fetchCaregiverById(int)}
     */
    @Test
    void testFetchCaregiverById() throws Exception {
        Caregiver caregiver = new Caregiver();
        caregiver.setAddress("42 Main St");
        caregiver.setEmailId("42");
        caregiver.setFirstName("Jane");
        caregiver.setId(1);
        caregiver.setLastName("Doe");
        caregiver.setPhone(1);
        caregiver.setStatus("Status");
        when(caregiverService.fetchCaregiverById(anyInt())).thenReturn(caregiver);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/Caregiver/{id}", 1);
        MockMvcBuilders.standaloneSetup(registrationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"emailId\":\"42\",\"address\":\"42 Main St\",\"phone\":1,\"status\""
                                        + ":\"Status\"}"));
    }

    /**
     * Method under test: {@link RegistrationController#deleteCaregiverById(int)}
     */
    @Test
    void testDeleteCaregiverById() throws Exception {
        doNothing().when(caregiverService).deleteCaregiverById(anyInt());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/Caregiver/{id}", 1);
        MockMvcBuilders.standaloneSetup(registrationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Caregiver Deleted Successfully"));
    }

    /**
     * Method under test: {@link RegistrationController#deleteCaregiverById(int)}
     */
    @Test
    void testDeleteCaregiverById2() throws Exception {
        doNothing().when(caregiverService).deleteCaregiverById(anyInt());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/Caregiver/{id}", 1);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(registrationController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Caregiver Deleted Successfully"));
    }

    /**
     * Method under test: {@link RegistrationController#updateCaregiver(int, Caregiver)}
     */
    @Test
    void testUpdateCaregiver() throws Exception {
        Caregiver caregiver = new Caregiver();
        caregiver.setAddress("42 Main St");
        caregiver.setEmailId("42");
        caregiver.setFirstName("Jane");
        caregiver.setId(1);
        caregiver.setLastName("Doe");
        caregiver.setPhone(1);
        caregiver.setStatus("Status");
        when(caregiverService.updateCaregiver(anyInt(), (Caregiver) any())).thenReturn(caregiver);

        Caregiver caregiver1 = new Caregiver();
        caregiver1.setAddress("42 Main St");
        caregiver1.setEmailId("42");
        caregiver1.setFirstName("Jane");
        caregiver1.setId(1);
        caregiver1.setLastName("Doe");
        caregiver1.setPhone(1);
        caregiver1.setStatus("Status");
        String content = (new ObjectMapper()).writeValueAsString(caregiver1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/updateCaregiver/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(registrationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"emailId\":\"42\",\"address\":\"42 Main St\",\"phone\":1,\"status\""
                                        + ":\"Status\"}"));
    }

    /**
     * Method under test: {@link RegistrationController#assignCareGiver(int, int)}
     */
    @Test
    void testAssignCareGiver() throws Exception {
        Caregiver caregiver = new Caregiver();
        caregiver.setAddress("42 Main St");
        caregiver.setEmailId("42");
        caregiver.setFirstName("Jane");
        caregiver.setId(1);
        caregiver.setLastName("Doe");
        caregiver.setPhone(1);
        caregiver.setStatus("Status");
        when(registrationService.assignCareGiver(anyInt(), anyInt())).thenReturn(caregiver);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/{userId}/caregiver/{careId}", 123,
                123);
        MockMvcBuilders.standaloneSetup(registrationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"emailId\":\"42\",\"address\":\"42 Main St\",\"phone\":1,\"status\""
                                        + ":\"Status\"}"));
    }

    /**
     * Method under test: {@link RegistrationController#fetchByfirstName(String, Caregiver)}
     */
    @Test
    void testFetchByfirstName() throws Exception {
        Caregiver caregiver = new Caregiver();
        caregiver.setAddress("42 Main St");
        caregiver.setEmailId("42");
        caregiver.setFirstName("Jane");
        caregiver.setId(1);
        caregiver.setLastName("Doe");
        caregiver.setPhone(1);
        caregiver.setStatus("Status");
        when(caregiverService.fetchCaregiverByfirstName((String) any())).thenReturn(caregiver);

        Caregiver caregiver1 = new Caregiver();
        caregiver1.setAddress("42 Main St");
        caregiver1.setEmailId("42");
        caregiver1.setFirstName("Jane");
        caregiver1.setId(1);
        caregiver1.setLastName("Doe");
        caregiver1.setPhone(1);
        caregiver1.setStatus("Status");
        String content = (new ObjectMapper()).writeValueAsString(caregiver1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getCaregiver/{firstName}", "Jane")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(registrationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"emailId\":\"42\",\"address\":\"42 Main St\",\"phone\":1,\"status\""
                                        + ":\"Status\"}"));
    }

    /**
     * Method under test: {@link RegistrationController#getMember(int)}
     */
    @Test
    void testGetMember() throws Exception {
        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregiver(new ArrayList<>());
        user.setConfirmPassword("iloveyou");
        user.setEmailId("42");
        user.setId(1);
        user.setPassword("iloveyou");
        user.setfirstName("Jane");
        user.setlatName("Doe");
        when(registrationService.getUserById(anyInt())).thenReturn(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getMember/{id}", 1);
        MockMvcBuilders.standaloneSetup(registrationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"emailId\":\"42\",\"password\":\"iloveyou\",\"confirmPassword\":"
                                        + "\"iloveyou\",\"address\":\"42 Main St\",\"caregiver\":[]}"));
    }

    /**
     * Method under test: {@link RegistrationController#getUser(String)}
     */
    @Test
    void testGetUser() throws Exception {
        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregiver(new ArrayList<>());
        user.setConfirmPassword("iloveyou");
        user.setEmailId("42");
        user.setId(1);
        user.setPassword("iloveyou");
        user.setfirstName("Jane");
        user.setlatName("Doe");
        when(registrationService.fetchUserByEmailId((String) any())).thenReturn(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getUser/{id}", "42");
        MockMvcBuilders.standaloneSetup(registrationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"emailId\":\"42\",\"password\":\"iloveyou\",\"confirmPassword\":"
                                        + "\"iloveyou\",\"address\":\"42 Main St\",\"caregiver\":[]}"));
    }

    /**
     * Method under test: {@link RegistrationController#getlogin(String)}
     */
    @Test
    void testGetlogin() throws Exception {
        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregiver(new ArrayList<>());
        user.setConfirmPassword("iloveyou");
        user.setEmailId("42");
        user.setId(1);
        user.setPassword("iloveyou");
        user.setfirstName("Jane");
        user.setlatName("Doe");
        when(registrationService.fetchUserByEmailId((String) any())).thenReturn(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getLogin/{id}", "42");
        MockMvcBuilders.standaloneSetup(registrationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"userName\":\"42\",\"password\":\"iloveyou\"}"));
    }

    /**
     * Method under test: {@link RegistrationController#registerUser(User)}
     */
    @Test
    void testRegisterUser() throws Exception {
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
        when(registrationService.fetchUserByEmailId((String) any())).thenReturn(user);
        when(registrationService.saveUser((User) any())).thenReturn(user1);

        User user2 = new User();
        user2.setAddress("42 Main St");
        user2.setCaregiver(new ArrayList<>());
        user2.setConfirmPassword("iloveyou");
        user2.setEmailId("");
        user2.setId(1);
        user2.setPassword("iloveyou");
        user2.setfirstName("Jane");
        user2.setlatName("Doe");
        String content = (new ObjectMapper()).writeValueAsString(user2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/registeruser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(registrationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"emailId\":\"42\",\"password\":\"iloveyou\",\"confirmPassword\":"
                                        + "\"iloveyou\",\"address\":\"42 Main St\",\"caregiver\":[]}"));
    }

    /**
     * Method under test: {@link RegistrationController#registerUser(User)}
     */
    @Test
    void testRegisterUser2() throws Exception {
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
        when(registrationService.fetchUserByEmailId((String) any())).thenReturn(user);
        when(registrationService.saveUser((User) any())).thenReturn(user1);

        User user2 = new User();
        user2.setAddress("42 Main St");
        user2.setCaregiver(new ArrayList<>());
        user2.setConfirmPassword("iloveyou");
        user2.setEmailId(null);
        user2.setId(1);
        user2.setPassword("iloveyou");
        user2.setfirstName("Jane");
        user2.setlatName("Doe");
        String content = (new ObjectMapper()).writeValueAsString(user2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/registeruser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(registrationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"emailId\":\"42\",\"password\":\"iloveyou\",\"confirmPassword\":"
                                        + "\"iloveyou\",\"address\":\"42 Main St\",\"caregiver\":[]}"));
    }
}

