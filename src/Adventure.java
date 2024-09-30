import java.util.Locale;

public class Adventure {
    private Map map = new Map();
    private Player p = new Player(map.firstRoom());
    private UserInterface ui ;



    public void startGame(UserInterface ui) {
        boolean playingGame = true;
        while (playingGame) {
            playingGame = ui.reqAction();
        }
    }

    public Player getPlayer()
    {
        return p;
    }
    public Map getMap()
    {
        return map;
    }
    public void setUI(UserInterface ui)
    {
        this.ui = ui;
    }

    public void itemToInv(Item itemName)
    {
        p.addItem(itemName);

    }


}
