package lesson1.work;

/**
 * Контроллер. Основной цикл работы пользовательского диалога.
 */
public class Controller {

    /**
     * Рабочий цикл приложения.
     * Принимает на вход класс объект класса Calculator
     *
     * @param calc класс объект класса Calculator
     */
    public Controller(Calculator calc)  {
        System.out.println("Консольный калькулятор v.1");
        boolean run = true;
        while (run) {
            System.out.printf("--------------\n" +
                    "A=%d, B=%d\n" +
                    "--------------\n", calc.getA(), calc.getB());
            String answer = CInput.input(
                    "1 - ввод А\n" +
                            "2 - ввод B\n" +
                            "3 - сложение\n" +
                            "4 - вычитание\n" +
                            "5 - умножение\n" +
                            "6 - деление\n" +
                            "Q - выход\n" +
                            "--------------\n:");
            if (answer.isEmpty()) continue;
            try {
                switch (answer) {
                    case ("1") -> {
                        calc.setA(Integer.parseInt(CInput.input("Введите A: ")));
                    }
                    case ("2") -> {
                        calc.setB(Integer.parseInt(CInput.input("Введите B: ")));
                    }
                    case ("3") -> {
                        System.out.println("A+B=" + calc.add());
                        CInput.input("Press Enter to continue..");
                    }
                    case ("4") -> {
                        System.out.println("A-B=" + calc.sub());
                        CInput.input("Press Enter to continue..");
                    }
                    case ("5") -> {
                        System.out.println(("A*B=" + calc.mult()));
                        CInput.input("Press Enter to continue..");
                    }
                    case ("6") -> {
                        System.out.println(("A/B=" + calc.div()));
                        CInput.input("Press Enter to continue..");
                    }
                    case ("Q"), ("q") -> {
                        System.out.println("Удачи!");
                        run = false;
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("Ошибка формата числа");
            } catch (ArithmeticException e) {
                System.out.println("Ошибка. Деление на ноль!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
