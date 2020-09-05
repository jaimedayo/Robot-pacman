import processing.core.PApplet;

public class Main extends PApplet {

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
	}
	
	int [][] matrix; 
	int col,row;
	int posX,posY;
	
	int matX, matY;

	public void settings() {
		size(400, 400);
	}

	public void setup() {
		col     = 10;
		row     = 10;
		posX = 60;
		posY = 60;
		matX = 1;
		matY = 1;
	    matrix  = new int [][]{
	    	{1,1,1,1,1,1,1,1,1,1},
			{1,0,0,2,2,2,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1}
		};
	}

	public void draw() {
		background(0);
		
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				if(matrix[j][i] == 0) {
					fill(255);
				}else if (matrix[j][i] == 1) {
					fill(0);
				}else {
					fill(255,0,0);
				}
				rect((i*40),(j*40),40,40);
			}
		}
		
		ellipse(posX,posY,40,40);
	}

	public void mousePressed() {
	
	}
	
	public void keyPressed() {
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
