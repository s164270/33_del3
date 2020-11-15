package game;

import gui_fields.GUI_Field;
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
        fields[player.getPosition()].landOnField();
        gui.showMessage(player.getName() + " landede på " + guiFields[player.getPosition()].getTitle());
    }

    public GUI_Field[] getGuiFields() {
        return guiFields;
    }

    public void landOnField(int fieldIndex, Player player)
    {
        fields[fieldIndex].landOnField();
        guiFields[fieldIndex].getDescription();
    }

    public void setField(int fieldIndex, Field field)
    {
        fields[fieldIndex] = field;
    }

    private void createFields()
    {
        for(int i = 0; i < NFIELDS; i++)
        {
            fields[i] = new Field("felt nummer " + i);
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
    }


    public void test1()
    {
        fields[0].landOnField();
        fields[1].landOnField();
        fields[23].landOnField();
    }
}
