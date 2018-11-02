package Mouse;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;


public class Clicker{
	private boolean stop=false;
	private int how;
	private int perSecond;
	public Clicker(int how, int perSecond)
	{
		this.how=how;
		this.perSecond=perSecond*1000;
	}
	public Clicker(int perSecond)
	{
		this.perSecond=perSecond*1000;
	}
	public void someClick()
	{
		Point b;
		PointerInfo a;
		int x, y;
		for (double i=0;i<how;i++)
		{
			a = MouseInfo.getPointerInfo();
			b = a.getLocation();
			x = (int) b.getX();
			y = (int) b.getY();
			try {
				click(x,y);
				System.out.println("Click");
			} catch (AWTException e) {
				e.printStackTrace();
			}
			try
			{
				Thread.sleep(perSecond);
			}
			catch(InterruptedException e) {}
		}
	}
	public void loopCLick() {
		Point b;
		PointerInfo a;
		int x, y;
		while(true)
		{
			a = MouseInfo.getPointerInfo();
			b = a.getLocation();
			x = (int) b.getX();
			y = (int) b.getY();
			try {
				click(x,y);
				System.out.println("Click");
			} catch (AWTException e) {
				e.printStackTrace();
			}
			try
			{
				Thread.sleep(perSecond);
			}
			catch(InterruptedException e) {}
			if(stop==true)
				break;
		}
	}
	public static void click(int x, int y) throws AWTException{
	    Robot bot = new Robot();
	    bot.mouseMove(x, y);    
	    bot.mousePress(InputEvent.BUTTON1_MASK);
	    bot.mouseRelease(InputEvent.BUTTON1_MASK);
}
}