package game;

import player.Player;

public abstract class Field {
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

    public void visitField(Player player)
    {
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
