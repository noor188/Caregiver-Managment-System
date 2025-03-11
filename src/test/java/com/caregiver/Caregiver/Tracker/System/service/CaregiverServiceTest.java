package com.caregiver.Caregiver.Tracker.System.service;

import com.caregiver.Caregiver.Tracker.System.model.Caregiver;
import com.caregiver.Caregiver.Tracker.System.model.Role;
import com.caregiver.Caregiver.Tracker.System.repository.CaregiverRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ActiveProfiles("test")
@SpringBootTest
class EmployeeServiceTest {

    @Mock
    private CaregiverRepository caregiverRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private CaregiverService caregiverService;

    private Caregiver caregiver;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        caregiver = new Caregiver();
        caregiver.setId(1L);
        caregiver.setFirstName("John");
        caregiver.setLastName("Smith");
        caregiver.setEmail("john.doe@example.com");
        caregiver.setRole(Role.CAREGIVER);
        caregiver.setPassword("password123");
    }

    @Test
    void getAllCaregiver_ReturnsListOfCaregivers() {
        // Arrange
        List<Caregiver> caregivers = Arrays.asList(caregiver);
        when(caregiverRepository.findAll()).thenReturn(caregivers);

        // Act
        List<Caregiver> result = caregiverService.getAllCaregivers();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(caregiver.getFirstName(), result.get(0).getFirstName());
    }

    @Test
    void getEmployeeById_ValidId_ReturnsEmployee() {
        // Arrange
        when(caregiverRepository.findById(1)).thenReturn(Optional.of(caregiver));

        // Act
        Caregiver result = caregiverService.getCaregiverById(1);

        // Assert
        assertNotNull(result);
        assertEquals(caregiver.getId(), result.getId());
    }


}
