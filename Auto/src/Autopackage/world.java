package Autopackage;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class world {
	private int[][] tile;
	private int width;
	private int height;
	private Motor motor;
	
	public world(Motor motor) {
		loadWorld("bala/world.txt");
		this.motor = motor;
		
	}


	
	public String loadFile(String path){ 
		StringBuilder sr = new StringBuilder();
		
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line;
			while((line = reader.readLine())!=null) {
				sr.append(line +"\n");
				
			}
			reader.close();
			
		} catch (IOException e){
			e.printStackTrace();
		}
		return sr.toString();
		
	}
	
	private int parseInt(String number) {
		return Integer.parseInt(number);
		
	}
	
	
	private void loadWorld(String path) {
		String file = loadFile(path);
		String[] space = file.split("\\s+");
		width = parseInt(space[0]);
		height = parseInt(space[1]);
		tile = new int[width][height];
		for(int x =0;x<width;x++) {
			for(int y=0;y<height;y++) {
				tile[x][y] = parseInt( space[(x+y*width)+2]);		
				
			}
		}
		
	}
	
	
	
	public void render(Graphics g) {
		
		int start = Math.max(0, (motor.getOfset())/Tile.tileHeight);
		int end = Math.min(height, (motor.getOfset()+Display.height+20)/Tile.tileHeight);
		
		for(int i=0;i<width;i++) {
			for(int j=start;j<height;j++) {  
				Tile t = Tile.tiles[tile[i][j]];
				t.render(g, i*Tile.tileWidth, (j*Tile.tileHeight)-motor.getOfset());
				
			}
		}
		
	}

}
