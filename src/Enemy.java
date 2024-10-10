public class Enemy
{
    private int maxHp;
    private int hp;
    private Room currRoom;
    private  Weapon equip;
    private String name;
    private String description;
    public Enemy(String name, String description, Weapon equip, int maxHp)
    {
        this.name = name;
        this.description = description;
        this.currRoom = currRoom;
        this.equip = equip;
        this.maxHp = maxHp;
        this.hp= maxHp;
    }

    public int Attack(int times){
        return equip.damage;
    }
    public void hurt(int dmg)
    {
        hp = hp - dmg;
    }

    public void dropItem()
    {
        currRoom.addByClass(equip);
    }
    public Weapon getEq()
    {
        return equip;
    }

    public String getName()
    {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public String getWeaponName() {
        return equip.name;
    }
    public void kill()
    {
        dropItem();
        currRoom.removeEnemy(this);
    }
    public void setCurrRoom(Room r)
    {
        this.currRoom = r;
    }
    public String getDescription(){
        return description;
    }
}

