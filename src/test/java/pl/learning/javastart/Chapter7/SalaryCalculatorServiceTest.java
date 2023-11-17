package pl.learning.javastart.Chapter7;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import pl.learning.javastart.Chapter5.ex1.Employee;
import pl.learning.javastart.Chapter5.ex1.SalaryCalculatorService;
import pl.learning.javastart.Chapter5.ex1.TaskManagmentSystem;

import java.math.BigDecimal;



class SalaryCalculatorServiceTest {
    @Mock
    TaskManagmentSystem taskManagementSystem;

    @Test
    public void shouldThrowForNoLongerWorkingEmployee() {
        //given
        SalaryCalculatorService salaryCalculatorService = new SalaryCalculatorService(taskManagementSystem);
        Employee ted = new Employee("Ted", BigDecimal.ZERO);
        Mockito.when(taskManagementSystem.countFinishedTasksForEmployee(ted)).thenThrow(new EmployeeNoLongerWorkingException());

        //when, then
       Assertions.assertThatThrownBy(() -> salaryCalculatorService.calculateSalary(ted))
               .isInstanceOf(pl.learning.javastart.Chapter7.SalaryCalculatorService.class)
               .hasCauseInstanceOf(EmployeeNoLongerWorkingException.class)
               .hasMessage("Could not calculate salary. Reason: Employee not found in database");

    }
}