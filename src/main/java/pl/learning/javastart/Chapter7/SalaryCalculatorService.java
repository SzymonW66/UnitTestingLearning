package pl.learning.javastart.Chapter7;

import pl.learning.javastart.Chapter5.ex1.Employee;
import pl.learning.javastart.Chapter5.ex1.TaskManagmentSystem;

import java.math.BigDecimal;

public class SalaryCalculatorService {
    private TaskManagmentSystem taskManagementSystem;

    public SalaryCalculatorService(TaskManagmentSystem taskManagementSystem) {
        this.taskManagementSystem = taskManagementSystem;
    }

    public BigDecimal calculateSalary(Employee employee) throws SalaryCalculationFailedException {
        int finishedTasks;
        try {
            finishedTasks = taskManagementSystem.countFinishedTasksForEmployee(employee);
        } catch (Exception e) {
            throw new SalaryCalculationFailedException("Could not calculate salary. Reason: " + e.getMessage(), e);
        }

        BigDecimal bonus = BigDecimal.ZERO;
        if (finishedTasks >= 10) {
            bonus = new BigDecimal("500");
        } else if (finishedTasks > 20) {
            bonus = new BigDecimal("1000");
        }

        return employee.getBaseSalary().add(bonus);

    }
}
