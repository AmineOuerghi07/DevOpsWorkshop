package tn.esprit.studentmanagement.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.crossstore.ChangeSetPersister;
import tn.esprit.studentmanagement.entities.Department;
import tn.esprit.studentmanagement.repositories.DepartmentRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentService departmentService;

    @Test
    void shouldReturnDepartmentFromId()
    {
        Department department = new Department();
        department.setIdDepartment(1L);
        when(departmentRepository.findById(1L)).thenReturn(Optional.of(department));

        Department returnedDepartment = departmentService.getDepartmentById(1L);

        assertEquals(department.getIdDepartment(), returnedDepartment.getIdDepartment());

        verify(departmentRepository).findById(1L);
    }


//    @Test
//    void shouldThrowExceptionWhenDepartmentNotFound()
//    {
//        // Arrange
//        Department department = new Department();
//        department.setIdDepartment(99L);
//        when(departmentRepository.findById(99L)).thenReturn(Optional.empty());
//
//        // Act
//        Department result = departmentService.getDepartmentById(99L);
//        // Assert
//
//        assertNull(result);
//
//        verify(departmentRepository).findById(99L);
//    }
}
