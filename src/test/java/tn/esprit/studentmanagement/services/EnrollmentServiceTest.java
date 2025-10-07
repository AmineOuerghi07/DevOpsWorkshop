package tn.esprit.studentmanagement.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.studentmanagement.entities.Enrollment;
import tn.esprit.studentmanagement.repositories.EnrollmentRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EnrollmentServiceTest {

    @Mock
    EnrollmentRepository enrollmentRepository;

    @InjectMocks
    EnrollmentService enrollmentService;

    @Test
    void shouldCreateEnrollment() {
        Enrollment enrollment = new Enrollment();
        enrollment.setGrade(15.0);
        when(enrollmentRepository.save(enrollment)).thenReturn(enrollment);

        Enrollment savedEnrollment = enrollmentService.saveEnrollment(enrollment);

        assertEquals(savedEnrollment.getGrade(), enrollment.getGrade());

        verify(enrollmentRepository).save(enrollment);
    }
}
