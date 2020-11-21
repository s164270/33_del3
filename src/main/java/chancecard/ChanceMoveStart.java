package chancecard;

import game.GameBoard;
import gui_main.GUI;
import player.Player;

import java.awt.*;

public class ChanceMoveStart extends Chance
{

    public ChanceMoveStart(GameBoard board, GUI gui, Player[] player)
    {
        super(board,gui,player);
    }

    @Override
    public void executeChance()
    {
        super.executeChance();
        gui.showMessage("lol");
    }
}
