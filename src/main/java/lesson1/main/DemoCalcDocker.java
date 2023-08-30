package lesson1.main;
import java.util.Random;
import lesson1.work.Calculator;

/**
 * Класс для демонстрации работы программы в контейнере Docker
 */
public class DemoCalcDocker {
    public static void main(String[] args) {
        Random rnd = new Random();
        Calculator calc = new Calculator();
        calc.setA(rnd.nextInt(1000));
        calc.setB(rnd.nextInt(1000));
        System.out.printf("A=%d , B=%d\n",calc.getA(),calc.getB());
        System.out.println("A+B="+calc.add());
        System.out.println("A-B="+calc.sub());
        System.out.println("A*B="+calc.mult());
        System.out.println("A/B="+calc.div());
    }


}
