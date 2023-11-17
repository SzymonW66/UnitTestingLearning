package pl.learning.javastart.Chapter7;

public class EmployeeNoLongerWorkingException extends RuntimeException{
    public EmployeeNoLongerWorkingException() {
        super("Employee is no longer hired");
    }
}

class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException() {
        super("Employee not found in database");
    }
}

class SalaryCalculationFailedException extends RuntimeException {
    public SalaryCalculationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
