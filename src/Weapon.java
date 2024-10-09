public abstract class Weapon extends Item{

    protected int damage;


    public Weapon(String name, String desc, int damage ) {
        super(name, desc);
        this.damage = damage;
    }

    abstract int use(int timesUsed);
    abstract int checkUses();
}
