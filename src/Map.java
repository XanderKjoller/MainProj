public class Map {
    private String bogstandard = "you find yourself in a room, ";
    private Room room1 = new Room(bogstandard + "it's pretty dull", "1");
    private Room room2 = new Room(bogstandard + "nothing special about it", "2");
    private Room room3 = new Room(bogstandard + "beautifully boring", "3");
    private Room room4 = new Room(bogstandard + "wow.", "4");
    private Room room5 = new Room(bogstandard + "with walls gilded by gold, and in the center lies unimaginable treasure", "5");
    private Room room6 = new Room(bogstandard + "get help", "6");
    private Room room7 = new Room(bogstandard +"it's just a room", "7");
    private Room room8 = new Room(bogstandard + "a skibiddi room", "8");
    private Room room9 = new Room("you find yourself in a hard place", "9");
    private RangedWeapon bow = new RangedWeapon("bow", "a tool", 100, 10);
    private MeleeWeapon sword = new MeleeWeapon("sword", "it cuts", 50);
    private MeleeWeapon mockery = new MeleeWeapon("mockery", "breaks bones", 30);
    private Enemy eboy = new Enemy("E-boy", "the scourge of the internet", mockery, 60 );
    private Enemy robot = new Enemy("robot", "beep boop", bow, 60 );
    public Map()
    {
        Food app = new Food("apple","nomnom",100);
        connectRooms();
        room1.addItem("grappler","it looks cool ig");
        room1.addByClass(app);
        room1.addByClass(sword);
        //room1.addByClass(bow);
        room2.addEnemy(eboy);
        room2.addEnemy(robot);
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
