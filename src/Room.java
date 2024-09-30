import java.util.ArrayList;

public class Room {
    private Room north;
    private Room east;
    private Room south;
    private Room west;
    public String roomDesc;
    private ArrayList<Item> it = new ArrayList<Item>();
    public Room(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    public String getRoomDesc() {
        return roomDesc;
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
            case "south":
                south = neighbour;
            case "west":
                west = neighbour;
        }
    }

    public void addItem(String name, String desc)
    {
        it.add(new Item(name,desc));
    }

    String printItems()
    {
        String itemList = "";
        for (Item r : it)
        {
            itemList = itemList + "\n" + r.getName() + " " + r.getDesc();
        }
        return itemList;
    }
    public Item removeItem(String item)
    {
        for (Item r : it)
        {
            String gotName = r.getName();
            if (gotName!=null && gotName.equalsIgnoreCase(item))
            {
                System.out.println(r.getName());
                it.remove(r);
                return r;

            }
        }
        return  null;
    }
}
