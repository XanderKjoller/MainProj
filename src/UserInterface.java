import java.util.Scanner;

public class UserInterface {

    public enum Cardinals {north, east, south, west}

    private Adventure adv;
    private Player p;
    private Map m;


    public UserInterface(Adventure adv) {
        this.adv = adv;
        this.m = adv.getMap();
        this.p = adv.getPlayer();
    }

    public boolean reqAction() {
        Scanner sc = new Scanner(System.in);


        while (true) {
            printRoomDesc();

            System.out.println("what do you wish to do, look around, go in a cardinal direction? take something, or mayhaps just exit?");
            Room curRoom = p.getCurrentRoom();
            String in = sc.nextLine().toLowerCase();

            switch (in) {
                case "n":
                    System.out.println(curRoom.printAllNeighbours());
                            break;
                case "look", "l":
                    String items = curRoom.printItems();
                    if (items != "") {
                        printRoomItems();
                    } else {
                        System.out.println("your search for items had no result");
                    }
                    break;
                case "exit", "e":
                    return false;
                case "inv", "inventory", "i":
                    String inv = p.printItems();
                    if (inv != null) {
                        System.out.println("your bag contains" + p.printItems());
                    } else {
                        System.out.println("your inventory is empty");
                    }
                    break;
                case "hp", "health", "status":
                    System.out.println("health = " + p.getHealt());
                    break;
                default:
                    boolean doorFound = false;
                    for (Cardinals s : Cardinals.values()) {
                        if (in.contains(s.toString())) {
                            String goin =  p.moveChar(s.toString());
                            System.out.println(goin);
                            doorFound = true;
                            if (goin != null) {
                            } else {
                                System.out.println("there is no door " + s.toString());
                                break;
                            }

                        }
                    }
                    String split[] = in.split(" ");
                    if (split.length == 2) {
                        switch (split[0]) {
                            case "drop":
                                System.out.println("you dropped" + curRoom.takeItem(p.removeItem(split[1])));
                            case "take":
                                System.out.println("you took" + p.addItem(curRoom.removeItem(split[1])));
                            case "eat":
                                System.out.println(p.eatItem(split[1]));
                        }
                    } else {
                        if (!doorFound) System.out.println("invalid input");
                    }
                    break;
            }
        }
    }


    public void printRoomItems() {
        System.out.println("within the room lies;" + p.getCurrentRoom().printItems());
    }

    public void printRoomDesc() {
        System.out.println(p.getCurrentRoom().getRoomDesc());
    }

}
//                        String ziddy = "a";
//                        switch (split[0]) {
//                            case "drop":
//                                for (int i = 1; i < split.length; i++) {
//                                    String griddy = p.getCurrentRoom().takeItem(p.removeItem(split[i]));
//                                    if (i >= (split.length - 1) && griddy != null) {
//                                        ziddy = ziddy.substring(0, ziddy.length() - 1) + " and " + griddy + ".";
//
//
//                                    } else if (griddy != null) {
//                                        ziddy = ziddy + " " + griddy + ",";
//                                    }
//
//                                }
//                                System.out.println("you dropped " + ziddy);
//                                break;
//                            case "take":
//                                boolean prevWasFalse;
//                                for (int i = 1; i < split.length; i++) {
//                                    String griddy = p.addItem(p.getCurrentRoom().removeItem(split[i]));
//
//                                    if (i > (split.length - 1)) {
//                                        if (griddy != null) {
//                                            ziddy = ziddy.substring(0, ziddy.length() - 1) + " and a" + griddy;
//                                        }
//
//                                    } else {
//                                        if (griddy != null) {
//                                            ziddy = ziddy + " " + griddy + ",";
//                                        }
//                                    }
//                                }
//                                System.out.println("you took " + ziddy);
//                                break;
//}