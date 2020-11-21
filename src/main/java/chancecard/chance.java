package chancecard;

import gui_fields.GUI_Chance;

import java.awt.*;
import java.util.Random;

import static java.lang.Math.random;

public class chance {
    private GUI_Chance[] chances= new GUI_Chance[24];
    public chance()
    {
        createChance();
    }

    public void createChance()
    {
        GUI_Chance card0 = new GUI_Chance("CHANCE","Ryk frem til START","Modtag M2", Color.BLUE,Color.ORANGE);
        GUI_Chance card1 = new GUI_Chance("CHANCE","Giv dette kort til BILEN og tag et chancekort mere","BIL: på din næste tuur skal du drøne rem til et hvilket som hels ledig felt og købe det. Hvis der er ikke nogen ledige felter skal du købe et fra en anden spiller!", Color.BLUE,Color.ORANGE);
        GUI_Chance card2 = new GUI_Chance("CHANCE","Ryk frem til START","Modtag M2", Color.BLUE,Color.ORANGE);
        GUI_Chance card3 = new GUI_Chance("CHANCE","Ryk op til","5 felter frem", Color.BLUE,Color.ORANGE);
        GUI_Chance card4 = new GUI_Chance("CHANCE","GRATIS FELT","Ryk frem til orange felt. Hvis der er ledig, får du det GRATIS! elles skal du BETALE til ejeren", Color.ORANGE,Color.ORANGE);
        GUI_Chance card5 = new GUI_Chance("CHANCE","Ryk 1 felt frem","eller tag et chancekort mere", Color.BLUE,Color.ORANGE);
        GUI_Chance card6 = new GUI_Chance("CHANCE","Giv dette kort til SKIBET, og tag en chancekort mere","Modtag M2", Color.BLUE,Color.ORANGE);
        GUI_Chance card7 = new GUI_Chance("CHANCE","Ryk frem til START","Modtag M2", Color.BLUE,Color.ORANGE);
        GUI_Chance card8 = new GUI_Chance("CHANCE","Ryk frem til START","Modtag M2", Color.BLUE,Color.ORANGE);
        GUI_Chance card9 = new GUI_Chance("CHANCE","Ryk frem til START","Modtag M2", Color.BLUE,Color.ORANGE);
        GUI_Chance card10 = new GUI_Chance("CHANCE","Ryk frem til START","Modtag M2", Color.BLUE,Color.ORANGE);
        GUI_Chance card11 = new GUI_Chance("CHANCE","Ryk frem til START","Modtag M2", Color.BLUE,Color.ORANGE);
        GUI_Chance card12 = new GUI_Chance("CHANCE","Ryk frem til START","Modtag M2", Color.BLUE,Color.ORANGE);
        GUI_Chance card13 = new GUI_Chance("CHANCE","Ryk frem til START","Modtag M2", Color.BLUE,Color.ORANGE);
        GUI_Chance card14 = new GUI_Chance("CHANCE","Ryk frem til START","Modtag M2", Color.BLUE,Color.ORANGE);
        GUI_Chance card15 = new GUI_Chance("CHANCE","Ryk frem til START","Modtag M2", Color.BLUE,Color.ORANGE);
        GUI_Chance card16 = new GUI_Chance("CHANCE","Ryk frem til START","Modtag M2", Color.BLUE,Color.ORANGE);
        GUI_Chance card17 = new GUI_Chance("CHANCE","Ryk frem til START","Modtag M2", Color.BLUE,Color.ORANGE);
        GUI_Chance card18 = new GUI_Chance("CHANCE","Ryk frem til START","Modtag M2", Color.BLUE,Color.ORANGE);
        GUI_Chance card19 = new GUI_Chance("CHANCE","Ryk frem til START","Modtag M2", Color.BLUE,Color.ORANGE);
        GUI_Chance card20 = new GUI_Chance("CHANCE","Ryk frem til START","Modtag M2", Color.BLUE,Color.ORANGE);
        GUI_Chance card21 = new GUI_Chance("CHANCE","Ryk frem til START","Modtag M2", Color.BLUE,Color.ORANGE);
        GUI_Chance card22 = new GUI_Chance("CHANCE","Ryk frem til START","Modtag M2", Color.BLUE,Color.ORANGE);
        GUI_Chance card23 = new GUI_Chance("CHANCE","Ryk frem til START","Modtag M2", Color.BLUE,Color.ORANGE);
        chances[0]=card0;
        chances[1]=card1;
        chances[2]=card2;
        chances[3]=card3;
        chances[4]=card4;
        chances[5]=card5;
        chances[6]=card6;
        chances[7]=card7;
        chances[8]=card8;
        chances[9]=card9;
        chances[10]=card10;
        chances[11]=card11;
        chances[12]=card12;
        chances[13]=card13;
        chances[14]=card14;
        chances[15]=card15;
        chances[16]=card16;
        chances[17]=card17;
        chances[18]=card18;
        chances[19]=card19;
        chances[20]=card20;
        chances[21]=card21;
        chances[22]=card22;
        chances[23]=card23;
    }
    public GUI_Chance getRandomChance() {
        final Random random = new Random();
        int number;
        number = random.nextInt(24);
        return chances[number];
    }

}
