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

    public byte getWinningLength() {
        return winningLength;
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

    public void setCell(byte x, byte y, char sym) {
        gamefield[x][y] = sym;
    }

    /**
     * Проверка игрового поля на состояние победы.
     *
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
        for (byte y = (byte) (dimensionY - 1); y >= 0; y--) {
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
                y--;
            }
        }
        return false;
    }

}
