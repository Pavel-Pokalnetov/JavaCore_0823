package lesson2;

import java.util.Random;

public class Controller {
    private final View vw;
    private final Model gb;

    public Controller(Model gb, View vw) {
        this.gb = gb;
        this.vw = vw;
        this.runGame();
    }

    private void runGame() {
        vw.output("ИГРА КРЕСТИКИ-НОЛИКИ");
        byte dimX;
        byte dimY;
        byte winLen;
        do {
            vw.output("Укажите размер игрового поля");
            dimX = Byte.parseByte(vw.input("по вертикали (3-26): "));
            if (dimX < 3 || dimX > 26) {vw.output("Неверный ввод, повторите");continue;}
            dimY = Byte.parseByte(vw.input("по горизонтали (3-26): "));
            if (dimY < 3 || dimY > 26) {vw.output("Неверный ввод, повторите");continue;}
            winLen = Byte.parseByte(vw.input("Укажите длину победной цепочки(3-26)"));
            if (winLen < 3 || winLen > 26) {vw.output("Неверный ввод, повторите");continue;}
            break;
        } while (true);
        boolean runStatus = true;
        while (runStatus) {
            gb.reset(dimX, dimY, winLen);
            vw.output("Первый ход делаю Я))");
            while (true) {
                playCPU();
                vw.output(gb.toString());
                if (checkGameStatus() != 0) break;
                playUSER();
                vw.output(gb.toString());
                if (checkGameStatus() != 0) break;
            }
            switch (checkGameStatus()) {
                case (1) -> //выиграл компьютер
                        vw.output("Я выиграл)))");
                case (2) -> //выиграл игрок
                        vw.output("Вы выиграли");
            }
            String answer = vw.input("Повторим? (N - для выхода , Enter - продолжить):");
            if (answer.isEmpty()) continue;
            if (answer.equalsIgnoreCase("N")) runStatus = false;
        }
    }

    private void playUSER() {
        boolean userInput;
        byte turnX=0;
        byte turnY=0;
        do {
            try {
                String _turnX = vw.input("Ваш ход\nколонка: ");
                if (_turnX.length() != 1) throw new InputException("Ошибка ввода буквы");
                turnX = (byte) (_turnX.charAt(0) - 65);
                try {
                    turnY = Byte.parseByte(vw.input("строка: "));
                } catch (NumberFormatException e) {
                    throw new InputException("Ошибка ввода номера строки");
                }
                if (gb.checkNonRealCell(turnX, turnY)) throw new InputException("Нет такой ячейки");
                if (gb.checkNonFreeCell(turnX, turnY)) throw new InputException("Ячейка занята");
                userInput = false;
            } catch (InputException e) {
                vw.output(e.getMessage());
                userInput = true;
            } catch (Exception e) {
                vw.output("Что-то пошло не так");
                e.printStackTrace();
                return;
            }
        } while (userInput);
        gb.setCell(turnX, turnY, 'Х');
    }

    /** возвращает статус игры (проверка на выигрыш)
     * @return
     */
    private int checkGameStatus() {
        if (gb.checkWin('O')) return 1;
        if (gb.checkWin('X')) return 2;
        return 0;
    }

    private void playCPU() {
        Random rnd = new Random();
        byte x,y;
        byte maxX = gb.getDimensionX();
        byte maxY = gb.getDimensionY();
        do{
            x = (byte) rnd.nextInt(maxX);
            y = (byte) rnd.nextInt(maxY);
        }while (gb.checkNonFreeCell(x,y));
        gb.setCell(x,y,'O');
    }


    static class InputException extends Exception {

        public InputException(String message) {
            super(message);
        }
    }

}
