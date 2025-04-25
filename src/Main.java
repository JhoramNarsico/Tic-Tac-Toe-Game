// "Tic Tac Toe is fun!"
import java.awt.EventQueue; 

public class Main { 

    public static void main(final String[] args) {
        EventQueue.invokeLater(() -> {
            final GameModel model = new GameModel();
            final GameView view = new GameView();
            final GameController controller = new GameController(model, view);
            controller.startGame();
        });
    }
}
