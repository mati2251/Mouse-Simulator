import java.awt.AWTException;
import java.util.*;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;


public class Clicker{
	public static void main(String []arsg)
	{
		Scanner input = new Scanner(System.in);
		Point b;
		PointerInfo a;
		int x, y;
		int behind, how = 0;
		System.out.println("How many second to next click?");behind=input.nextInt()*1000;
		System.out.println("How many clicks?" ); how=input.nextInt();
		for (double i=0;i<how;i++)
		{
			a = MouseInfo.getPointerInfo();
			b = a.getLocation();
			x = (int) b.getX();
			y = (int) b.getY();
			try {
				click(x,y);
				System.out.println("lel");
			} catch (AWTException e) {
				e.printStackTrace();
			}
			try
			{
				Thread.sleep(behind);
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

