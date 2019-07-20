package Autopackage;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class loadImage {
	
	public static BufferedImage Motors,playerMotor,enemyMotor,enemyMotor1,enemyMotor2,enemyMotor3,fullImage;
	public static BufferedImage road;
	public static BufferedImage grass;
	public static BufferedImage footPath;
	
	public static void init() {
		
	fullImage=imageLoader("/background.png");
	Motors = imageLoader("/car1.png");
	enemyMotor1 = imageLoader("/car2.png");
	crop();
		
		
		
		
	}
	public static BufferedImage imageLoader(String path) {
		
		try {
			return ImageIO.read(loadImage.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
	public static void crop() {
//		 subImage1 = fullImage.getSubimage(0,0,135,200);
//     	 subImage2 = fullImage.getSubimage(140,0,134,200);
		grass= fullImage.getSubimage(0,0,134,200);
		road = fullImage.getSubimage(140,0,134,200);
		footPath=fullImage.getSubimage(260,0,134,200);
		
		
		playerMotor  = Motors.getSubimage(0, 0,50,93);
		enemyMotor = enemyMotor1.getSubimage(0, 0, 50,93); 
		
		
		
		
		
		
		 
		
	}
	

}
