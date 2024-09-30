import java.util.Locale;
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
            System.out.println("what do you wish to do, look around, go in a cardinal direction? take something, or mayhaps just exit?");
            String in = sc.nextLine().toLowerCase();
            if (in.contains("look")) {
                Room curRoom = p.getCurrentRoom();
                String items = curRoom.printItems();
                if (items != "") {
                    printRoomItems();
                } else {
                    System.out.println("your search for items had no result");
                }
            } else if (in.contains("exit")) {
                return false;
            } else if (in.contains("take".toLowerCase())) {
                String[] split = in.split(" ");
                if (split.length >1 && split[1] != null) {
                    String pDiddy = p.addItem(p.getCurrentRoom().removeItem(split[1]));
                    if (pDiddy!=null) {
                        System.out.println("you've taken " + pDiddy);
                    }else {
                        System.out.println("life sucks and then you die");
                    }
                }else{
                    System.out.println("take what? in one sentence please");
                }
                else if (in.contains("take".toLowerCase())) {
                    String[] split = in.split(" ");
                    if (split.length >1 && split[1] != null) {
                        String pDiddy = p.addItem(p.getCurrentRoom().removeItem(split[1]));
                        if (pDiddy!=null) {
                            System.out.println("you've taken " + pDiddy);
                        }else {
                            System.out.println("life sucks and then you die");
                        }
                    }else{
                        System.out.println("take what? in one sentence please");
                    }


            } else if (in.contains("inventory"))
            {
                String inv = p.printItems();
                if (inv != null)
                {
                    System.out.println("your bag contains" + p.printItems());
                }else{
                    System.out.println("your inventory is empty");
                }
            }else {
                for (Cardinals s : Cardinals.values()) {
                    if (in.contains(s.toString())) {
                        String goin = p.moveChar(s.toString());
                        if (goin != null) {
                        } else {
                            System.out.println("there is no door " + s.toString());
                        }
                        break;
                    }
                }
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

