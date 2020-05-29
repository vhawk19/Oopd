import java.applet.*;

import java.awt.*;

import java.util.*;

public class Clock extends Applet implements Runnable

{

    Thread t;

    //Initialize the applet

    public void init()

    {

	setBackground(Color.white);

    }

    //Function to start the thread

    public void start()

    {

	t = new Thread(this);

	t.start();

    }

    //Function to execute the thread

    public void run()

    {

	while(true)

	{

	    try

	    {

		repaint();

		//Delay by 1 sec

		Thread.sleep(1000);

	    }

	    catch(Exception e)

            {

            }

	}

    }

    //Function to draw the clock

    public void paint(Graphics g)

    {

	Calendar time = Calendar.getInstance();

	int hour = time.get(Calendar.HOUR_OF_DAY) % 12;

	int minute = time.get(Calendar.MINUTE);

	int second = time.get(Calendar.SECOND);

	double angle;

	int x,y;

	//Draw a circle with center(250,250) & radius=150

	g.drawOval(100,100,300,300);

	//Label the clock

	String s="12";

	int i=0;

	while(i<12)

	{

	    angle = Math.toRadians(30*(i-3));

	    x = 250+(int)(Math.cos(angle)*135);

	    y = 250+(int)(Math.sin(angle)*135);

	    g.drawString(s,x,y);

	    i++;

	    s=String.valueOf(i);

	}	

	//Draw the hours hand

	g.setColor(Color.green);

	angle = Math.toRadians((30*hour)-90);

	x = 250+(int)(Math.cos(angle)*100);

	y = 250+(int)(Math.sin(angle)*100);

        g.drawLine(250,250,x,y);

	//Draw the minutes hand

	g.setColor(Color.red);

	angle = Math.toRadians((6*minute)-90);

	x = 250+(int)(Math.cos(angle)*115);

	y = 250+(int)(Math.sin(angle)*115);

	g.drawLine(250,250,x,y);

	//Draw the seconds hand

	g.setColor(Color.blue);

	angle = Math.toRadians((6*second)-90);

	x = 250+(int)(Math.cos(angle)*130);

	y = 250+(int)(Math.sin(angle)*130);

	g.drawLine(250,250,x,y);

    }

}

/*

<applet code = Clock.class width=500 height=500>

</applet>

*/
