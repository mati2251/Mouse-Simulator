import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;


public class Clicker{
	public static void main(String []arsg)
	{
		Point b;
		PointerInfo a;
		int x, y;
		for (double i=0;i<60;i++)
		{
			a = MouseInfo.getPointerInfo();
			b = a.getLocation();
			x = (int) b.getX();
			y = (int) b.getY();
			try {
				click(x,y);
				System.out.println("lel");
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try
			{
				Thread.sleep(500);
			}
			catch(InterruptedException e) {}
		}
	}
	public static void click(int x, int y) throws AWTException{
	    Robot bot = new Robot();
	    bot.mouseMove(x, y);    
	    bot.mousePress(InputEvent.BUTTON1_MASK);
	    bot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
}

