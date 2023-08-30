package work;

/**
 * Класс калькулятор. Хранение операндов А и В. Операции над ними
 */
public class Calculator {
    /**
     * Операнд A
     */
    private int A;
    /**
     * Операнд B
     */
    private int B;

    public Calculator() {
        setA(0);
        setB(0);
    }


    /**
     * Получение операнда А
     *
     * @return
     */
    public int getA() {
        return A;
    }

    /**
     * Получение операнда B
     *
     * @return
     */
    public int getB() {
        return B;
    }

    /**
     * Сложение
     *
     * @return A+B
     */
    public int add() {
        return A + B;
    }

    /**
     * Вычитание
     *
     * @return A-B
     */
    public int sub() {
        return A - B;
    }

    /**
     * Умножение
     *
     * @return A*B
     */
    public int mult() {
        return A * B;
    }

    /**
     * Деление
     *
     * @return A/B
     * @throws ArithmeticException - если B==0
     */
    public float div() throws ArithmeticException {
        if (B == 0) throw new ArithmeticException();
        return (float) A / B;
    }

    /**
     * Деление (целое)
     *
     * @return A/B
     * @throws ArithmeticException - если B==0
     */
    public int intdiv() throws ArithmeticException {
        if (B == 0) throw new ArithmeticException();
        return A / B;
    }

    /**
     * Установить значение операнда А
     *
     * @param A
     */
    public void setA(int A) {
        this.A = A;
    }

    /**
     * Установить значение операнда B
     *
     * @param B
     */
    public void setB(int B) {
        this.B = B;
    }
}
