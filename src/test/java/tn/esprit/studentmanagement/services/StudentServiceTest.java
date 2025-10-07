package tn.esprit.studentmanagement.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.studentmanagement.entities.Student;
import tn.esprit.studentmanagement.repositories.StudentRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    void shouldReturnAllStudents() {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        when(studentRepository.findAll()).thenReturn(students);

        List<Student> returnedStudents = studentService.getAllStudents();

        assertEquals(students, returnedStudents);
        verify(studentRepository).findAll();
    }
}
