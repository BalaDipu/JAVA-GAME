package Autopackage;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class gameSetUp implements Runnable{
	private Thread thread;
	private Display display;
	private String title;
	private int width,height;
	private BufferStrategy buffer;
	private Graphics g;
	private gameManager manager;
	  
	
	public gameSetUp(String title, int width,int height ) {
		this.title=title;
		this.width =width;
		this.height= height;
		
		
	}
	
	public void init() {
		display = new Display(title,width,height); 
	   manager =new gameManager();
	   manager.init();

		
	}
	
	
	
	public synchronized void start() {
		if(thread==null) {
			thread=new Thread(this);
			thread.start();
		}
	}
	
	
	public synchronized void stop() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public void tick() {
		manager.tick();
		
	}
	
	
	public void render() {
		buffer = display.canvas.getBufferStrategy();
		if(buffer == null) {
			display.canvas.createBufferStrategy(3);
			return;
		}
		g=buffer.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		manager.render(g);
		
		buffer.show();
		g.dispose();
		
		
	}
	
	
	
	public void run() {
		init();
		
		int fps=50;
		double timePerUpdate = 1000000000/fps;
		double delta = 0;
		long outLoopTime = System.nanoTime();
		
		
		
		while(true) {
			delta = delta + (System.nanoTime()-outLoopTime)/timePerUpdate;
			outLoopTime = System.nanoTime();
			if(delta>=1){
			tick();
		    render();
		    delta--;
		    
			}
		}
		
	}

}
