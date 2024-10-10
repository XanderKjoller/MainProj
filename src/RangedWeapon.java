public class RangedWeapon extends Weapon {
    public int uses;
    public RangedWeapon(String name, String desc, int damage, int uses) {
        super(name, desc, damage);
        this.uses=uses;
        this.desc = desc + ", has " +uses+ " left";
    }

    @Override
    int use(int timesUsed) {
        if (uses>=timesUsed){
            uses = uses - timesUsed;
            this.desc = desc.substring(0, (desc.indexOf("has"))) + "has " +uses+ "uses" + " left";
            return timesUsed*damage;

        }
        return -1;
    }

    @Override
    public int checkUses() {
        return uses;
    }
}
