public class Food extends Item{
    private int healing;
    public Food(String name, String desc, int healing) {
        super(name, desc);
        this.healing = healing;
    }

    public int getHealing() {
        return healing;
    }
}
