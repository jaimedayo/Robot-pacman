
public class Enemyh extends Charac{
	public int secX;
	public int secY;
	public Enemyh(int posX, int posY,int secX, int secY) {
		super(posX, posY);
		this.secX=secX;
		this.secY=secY;
	}
	public int getsX() {
		return secX;
	}
	public int getsY() {
		return secY;
		}
}
