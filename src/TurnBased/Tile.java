package TurnBased;

import processing.core.PApplet;

abstract public class Tile {
PApplet pApplet;
CharacterClass character;
Boolean impassable;
int x,y;

    public Tile( int x, int y, PApplet pApplet) {
        this.pApplet = pApplet;
        this.x = x;
        this.y = y;
    }


    abstract public void display(int x, int y );


    public CharacterClass getCharacter() {
        return character;
    }

    public void setCharacter(CharacterClass character) {
        this.character = character;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
