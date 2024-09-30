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
            String in = sc.nextLine().toLowerCase();
            switch (in) {
                case "look", "l":
                    Room curRoom = p.getCurrentRoom();
                    String items = curRoom.printItems();
                    printRoomDesc();
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
                default:
                    String split[] =in.split(" ");
                    if (split.length >1)
                    {
                        switch (split[0])
                        {
                            case"drop":
                                if (p.getInv().size()>0) {
                                    String pDiddy = p.getCurrentRoom().takeItem(p.removeItem(split[1]));
                                    System.out.println("you dropped " + pDiddy);
                                }
                                break;
                            case"take":
                                String ziddy = p.addItem(p.getCurrentRoom().removeItem(split[1]));
                                System.out.println("you took " + ziddy);
                                break;
                        }
                    }else
                    {
                    for (Cardinals s : Cardinals.values()) {
                        if (in.contains(s.toString())) {
                            String goin = p.moveChar(s.toString());
                            if (goin != null) {
                            } else {
                                System.out.println("there is no door " + s.toString());
                                break;
                            }
                        }
                    }
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