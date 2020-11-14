package game;

import dice.DiceCup;
import gui_fields.*;
import gui_main.GUI;
import player.Player;

import java.awt.*;
import java.io.File;

public class Game
{

    private final Player player1;
    private final Player player2;
    private final DiceCup dice;
    private GUI gui;
    private GUI_Field[] fields;
    private Player currentPlayer;
    private boolean gameOver;

    public Game()
    {
        dice = new DiceCup();
        GUI.setNull_fields_allowed(true);

        fields = new GUI_Field[24];
        createField();
        gui = new GUI(fields, Color.WHITE);

        gameOver = false;

        String welcome_msg = "Welcome to the game!\n";
        gui.showMessage(welcome_msg);

        player1 = new Player(gui);
        player2 = new Player(gui);
        gui.addPlayer(player1.getGuiPlayer());
        gui.addPlayer(player2.getGuiPlayer());
        gui.showMessage("Okay " + player1.getName() + ", you start.");
        currentPlayer = player1;
    }

    public Game(String playerName1, String playerName2)
    {
        dice = new DiceCup();
        GUI.setNull_fields_allowed(true);

        fields = new GUI_Field[24];
        createField();
        gui = new GUI(fields, Color.WHITE);

        gameOver = false;

        player1 = new Player(playerName1);
        player2 = new Player(playerName2);
        gui.addPlayer(player1.getGuiPlayer());
        gui.addPlayer(player2.getGuiPlayer());
        currentPlayer = player1;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void close() {
        this.gui.close();
    }

    public void rollDice()
    {
        dice.rollDice();
        gui.setDice(dice.getDice1(), dice.getDice2());
    }

    public void turn(Player player)
    {
        gui.showMessage("It is " + player.getName() + "'s turn");

        rollDice();
        movePlayer(player, dice.getSum());
        gameOver();

        if(dice.getSum() != 10)
        {
            changePlayer();
        }
    }

    public void gameOver()
    {
        if (currentPlayer.getPoints() >= 3000)
        {
            this.gameOver = true;
        }

    }
    public void endGame()
    {
        this.gameOver = true;
        gui.showMessage("The game is over, " + currentPlayer.getName() + " has won!!");
        gui.close();
    }

    public Player getCurrentPlayer()
    {
        return currentPlayer;
    }

    public void changePlayer()
    {
        if (currentPlayer==player1)
        {
            currentPlayer = player2;
        }
        else
        {
            currentPlayer = player1;
        }
    }

    public void movePlayer(Player player, int roll)
    {
        Player otherPlayer;
        if (player==player1)
        {
            otherPlayer=player2;
        }
        else
        {
            otherPlayer=player1;
        }

        for (int i = 0; i<12; i++)
        {
            if(fields[i].hasCar(otherPlayer.getGuiPlayer()))
            {
                fields[i].removeAllCars();
                fields[i].setCar(otherPlayer.getGuiPlayer(), true);
            }
            else
            {
                fields[i].removeAllCars();
            }
        }

        fields[roll-1].setCar(player.getGuiPlayer(), true);
        //player.addPoints(Integer.parseInt(fields[roll-1].getSubText()));
        gui.showMessage(fields[roll-1].getDescription());
    }

    public void createField()
    {
        // Get the absolut file path for images in a way that works cross platform
        String IMAGE_DIR_PATH = System.getProperty("user.dir") + File.separator + "src"  + File.separator + "main"  + File.separator + "resources"  + File.separator+ "img"  + File.separator;
        System.out.println(IMAGE_DIR_PATH);
        fields[0] = new GUI_Shipping(IMAGE_DIR_PATH+"freepark.png","Gratis", "Parkering", "Gratis Parkering", "", Color.WHITE, Color.BLACK);
        fields[1] = new GUI_Shipping(IMAGE_DIR_PATH+"arcade.png","Spillehallen", "$3", "Spillehallen", "", Color.RED, Color.BLACK);
        fields[2] = new GUI_Shipping(IMAGE_DIR_PATH+"cinema.png","Biografen", "$3", "", "", Color.RED, Color.BLACK);
        fields[3] = new GUI_Shipping(IMAGE_DIR_PATH+"chance.png","Chance", "", "", "", Color.WHITE, Color.BLACK);
        fields[4] = new GUI_Shipping(IMAGE_DIR_PATH+"toystore.png","Legetøjsbutik", "$3", "", "", Color.YELLOW, Color.BLACK);
        fields[5] = new GUI_Shipping(IMAGE_DIR_PATH+"petstore.png","Dyrehandlen", "$3", "", "", Color.YELLOW, Color.BLACK);
        fields[6] = new GUI_Shipping(IMAGE_DIR_PATH+"gotoprison.png","Gå i", "Fængsel", "", "", Color.WHITE, Color.BLACK);
        fields[7] = new GUI_Shipping(IMAGE_DIR_PATH+"bowling.png","Bowlinghallen", "$4", "", "", Color.GREEN, Color.BLACK);
        fields[8] = new GUI_Shipping(IMAGE_DIR_PATH+"zoo.png","Zoo", "$4", "", "", Color.GREEN, Color.BLACK);
        fields[9] = new GUI_Shipping(IMAGE_DIR_PATH+"chance.png","Chance", "", "", "", Color.WHITE, Color.BLACK);
        fields[10] = new GUI_Shipping(IMAGE_DIR_PATH+"waterpark.png","Vandlandet", "$5", "", "", Color.BLUE, Color.BLACK);
        fields[11] = new GUI_Shipping(IMAGE_DIR_PATH+"beach.png","Strandpromenaden", "$5", "", "+650", Color.BLUE, Color.BLACK);
        fields[12] = new GUI_Shipping(IMAGE_DIR_PATH+"start.png","Start", "", "Modtag $2", "", Color.WHITE, Color.BLACK);
        fields[13] = new GUI_Shipping(IMAGE_DIR_PATH+"burgerbar.png","Burgerbaren", "$1", "", "", Color.ORANGE, Color.BLACK);
        fields[14] = new GUI_Shipping(IMAGE_DIR_PATH+"pizzahouse.png","Pizzariaet", "$1", "", "", Color.ORANGE, Color.BLACK);
        fields[15] = new GUI_Shipping(IMAGE_DIR_PATH+"chance.png","Chance", "", "", "", Color.WHITE, Color.BLACK);
        fields[16] = new GUI_Shipping(IMAGE_DIR_PATH+"candystore.png","Slikbutikken", "$1", "", "", Color.CYAN, Color.BLACK);
        fields[17] = new GUI_Shipping(IMAGE_DIR_PATH+"icecreamshop.png","Iskiosken", "$1", "", "", Color.CYAN, Color.BLACK);
        fields[18] = new GUI_Shipping(IMAGE_DIR_PATH+"inprison.png","I Fængsel", "", "", "", Color.WHITE, Color.BLACK);
        fields[19] = new GUI_Shipping(IMAGE_DIR_PATH+"museum.png","Museet", "$2", "", "", Color.MAGENTA, Color.BLACK);
        fields[20] = new GUI_Shipping(IMAGE_DIR_PATH+"library.png","Biblioteket", "$2", "", "", Color.MAGENTA, Color.BLACK);
        fields[21] = new GUI_Shipping(IMAGE_DIR_PATH+"chance.png","Chance", "", "", "", Color.WHITE, Color.BLACK);
        fields[22] = new GUI_Shipping(IMAGE_DIR_PATH+"skatepark.png","Skateparken", "$2", "", "", Color.PINK, Color.BLACK);
        fields[23] = new GUI_Shipping(IMAGE_DIR_PATH+"swimmingpool.png","Swimmingpoolen", "$2", "", "", Color.PINK, Color.BLACK);
    }


}
