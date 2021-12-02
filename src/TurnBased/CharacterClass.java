package TurnBased;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

abstract public class CharacterClass {
    PApplet pApplet;
    PImage[] s, a, w, d;
    Tile placement; //placement is a reference to the tile the character is on
    PVector xy;     //Used for moving animation, not the actual coordinates
    PImage currentImg;
    int animationCounter;
    String direction;
    int hp, attack;
    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setDirection(PVector xy) {
        if (this.xy.x == 0 && this.xy.y == 0) {
            this.xy = xy;
            if (0 < xy.x) {
                direction = "d";
            } else if (0 > xy.x) {
                direction = "a";
            }
            if (0 < xy.y) {
                direction = "s";
            } else if (0 > xy.y) {
                direction = "w";
            }
        }


    }



    abstract void updateAnimationCounter() ;
    abstract void updatePosition();
    abstract public void display(int x, int y);

    public void updateAnimation() {
        //update animation
        if (0 < xy.x) {
            xy.x -= 4;
            this.direction = "d";
        } else if (0 > xy.x) {
            xy.x += 4;
            this.direction = "a";
        }
        if (0 < xy.y) {
            this.direction = "s";
            xy.y -= 4;
        } else if (0 > xy.y) {
            this.direction = "w";
            xy.y += 4;
        }
        //System.out.println(xy.x + " : " + xy.y);
    }

    public void move(int endX, int endY){

        Tile tempTile = this.placement;
        try {
            Tile newTile = Main.map.room[endX][endY];
            this.xy = new PVector((newTile.getX() - tempTile.getX()) * 32, (newTile.getY() - tempTile.getY()) * 32);
            Main.map.room[endX][endY].setCharacter(this);
            setPlacement(Main.map.room[endX][endY]);
            tempTile.setCharacter(null);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.printf("cant leave room lol");

        }

    }

    public PVector getXy() {
        return xy;
    }

    public void setXy(PVector xy) {
        this.xy = xy;
    }
    public int getX() {
        return placement.getX();
    }
    public int getY() {
        return placement.getY();
    }
    public Tile getPlacement() {
        return placement;
    }
    public void setPlacement(Tile placement) {
        this.placement = placement;
    }
}
