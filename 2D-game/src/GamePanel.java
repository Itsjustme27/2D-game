import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class GamePanel extends JPanel implements Runnable{
    //SCREEN SETTINGS

    final int originalTileSize = 16; // 16x16
    final int scale = 3;

    //Resolution
    final int tileSize = originalTileSize * scale;  //48x48

    final int maxScreenCol = 16;
    final int maxScreenRow = 12;

    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    KeyHandler keyH = new KeyHandler();

    Thread gameThread;

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));  // sets the size of this class(JPanel)
        this.addKeyListener(keyH);
        this.setFocusable(true);
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); //if set to true, all the drawing from this component will be done in a offscreen painting buffer. (added to improve rendering performance)
    }

    public void startGameThread() {
        gameThread = new Thread(this);  //Passing the GamePanel class to the thread
        gameThread.start();
    }

    @Override
    public void run() {
        // GAMELOOP
        // 1) UPDATE : update information such as character positions 
        // 2) DRAW : draw the screen with updated information

        while(gameThread != null) {
            long currentTime = System.nanoTime();
            System.out.println("Current Time" + currentTime);
            update();
            repaint();
        }
    }

    public void update() {
        if(keyH.upPressed == true) {
            playerY -= playerSpeed;
        }else if(keyH.downPressed == true) {
            playerY += playerSpeed;
        }else if(keyH.leftPressed == true) {
            playerX -= playerSpeed;
        }else if(keyH.rightPressed) {
            playerX += playerSpeed;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY,  tileSize, tileSize);  
        g2.dispose();
    }  
}
