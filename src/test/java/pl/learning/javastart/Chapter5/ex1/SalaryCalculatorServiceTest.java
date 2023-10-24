package pl.learning.javastart.Chapter5.ex1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class SalaryCalculatorServiceTest {

    @Mock
    TaskManagmentSystem taskManagmentSystem;

    private SalaryCalculatorService salaryCalculatorService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        salaryCalculatorService = new SalaryCalculatorService(taskManagmentSystem);
    }

    @Test
    public void shouldHaveNotBonus() {
        //given
        Employee employee1 = new Employee("Tomek", BigDecimal.valueOf(2000));
        when(taskManagmentSystem.countFinishedTasksForEmployee(employee1)).thenReturn(9);

        //when
        BigDecimal salary = salaryCalculatorService.calculateSalary(employee1);

        //then
        assertThat(salary).isEqualTo(BigDecimal.valueOf(2000));
    }

    @Test
    public void shouldHave1000Bonus() {
        //given
        Employee employee2 = new Employee("Albert", BigDecimal.valueOf(2000));
        when(taskManagmentSystem.countFinishedTasksForEmployee(employee2)).thenReturn(20);
        //when
        BigDecimal salary = salaryCalculatorService.calculateSalary(employee2);
        //then
        assertThat(salary).isEqualTo(BigDecimal.valueOf(3000));
    }

    @ValueSource(ints = {10, 19})
    @ParameterizedTest
    public void shouldHave500Bonus(int finishedTasks) {
        //given
        Employee employee = Mockito.mock(Employee.class);
        when(employee.getBaseSalary()).thenReturn(BigDecimal.valueOf(2000));
        when(taskManagmentSystem.countFinishedTasksForEmployee(employee)).thenReturn(finishedTasks);
        //when
        BigDecimal salary = salaryCalculatorService.calculateSalary(employee);
        //then
        assertThat(salary).isEqualTo(BigDecimal.valueOf(2500));

    }


}