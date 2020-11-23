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
        chances[2] = new ChanceBirthday(board, gui, player,"Det er din fødselsdag! Alle giver dig M1!\n Tillykke med fødselsdagen!", Color.BLUE,Color.ORANGE);
        chances[3] = new ChanceFreeJail(board, gui, player,"Du løslades uden omkostninger\n Behold dette kort intil du får brug for det.", Color.BLUE,Color.ORANGE);
        chances[4] = new ChanceGet2(board, gui, player,"Du har lavet alle dine lektier!\n Modtag M2 fra banken", Color.BLUE,Color.ORANGE);
        chances[5] = new ChanceMoveToBeach(board, gui, player,"Ryk frem til STRANDPROMENADEN", Color.BLUE,Color.ORANGE);
        chances[6] = new ChancePay2(board, gui, player,"Du har spist for meget slik\n BETAL M2 til banken", Color.BLUE,Color.ORANGE);
        chances[7] = new ChanceMoveColor(board, gui, player,"Ryk frem til orange eller grønt felt.", Color.BLUE,Color.ORANGE, new String[]{"Burgerbaren","Pizzariaet","Bowlinghallen","Zoo"});
        chances[8] = new ChanceMoveColor(board, gui, player,"Ryk frem til lyseblåt felt.", Color.BLUE,Color.ORANGE, new String[]{"Slikbutikken","Iskiosken"});
        chances[9] = new ChanceMoveColor(board, gui, player,"Ryk frem til pink eller mørkeblåt felt", Color.BLUE,Color.ORANGE, new String[]{"Skateparken","Swimmingpoolen","Vandlandet","Strandpromenaden"});
        chances[10] = new ChanceMoveColor(board, gui, player,"Ryk frem til et orange felt", Color.BLUE,Color.ORANGE, new String[]{"Burgerbaren","Pizzariaet"});
        chances[11] = new ChanceMoveColor(board, gui, player,"Ryk frem til rød felt", Color.BLUE,Color.ORANGE, new String[]{"Spillehallen","Biografen"});
        chances[12] = new ChanceMoveColor(board, gui, player,"Ryk frem til Skateparken", Color.BLUE,Color.ORANGE, new String[]{"Skateparken"});
        chances[13] = new ChanceMoveColor(board, gui, player,"Ryk frem til lyseblåt eller rød", Color.BLUE,Color.ORANGE, new String[]{"Slikbutikken","Iskiosken","Spillehallen","Biografen"});
        chances[14] = new ChanceMoveColor(board, gui, player,"Ryk frem til lilla eller gul", Color.BLUE,Color.ORANGE, new String[]{"Museet","Biblioteket","Legetøjsbutik","Dyrehandlen"});
        chances[15] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        chances[16] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        chances[17] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        chances[18] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        chances[19] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        chances[20] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        chances[21] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        chances[22] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        chances[23] = new ChanceMoveStart(board, gui, player,"Ryk frem til START\n Modtag M2", Color.BLUE,Color.ORANGE);
        for (int i = 20; i < chances.length; i++)
        {
           int j = i % player.length;
            chances[20] = new ChanceMovePlayer(board, gui, player,"Giv dette kort til "+ player[j].getName(), Color.BLUE,Color.ORANGE, player[j]);

        }


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
