import java.awt.Button; 

public class GameController {
    private final GameModel model; 
    private final GameView view;   

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                final int currentRow = row;
                final int currentCol = col;
                Button cellButton = view.getCell(row, col);
                if (cellButton != null) {
                    cellButton.addActionListener(e -> handleCellClick(currentRow, currentCol));
                }
            }
        }

        view.getResetButton().addActionListener(e -> resetGame());
    }

    public void startGame() {
        view.setVisible(true);
        updateStatus();
    }

    private void handleCellClick(int row, int col) {
        if (model.isGameOver()) {
            return;
        }

        int playerWhoMoved = model.getCurrentPlayer();

        if (model.makeMove(row, col)) {
            view.updateCell(row, col, playerWhoMoved);

            int winner = model.checkWinner();

            switch (winner) {
                case GameModel.X_PLAYER -> {
                    view.updateStatus("Player X wins!");
                    view.disableBoard();
                }
                case GameModel.O_PLAYER -> {
                    view.updateStatus("Player O wins!");
                    view.disableBoard();
                }
                case GameModel.EMPTY -> {
                    view.updateStatus("It's a tie!");
                    view.disableBoard();
                }
                default -> updateStatus();
            }
        }
    }

    private void resetGame() {
        model.reset();
        view.resetBoard();
        updateStatus();
    }

    private void updateStatus() {
        if (model.getCurrentPlayer() == GameModel.X_PLAYER) {
            view.updateStatus("Player X's turn");
        } else {
            view.updateStatus("Player O's turn");
        }
    }
}

