import javax.swing.JFrame;

public class App {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false); // sets if the window can be resized or not

        // window.setSize(500,400);

        window.setTitle("2d game");
        window.setLocationRelativeTo(null); // sets the window to the center of the screen

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        //Calling gameThread method
        gamePanel.startGameThread();

        window.setVisible(true);
    }
}