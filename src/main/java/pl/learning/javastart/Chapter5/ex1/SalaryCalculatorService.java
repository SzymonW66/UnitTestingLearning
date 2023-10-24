package pl.learning.javastart.Chapter5.ex1;

import java.math.BigDecimal;

public class SalaryCalculatorService {

    private TaskManagmentSystem taskManagementSystem;

    public SalaryCalculatorService(TaskManagmentSystem taskManagementSystem) {
        this.taskManagementSystem = taskManagementSystem;
    }


    public BigDecimal calculateSalary(Employee employee) {
        TaskManagmentSystem taskManagmentSystem = new TaskManagmentSystem();

        int finishedTasks = taskManagmentSystem.countFinishedTasksForEmployee(employee);

        BigDecimal bonus = BigDecimal.ZERO;
        if (finishedTasks >= 20) {
            bonus = new BigDecimal("1000");
        } else if (finishedTasks > 10) {
            bonus = new BigDecimal("500");
        }

        return employee.getBaseSalary().add(bonus);
    }
}
