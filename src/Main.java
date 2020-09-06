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
		
		col     = 11;
		row     = 10;
		posX = 200;
		posY = 19;
		matX = 1;
		matY = 1;
	    matrix  = new int [][]{
	    	{0,1,1,1,1,1,1,1,1,1,1},
			{1,0,1,0,1,0,1,0,1,0,1},
			{1,2,1,0,0,0,0,0,1,0,1},
			{1,0,1,0,0,2,1,1,1,0,1},
			{1,2,0,0,0,0,1,0,0,0,1},
			{1,1,0,0,1,0,1,0,0,0,1},
			{1,1,0,2,1,0,0,0,0,0,1},
			{1,0,0,0,1,0,1,0,0,0,1},
			{1,0,2,0,1,0,1,0,2,0,1},
			{1,1,1,1,1,1,1,1,1,1,1}
		};
	}

	public void draw() {
		sec= second();
		
switch(pag) {
		
case 0://startscreen
			
			image(back1, 0, 0);

					
		

			break;//gamescreen
		case 1:

			image(back2, 0, 0);
			
			

			
			
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
						wall((i*64+136), (j*64-45));
					}else if (matrix[j][i] == 2) {
						firetrap((i*64+136), (j*64-45));
					}
					else {
						fill(255,0,0);
					}
					
				}
			}
			
			ellipse(posX,posY,40,40);
		player(a.getX(), a.getY());
			break;
			
			
			
		case 2: //scorescreen
			
			image(back3, 0, 0);//background
			//username
			
			 fill(255);
			  text(cp5.get(Textfield.class,"textValue").getText(), 330,160);
	
			//temporizador 
			fill(210);
			  textSize(40);
			text(cont1 + ":"+ cont, 460, 255);
			break;
		case 3:
			background(20);
			
				
			
				
			break;
		case 4:
			break;
		
		}
		
	}
	

	public void mousePressed() {
		if(mouseY>268 && mouseY<313 &&  mouseX>315 && mouseX<478 && pag==0) {
			cp5.get("textValue").hide();
			cp5.get("clear").hide();
			a = new Player(200,20,3,false,0,0,false);
			
			
			
	pag=1;}
	
		if(mouseY>350 && mouseY<394 &&  mouseX>315 && mouseX<478 && pag==2) {
		
		
pag=0;}
	if(mouseY>350 && mouseY<394 &&  mouseX>315 && mouseX<478 && pag==0) {
		cp5.get("textValue").hide();
		cp5.get("clear").hide();
		
pag=2;}

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
			a.move(3);
			
			break;
		case LEFT:
			a.move(2);
			break;
		case UP:
			a.move(0);
			break;
		case DOWN:
			a.move(1);
			break;
		default:
			break;
		}
	}
	
	//drawing section
	
	public void wall(int x, int y) {
		image(wood, x, y,64,64);
	}
	public void firetrap(int x, int y) {
		image(firetrap, x, y,64,64);
		if(sec % 3 == 0) {
		image(fire, x, y,64,64);}
	}
	
	public void player(int x, int y) {
		image(player, x, y,64,64);
	}
	
	public void battery(int x, int y) {
		image(battery, x, y,64,64);
	}
	
	public void coin(int x, int y) {
		image(coin, x, y,64,64);
	}
	
	public void enemiv(int x, int y) {
		image(enemiv, x, y,64,64);
	}
	public void enemio(int x, int y) {
		image(enemio, x, y,64,64);
	}
	
	public void gate(int x, int y) {
		image(gate, x, y,64,64);
	}
	
	public void guner(int x, int y) {
		image(guner, x, y,64,64);
	}
	
	public void multip(int x, int y) {
		image(multip, x, y,64,64);
	}
	public void shield(int x, int y) {
		image(shield, x, y,64,64);
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
