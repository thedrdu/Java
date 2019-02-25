import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Paddle
{
   private int x, y, w, h, dx, dy, leftKey, rightKey, xMax, yMax;
   private boolean left, right;
   private Color color;
   
   
   
   public Paddle(int x, int y, int w, int h, int dx, int dy, int leftKey, int rightKey, int xMax, int yMax,
         boolean left, boolean right, Color color)
   {
      this.x = x;
      this.y = y;
      this.w = w;
      this.h = h;
      this.dx = dx;
      this.dy = dy;
      this.leftKey = leftKey;
      this.rightKey = rightKey;
      this.xMax = xMax;
      this.yMax = yMax;
      this.color = color;
   }

   public void update()
   {
      
      if(left) x -= dx;
      if(right) x += dx;
         
      if(x < 0) x = 0;
      if(x > xMax - w) x = xMax - w;
   }
   
   public void setKeyPress(int key)
   {
      if(key == leftKey) left = true;
      if(key == rightKey) right = true;
         
   }

   public void setKeyRelease(int key)
   {
      if(key == leftKey) left = false;
      if(key == rightKey) right = false;
         
   }
   
   public void draw(Graphics2D g2)
   {
      g2.setColor(color);
      g2.fill(getBounds());
      g2.setColor(Color.BLACK);
      g2.draw(getBounds());
      
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
}
