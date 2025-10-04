import java.awt.Color;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {

        // 主窗口
        JFrame window = new JFrame("Snake");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 画板
        // JPanel panel = new JPanel();
        // panel.setBackground(Color.BLACK);
        // window.add(panel);

        Game game = new Game();
        game.setBackground(Color.DARK_GRAY);
        window.add(game);


        window.setVisible(true);
    }
}

