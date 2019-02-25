import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Ball
{
   //INSTANCE VARIABLES
   private int x, y, w, h, dx, dy, xMax, yMax;
   private Color color;

   
   public Ball(int x, int y, int w, int h, int dx, int dy, int xMax, int yMax, Color color)
   {
      this.x = x;
      this.y = y;
      this.w = w;
      this.h = h;
      this.dx = dx;
      this.dy = dy;
      this.xMax = xMax;
      this.yMax = yMax;
      this.color = color;
   }


   public void update()
   {
   x += dx;
   y += dy;
   
   
   if(x <= 0 || x >= xMax-w)
      dx = -dx;
   if(y <= 0)// || y >= yMax-h)
      dy = -dy;
   
   }
   
   
   public void draw(Graphics2D g2)
   {
    g2.setColor(color);
    g2.fill(getBounds());
    g2.setColor(Color.BLACK);
    g2.draw(getBounds());
   }
   
   public boolean isOffBoard1()
   {
      return y > yMax;
   }
   
   public Ellipse2D.Double getBounds()
   {
      return new Ellipse2D.Double(x, y, w, h);
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


   public Color getColor()
   {
      return color;
   }


   public void setColor(Color color)
   {
      this.color = color;
   }


   public boolean isOffBoard()
   {
      return false;
   }
   
  
}
