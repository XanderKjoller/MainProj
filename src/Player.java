import java.util.ArrayList;
import java.util.Locale;

public class Player {
    private Room currentRoom;
    public ArrayList<Item> inv = new ArrayList<Item>();
    private int health = 100;
    private int maxHealth = 150;

    public Player(Room initialRoom) {
        this.currentRoom = initialRoom;
        inv.add(new Food("æble", "nam nam", 100));
    }

    public int getHealt() {
        return health;
    }

    public String moveChar(String dir) {
        String dirLow = dir.toLowerCase(Locale.ROOT);
        Room newRoom = currentRoom.getNeighbour(dirLow);
        if (newRoom != null) {
            currentRoom = newRoom;
            return "you moved " + dir;
        } else {
            return null;
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public String addItem(Item it) {
        if (it != null) {
            inv.add(it);
            return it.getName();
        } else {
            return null;
        }
    }

    String printItems() {
        String itemList = "";
        for (Item r : inv) {
            itemList = itemList + "\n" + r.getName() + " " + r.getDesc();
        }
        return itemList;
    }

    public Item findItem(String item) {
        for (Item r : inv) {
            String gotName = r.getName();
            if (gotName != null && gotName.equalsIgnoreCase(item)) {
                return r;
            }
        }
        return null;
    }

    public Item removeItem(String item) {
        Item found = findItem(item);
        if (found != null) {
            inv.remove(found);
            return found;
        }
        return null;
    }

    public ArrayList<Item> getInv() {
        return inv;
    }

    public Item findItemAnyWhere(String nam) {
        if (findItem(nam) != null) return findItem(nam);
        else return currentRoom.findItem(nam);
    }
    public void heal(int healing)
    {
        health = health+healing;
        if (health>maxHealth) health = maxHealth;
    }

    public String eatItem(String nom) {
        Item feast = findItemAnyWhere(nom);
        if (feast instanceof Food) {
            Food beast = (Food) feast;
            inv.remove(nom);
            currentRoom.removeItem(nom);
            heal(beast.getHealing());
            return "you ate " + nom + " and healed " + beast.getHealing() + " hp is now " +health;
        } else if (feast != null) {
            return nom + " is not food";
        } else return "there is no such item in your inventory or in the room";
    }
}