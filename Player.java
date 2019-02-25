import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class Player
{
   private int x, y, w, h, dx, dy, leftKey, rightKey, upKey, downKey, xMax, yMax;
   private boolean left, right, up, down;
   private Color color;
private Image image;
   
   
   
   public Player(int x, int y, int w, int h, int dx, int dy, int leftKey, int rightKey, int upKey, int downKey, int xMax, int yMax,
         Color color, Image image)
   {
      this.x = x;
      this.y = y;
      this.w = w;
      this.h = h;
      this.dx = dx;
      this.dy = dy;
      this.leftKey = leftKey;
      this.rightKey = rightKey;
      this.upKey = upKey;
      this.downKey = downKey;
      this.xMax = xMax;
      this.yMax = yMax;
      this.color = color;
      this.image = image;
   }
   
   public void drawImage(Graphics2D g2, JPanel panel)
   {
	   g2.drawImage(image,x-26,y-10,80,100,panel);
   }

   public void update()
   {
      
      if(left) x -= dx;
      if(right) x += dx;
      if(up) y += dy;
      if(down) y-= dy;
         
      if(x < -w) x = xMax-w;
      if(x > xMax - w) x = -w+1;
   }
   
   public void setKeyPress(int key)
   {
      if(key == leftKey) left = true;
      if(key == rightKey) right = true;
      if(key == upKey) up = true;
      if(key == downKey) down = true;
         
   }

   public void setKeyRelease(int key)
   {
      if(key == leftKey) left = false;
      if(key == rightKey) right = false;
      if(key == upKey) up = false;
      if(key == downKey) down = false;
         
   }
   
   public void draw(Graphics2D g2)
   {
//      g2.setColor(color);
//      g2.fill(getBounds());
//      g2.setColor(Color.WHITE);
//      g2.draw(getBounds());
      
   }
   
   public Rectangle getBounds()
   {
      return new Rectangle(x, y, w, h);
   }
   
   
   
   public int getX()
   {
      return x;
   }



   public void setX(int x)
   {
      this.x = x;
   }



   public int getY()
   {
      return y;
   }



   public void setY(int y)
   {
      this.y = y;
   }



   public int getW()
   {
      return w;
   }



   public void setW(int w)
   {
      this.w = w;
   }



   public int getH()
   {
      return h;
   }



   public void setH(int h)
   {
      this.h = h;
   }



   public int getDx()
   {
      return dx;
   }



   public void setDx(int dx)
   {
      this.dx = dx;
   }



   public int getDy()
   {
      return dy;
   }



   public void setDy(int dy)
   {
      this.dy = dy;
   }



   public int getLeftKey()
   {
      return leftKey;
   }



   public void setLeftKey(int leftKey)
   {
      this.leftKey = leftKey;
   }



   public int getRightKey()
   {
      return rightKey;
   }



   public void setRightKey(int rightKey)
   {
      this.rightKey = rightKey;
   }



   public int getxMax()
   {
      return xMax;
   }



   public void setxMax(int xMax)
   {
      this.xMax = xMax;
   }



   public int getyMax()
   {
      return yMax;
   }



   public void setyMax(int yMax)
   {
      this.yMax = yMax;
   }



   public boolean isLeft()
   {
      return left;
   }



   public void setLeft(boolean left)
   {
      this.left = left;
   }



   public boolean isRight()
   {
      return right;
   }



   public void setRight(boolean right)
   {
      this.right = right;
   }



   public Color getColor()
   {
      return color;
   }



   public void setColor(Color color)
   {
      this.color = color;
   }

public int getUpKey() {
	return upKey;
}

public void setUpKey(int upKey) {
	this.upKey = upKey;
}

public int getDownKey() {
	return downKey;
}

public void setDownKey(int downKey) {
	this.downKey = downKey;
}

public boolean isUp() {
	return up;
}

public void setUp(boolean up) {
	this.up = up;
}

public boolean isDown() {
	return down;
}

public void setDown(boolean down) {
	this.down = down;
}
}
