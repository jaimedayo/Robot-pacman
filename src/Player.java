
public class Player extends Charac{
	
private int coin;
	public int live;
	public boolean protect;
	public int count;
	public int countp;
	public boolean state;
	public Player(int posX, int posY,int live,boolean protect,int count,int countp,boolean state,int coin) {
		super(posX, posY);
		this.live=live;
		this.coin=coin;
		this.protect=protect;
		this.count=count;
		this.countp=countp;
		this.state=state;
	
		
		
	
		// TODO Auto-generated constructor stub
		
		}

	public void damage() {
		if (protect==false) {
			live--;
		}
		}
public int getLive() {
		return live;
	}
	}

	

