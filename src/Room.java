public class Room {
    public Room north;
    public Room east;
    public Room south;
    public Room west;
    public String roomDesc;

    public Room(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    public String getRoomDesc()
    {
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
}
