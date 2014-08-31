int xCanvas = 500;                     // size of canvas
int yCanvas = 500;                     // size of canvas

int[] xCookieLocation = new int[10];               // X value of cookies 
int[] yCookieLocation = new int[10];               // Y value of cookies

int cookieSize = 70;                   // Cookie Size

boolean  mouseClicked = false;         // to let the word Click turn into Cookies

PImage cookieMonster;

void setup()
{
    size(xCanvas, yCanvas);
    cookieMonster = loadImage("cookieMonster.png");
    randomizedXPosition();
    randomizedYPosition();
}

void draw()
{
    background(0, 255, 0);
    drawText();
    drawCookies();
    image(cookieMonster, -95, 120);
    mouseClicking();
}

void randomizedXPosition()
{
    for(int i = 0; i < xCookieLocation.length; ++i)
    {
        xCookieLocation[i] = (int)(Math.random()* xCanvas);
    }
}

void randomizedYPosition()
{
    for(int i = 0; i < xCookieLocation.length; ++i)
    {
        yCookieLocation[i] = (int)(Math.random()* - 1500);
    }
}

void drawCookies()
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

void mouseClicking()
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

void mouseClicked()
{
    mouseClicked = true;
}   

void drawText()
{
	fill(0, 0, 255);
    textAlign(CENTER);
    textSize(60);
    text("Cookiiiieesssssss!", xCanvas/2, yCanvas/2 - 150);
}

