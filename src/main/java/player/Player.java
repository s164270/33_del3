package player;

import chancecard.ChanceMoveColor;
import chancecard.ChanceMovePlayer;
import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

public class Player
{

    private int position = 0;
    private Account account;
    private String playerName;
    private ChanceMovePlayer chanceCard;
    private GUI_Player gui_player;
    private static String[] colors = {"BLUE",
            "CYAN",
            "DARK_GRAY",
            "GRAY",
            "GREEN",
            "LIGHT_GRAY",
            "MAGENTA",
            "ORANGE",
            "PINK",
            "RED",
            "WHITE",
            "YELLOW"};



    public Player(GUI gui)
    {
        try
        {
            account = new Account(20);
            playerName = gui.getUserString("Input player name");
            String col = gui.getUserSelection("Choose color for " + playerName,
                    colors
            );

            Color i = (Color) Color.class.getDeclaredField(col).get(null);
            GUI_Car car = new GUI_Car();
            car.setPrimaryColor(i);
            List<String> list = new ArrayList<String>(Arrays.asList(colors));
            list.removeAll(Collections.singleton((col)));
            colors = new String[list.size()];
            colors = list.toArray(colors);
            gui_player = new GUI_Player(playerName, account.getBalance(), car);
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        } catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        }
    }
    public Player(String playerName)
    {
        this.playerName=playerName;
        account = new Account(20);
        GUI_Car car = new GUI_Car();
        car.setPrimaryColor(Color.RED);
        gui_player = new GUI_Player(playerName, account.getBalance(), car);
    }

    public int getPosition() {
        return position;
    }

    public void move(int distance)
    {
        if(distance < 0 || distance > 24)
        {
            throw new IllegalArgumentException("distance can't be <0 or be >24");
        }

        if(position + distance < 24)
        {
            position = position + distance;
        }
        else
        {
            position = (position + distance) - 24;
        }
    }

    public String getName()
    {
        return playerName;
    }

    public int getPoints()
    {
        return account.getBalance();
    }

    public void addPoints(int points)
    {
        if (points > 0)
        {
            account.deposit(points);
        }
        else
        {
            account.withdraw(Math.abs(points));
        }
        this.gui_player.setBalance(account.getBalance());
    }

    public GUI_Player getGuiPlayer()
    {
        return gui_player;
    }

    public ChanceMovePlayer getChanceCard()
    {
        return chanceCard;
    }

    public void setChanceCard(ChanceMovePlayer chanceCard)
    {
        this.chanceCard = chanceCard;
    }
}
