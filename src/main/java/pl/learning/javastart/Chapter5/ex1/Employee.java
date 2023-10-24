package pl.learning.javastart.Chapter5.ex1;

import java.math.BigDecimal;

public class Employee {
    private String name;
    private BigDecimal baseSalary;

    public Employee(String name, BigDecimal baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(BigDecimal baseSalary) {
        this.baseSalary = baseSalary;
    }
}
