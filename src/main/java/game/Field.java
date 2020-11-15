package game;

import player.Player;

public class Field {
    private String name;

    public Field()
    {
        name = "default";
    }

    public Field(String name)
    {
        this.name = name;
    }

    public void landOnField(Player player)
    {
        System.out.println("landede på " + name);
    }

}
