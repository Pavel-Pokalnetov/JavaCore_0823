package lesson3.employees;

/**
 * Класс Freelancer представляет сотрудника-фрилансера, который является подклассом класса Employee.
 */
public class Freelancer extends Employee {
    private static final double WORK_DAYS_PER_MONTH = 20.8; // Среднее число рабочих дней в месяце
    private static final double WORK_HOURS_PER_DAY = 8; // Число часов в рабочем дне
    private double hourlyRate; // Почасовая ставка фрилансера

    /**
     * Конструктор для создания объекта Freelancer.
     *
     * @param name       Имя сотрудника
     * @param age        Возраст сотрудника
     * @param hourlyRate Почасовая ставка сотрудника
     */
    public Freelancer(String name, int age, double hourlyRate) {
        super(name, age, 0); // Нулевая фиксированная оплата для почасовых сотрудников
        this.hourlyRate = hourlyRate;
        this.setType("Freelance");
    }

    /**
     * Метод для расчета зарплаты сотрудника-фрилансера.
     *
     * @return Зарплата сотрудника-фрилансера
     */
    @Override
    public double calculateSalary() {
        return WORK_DAYS_PER_MONTH * WORK_HOURS_PER_DAY * hourlyRate;
    }

    /**
     * Метод для получения зарплаты сотрудника-фрилансера.
     *
     * @return Зарплата сотрудника-фрилансера
     */
    @Override
    public double getSalary() {
        return calculateSalary();
    }
}