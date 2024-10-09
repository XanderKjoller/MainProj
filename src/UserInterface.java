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
                    int pHealth = p.getHealt();
                    System.out.println("health = " + pHealth);
                    if (pHealth<50) System.out.println("you're low on health");
                    if (pHealth>50) System.out.println("you're all good");
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
                            case "check":
                                Item foundStuff = p.findItemAnyWhere(split[1]);
                                if (foundStuff != null) System.out.println(foundStuff.desc);
                                else System.out.println("you hold no such item");
                                break;
                            case "drop":
                                System.out.println("you dropped" + curRoom.takeItem(p.removeItem(split[1])));
                                break;
                            case "take":
                                System.out.println("you took" + p.addItem(curRoom.removeItem(split[1])));
                                break;
                            case "eat":
                                System.out.println(p.eatItem(split[1]));
                                break;
                            case "equip":
                                String wep = p.equipWeapon(split[1]);
                                if (wep != null) {
                                    System.out.println("you equipped " + wep );
                                } else
                                {
                                    System.out.println("there is no " + split[1] );
                                }
                                break;
                            case "attack":
                                Weapon w = p.getWeapon();
                                if (w != null) {
                                    int pack = p.attack(1);
                                    if (pack>0) {
                                        System.out.println("you attack with " + p.getWeapon().getName() + " dealing " + pack + " damage");
                                    }else System.out.println("you helplessly flail around as your weapon has no uses left");
                                } else {
                                    System.out.println("you hold no weapon so you use your fists");
                                    System.out.println("you attack " + split[1] + " dealing " + p.attack(1) +" damage");
                                }
                                break;


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