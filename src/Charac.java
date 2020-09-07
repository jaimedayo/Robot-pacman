

public class Charac {
	public int posX;
	public int posY;
	public Charac(int posX,int posY) {
		this.posX = posX;
		this.posY = posY;
	}

	public void move(int ty) {
		switch(ty) {
		case 0://up
			posY= posY-64;
			
			break;
		case 1://down
			posY=  posY+64;
			
			break;
		case 2://left
			posX= posX-64;
			
			break;
		case 3://right
			posX= posX+64;
			break;
			
		}
	}

	public int getX() {
		return posX;
	}
	public int getY() {
		return posY;
	}
}
