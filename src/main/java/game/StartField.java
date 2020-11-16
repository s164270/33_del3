package game;

import player.Player;

public class StartField extends Field{

    @Override
    public void visitField(Player player) {
        player.addPoints(2);
        System.out.println(player.getName() + " passerede start og fik $2");
    }
}
