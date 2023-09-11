package lesson3;

import lesson3.comparators.EmployeeAgeComparator;
import lesson3.comparators.EmployeeNameComparator;
import lesson3.comparators.EmployeeSalaryComparator;
import lesson3.employees.Employee;
import lesson3.employees.EmployeeList;
import lesson3.employees.Freelancer;
import lesson3.employees.Worker;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        EmployeeList employees = new EmployeeList();

        // Добавление сотрудников в список
        employees.addEmployee(new Worker("Иванов Иван", 35, 20000));
        employees.addEmployee(new Worker("Иванов Иван", 30, 50000));
        employees.addEmployee(new Worker("Иванов Иван", 30, 70000));
        employees.addEmployee(new Freelancer("Петров Петр", 28, 700));
        employees.addEmployee(new Freelancer("Смирнова Анна", 35, 1000));
        employees.addEmployee(new Worker("Сидорова Елена", 42, 60000));
        employees.addEmployee(new Freelancer("Козлов Кирилл", 25, 400));
        employees.addEmployee(new Worker("Михайлова Александра", 33, 55000));
        employees.addEmployee(new Freelancer("Новиков Даниил", 29, 200));
        employees.addEmployee(new Worker("Алексеева Екатерина", 38, 65000));
        employees.addEmployee(new Freelancer("Павлов Владимир", 27, 600));
        employees.addEmployee(new Worker("Егорова Ольга", 31, 52000));


        printHeader("Сортировка по умолчанию");
        Collections.sort(employees.getEmployees());
        printEmployees(employees);

        printHeader("Сортировка по зарплате");
        employees.getEmployees().sort(new EmployeeSalaryComparator());
        printEmployees(employees);

        printHeader("Сортировка по возрасту");
        employees.getEmployees().sort(new EmployeeAgeComparator());
        printEmployees(employees);

        printHeader("Сортировка по имени");
        employees.getEmployees().sort(new EmployeeNameComparator());
        printEmployees(employees);
    }

    /**
     * Печать списка сотрудников
     */
    private static void printEmployees(EmployeeList employeeList) {
        // Итерация по списку сотрудников с использованием цикла foreach
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }

    private static void printHeader(String st) {
        System.out.println("\n");
        System.out.printf("%25s", "=== " + st + " =======================================\n");
    }
}
