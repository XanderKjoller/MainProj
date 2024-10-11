import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    public enum Cardinals {north, east, south, west}

    private Adventure adv;
    private Player p;
    private Boolean noEvildoers;

    public UserInterface(Adventure adv) {
        this.adv = adv;
        this.p = adv.getPlayer();
        noEvildoers = p.getCurrentRoom().getEvilDoers().isEmpty();
    }

    public boolean reqAction() {
        Scanner sc = new Scanner(System.in);
        printRoomDesc(p.getCurrentRoom());

        while (true) {
            if (p.getHealt() <= 0) {
                System.out.println("you succumb to your wounds." + "\n" + "game over");
                return false;
            }
            System.out.println("type help at any time for a list of commands");
            Room curRoom = p.getCurrentRoom();
            String in = sc.nextLine().toLowerCase();
            String split[] = in.split(" ");
            noEvildoers = curRoom.getEvilDoers().isEmpty();

            switch (split[0]) {
                case "help":
                    help();
                    break;

                case "n":
                    System.out.println(curRoom.printAllNeighbours());
                    break;
                case "look", "l":
                    String items = curRoom.printItems();
                    if (!noEvildoers) {
                        System.out.println("enemies prevent you from finding items so you identify them instead");
                        printDetailedRoomDesc();
                        break;
                    }
                    if (items != "") {
                        printDetailedRoomDesc();
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
                    if (pHealth < 50) System.out.println("you're low on health");
                    if (pHealth > 50) System.out.println("you're all good");
                    break;
                case "check":
                    Item foundStuff = p.findItemAnyWhere(split[1]);
                    if (foundStuff != null) System.out.println(foundStuff.desc);
                    else System.out.println("there is no such item near you");
                    break;
                case "drop":
                    if (split[1] != null) {
                        System.out.println("you dropped " + curRoom.takeItem(p.removeItem(split[1])));
                    } else System.out.println("state an item too");
                    break;
                case "take":
                    if (1 < split.length) {
                        if (!curRoom.getEvilDoers().isEmpty()) {
                            System.out.println("too many bad guys to loot stuff");
                            break;
                        }
                        System.out.println("you took " + p.addItem(curRoom.removeItem(split[1])));
                    } else System.out.println("state an item too");
                    break;
                case "eat":
                    if (split.length > 1) {
                        System.out.println(p.eatItem(split[1]));
                    } else System.out.println("state a food as well");
                    break;
                case "equip":
                    if (split.length > 1) {
                        String wep = p.equipWeapon(split[1]);
                        if (wep != null) {
                            System.out.println("you equipped " + wep);
                        } else {
                            System.out.println("there is no equippable item named " + split[1]);
                        }
                    } else System.out.println("state an item as well");
                    break;
                case "attack":
                    Weapon w = p.getWeapon();
                    if (w == null) {
                        System.out.println("you hold no weapon, it is unwise to attack anyone");
                        break;
                    }
                    Enemy e;
                    if (split.length > 1) {
                        e = curRoom.findEvilDoer(split[1]);
                        if (e != null) {
                            System.out.println(adv.Fight(p, e));
                        } else {
                            e = curRoom.getEvilDoers().getFirst();
                            if (e != null) {
                                System.out.println(adv.Fight(p, e));
                            }
                        }
                    } else {
                        e = curRoom.getEvilDoers().getFirst();
                        if (e != null) {
                            System.out.println(adv.Fight(p, e));
                        }
                    }
                    break;

                default:
                    boolean doorFound = false;
                    for (Cardinals s : Cardinals.values()) {
                        if (in.contains(s.toString())) {
                            String goin = p.moveChar(s.toString());
                            System.out.println(goin);
                            doorFound = true;
                            if (goin != null) {
                                printRoomDesc(curRoom);
                                break;
                            } else {
                                System.out.println("there is no door " + s.toString());
                                break;
                            }

                        }
                    }
                    if (!doorFound) System.out.println("invalid input");
                    break;
            }
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }


    public void printRoomItems() {
        System.out.println("within the room lies;" + p.getCurrentRoom().printItems());
    }

    public void printDetailedRoomDesc() {
        Room cRoom = p.getCurrentRoom();
        if (!noEvildoers) System.out.println(cRoom.printEvilDoers());
        else printRoomItems();
    }

    public void printRoomDesc(Room curRoom) {

        System.out.println(curRoom.getRoomDesc());
        if (!noEvildoers) System.out.println("you notice one or more enemies in the room");
    }

    public void help() {
        System.out.println(
                "look: take a look at your sorroundings\n"
                        + "take (item): take an item from the room\n"
                        + "drop (item): drop an item from your inventory\n"
                        + "equip (item): equip an item from your inventory or the ground\n"
                        + "eat (item): eat a food for healing effects\n"
                        + "attack (enemy): attack an enemy, leave enemy empty to attack the first enemy found\n"
                        + "check (item): take a look at a specific item\n"
                        + "move (cardinal): move a given direction\n"
                        + "inventory: look at your inventory\n"
                        + "hp: check your remaining hp\n"
        );
    }//should've printed a list of commands
}