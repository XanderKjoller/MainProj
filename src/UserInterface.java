import java.util.Scanner;

public class UserInterface {

    public enum Cardinals {north, east, south, west}

    private Adventure adv;

    public UserInterface(Adventure adv) {
        this.adv = adv;
    }

    public boolean reqAction() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("what do you wish to do, look around or go in a cardinal direction?");
            String in = sc.nextLine().toLowerCase();
            if (in.contains("look")) {
                System.out.println(adv.currentRoom.getRoomDesc());
            } else if (in.contains("exit")) {
                return false;
            } else {
                for (Cardinals s : Cardinals.values()) {
                    if (in.contains(s.toString())) {
                        adv.moveChar(s.toString());
                        System.out.println(adv.moveChar(s.toString()));
                        System.out.println(adv.currentRoom.getRoomDesc());
                        break;
                    }
                }
            }
        }
    }
}

