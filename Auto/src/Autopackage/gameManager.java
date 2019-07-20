package Autopackage;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class gameManager {
	
	private world world;
  	private Motor motor;
  	private long time = System.nanoTime();
  	private long delay;
  	private int health;
  	private speedMeter meter;
  	
  	
  	private ArrayList<EnemyMotor> eMotor;
	
	
	
	
	
	  public gameManager() {
		 
		  motor=new Motor();
		  world = new world(motor);
		  meter =new speedMeter(motor);
		  eMotor = new ArrayList<EnemyMotor>();
			delay=2000;
			health=5;
		  
		
	  }
	  public void init(){
		  
		  
		 loadImage.init();
		 motor.init();
		
		
	  }
      public void tick(){
    	 
    	  motor.tick(); 
    	  Random rand = new Random();
    	  int randX = rand.nextInt(800);
    	  int randY = rand.nextInt(Display.height);
    	  while(randX<310) {
    		  randX = rand.nextInt(800);
    	  }
    	  //r1.x = player motor x ;
    	  // r1.y = player motor y;
    	  //r2.x= enemy motor x;
    	  //r2.y = enemy motor y;
    	  
    	  
    	  /* if(r1.x<r2.x + width &&
    	   *  r1.x + width>r2.x &&
    	   *   r1.y<r2.y + width &&
    	   *    r1.y + width > r2.y) */
    	    
    	  for(int i=0;i<eMotor.size();i++) {
    		  int px =motor.getX();
    		  int py = motor.getY();
    		  
    		  
    		  int ex =eMotor.get(i).getX();
    		  int ey =eMotor.get(i).getY();
    		  /* if(r1.x<r2.x + width &&
        	   *  r1.x + width>r2.x &&
        	   *   r1.y<r2.y + width &&
        	   *    r1.y + width > r2.y) */
    		  if(px < ex + 60 && px + 60 > ex &&
    				  py < ey +60 && py + 60 > ey) {
    			  
    			  eMotor.remove(i);
    			  i--;
    			  health --;
    			  System.out.println(health);
    			  
    			  motor.setSpeed(0);
    			  motor.setHealth(health);
    			  
    		  
    		  
    			   
    		  }
    		  
    	  }
    	  
    	  
    	  
    	  long elapsed=(System.nanoTime() -time)/1000000;
    	  if(elapsed>delay) {
    		  if(motor.getSpeed()>=3) {
    	  
    	  eMotor.add(new EnemyMotor( motor,randX,(-randY)+motor.getOfset()));
    	  
    		  }
    	  time = System.nanoTime();
    	  
    	  }
    	  
    	  //enemyMotor
    	  for(int i=0;i<eMotor.size();i++) {
    		  eMotor.get(i).tick();
    	  }
    	  
		
	  }
     public void render(Graphics g){
//    	 g.drawImage(loadImage.fullImage,40,40,100,100,null);
//    	 g.drawImage(loadImage.subImage1,200,200,100,100,null);
//    	 g.drawImage(loadImage.subImage2,400,400,100,100,null); 
    	 world.render(g);
    	 motor.render(g);
    	 meter.render(g);
    	 
    	 for(int i=0;i<eMotor.size();i++) {
    		 eMotor.get(i).render(g);
    		 
    	 }
    	 
    	 
    	 
    
     }	
	
}
