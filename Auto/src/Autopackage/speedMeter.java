package Autopackage;

import java.awt.Color;
import java.awt.Graphics;

public class speedMeter {
	
	private  Motor motor;
	public speedMeter(Motor motor) {
		this.motor =motor;
	}
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(27,125,200,200);
		
		g.setColor(Color.BLACK);
		g.fillOval(50,150,150,150);
		double speed = motor.getSpeed()%75.0/7*Math.PI*2;
		
		int centreX = 50+75;
		int centreY = 150+75;
		
		int animX =(int) (centreX + Math.sin(speed)*75);
		int animY = (int) (centreY - Math.cos(speed)*75);
		g.setColor(Color.WHITE);
		g.drawLine(centreX,centreY,animX,animY);
		for(int i=0;i<=7;i++) {
			int radian = (int) (i%7.0/7*Math.PI*2);
			int anim3 =(int) (centreX + Math.sin(radian)*75);
			int anim4 = (int) (centreY - Math.cos(radian)*75);
			String j = Integer.toString(i);
			g.drawString(j, anim3, anim4);
			
		}
	}

}
