import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class OriginalDesign extends PApplet {

int xCanvas = 500;                     //size of canvas
int yCanvas = 500;					   //size of canvas

int yCookieLocation = 0;

int cookieSize = 70;

public void setup()
{
    size(xCanvas, yCanvas);
}

public void draw()
{
    drawMonsterFace();
    drawText();
    drawCookies();
}

public void mousePressed()
{
	background(255);
	fill(0, 0, 255);
	textAlign(CENTER);
	textSize(60);
	text("Coooookieees!", xCanvas/2, yCanvas/2 - 100);
	drawCookies();  

}

public void drawMonsterFace()
{
	fill(0, 0, 255);
	stroke(0, 0, 255);
    ellipse(xCanvas/2, yCanvas/2, 100, 100);
}

public void drawText()
{
	textAlign(CENTER);
	textSize(60);
	text("Click Me!", xCanvas/2, yCanvas/2 - 100);
}

public void drawCookies()
{
	stroke(250, 69, 19);
	fill(139, 69, 19);
	ellipse(random(0,500), yCookieLocation, cookieSize, cookieSize);
	yCookieLocation += 5;
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "OriginalDesign" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
