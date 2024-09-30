import java.util.ArrayList;
import java.util.Locale;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inv = new ArrayList<Item>();

    public Player(Room initialRoom)
    {
        this.currentRoom = initialRoom;
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
    public String addItem(Item it)
    {
        if (it!=null) {
            inv.add(it);
            return it.getName();
        }else
        {return null;
        }
    }

    String printItems()
    {
        String itemList = "";
        for (Item r : inv)
        {
            itemList = itemList + "\n" + r.getName() + " " + r.getDesc();
        }
        return itemList;
    }
    public Item removeItem(String item)
    {
        for (Item r : inv)
        {
            String gotName = r.getName();
            if (gotName!=null && gotName.equalsIgnoreCase(item))
            {
                inv.remove(r);
                return r;
            }
        }
        return  null;
    }
    public ArrayList<Item> getInv()
    {
        return inv;
    }
}
