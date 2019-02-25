import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Brick
{
   private int x, y, w, h;
   private Color color;
   
   
   public Brick(int x, int y, int w, int h, Color color)
   {
      this.x = x;
      this.y = y;
      this.w = w;
      this.h = h;
      this.color = color;
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


   public Color getColor()
   {
      return color;
   }


   public void setColor(Color color)
   {
      this.color = color;
   }
   
   
}
