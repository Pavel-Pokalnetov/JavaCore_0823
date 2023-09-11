package lesson2;

public class Model {
    private byte dimensionX;
    private byte dimensionY;
    private byte winningLength;
    private char[][] gamefield;

    public byte getDimensionX() {
        return dimensionX;
    }

    public byte getDimensionY() {
        return dimensionY;
    }


    public void reset(byte dimensionX, byte dimensionY, byte winningLength) {
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.winningLength = winningLength;
        gamefield = new char[dimensionX][dimensionY];
        for (byte x = 0; x < dimensionX; x++) {
            for (byte y = 0; y < dimensionY; y++) {
                gamefield[x][y] = ' ';
            }
        }
    }

    /**
     * Проверка индексов ячейки
     *
     * @param x строка
     * @param y колонка
     * @return true если ячейка с такими индексами не существует
     */
    public boolean checkNonRealCell(byte x, byte y) {
        if (x >= dimensionX || x < 0) return true;
        return y >= dimensionY || y < 0;
    }

    /**
     * Проверяет свободна ли ячейка с указанными индексами
     *
     * @param x строка
     * @param y колонка
     * @return true если ячейка не пустая
     */
    public boolean checkNonFreeCell(Byte x, Byte y) {
        return (gamefield[x][y] != ' ');
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("  ");
        for (byte x = 0; x < dimensionY; x++) {
            result.append(String.format(" %s", (char) (x + 65)));
        }
        result.append("\n");
        for (byte x = 0; x < dimensionX; x++) {
            result.append(String.format("%2s", x + 1));
            for (byte y = 0; y < dimensionY; y++) {
                result.append(String.format("┊%s", gamefield[x][y]));
            }
            result.append("┊\n");
        }
        return result.toString();
    }

    /** Устанавливает содержимое ячейки
     * @param x - индекс строки
     * @param y - индекс колонки
     * @param sym - записываемый символ
     */
    public void setCell(byte x, byte y, char sym) {
        gamefield[x][y] = sym;
    }

    /**
     * Проверка игрового поля на состояние победы.
     * Проверка идет в цикле по вертикалям, по горизонталям и по правым и левым диагоналям
     * @param checkSym проверяемые символы в цепочке (X или О)
     * @return true если на поле победная комбинация
     */
    public boolean checkWin(char checkSym) {
        byte winChain;
        //перебор вертикалей
        for (byte x = 0; x < dimensionX; x++) {
            winChain = 0;
            for (byte y = 0; y < dimensionY; y++) {
                if (gamefield[x][y] == checkSym) {
                    winChain++;
                } else {
                    winChain = 0;
                }
                if (winChain == winningLength) return true;
            }
        }
        //перебор горизонталей
        for (byte y = 0; y < dimensionY; y++) {
            winChain = 0;
            for (byte x = 0; x < dimensionX; x++) {
                if (gamefield[x][y] == checkSym) {
                    winChain++;
                } else {
                    winChain = 0;
                }
                if (winChain == winningLength) return true;

            }
        }
        //перебор правых диагоналей
        for (byte x = 0; x < dimensionX; x++) {
            byte y = 0;
            byte dx = 0;
            winChain = 0;
            while (!checkNonRealCell((byte) (x + dx), y)) {
                if (gamefield[x + dx][y] == checkSym) {
                    winChain++;
                } else {
                    winChain = 0;
                }
                if (winChain == winningLength) return true;
                dx--;
                y++;
            }
        }
        for (byte y = 1; y < dimensionY; y++) {
            byte x = (byte) (dimensionX - 1);
            byte dx = 0;
            winChain = 0;
            while (!checkNonRealCell((byte) (x + dx), y)) {
                if (gamefield[x + dx][y] == checkSym) {
                    winChain++;
                } else {
                    winChain = 0;
                }
                if (winChain == winningLength) return true;
                dx--;
                y++;
            }
        }
        //перебор левых диагоналей
        for (byte x = 0; x < dimensionX; x++) {
            byte y = (byte) (dimensionY - 1);
            byte dx = 0;
            winChain = 0;
            while (!checkNonRealCell((byte) (x + dx), y)) {
                if (gamefield[x + dx][y] == checkSym) {
                    winChain++;
                } else {
                    winChain = 0;
                }
                if (winChain == winningLength) return true;
                dx--;
                y--;
            }
        }
        for (byte y = (byte) (dimensionY - 2); y >= 0; y--) {
            byte x = (byte) (dimensionX - 1);
            byte dy = 0;
            winChain = 0;
            while (!checkNonRealCell(x, (byte) (y+dy))) {
                if (gamefield[x][y+dy] == checkSym) {
                    winChain++;
                } else {
                    winChain = 0;
                }
                if (winChain == winningLength) return true;
                x--;
                dy--;
            }
        }
        return false;
    }

    /** Проверка позиции (x,y) на выигрыш true - если ход приводит к выигрышу.
     * @param x строка
     * @param y колонка
     * @param checkSym - проверяемый символ
     * @return true, если ход с символом chekSym в позицию x,y приводит к победе
     */
    private boolean checkNextWin(byte x,byte y ,char checkSym){
        boolean result = false;
        setCell(x,y,checkSym);
        result = checkWin(checkSym);
        setCell(x,y,' ');
        return result;
    }

    /** Поиск выигрышного хода. Возвращает координаты первой выигрышной позиции или {-1,-1}, если выигрышной позиции нет.
     * @param checkSym символ хода (0 или X)
     * @return массив byte[], где 0 и 1 индексы - соответственно x и y - координаты ячейки, приводящие к победе,
     */
    public byte[] findWinPosition(char checkSym){
        for (byte x = 0; x < dimensionX; x++) {
            for (byte y = 0; y < dimensionY; y++) {
                if (checkNonFreeCell(x, y)) continue;
                if (checkNextWin(x,y,checkSym)){return new byte[]{x,y};}
            }
        }
        return new byte[]{-1,-1};
    }


    /** Проверка на заполнение поля
     * @return true, если поле заполнено
     */
    public boolean noFreeCells() {
        for (int x = 0; x < dimensionX; x++) {
            for (int y = 0; y < dimensionY; y++) {
                if (gamefield[x][y]==' ') return false;
            }

        }
        return true;
    }
}
