import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;



import controlP5.*;

public class Main extends PApplet {

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
	}
	PImage back1;
	PImage back2;
	PImage back3;
	PImage battery;
	PImage coin;
	PImage enemiv;
	PImage enemio;
	PImage fire;
	PImage firetrap;
	PImage gate;
	PImage key;
	PImage player;
	PImage shield;
	PImage wood;
	PImage guner;
	PImage multip;
	
	
	Player a;
	
	
	ControlP5 cp5;

	String textValue = "";

		String text;
	int [][] matrix; 
	int col,row;
	
	int posX,posY;
	int pag;
	int matX, matY;
	int sec;
	int time=0;
	int cont=0;
	int cont1=0;
	int r ;
	int l ;
	int p ;
	int d ;
	public void settings() {
		size(800, 550);
	}

	public void setup() {
		
		PFont font = createFont("arial",20);
		  
		  cp5 = new ControlP5(this);
		                 
		  cp5.addTextfield("textValue")
		     .setPosition(300,155)
		     .setSize(250,60)
		     .setFont(createFont("arial",20))
		     .setAutoClear(false)
		     ;
		       
		  cp5.addBang("clear")
		     .setPosition(550,155)
		     .setSize(80,60)
		     .getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER)
		     ;    
		  
		
		  textFont(font);
	
		
		back1 = loadImage("image/frame1.png");
		back2 = loadImage("image/frame2.png");
		back3 = loadImage("image/frame3.png");
		battery = loadImage("image/battery.png");
		coin = loadImage("image/coin.png");
		enemio = loadImage("image/enenmio.png");
		enemiv = loadImage("image/enemiv.png");
		fire = loadImage("image/fire.png");
		firetrap = loadImage("image/firetrap.png");
		gate = loadImage("image/gate.png");
		guner = loadImage("image/guner.png");
		key = loadImage("image/key.png");
		multip = loadImage("image/multip.png");
		player = loadImage("image/player.png");
		shield = loadImage("image/shield.png");
		wood = loadImage("image/wood.png");
		
		col  = 11;
		row  = 10;
		posX = 1;
		posY = 1;
	
		
		matX = 1;
		matY = 1;
	    matrix  = new int [][]{
	    	{11,11,11,11,11,11,11,11,11,11,11},
			{11,0,5,4,5,2,5,3,5,0,11},
			{11,6,5,1,1,1,1,1,5,1,11},
			{11,1,5,1,1,6,5,5,5,1,11},
			{11,6,1,1,1,1,5,1,1,1,11},
			{11,5,1,1,5,1,5,1,1,1,11},
			{11,5,1,5,5,1,0,1,1,1,11},
			{11,1,1,1,5,1,5,1,1,1,11},
			{11,1,6,1,5,0,5,1,6,1,11},
			{11,11,11,11,11,11,11,11,11,11,11}
		};
	}

	public void draw() {
		sec= second();
		
switch(pag) {
		
case 0://startscreen
			
			image(back1, 0, 0);

					
		

			break;//gamescreen
		case 1:
			println(a.getCoin());
			image(back2, 0, 0);
			
			//life points
			switch(a.getLive()) {
			case 0:
				break;
			case 1:
				battery(8,75);
				break;
			case 2:
				battery(8,75);
				battery(68,75);
				break;
			case 3:
				battery(8,75);
				battery(68,75);
				battery(128,75);
				
				break;
			}
if(a.getPro()) {
	
	shield(80, 440);
}
if(a.getState()) {
	multip(20, 440);
	
}
			//score
			fill(210);
			  textSize(50);
			  text(a.getCoin(), 96, 380);
			//temporizador 
			  if(sec > time) {
				  time=sec;
				 cont++;
			  }
			  if(sec>60) {
				  sec =0;
			  }
			  if(cont>=60) {cont1++;}
			
		
			  fill(210);
			  textSize(32);
			  text(cont1 + ":"+ cont, 60, 237);
			
			
			//matix
			for (int i = 0; i < col; i++) {
				for (int j = 0; j < row; j++) {
					if(matrix[j][i] == 0) {
						fill(255);
					}else if (matrix[j][i] == 1) {
						coin((i*64+136), (j*64-45));
						
					}else if (matrix[j][i] == 2) {
						shield((i*64+140), (j*64-45));
						
					}else if (matrix[j][i] == 3) {
						battery((i*64+146), (j*64-35));
						
					}else if (matrix[j][i] == 4) {
						multip((i*64+136), (j*64-45));
						
					}else if (matrix[j][i] == 5) {
						wall((i*64+136), (j*64-45));
						
					}else if (matrix[j][i] == 6) {
						firetrap((i*64+136), (j*64-45));
						
					}else if (matrix[j][i] == 7) {
						turret((i*64+136), (j*64-45));
						
					}else if (matrix[j][i] == 8) {
						rect((i*64+136), (j*64-3),(64),(20));
						
					}else if (matrix[j][i] == 9) {
						enemiv((i*64+136), (j*64-45));
						
					}else if (matrix[j][i] == 10) {
						enemio((i*64+136), (j*64-45));
						
					}else if (matrix[j][i] == 11) {
						
						
					}else if (matrix[j][i] == 12) {
						gate((i*64+136), (j*64-45));
					}
				else if (matrix[j][i] == 13) {
					firetrapOn((i*64+136), (j*64-45));
					
				}else {
						fill(255,0,0);
					}
					if(sec%3==0&&matrix[j][i] == 6) {
						matrix[j][i] = 13;}else{
							if(matrix[j][i] == 13) {
								matrix[j][i] = 6;
						}
						r = matrix[posY][posX+1];
						l = matrix[posY][posX-1];
						p = matrix[posY-1][posX];
						d = matrix[posY+1][posX];
					}
				}
					
			}
			player(a.getX(),a.getY());
			if(posX==9 && posY==1) {
				pag=2;
			}
			break;
			
			
		case 2: //scorescreen
			
			image(back3, 0, 0);//background
			//username
			
			 fill(255);
			  text(cp5.get(Textfield.class,"textValue").getText(), 330,160);
	
			//temporizador 
			fill(220);
			  textSize(40);
			text(cont1 + ":"+ cont, 460, 255);
			//score

			  textSize(50);
			  text(a.getCoin(), 310, 255);
			break;
		case 3:
			background(20);
			
				
			
				
			break;
		case 4:
			break;
		
		}
		
	}
	

	private void turret(int i, int j) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed() {
		if(mouseY>268 && mouseY<313 &&  mouseX>315 && mouseX<478 && pag==0) {
			cp5.get("textValue").hide();
			cp5.get("clear").hide();
			a = new Player(200,20,2,false,0,0,false,0);
			
			
			
	pag=1;}
	
		if(mouseY>350 && mouseY<394 &&  mouseX>315 && mouseX<478 && pag==2) {
		
		
pag=0;}
	if(mouseY>350 && mouseY<394 &&  mouseX>315 && mouseX<478 && pag==0) {
		cp5.get("textValue").hide();
		cp5.get("clear").hide();
		
pag=2;}

}
	
	public void keyPressed() {
		
	
	
		switch (keyCode) {
		

		case RIGHT:
			switch (r) {
			case 0:
				a.move(3);
				posX=posX+1;
				
				break;
				
			case 1:
				a.move(3);
				posX=posX+1;
				a.coinObtein();
				taker();
				break;
				
			case 2:
				a.move(3);
				a.setProtect();
				posX=posX+1;
				taker();
				break;
				
			case 3:
				a.move(3);
				a.setbattery();
				posX=posX+1;
				taker();
				
				break;
				
			case 4:
				a.move(3);
				a.setState();
				posX=posX+1;
				taker();
				break;
				
			case 6:
				a.move(3);
				posX=posX+1;
				break;
					
			}
			

			break;
		case LEFT:
			switch (l) {
			case 0:
				a.move(2);
				posX=posX -1;
				
				break;
				
			case 1:
				a.move(2);
				posX=posX -1;
				a.coinObtein();
				taker();
				break;
				
			case 2:
				a.move(2);
				a.setProtect();
				posX=posX -1;
				taker();
				break;
				
			case 3:
				a.move(2);
				a.setbattery();
				posX=posX -1;
				taker();
				break;
				
			case 4:
				a.move(2);
				a.setState();
				posX=posX -1;
				taker();
				break;
				
			case 6:
				a.move(2);
				posX=posX -1;
				break;
			}
			break;
		case UP:
			switch (p) {
			case 0:
				a.move(0);
				posY=posY -1;
				break;
				
			case 1:
				a.move(0);
				posY=posY -1;
				a.coinObtein();
				taker();
				break;
				
			case 2:
				a.move(0);
				a.setProtect();
				posY=posY -1;
				taker();
				
				break;
				
			case 3:
				a.move(0);
				a.setbattery();
				posY=posY -1;
				taker();
				break;
				
			case 4:
				a.move(0);
				a.setState();
				posY=posY -1;
				taker();
				break;
				
			case 6:
				a.move(0);
				posY=posY -1;
				break;
			
		}
			break;
		case DOWN:
			switch (d) {
			case 0:
				a.move(1);
				posY=posY+1;
				break;
				
			case 1:
				a.move(1);
				posY=posY+1;
				a.coinObtein();
				taker();
				break;
				
			case 2:
				a.move(1);
				a.setProtect();
				posY=posY+1;
				taker();
				break;
				
			case 3:
				a.move(1);
				a.setbattery();
				posY=posY+1;
				taker();
				break;
				
			case 4:
				a.move(1);
				a.setState();
				posY=posY+1;
				taker();
				break;
				
			case 6:
				a.move(1);
				posY=posY+1;
				break;
		
			}
			break;
		}
		
	}
	public void taker() {
		 matrix[posY][posX]=0;
	}
	
	//drawing section
	public void firetrapOn (int x, int y) {
		image(firetrap, x, y,64,64);
		image(fire, x, y,64,64);}
	
	public void wall(int x, int y) {
		image(wood, x, y,64,64);
	}
	public void firetrap(int x, int y) {
		image(firetrap, x, y,64,64);
		
	}
	
	
	public void player(int x, int y) {
		image(player, x, y,63,63);
	}
	
	public void battery(int x, int y) {
		image(battery, x, y);
	}
	
	public void coin(int x, int y) {
		
		image(coin, x+10, y+10);
		
	}
	
	public void enemiv(int x, int y) {
		image(enemiv, x, y);
	}
	public void enemio(int x, int y) {
		image(enemio, x, y);
	}
	
	public void gate(int x, int y) {
		image(gate, x, y,64,64);
	}
	
	public void guner(int x, int y) {
		image(guner, x, y,64,64);
	}
	
	public void multip(int x, int y) {
		image(multip, x, y);
	}
	public void shield(int x, int y) {
		image(shield, x, y);
	}
	
	
	public void clear() {
		  cp5.get(Textfield.class,"textValue").clear();
		}

		void controlEvent(ControlEvent theEvent) {
		  if(theEvent.isAssignableFrom(Textfield.class)) {
		    println("controlEvent: accessing a string from controller '"
		            +theEvent.getName()+"': "
		            +theEvent.getStringValue()
		            );
		  }
		}
		public void input(String theText) {
		  // automatically receives results from controller input
		  println("a textfield event for controller 'input' : "+theText);
		}
}
