import java.util.Locale;

public class Adventure {
    private Map map = new Map();
    private Player p = new Player(map.firstRoom());



    public void startGame(UserInterface ui) {
        boolean playingGame = true;
        while (playingGame) {
            playingGame = ui.reqAction();
        }
    }

    public Player getPlayer() {
        return p;
    }

    public String Fight(Player p, Enemy e)
    {   String eNam = e.getName();
        String eWep = e.getWeaponName();
        String exitMessage = "";

        int pDamage = p.attack(1);
        if (pDamage == -1)
        {
            exitMessage = "your weapon is out of uses it is unwise to attack";
        } else {
            e.hurt(pDamage);
            exitMessage = exitMessage + "you hurt " + eNam + " for " + pDamage;
            if (e.getHp() >= 0) {
                int eDam = e.Attack(1);
                exitMessage = exitMessage + "\n" + eNam + " hp = " + e.getHp();
                p.modifyHp(-eDam);
                exitMessage = exitMessage + "\n" + eNam + " strikes you with " + eWep + " for " + eDam + "\n" + "your hp is nowm " + p.getHealt();
            } else {
                exitMessage = exitMessage + "\n" + eNam + " dies leaving his weapon, " + eWep + " on the floor";
                e.kill();
            }
        }
        return exitMessage;
    }


}
