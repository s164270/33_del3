package game;

import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Shipping;
import gui_main.GUI;
import player.Player;

import java.awt.*;
import java.io.File;

public class GameBoard
{
    private final int NFIELDS = 24;
    private Field[] fields;
    private GUI_Field[] guiFields;
    private GUI gui;

    public GameBoard()
    {
        fields = new Field[NFIELDS];
        guiFields = new GUI_Field[NFIELDS];
        createFields();
        createGuiFields();
    }

    public void setGui(GUI gui)
    {
        this.gui = gui;
    }

    public void movePlayer(Player player, int distance){

        guiFields[player.getPosition()].setCar(player.getGuiPlayer(), false);
        player.move(distance);
        guiFields[player.getPosition()].setCar(player.getGuiPlayer(), true);
        fields[player.getPosition()].landOnField(player);
        gui.showMessage(player.getName() + " landede på " + guiFields[player.getPosition()].getTitle());
    }

    public GUI_Field[] getGuiFields() {
        return guiFields;
    }

    public void setField(int fieldIndex, Field field)
    {
        fields[fieldIndex] = field;
    }

    private void createFields()
    {
        fields[1] = new PropertyField("felt nummer 1", 3);
        fields[2] = new PropertyField("felt nummer 2", 3, (PropertyField) fields[1]);

        fields[4] = new PropertyField("felt nummer 4", 3);
        fields[5] = new PropertyField("felt nummer 5", 3, (PropertyField) fields[4]);

        fields[7] = new PropertyField("felt nummer 7", 4);
        fields[8] = new PropertyField("felt nummer 8", 4, (PropertyField) fields[7]);

        fields[10] = new PropertyField("felt nummer 10", 5);
        fields[11] = new PropertyField("felt nummer 11", 5, (PropertyField) fields[10]);

        fields[13] = new PropertyField("felt nummer 13", 1);
        fields[14] = new PropertyField("felt nummer 14", 1, (PropertyField) fields[13]);

        fields[16] = new PropertyField("felt nummer 16", 1);
        fields[17] = new PropertyField("felt nummer 17", 1, (PropertyField) fields[16]);

        fields[19] = new PropertyField("felt nummer 19", 2);
        fields[20] = new PropertyField("felt nummer 20", 2, (PropertyField) fields[19]);

        fields[22] = new PropertyField("felt nummer 22", 2);
        fields[23] = new PropertyField("felt nummer 23", 2, (PropertyField) fields[22]);

        for(int i = 0; i < NFIELDS; i++)
        {
            if(fields[i] == null)  {
                fields[i] = new Field("felt nummer " + i);
            }
        }
    }

    private void createGuiFields()
    {
        // Get the absolut file path for images in a way that works cross platform
        String IMAGE_DIR_PATH = System.getProperty("user.dir") + File.separator + "src"  + File.separator + "main"  + File.separator + "resources"  + File.separator+ "img"  + File.separator;
        guiFields[0] = new GUI_Shipping(IMAGE_DIR_PATH+"freepark.png","Gratis", "Parkering", "Gratis Parkering", "", Color.WHITE, Color.BLACK);
        guiFields[1] = new GUI_Shipping(IMAGE_DIR_PATH+"arcade.png","Spillehallen", "$3", "Spillehallen", "", Color.RED, Color.BLACK);
        guiFields[2] = new GUI_Shipping(IMAGE_DIR_PATH+"cinema.png","Biografen", "$3", "", "", Color.RED, Color.BLACK);
        guiFields[3] = new GUI_Shipping(IMAGE_DIR_PATH+"chance.png","Chance", "", "", "", Color.WHITE, Color.BLACK);
        guiFields[4] = new GUI_Shipping(IMAGE_DIR_PATH+"toystore.png","Legetøjsbutik", "$3", "", "", Color.YELLOW, Color.BLACK);
        guiFields[5] = new GUI_Shipping(IMAGE_DIR_PATH+"petstore.png","Dyrehandlen", "$3", "", "", Color.YELLOW, Color.BLACK);
        guiFields[6] = new GUI_Shipping(IMAGE_DIR_PATH+"gotoprison.png","Gå i", "Fængsel", "", "", Color.WHITE, Color.BLACK);
        guiFields[7] = new GUI_Shipping(IMAGE_DIR_PATH+"bowling.png","Bowlinghallen", "$4", "", "", Color.GREEN, Color.BLACK);
        guiFields[8] = new GUI_Shipping(IMAGE_DIR_PATH+"zoo.png","Zoo", "$4", "", "", Color.GREEN, Color.BLACK);
        guiFields[9] = new GUI_Shipping(IMAGE_DIR_PATH+"chance.png","Chance", "", "", "", Color.WHITE, Color.BLACK);
        guiFields[10] = new GUI_Shipping(IMAGE_DIR_PATH+"waterpark.png","Vandlandet", "$5", "", "", Color.BLUE, Color.BLACK);
        guiFields[11] = new GUI_Shipping(IMAGE_DIR_PATH+"beach.png","Strandpromenaden", "$5", "", "+650", Color.BLUE, Color.BLACK);
        guiFields[12] = new GUI_Shipping(IMAGE_DIR_PATH+"start.png","Start", "", "Modtag $2", "", Color.WHITE, Color.BLACK);
        guiFields[13] = new GUI_Shipping(IMAGE_DIR_PATH+"burgerbar.png","Burgerbaren", "$1", "", "", Color.ORANGE, Color.BLACK);
        guiFields[14] = new GUI_Shipping(IMAGE_DIR_PATH+"pizzahouse.png","Pizzariaet", "$1", "", "", Color.ORANGE, Color.BLACK);
        guiFields[15] = new GUI_Shipping(IMAGE_DIR_PATH+"chance.png","Chance", "", "", "", Color.WHITE, Color.BLACK);
        guiFields[16] = new GUI_Shipping(IMAGE_DIR_PATH+"candystore.png","Slikbutikken", "$1", "", "", Color.CYAN, Color.BLACK);
        guiFields[17] = new GUI_Shipping(IMAGE_DIR_PATH+"icecreamshop.png","Iskiosken", "$1", "", "", Color.CYAN, Color.BLACK);
        guiFields[18] = new GUI_Shipping(IMAGE_DIR_PATH+"inprison.png","I Fængsel", "", "", "", Color.WHITE, Color.BLACK);
        guiFields[19] = new GUI_Shipping(IMAGE_DIR_PATH+"museum.png","Museet", "$2", "", "", Color.MAGENTA, Color.BLACK);
        guiFields[20] = new GUI_Shipping(IMAGE_DIR_PATH+"library.png","Biblioteket", "$2", "", "", Color.MAGENTA, Color.BLACK);
        guiFields[21] = new GUI_Shipping(IMAGE_DIR_PATH+"chance.png","Chance", "", "", "", Color.WHITE, Color.BLACK);
        guiFields[22] = new GUI_Shipping(IMAGE_DIR_PATH+"skatepark.png","Skateparken", "$2", "", "", Color.PINK, Color.BLACK);
        guiFields[23] = new GUI_Shipping(IMAGE_DIR_PATH+"swimmingpool.png","Swimmingpoolen", "$2", "", "", Color.PINK, Color.BLACK);
        guiFields[22].setForeGroundColor(Color.RED);

    }
}
