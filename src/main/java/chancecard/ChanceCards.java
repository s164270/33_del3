package chancecard;

import game.GameBoard;
import gui_fields.GUI_Chance;
import gui_main.GUI;
import player.Player;

import java.awt.*;
import java.util.Random;

public class ChanceCards
{
    private GameBoard board;
    private GUI gui;
    private Player[] player;
    private Chance[] chances= new Chance[24];
    public ChanceCards(GameBoard board, GUI gui, Player[] player)
    {
        this.board=board;
        this.gui=gui;
        this.player=player;
        createChance();
    }


    public void createChance()
    {
        chances[0] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        chances[1] = new ChanceMove5(board, gui, player,"Ryk frem 5 felter", Color.BLUE,Color.ORANGE);
        chances[2] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        chances[3] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        chances[4] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        chances[5] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        chances[6] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        chances[7] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        chances[8] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        chances[9] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        chances[10] = new ChanceMoveColor(board, gui, player,"Ryk frem til et orange felt", Color.BLUE,Color.ORANGE, new String[]{"Burgerbaren","Pizzariaet"});
        chances[11] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        chances[12] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        chances[13] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        chances[14] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        chances[15] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        chances[16] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        chances[17] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        chances[18] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        chances[19] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        chances[20] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        chances[21] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        chances[22] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        chances[23] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);


        /*
        chances[1] = new ChanceMoveStart(board, gui, player,"Giv dette kort til BILEN og tag et chancekort mere","BIL: på din næste tuur skal du drøne rem til et hvilket som hels ledig felt og købe det. Hvis der er ikke nogen ledige felter skal du købe et fra en anden spiller!", Color.BLUE,Color.ORANGE);
        chances[2] = new ChanceMoveStart(board, gui, player,"Ryk frem til START","Modtag M2", Color.BLUE,Color.ORANGE);
        chances[3] = new ChanceMoveStart(board, gui, player,"Ryk op til","5 felter frem", Color.BLUE,Color.ORANGE);
        chances[4] = new ChanceMoveStart(board, gui, player,"GRATIS FELT","Ryk frem til orange felt. Hvis der er ledig, får du det GRATIS! elles skal du BETALE til ejeren", Color.ORANGE,Color.ORANGE);
        chances[5] = new ChanceMoveStart(board, gui, player,"Ryk 1 felt frem","eller tag et chancekort mere", Color.BLUE,Color.ORANGE);
        chances[6] = new ChanceMoveStart(board, gui, player,"Giv dette kort til SKIBET, og tag en chancekort mere","Modtag M2", Color.BLUE,Color.ORANGE);
        */
    }
    public Chance getRandomChance() {
        final Random random = new Random();
        int number;
        number = random.nextInt(24);
        return chances[number];
    }

}
