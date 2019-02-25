
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



public class BreakoutGUI extends JPanel implements KeyListener
{
   private static final long serialVersionUID = 1L;
   private static final int PREF_W = 800;
   private static final int PREF_H = 600;
   private Timer timer;
   private Ball ball;
   private Paddle paddle;
   private ArrayList<Brick> bricks;
   private int score;
   private int level;
   private boolean playing;
   private boolean gameOver;
   private int turnsLeft;
   private String message;
   
   
   public BreakoutGUI()
   {
      this.addKeyListener(this);
      this.setFocusable(true);   
      
      score = 0;
      level = 1;
      turnsLeft = 3;
      playing = false;
      gameOver = false;
      message = "Welcome!";
      
      ball = new Ball(PREF_W/2-10, 550, 20, 20, 1, -1, PREF_W, PREF_H, Color.RED);
      
      paddle = new Paddle(PREF_W/2-50, 575, 100, 10, 1, 0, 37, 39, PREF_W, PREF_H, false, false, Color.BLACK);
      
      bricks = new ArrayList<Brick>();
      initializeBricks(1, 10, 30, Color.GREEN);
      
      
      timer = new Timer(2
            , new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            update();
            repaint();
         }
      });
      timer.start();
      System.out.println(getWidth());
   }
   
   public void update()
   {
      if(playing)
      {
     ball.update();
     paddle.update();
     if(ball.isOffBoard1())
        {
           playing = false;
           turnsLeft--;
           if(turnsLeft == 0)
              gameOver = true;
           else
              roundReset();
        }
     checkPaddleCollision();
     checkBrickCollision();
     if(bricks.size() == 0)
        {
           level++;
           initializeBricks(level, 10, 30, Color.BLUE);
          
        }
      }
     else if(gameOver)
        {
           message = "GAME OVER . . .  <R> TO RESTART";
        }
     
     else
        {
           message = "PRESS SPACE TO SERVE";
        }
   }
   
   public void checkPaddleCollision()
   {
      if (ball.getBounds().intersects(paddle.getBounds()))
         ball.setDy(-ball.getDy()); 
   }
   
   public void checkBrickCollision()
   {
      for (int i = 0; i < bricks.size(); i++)
         if(ball.getBounds().intersects(bricks.get(i).getBounds()))
         {
            bricks.remove(i);
            score++;
            ball.setDy(-ball.getDy());
         }
   }
   
  
   public void checkCollision()
   {
      
   }
   
   public void initializeBricks(int rows, int cols, int height, Color color)
   {
      int brickWidth = PREF_W / cols;
      for(int r = 0; r < rows; r++)
         for(int c = 0; c < cols; c++)
            bricks.add(new Brick(c*brickWidth, r*height+100, brickWidth, height, Color.GREEN));
      
   }
   
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
      g2.setColor(Color.WHITE);
      
      g2.fillRect(0, 0, getWidth(), getHeight());
      
      g2.setColor(Color.GRAY);
      g2.drawString("Score: " + score, 10, 20);
      g2.drawString("Level: " + level, 10, 35);
      
      g2.drawString("Turns Left: " + turnsLeft, 10, 50);
      
      g2.drawString(message, PREF_W/2-50, 300);
      
      
      ball.draw(g2);
      paddle.draw(g2);
      for(Brick b : bricks)
         b.draw(g2);
   }

   public Dimension getPreferredSize()
   {
      return new Dimension(PREF_W, PREF_H);
   }
   
   public void roundReset()
   {
      ball.setX(PREF_W/2-10);
      ball.setY(550);
      paddle.setX(PREF_W/2-50);
      paddle.setY(575);
      playing = false;
   }

   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Breakout!");
      BreakoutGUI panel = new BreakoutGUI();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(panel);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
      
      
   }

   @Override
   public void keyPressed(KeyEvent e)
   {
     int key = e.getKeyCode();
     
     if(key == KeyEvent.VK_SPACE)
        if(playing = false)
           playing = true;
     
     if(key == KeyEvent.VK_R)
        if(gameOver = true)
           gameOver = false;
     
     paddle.setKeyPress(key);
     
    }

   @Override
   public void keyReleased(KeyEvent e)
   {
      int key = e.getKeyCode();
      
   if(key == KeyEvent.VK_SPACE)
   {
         playing = true;
   }
   
   if(key == KeyEvent.VK_R)
   {
         turnsLeft = 3;
         level = 1;
         score = 0;
         gameOver = false;
         ball.setX(PREF_W/2-10);
         ball.setY(550);
         paddle.setX(PREF_W/2-50);
         paddle.setY(575);
         playing = false;
   }
      
      paddle.setKeyRelease(key);
   }
   
   @Override
   public void keyTyped(KeyEvent e){}
}
