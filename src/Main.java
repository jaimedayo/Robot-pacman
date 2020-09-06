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
			  noStroke();
		
			  fill(210);
			  textSize(32);
			  text(cont1 + ":"+ cont, 60, 237);
			
			
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
		if(mouseY>500) {
			cp5.get("textValue").hide();
			cp5.get("clear").hide();
	pag++;}
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
