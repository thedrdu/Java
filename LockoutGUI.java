import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



public class LockoutGUI extends JPanel implements KeyListener
{
   private static final long serialVersionUID = 1L;
   private static final int PREF_W = 800;
   private static final int PREF_H = 600;
   private Timer timer;
   private Laser laser;
   private Player player;
   private ArrayList<Brick> bricks;
   private int score;
   private int level;
   private boolean playing;
   private boolean gameOver;
   private String message;
   private int speed;
   private Image image;
   private Image background;
   private int highscore;
   
   
   public LockoutGUI()
   {
      this.addKeyListener(this);
      this.setFocusable(true);   
      
      image = new ImageIcon(this.getClass().getResource("spaceship.png")).getImage();
      background = new ImageIcon(this.getClass().getResource("stars.gif")).getImage();
      score = 0;
      level = 1;
      playing = false;
      gameOver = false;
      message = "Welcome!";
      speed = 1;  //This determines the speed of falling bricks, not the player's speed
      highscore = 0;
      laser = new Laser(386, 550, 5, 30, -3, Color.RED);
      

      
      player = new Player(PREF_W/2-20, 525, 25, 75, 3, 0, 37, 39, 38, 40, PREF_W, PREF_H, Color.WHITE, image);
      
      bricks = new ArrayList<Brick>();
      initializeBricks(1, 10, 30, speed, Color.RED);
      
      
      timer = new Timer(7
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
    	  for(Brick b : bricks)
    		  b.update();
     laser.update();
     player.update();
   
     for(int i = 0; i < bricks.size(); i++)

    	 checkCollision();  //Checks if the player is hitting anything
     checkBrickCollision();
     
     if(score > highscore)
    	 	highscore = score;
     
     if(score == 10) //Changes difficulty when score is 10
     {
    	 for(Brick b : bricks)
   		  b.setDy(2);
    	 speed = 2;
     }
     
     if(score == 20) //Changes difficulty when score is 20
     {
    	 for(Brick b : bricks)
   		  b.setDy(3);
    	 speed = 3;
     }
        	 
     if(bricks.get(0).getY()>PREF_H)
     {
    	 
    	 	initializeBricks(level, 10, 30, speed, Color.RED);
     }
//     if(bricks.size() == 0)
//     {
//        level++;
//        initializeBricks(level, 10, 30, Color.BLUE);
//       
//     }
   
      }
     else if(gameOver)
        {
           message = "GAME OVER . . .  <R> TO RESTART";
        }
     
     else
        {
           message = "PRESS ENTER TO SERVE";
        }
   }
   
   
   public void checkBrickCollision()
   {
      for (int i = 0; i < bricks.size(); i++)
         if(laser.getBounds().intersects(bricks.get(i).getBounds()))
        	 	if(bricks.get(i).getColor().equals(Color.GREEN)) //Checks if laser is hitting green brick
        	 	{
        	 		bricks.remove(i);  
        	 		laser.setY(-100);
        	 		//This makes it go out of bounds so that you can shoot again after hitting a brick
        	 		score++;
        	 	}
        	 	else
        	 		laser.setY(-100);
   }
   
  
   public void checkCollision()
   {
	   for (int i = 0; i < bricks.size(); i++)
	         if(player.getBounds().intersects(bricks.get(i).getBounds()))
	         {
	        	 	gameOver = true;
	   			playing = false;
	         }
   }
   
   
   public void initializeBricks(int rows, int cols, int height, int dy, Color color)
   {
	  bricks = new ArrayList<Brick>();
      int brickWidth = PREF_W / cols;
      for(int r = 0; r < rows; r++)
         for(int c = 0; c < cols; c++)
            bricks.add(new Brick(c*brickWidth, -20, brickWidth, height, dy, Color.RED));
      int num = (int)(Math.random()*bricks.size()); 
      bricks.get(num).setColor(Color.GREEN); //Uses random integer num to decide green brick
      
   }
   
   
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      
      g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
      g2.setColor(Color.WHITE);
      
      g2.fillRect(0, 0, getWidth(), getHeight());
      
      
      
      JPanel panel = null;
      g2.drawImage(background,0,0,PREF_W,PREF_H, null, panel);
      laser.draw(g2);
      player.draw(g2);
      g2.setColor(Color.GRAY);
      g2.drawString("Score: " + score, 10, 20);
      g2.drawString("Highscore: " + highscore, 10, 35);
      g2.drawString("Level: " + level, 10, 50);
    
      g2.drawString(message, PREF_W/2-50, 300);
      message = "";
      
      
      
	player.drawImage(g2, panel);
      for(Brick b : bricks)
         b.draw(g2);
      
   }

   public Dimension getPreferredSize()
   {
      return new Dimension(PREF_W, PREF_H);
   }
   
   public void roundReset()
   {
      laser.setX(PREF_W/2-10);
      laser.setY(550);
      player.setX(PREF_W/2-50);
      player.setY(525);
      playing = false;
   }

   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Lockout!");
      LockoutGUI panel = new LockoutGUI();
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
     
     if(key == KeyEvent.VK_ENTER)
        if(playing = false)
           playing = true;
     
     if(key == KeyEvent.VK_R)
        if(gameOver = true)
           gameOver = false;
     
     if(key == KeyEvent.VK_UP)
     {
  	   if(laser.isOffBoard2())
  	     {
  	        laser.setY(550);
  	        laser.setX(player.getX()+11);
  	     }
     }
     player.setKeyPress(key);
     
    }
   

   @Override
   public void keyReleased(KeyEvent e)
   {
      int key = e.getKeyCode();
      
   if(key == KeyEvent.VK_ENTER)
   {
         playing = true;
   }
   
   
   
   if(key == KeyEvent.VK_R)
   {
         level = 1;
         score = 0;
         speed = 1;
         gameOver = false;
         laser.setX(PREF_W/2-10);
         laser.setY(550);
         player.setX(PREF_W/2-20);
         player.setY(525);
         playing = false;
         initializeBricks(1, 10, 30, 1, Color.RED);
   }
      
      player.setKeyRelease(key);
   }
   
   @Override
   public void keyTyped(KeyEvent e){}
}
