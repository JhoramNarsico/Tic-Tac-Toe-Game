public final class GameModel {
    public static final int EMPTY = 0;
    public static final int X_PLAYER = 1;
    public static final int O_PLAYER = 2;

    private final int[][] board;
    private int currentPlayer;
    private boolean gameOver;

    public GameModel() {
        board = new int[3][3];
        reset();
    }

    public void reset() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = EMPTY;
            }
        }
        currentPlayer = X_PLAYER;
        gameOver = false;
    }

    public boolean makeMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 ||
            board[row][col] != EMPTY || gameOver) {
            return false;
        }

        board[row][col] = currentPlayer;
        currentPlayer = (currentPlayer == X_PLAYER) ? O_PLAYER : X_PLAYER;

        return true;
    }

    public int checkWinner() {
        for (int row = 0; row < 3; row++) {
            if (board[row][0] != EMPTY &&
                board[row][0] == board[row][1] &&
                board[row][0] == board[row][2]) {
                gameOver = true;
                return board[row][0];
            }
        }

        for (int col = 0; col < 3; col++) {
            if (board[0][col] != EMPTY &&
                board[0][col] == board[1][col] &&
                board[0][col] == board[2][col]) {
                gameOver = true;
                return board[0][col];
            }
        }

        if (board[0][0] != EMPTY &&
            board[0][0] == board[1][1] &&
            board[0][0] == board[2][2]) {
            gameOver = true;
            return board[0][0];
        }

        if (board[0][2] != EMPTY &&
            board[0][2] == board[1][1] &&
            board[0][2] == board[2][0]) {
            gameOver = true;
            return board[0][2];
        }

        boolean isTie = true;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == EMPTY) {
                    isTie = false;
                    break;
                }
            }
            if (!isTie) break;
        }

        if (isTie) {
            gameOver = true;
            return EMPTY;
        }

        return -1;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public int getCellState(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            return board[row][col];
        }
        return EMPTY;
    }
}
