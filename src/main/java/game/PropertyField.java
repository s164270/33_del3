package game;

import player.Player;

public class PropertyField extends Field{
    private int cost;
    private boolean paired = false;

    private PropertyField neighbor;
    private Player owner;

    public PropertyField()
    {
        this.cost = 0;
    }

    public PropertyField(String name, int cost)
    {
        super(name);
        this.cost = cost;
    }

    public PropertyField(String name, int cost, PropertyField neighbor)
    {
        super(name);
        this.cost = cost;
        this.neighbor = neighbor;
        neighbor.setNeighbor(this);
    }

    public Player getOwner() {
        return owner;
    }

    public void setPaired(boolean paired) {
        this.paired = paired;
    }

    public void setNeighbor(PropertyField neighbor)
    {
        this.neighbor = neighbor;
    }

    @Override
    public void landOnField(Player player) {

        if(owner == null) //player has to buy the property
        {
            player.addPoints(-cost);
            owner = player;
            if(neighbor.getOwner() == this.owner)
            {
                paired = true;
                neighbor.setPaired(true);
            }
        }
        else if(owner != player)
        {
            if(paired)
            {
                player.addPoints(-2*cost);
                owner.addPoints(2*cost);
            }
            else
            {
                player.addPoints(-cost);
                owner.addPoints(cost);
            }
        }
    }
}
