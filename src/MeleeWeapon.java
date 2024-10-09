public class MeleeWeapon extends Weapon {
    public MeleeWeapon(String name, String desc, int damage) {
        super(name, desc, damage);
    }

    @Override
    int use(int timesUsed) {
        return  timesUsed*damage;
    }
    @Override
    int checkUses()
    {
        return 0;
    }
}
