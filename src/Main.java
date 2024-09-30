public class Main {

    public static void main(String[] args) {
        Adventure sys1 = new Adventure();
        UserInterface ui = new UserInterface(sys1);
        sys1.startGame(ui);
    }
}