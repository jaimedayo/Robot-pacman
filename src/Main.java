import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
	}
	PImage back1;
	PImage back2;
	PImage back3;
	
	int [][] matrix; 
	int col,row;
	int posX,posY;
	int pag;
	int matX, matY;

	public void settings() {
		size(800, 550);
	}

	public void setup() {
		
		back1 = loadImage("image/frame1.png");
		back2 = loadImage("image/frame2.png");
		back3 = loadImage("image/frame3.png");
		col     = 11;
		row     = 10;
		posX = 200;
		posY = 19;
		matX = 1;
		matY = 1;
	    matrix  = new int [][]{
	    	{1,1,1,1,1,1,1,1,1,1,1},
			{1,0,0,2,2,2,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1,1}
		};
	}

	public void draw() {
		
		switch(pag) {
		case 0:
			
			image(back1, 0, 0);
			
			break;
		case 1:
			
			
			image(back2, 0, 0);
			
			
			//matix
			for (int i = 0; i < col; i++) {
				for (int j = 0; j < row; j++) {
					if(matrix[j][i] == 0) {
						fill(255);
					}else if (matrix[j][i] == 1) {
						fill(0);
					}else {
						fill(255,0,0);
					}
					rect((i*64+136),(j*64-45),64,64);
				}
			}
			
			ellipse(posX,posY,40,40);
		
			break;
		case 2:
			image(back3, 0, 0);
			break;
		case 3:
			break;
		case 4:
			break;
		
		}
		
	}
	public void mousePressed() {
	pag++;
	}
	
	public void keyPressed() {
		
		switch(pag) {
		case 0:
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		
		}
		switch (keyCode) {
		case RIGHT:
			if(matrix[matY][matX+1]!=1) {
				posX += 40;
				matX++;
			}
			break;
		case LEFT:
			if(matrix[matY][matX-1]!=1) {
				posX -= 40;
				matX--;
			}
			break;
		case UP:
			if(matrix[matY-1][matX]!=1) {
				posY -= 40;
				matY--;
			}
			break;
		case DOWN:
			if(matrix[matY+1][matX]!=1) {
				posY += 40;
				matY++;
			}
			break;
		default:
			break;
		}
	}
}
