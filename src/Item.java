public class Item {
    protected String name;
    protected String desc;

    public Item (String name, String desc)
    {
        this.desc = desc;
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public String getDesc()
    {
        return desc;
    }
}
