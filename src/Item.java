public class Item {
    private String name;
    private String desc;

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
