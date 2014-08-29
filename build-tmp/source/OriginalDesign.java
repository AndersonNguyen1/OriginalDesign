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

int xCanvas = 500;                     // size of canvas
int yCanvas = 500;                     // size of canvas

int[] xCookieLocation = new int[10];               // X value of cookies 
int[] yCookieLocation = new int[10];               // Y value of cookies

int cookieSize = 70;                   // Cookie Size

boolean  mouseClicked = false;         // to let the word Click turn into Cookies

PImage cookieMonster;

public void setup()
{
    size(xCanvas, yCanvas);
    cookieMonster = loadImage("cookieMonster.png");
    randomizedXPosition();
    randomizedYPosition();
}

public void draw()
{
    background(0, 255, 0);
    drawText();
    drawCookies();
    image(cookieMonster, -95, 120);
    mouseClicking();
}

public void randomizedXPosition()
{
    for(int i = 0; i < xCookieLocation.length; ++i)
    {
        xCookieLocation[i] = (int)(Math.random()* xCanvas);
    }
}

public void randomizedYPosition()
{
    for(int i = 0; i < xCookieLocation.length; ++i)
    {
        yCookieLocation[i] = (int)(Math.random()* - 1500);
    }
}

public void drawCookies()
{
    for(int i = 0; i < xCookieLocation.length; ++i)
    {
        stroke(250, 69, 19);
        fill(139, 69, 19);
        ellipse(xCookieLocation[i], yCookieLocation[i], cookieSize, cookieSize);
        yCookieLocation[i] += 10;
        if (yCookieLocation[i] > yCanvas + cookieSize/2+ 300)
        {
            xCookieLocation[i] = (int)(Math.random()* xCanvas);
            yCookieLocation[i] = (int)(Math.random()* - 1500);
            yCookieLocation[i] = 0;            
        }   
    }
}

public void mouseClicking()
{
    if (mouseClicked)
    {
        background(0, 255, 0);
        fill(0, 0, 255);
        textAlign(CENTER);
        textSize(60);
        text("Coooookieees!", xCanvas/2, yCanvas/2 - 150);
        image(cookieMonster, -95, 120);
        drawCookies();
    }
}   

public void mouseClicked()
{
    mouseClicked = true;
}   

public void drawText()
{
	fill(0, 0, 255);
    textAlign(CENTER);
    textSize(60);
    text("Click Me!", xCanvas/2, yCanvas/2 - 150);
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
