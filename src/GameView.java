import java.awt.*;
import java.awt.event.*;

public class GameView extends Frame {
    private final Button[][] buttons;
    private final Button resetButton;
    private final Label statusLabel;

    public GameView() {
        setTitle("Tic Tac Toe");
        setSize(300, 350);
        setLayout(new BorderLayout());

        Panel gridPanel = new Panel();
        gridPanel.setLayout(new GridLayout(3, 3));

        buttons = new Button[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new Button("");
                buttons[row][col].setFont(new Font("Arial", Font.BOLD, 40));
                gridPanel.add(buttons[row][col]);
            }
        }

        statusLabel = new Label("Player X's turn");
        statusLabel.setAlignment(Label.CENTER);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        resetButton = new Button("New Game");

        Panel bottomPanel = new Panel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.add(resetButton);

        add(statusLabel, BorderLayout.NORTH);
        add(gridPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void updateCell(int row, int col, int player) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            String label = switch (player) {
                case GameModel.X_PLAYER -> "X";
                case GameModel.O_PLAYER -> "O";
                default -> "";
            };
            buttons[row][col].setLabel(label);
            buttons[row][col].setEnabled(false);
        }
    }

    public void updateStatus(String status) {
        statusLabel.setText(status);
    }

    public void resetBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setLabel("");
                buttons[row][col].setEnabled(true);
            }
        }
    }

    public void disableBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setEnabled(false);
            }
        }
    }

    public Button getCell(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            return buttons[row][col];
        }
        return null;
    }

    public Button getResetButton() {
        return resetButton;
    }
}
