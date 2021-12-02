package TurnBased;

import processing.core.PApplet;


public class Mountain extends Tile {

    public Mountain(int x, int y, PApplet pApplet) {
        super(x, y, pApplet);
        impassable = true;

    }
    @Override
    public void display(int x, int y ){
        pApplet.stroke(255);
        pApplet.strokeWeight(2);
        pApplet.fill(102, 51, 0);
        pApplet.square(x,y,32);

    }

    @Override
    public CharacterClass getCharacter() {
        return super.getCharacter();
    }

    @Override
    public void setCharacter(CharacterClass character) {
        super.setCharacter(character);
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }
}
