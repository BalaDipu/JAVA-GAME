package Autopackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Motor implements KeyListener {
	private int x,y;
	private int ofset;
	   
	private double speed;
	
//direction
	private boolean left,right,up,down;
	
	private int health;
	private int gare;
	
	
	//contructor
	
	
	
	public Motor() {
		
		x=Display.width-50;
		y=Tile.tileHeight*100;
		ofset=0;
		speed = 0.3f;
		health= 5;
		gare =  0;
		
		
		
		
	}
	
	public void init() {
		Display.frame.addKeyListener(this);
		
		
	
	}
	public void tick() {
		
		if(health>0) {
		
		
		ofset = y-(Display.height-150);
		if(right){
			if(x<=721)
			x += 3;
		}
		if(left){
			if(x>=379)
			x -= 3;
		}
		if(up){
			if(y>1000) {
			speed+=0.03f;
			if(speed>=7) {
				speed=7;
			}
		}
	}
		
}	
		if(y>1000)
		y-=speed;
		
		if(down){
			speed -=  0.030f; 
			if(speed<=0) {
				speed =0;
			}
		}
		y-=speed;
		
		}
		
	public double getSpeed() {
		return speed;
	}
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getOfset() {
		return ofset;
		
	}
	public void setSpeed(double speed) {
		this.speed= speed;
	}
	
	
	public void setHealth(int health) {
		this.health = health;
		
		
	}
	
	
	
	
	
	public void drawBoard(Graphics g) {
		int speed1 =(int)speed;
		switch(speed1) {
		
		case 0 :gare = 0;
		break;
		case 2 :gare = 1;
		break;
		case 4 : gare = 2;
		break;
		case 6 : gare = 3;
		break;
//		case 8 :gare = 4;
//		break;
//		case 10 : gare = 5;
//		break;
//		case 12 : gare = 6;
//		break;
//		case 14 : gare = 7;
//		break;
	
		
		
		}
		g.setColor(Color.lightGray);
		g.fillRect(10 ,10,250,100);
		//draw gare 
		g.setColor(Color.black);
		String Sgare = Integer.toString(gare);
		g.setFont(new Font("arial", Font .BOLD,30));
		g.drawString("My Car Gare :"+Sgare,20,40);
		g.drawString("My Car Power :"+health,20,80); 
		
		
		
	}
	
	public void GameOver(Graphics g) {
		g.setColor(Color.WHITE);
	    g.setFont(new Font("arial",Font.BOLD,80));
	    g.drawString("GAME OVER !!",Display.width/2,Display.height/2);
	    
	    
		
	}
	
	
	
	public void render(Graphics g) {
		
//		g.setColor(Color.red);
//		g.fillRect(x, y-ofset,80,120);
		if(health>0) {
		g.setColor(Color.red);
		g.drawImage(loadImage.playerMotor ,x,y-ofset,60,100,null);
		}
		else {
			GameOver(g);
		}
		//drawBoard
		drawBoard(g);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int source = e.getKeyCode();
		if(source==KeyEvent.VK_RIGHT) {
			right = true;
		}
		if(source==KeyEvent.VK_LEFT) {
			left = true;
		}
		if(source==KeyEvent.VK_UP) {
			up = true;
		}
		if(source==KeyEvent.VK_DOWN) {
			down = true;
		}
	
	
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int source = e.getKeyCode();
		
		if(source==KeyEvent.VK_RIGHT) {
			right = false;
		}
		if(source==KeyEvent.VK_LEFT) {
			left = false;
		}
		if(source==KeyEvent.VK_UP) {
			up = false;
		}
		if(source==KeyEvent.VK_DOWN) {
			down = false;
		}
		
	

		
	}
	@Override
	public void keyTyped(KeyEvent e) {

		
	}

}
