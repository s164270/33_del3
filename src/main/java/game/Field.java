package game;

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

    public void landOnField()
    {
        System.out.println("landede på " + name);
    }
}
