import java.util.Locale;

public class Adventure {
    private UserInterface ui = new UserInterface(this);
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
    public Room currentRoom = room1;


    public void startGame() {
        connectRooms();
        System.out.println(currentRoom.getRoomDesc());
        boolean playingGame = true;
        while (playingGame) {
            playingGame = ui.reqAction();
        }
    }

    public String moveChar(String dir) {
        String dirLow = dir.toLowerCase(Locale.ROOT);
        Room newRoom = currentRoom.getNeighbour(dirLow);
        if (newRoom != null) {
            currentRoom = newRoom;
            return "you moved " + dir;
        } else {
            return "there is no door " + dir;
        }
    }


    public void addNeighbour(Room neighbour, Room neighbour2, String dir) {
        switch (dir.toLowerCase()) {
            case "north":
                neighbour.north = neighbour2;
                neighbour2.south = neighbour;
                break;
            case "east":
                neighbour.east = neighbour2;
                neighbour2.west = neighbour;
                break;
            case "south":
                neighbour.south = neighbour2;
                neighbour2.north = neighbour;
                break;
            case "west":
                neighbour.west = neighbour2;
                neighbour2.east = neighbour;
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
}
