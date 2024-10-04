import java.util.ArrayList;

public class Room {
    private Room north;
    private Room east;
    private Room south;
    private Room west;
    public String roomDesc;
    private String name;
    private ArrayList<Item> it = new ArrayList<Item>();
    boolean recentlyDescribed = false;

    public Room(String roomDesc, String name) {
        this.roomDesc = roomDesc;
        this.name = name;
    }

    public String getRoomDesc() {
        if (recentlyDescribed) {
            return ("you've seen this room before");
        } else {
            recentlyDescribed = true;
            return roomDesc;
        }

    }

    public Room getNeighbour(String dir) {
        switch (dir.toLowerCase()) {
            case "north":
                return north;
            case "east":
                return east;
            case "south":
                return south;
            case "west":
                return west;
        }
        return null;
    }

    public void setNeighbour(String dir, Room neighbour) {
        switch (dir.toLowerCase()) {
            case "north":
                north = neighbour;
                break;
            case "east":
                east = neighbour;
                break;
            case "south":
                south = neighbour;
                break;
            case "west":
                west = neighbour;
                break;
        }
    }

    public void addItem(String name, String desc) {
        it.add(new Item(name, desc));
    }

    public String takeItem(Item i) {
        it.add(i);
        return i.getName();
    }

    String printItems() {
        String itemList = "";
        for (Item r : it) {
            itemList = itemList + "\n" + r.getName() + " " + r.getDesc();
        }
        return itemList;
    }

    public Item findItem(String item) {
        for (Item r : it) {
            String gotName = r.getName();
            if (gotName != null && gotName.equalsIgnoreCase(item)) {
                return r;

            }
        }
        return null;
    }
    public String getName()
    {
        return name;
    }
    public String printAllNeighbours()
    {
        String gethelp = "";
        if (south != null) gethelp += (south.getName()+ " south ");
        if (east != null) gethelp += (east.getName()+ " west ");
        if (west != null) gethelp += (west.getName() + " east ");
        if (north != null) gethelp += (north.getName()+ " north ");
        return gethelp;
    }

    public Item removeItem(String item) {
        Item found = findItem(item);
        if (found != null) {
            it.remove(found);
            return found;
        }
        return null;
    }

    public void addByClass(Item i) {
        it.add(i);
    }
}
