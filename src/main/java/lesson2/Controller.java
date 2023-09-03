package lesson2;

import java.util.Random;

public class Controller {
    private final View view;
    private final Model game;

    public Controller(Model game, View view) {
        this.game = game;
        this.view = view;
        this.runGame();
    }

    /**
     * Основной рабочий игровой цикл
     */
    private void runGame() {
        view.output("ИГРА КРЕСТИКИ-НОЛИКИ");
        byte dimX;
        byte dimY;
        byte winLen;
        do {
            try {
                view.output("Укажите размер игрового поля");
                dimX = Byte.parseByte(view.input("по вертикали (3-26): "));
                if (dimX < 3 || dimX > 26) throw new InputException();
                dimY = Byte.parseByte(view.input("по горизонтали (3-26): "));
                if (dimY < 3 || dimY > 26) throw new InputException();
                winLen = Byte.parseByte(view.input("Укажите длину победной цепочки(3-26)"));
                if (winLen < 3 || winLen > 26) throw new InputException();
                break;
            }catch (NumberFormatException e){
                view.output("Неправильный ввод");;
            } catch (InputException e) {
                view.output("Неверный ввод, повторите");
            }
        } while (true);
        boolean runStatus = true;
        while (runStatus) {
            game.reset(dimX, dimY, winLen);
            view.output("Первый ход делаю Я))");
            while (true) {
                playCPUAI();
                view.output(game.toString());
                if (checkGameStatus() != 0) break;
                playUSER();
                view.output(game.toString());
                if (checkGameStatus() != 0) break;
            }
            switch (checkGameStatus()) {
                case (1) -> //выиграл компьютер
                        view.output("Я выиграл)))");
                case (2) -> //выиграл игрок
                        view.output("Вы выиграли");
                case (3) -> //ничья
                        view.output("У нас ничья");
            }
            String answer = view.input("Повторим? (N - для выхода , Enter - продолжить):");
            if (answer.isEmpty()) continue;
            if (answer.equalsIgnoreCase("N")) runStatus = false;
        }
    }

    /**
     * Ход игрока
     */
    private void playUSER() {
        boolean userInput;
        byte index_Y=0;
        byte index_X=0;
        do {
            try {
                String _Y = view.input("Ваш ход\nколонка: ").toUpperCase();
                if (_Y.length() != 1) throw new InputException("Ошибка ввода буквы");
                index_Y = (byte) (_Y.charAt(0) - 65);
                try {
                    index_X = (byte) (Byte.parseByte(view.input("строка: "))-1);
                } catch (NumberFormatException e) {
                    throw new InputException("Ошибка ввода номера строки");
                }
                if (game.checkNonRealCell(index_X, index_Y)) throw new InputException("Нет такой ячейки");
                if (game.checkNonFreeCell(index_X, index_Y)) throw new InputException("Ячейка занята");
                userInput = false;
            } catch (InputException e) {
                view.output(e.getMessage());
                userInput = true;
            } catch (Exception e) {
                view.output("Что-то пошло не так");
                e.printStackTrace();
                return;
            }
        } while (userInput);
        game.setCell( index_X,index_Y, 'X');
    }

    /** Возвращает статус игры (проверка на выигрыш или ничью)
     * @return
     */
    private int checkGameStatus() {
        if (game.checkWin('0')) return 1; //выиграл CPU
        if (game.checkWin('X')) return 2; //выиграл человек
        if (game.noFreeCells()) return 3; //ничья
        return 0;
    }

    /**
     * Ход компьютера. Рандомный поиск свободной ячейки для хода.
     */
    private void playCPU() {
        Random rnd = new Random();
        byte x,y;
        byte maxX = game.getDimensionX();
        byte maxY = game.getDimensionY();
        do{
            x = (byte) rnd.nextInt(maxX);
            y = (byte) rnd.nextInt(maxY);
        }while (game.checkNonFreeCell(x,y));
        view.output(String.format("Мой ход: %s %s",(char)(y+65),x+1));
        game.setCell(x,y,'0');
    }

    /**
     * Ход компьютера с поиском выигрышных или защитных позиций.
     */
    private void playCPUAI(){
        //поиск позиции выигрыша для компьютера
        byte[] testRun = game.findWinPosition('0');
        if (testResult(testRun,'0')) return;

        //поиск защитной позиции
        //в которой следующим ходом может выиграть человек
        testRun = game.findWinPosition('X');
        if (testResult(testRun,'0')) return;
        //если ничего не нашли, то ход в любую свободную
        playCPU();
    }

    /**
     * Вспомогательный метод для playCPUAI()
     */
    private boolean testResult(byte[] t, char c){
        if (t[0]!=-1){
            game.setCell(t[0],t[1],c );
            view.output(String.format("Мой ход: %s %s",(char)(t[1]+65),t[0]+1));
            return true;
        }
        return false;
    }



    static class InputException extends Exception {
        public InputException(String message) {
            super(message);
        }
        public InputException() {
            super();
        }
    }

}
