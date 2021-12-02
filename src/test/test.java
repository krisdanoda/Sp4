package test;

public class test {
    public static void main(String[] args) {

        player player1 = new player("1");
        player player2 = player1;
        player1 = new player("2");

        System.out.println(player2.name);



    }
}
