package lesson3.employees;

/**
 * Класс Employee представляет абстрактного сотрудника с базовой информацией, такой как имя, возраст и зарплата.
 */
public abstract class Employee implements Comparable<Employee> {


    private String name; // Имя сотрудника
    private int age; // Возраст сотрудника
    private double salary; // Зарплата сотрудника
    private String type; // тип сотрудника

    /**
     * Конструктор для создания объекта Employee.
     *
     * @param name   Имя сотрудника
     * @param age    Возраст сотрудника
     * @param salary Зарплата сотрудника
     */
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    /**
     * Метод для расчета зарплаты сотрудника.
     *
     * @return Зарплата сотрудника
     */
    public abstract double calculateSalary();

    /**
     * Метод сравнения двух сотрудников.
     * Сравнение идет последовательно по полям: имя, возраст, зарплата
     *
     * @param other Другой сотрудник для сравнения
     * @return Результат сравнения по следующим критериям:
     * -1, если данный сотрудник должен быть раньше другого сотрудника;
     * 0, если сотрудники равны;
     * 1, если данный сотрудник должен быть позже другого сотрудника.
     * @throws NullPointerException Если other равно null
     */
    public int compareTo(Employee other) {
        if (other == null) {
            throw new NullPointerException("Cannot compare with null");
        }

        int nameComparison = this.name.compareTo(other.name);
        if (nameComparison != 0) {
            return nameComparison;
        }

        int ageComparison = Integer.compare(this.age, other.age);
        if (ageComparison != 0) {
            return ageComparison;
        }

        return Double.compare(this.calculateSalary(), other.calculateSalary());
    }

    // Геттеры и сеттеры

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%-20s  age=%-3d  salary=%-9.2f  type=%s", name, age, calculateSalary(), type);
    }
}