package lesson3.comparators;

import lesson3.employees.Employee;

import java.util.Comparator;

/**
 * Компаратор для сравнения сотрудников по имени.
 */
public class EmployeeNameComparator implements Comparator<Employee>{

    /**
     * Сравнивает двух сотрудников по их имени.
     *
     * @param employee1 первый сотрудник для сравнения
     * @param employee2 второй сотрудник для сравнения
     * @return отрицательное число, если у первого сотрудника имя "меньше",
     * положительное число, если "больше", и ноль, если имена одинаковы
     */
    @Override
    public int compare(Employee employee1, Employee employee2) {
        return employee1.getName().compareTo(employee2.getName());
    }
}