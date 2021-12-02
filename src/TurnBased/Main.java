package TurnBased;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import static java.awt.event.KeyEvent.*;

public class Main extends PApplet {
    Player player;
    int animationCounter;
    static int block = 32;
    PImage img;
    static Map map;
    static int gameState = 1, mapSize = 20;

    public static void main(String[] args) {

        PApplet.main(new String[]{Main.class.getName()});


    }

    @Override
    public void settings() {
        size(mapSize * block, mapSize * block + 4 * block);

    }

    @Override
    public void setup() {
        frameRate(30);
        animationCounter = 0;
        map = new Map(this);

        //Player stuff
        player = new Player(map.room[0][0], this);
        map.room[0][0].setCharacter(player);

    }

    @Override
    public void draw() {
        background(255);
        map.display(0, 0);

        animationCounter++;
        if (animationCounter >= 8) {
            animationCounter -= 8;
            player.updateAnimationCounter();

        }


    }

    @Override
    public void keyPressed() {

        if (gameState == 1) {
            if (keyCode == VK_W) {
                //player.setDirection("w");
                if(player.getXy().x==0 && player.getXy().y==0)
                player.move(player.getX(),player.getY()-1);

            } else if (keyCode == VK_S) {
                //player.setDirection("s");
                if(player.getXy().x==0 && player.getXy().y==0)

                    player.move(player.getX(),player.getY()+1);


            } else if (keyCode == VK_D) {
                //player.setDirection("d");
                if(player.getXy().x==0 && player.getXy().y==0)

                    player.move(player.getX()+1,player.getY());
            } else if (keyCode == VK_A) {
                //player.setDirection("a");
                if(player.getXy().x==0 && player.getXy().y==0)
                    player.move(player.getX()-1,player.getY());
            }
        }

    }


    /*
    @Override
    public void mouseClicked() {

        if (gameState == 1) {
            int x1 = (int) Math.floor(mouseX / 32);
            int y1 = (int) Math.floor(mouseY / 32);

            if (mouseButton == LEFT) {
                System.out.println("leftclick");
                selectedUnit = map.room[x1][y1];
                if (map.room[x1][y1].character != null)
                    selectedUnit = map.room[x1][y1].getCharacter();


            } else if (mouseButton == RIGHT) {
                System.out.println("rightClick");
                if (selectedUnit != null)
                    selectedUnit.rightClick();

            }


        }
    }
    */

}