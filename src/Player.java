



public class Player extends Charac{

	public int live;
	public boolean protect;
	public int count;
	public int countp;
	public boolean state;
	public Player(int posX, int posY,int live,boolean protect,int count,int countp,boolean state) {
		super(posX, posY);
		this.live=live;
		this.protect=protect;
		this.count=count;
		this.countp=countp;
		this.state=state;
		
		// TODO Auto-generated constructor stub
		
		}
	public void damage() {
		if (state) {
			live--;
		}
		}
	int getlive(){
		return live;	
		}
	public void paint() {
		
	}
	
	public void move(int ty) {
		switch(ty) {
		case 0://up
			posY=-46;
			
			break;
		case 1://down
			posY=+46;
			
			break;
		case 2://left
			posX=-46;
			
			break;
		case 3://right
			posX=+46;
			break;
			
		}
	}

}
