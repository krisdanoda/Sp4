package TurnBased;

import processing.core.PApplet;

public class GrassField extends Tile{


    public GrassField(int x, int y, PApplet pApplet) {
        super(x, y, pApplet);
        impassable = false;
    }
    public void display(int x, int y ){

        pApplet.stroke(255);
        pApplet.strokeWeight(2);
        pApplet.fill(60,160,80);
        pApplet.square(x,y,32);

    }
}
