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
    private final GameBoard board;
    private GUI gui;
    private Player currentPlayer;
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

        board = new GameBoard();
        gui = new GUI(
                board.getGuiFields(), Color.WHITE);

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


    private void loadBoard()
    {

    }


}
