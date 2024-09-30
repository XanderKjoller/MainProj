public class Map {
    private String bogstandard = "you find yourself in a room, ";
    private Room room1 = new Room(bogstandard + "it's pretty dull");
    private Room room2 = new Room(bogstandard + "nothing special about it");
    private Room room3 = new Room(bogstandard + "beautifully boring");
    private Room room4 = new Room(bogstandard + "wow.");
    private Room room5 = new Room(bogstandard + "with walls gilded by gold, and in the center lies unimaginable treasure");
    private Room room6 = new Room(bogstandard + "get help");
    private Room room7 = new Room(bogstandard +"it's just a room");
    private Room room8 = new Room(bogstandard + "a skibiddi room");
    private Room room9 = new Room("you find yourself in a hard place");
    public Map()
    {
        connectRooms();
        room1.addItem("gurh", "huhhhh");
        room1.addItem("hjhg","awrfc");
        room2.addItem("ghjk","faesgdtfjgk");
    }

    public void addNeighbour(Room neighbour, Room neighbour2, String dir) {
        String low = dir.toLowerCase();
        switch (low) {
            case "north":
                neighbour.setNeighbour(low, neighbour2);
                neighbour2.setNeighbour("south", neighbour);
                break;
            case "east":
                neighbour.setNeighbour(low, neighbour2);
                neighbour2.setNeighbour("west", neighbour);
                break;
            case "south":
                neighbour.setNeighbour(low, neighbour2);
                neighbour2.setNeighbour("north", neighbour);
                break;
            case "west":
                neighbour.setNeighbour(low, neighbour2);
                neighbour2.setNeighbour("east", neighbour);
                break;
        }
    }
        public void connectRooms() {
            addNeighbour(room1, room2, "east");
            addNeighbour(room1, room4, "south");
            addNeighbour(room2, room3, "east");
            addNeighbour(room3, room6, "south");
            addNeighbour(room4, room7, "south");
            addNeighbour(room5, room8, "south");
            addNeighbour(room6, room9, "south");
            addNeighbour(room7, room8, "east");
            addNeighbour(room8, room9, "east");
        }

       public Room firstRoom()
       {
           return room1;
       }

}
