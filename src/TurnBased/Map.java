package TurnBased;

import processing.core.PApplet;


public class Map {
    PApplet pApplet;
    Tile[][] room;


    public Map(PApplet pApplet) {

        this.room = new Tile[Main.mapSize][Main.mapSize];
        this.pApplet = pApplet;
        initEmptyMap(pApplet);

    }

    private void initEmptyMap(PApplet pApplet) {
        for(int i = 0; i<room.length; i++  )
            for (int j = 0; j<room[i].length; j++) {
                room[i][j] = new GrassField(i,j, pApplet);
            }
    }

    void display(int x, int y) {
        //Draws the map. Tiles + characters
        for (int i = 0; i < room.length; i++)
            for (int k = 0; k < room[0].length; k++) {
                room[i][k].display(x + i * 32, y + k * 32);
            }
        //Loops and draws all characters
        for (int i = 0; i < room.length; i++)
            for (int k = 0; k < room[0].length; k++)
                if (room[i][k].getCharacter() != null)
                    room[i][k].getCharacter().display(x + i * 32, y + k * 32);
    }


    void moveCharacter(int xStart, int yStart, int xEnd, int yEnd ){

        try{
            CharacterClass character = room[xStart][yStart].getCharacter();
            room[xEnd][yEnd].setCharacter(character);
            character.setPlacement(room[xEnd][yEnd]);
            room[xStart][yStart].setCharacter(null);


        }catch (NullPointerException e){
            System.out.println(e);

        }

    }


}
