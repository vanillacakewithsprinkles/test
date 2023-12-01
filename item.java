
public class item
{
    //name of the item (ex; super potion, revive)
    private String name;
    //amount of health gained by using the item
    private int healthgain;
    //amount of the item
    private int amount;

    /**
     * Constructor for objects of class item
     */
    public item(String name, int healthgain, int amount)
    {
        this.name = name;
        this.healthgain = healthgain;
        this.amount = amount;
    }

    //#setters
    public void setName(String name)
    {
        this.name = name;
    }
    public void setHealthgain(int healthgain)
    {
        this.healthgain = healthgain;
    }
    public void setAmount(int amount)
    {
        this.amount = amount;
    }
    //#getters
    public String getName()
    {
    return name;    
    }
    public int getHealthgain()
    {
    return healthgain;    
    }
    public int getAmount()
    {
    return amount;    
    }
}
