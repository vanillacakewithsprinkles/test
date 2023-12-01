public class character
{
    //# attributes
    private String name;
    private int attack;
    private int defense;
    private int health;
    private int speed;
    
    public character(String name, int attack, int defense, int health, int speed)
    {
      this.name = name;
      this.attack = attack;
      this.defense = defense;
      this.health = health;
      this.speed = speed;
    }
    
    //#Setters
    public void setName(String name)
    {
        this.name = name;
    }
    public void setAttack(int attack)
    {
        this.attack = attack;
    }
    public void setDefense(int defense)
    {
        this.defense = defense;
    }
    public void setHealth(int speed)
    {
        this.health = health;
    }
    public void setSpeed(int speed)
    {
        this.health = health;
    }
    //#Getters
    public String getName()
    {
    return name;    
    }
    public int getAttack()
    {
    return attack;    
    }
    public int getDefense()
    {
    return defense;    
    }
    public int getHealth()
    {
    return health;    
    }
     public int getSpeed()
    {
    return speed;    
    }
}
