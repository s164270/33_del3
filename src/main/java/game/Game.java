package game;

import chancecard.*;
import dice.DiceCup;
import gui_main.GUI;
import player.Account;
import player.Player;

import java.awt.*;
import java.util.Arrays;

public class Game
{


    private final DiceCup dice;
    private final GameBoard board;
    private GUI gui;
    private Player[] player;
    private Player currentPlayer;
    private ChanceCards chanceCards;
    private boolean gameOver;

    public Game()
    {
        dice = new DiceCup();
        GUI.setNull_fields_allowed(true);

        board = new GameBoard();
        gui = new GUI(board.getGuiFields(), Color.WHITE);
        board.setGui(gui);
        gameOver = false;

        gui.showMessage("Welcome to the game!\n");
        createPlayers();
        chanceCards=new ChanceCards(board, gui, player);
        chanceCards.createChance();
        gui.showMessage("Okay " + currentPlayer.getName() + ", you start.");
    }

    public Game(String playerName1, String playerName2)
    {
        // class creation for testing
        dice = new DiceCup();
        GUI.setNull_fields_allowed(true);

        board = new GameBoard();
        gui = new GUI(board.getGuiFields(), Color.WHITE);
        board.setGui(gui);
        gameOver = false;

        player=new Player[3];
        player[0] = new Player(playerName1);
        player[1] = new Player(playerName2);
        player[2] = new Player("playerName3");
        gui.addPlayer(player[0].getGuiPlayer());
        gui.addPlayer(player[1].getGuiPlayer());
        gui.addPlayer(player[2].getGuiPlayer());
        currentPlayer = player[0];
        chanceCards=new ChanceCards(board, gui, player);
        chanceCards.createChance();
    }

    private void createPlayers()
    {

        int numPlayers = gui.getUserInteger("Chose number of players",2,4);
        player=new Player[numPlayers];
        int minAge = 999;
        int minAgeIndex = 0;
        int age;
        for (int i = 0; i < numPlayers; i++)
        {
            player[i] = new Player(gui);
            gui.addPlayer(player[i].getGuiPlayer());
            age = gui.getUserInteger("What is "+ player[i].getName()+" age?");
            if (age < minAge)
            {
                minAge=age;
                minAgeIndex=i;
            }
            if (numPlayers == 2){
                player[i].addPoints(20);
            }
            else if (numPlayers == 3){
                player[i].addPoints(18);
            }
            else if (numPlayers == 4){
                player[i].addPoints(16);
            }
        }

        currentPlayer = player[minAgeIndex];
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
        gui.setDie(dice.getDice1());
    }

    public void turn(Player player)
    {
        gui.showMessage("It is " + player.getName() + "'s turn");

        rollDice();
        board.movePlayer(player, dice.getDice1());
        gameOver();
        changePlayer();
    }

    public void gameOver() {
        for (int i = 0; i < player.length; i++) {
            if (player[i].isBroke())
            {
                this.gameOver = true;
            }

        }
    }
    public void endGame()
    {
        this.gameOver = true;

        Player currentWinner = player[0];
        int currentMax = currentWinner.getPoints();

        for (int i = 1; i < player.length; i++) {
            if (player[i].getPoints() > currentMax)
            {
                currentMax = player[i].getPoints();
                currentWinner = player[i];
            }
        }

        gui.showMessage("The game is over, " + currentWinner.getName() + " has won!!");
        gui.close();
    }

    public Player getCurrentPlayer()
    {
        return currentPlayer;
    }

    public void changePlayer()
    {
        int index =Arrays.asList(player).indexOf(currentPlayer);
        if (index>= player.length-1)
        {
            currentPlayer=player[0];
        }
        else
        {
            currentPlayer=player[index+1];
        }
    }


    private void loadBoard()
    {

    }

    public void testFunction()
    {
        Chance card= new ChanceMovePlayer(board, gui, player,"Ryk frem til et orange felt", Color.BLUE,Color.ORANGE, currentPlayer);
        chanceCards.getRandomChance().executeChance(currentPlayer);
        //currentPlayer.getChanceCard().executeChance();
        board.movePlayerPosition(player[1],2);
        //board.movePlayerPosition(currentPlayer,15);
    }

}
