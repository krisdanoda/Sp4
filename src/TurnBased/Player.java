package TurnBased;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Player extends CharacterClass {

    public Player(Tile tile, PApplet pApplet) {
        placement = tile;
        animationCounter = 0;
        direction = "s";
        this.pApplet = pApplet;
        xy = new PVector(0, 0);

        currentImg = pApplet.loadImage("\\sprites\\ff1.png");

        s = new PImage[]{pApplet.loadImage("\\sprites\\ff1.png"),
                pApplet.loadImage("\\sprites\\ff2.png"),
                pApplet.loadImage("\\sprites\\ff1.png"),
                pApplet.loadImage("\\sprites\\ff3.png")};

        d = new PImage[]{pApplet.loadImage("\\sprites\\fr1.png"),
                pApplet.loadImage("\\sprites\\fr2.png"),
                pApplet.loadImage("\\sprites\\fr1.png"),
                pApplet.loadImage("\\sprites\\fr3.png")};

        w = new PImage[]{pApplet.loadImage("\\sprites\\fb1.png"),
                pApplet.loadImage("\\sprites\\fb2.png"),
                pApplet.loadImage("\\sprites\\fb1.png"),
                pApplet.loadImage("\\sprites\\fb3.png")};

        a = new PImage[]{pApplet.loadImage("\\sprites\\fl1.png"),
                pApplet.loadImage("\\sprites\\fl2.png"),
                pApplet.loadImage("\\sprites\\fl1.png"),
                pApplet.loadImage("\\sprites\\fl3.png")};
    }


    public void display(int x, int y) {
        if (direction == "w")
            currentImg = w[animationCounter];
        else if (direction == "d")
            currentImg = d[animationCounter];
        else if (direction == "a")
            currentImg = a[animationCounter];
        else
            currentImg = s[animationCounter];


        updateAnimation();
        pApplet.image(currentImg, x - xy.x, y - xy.y);
    }

    @Override
    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
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

    public void move(int endX, int endY) {

        Tile tempTile = this.placement;
        try {
            Tile newTile = Main.map.room[endX][endY];
            if (newTile.getImpassable() == false) {
                this.xy = new PVector((newTile.getX() - tempTile.getX()) * 32, (newTile.getY() - tempTile.getY()) * 32);
                Main.map.room[endX][endY].setCharacter(this);
                setPlacement(Main.map.room[endX][endY]);
                tempTile.setCharacter(null);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.printf("cant leave room lol");

        }

    }


    void updateAnimationCounter() {
        animationCounter++;
        if (animationCounter >= s.length)
            animationCounter -= s.length;

    }


    @Override
    void updatePosition() {

    }
}
