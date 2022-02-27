import static java.lang.System.*;
/**Class for Hero extends BattleCharacter.
 * Introduces a battle cry, kill count and gold count*/
public class Hero extends BattleCharacter
{
    private String battleCry;
    private int killCount, goldCount;
    /**
     * Default Hero constructor. Hero object will be assigned a name of "Unnamed Hero", health of 50, 
     * attack power of 20, defense 10, kill count of 0, gold count of 0, and a battle cry of "[insert Battle Cry here]". 
     */
    public Hero()
    {
        super("[insert name here",50,20,10,"[insert greeting here]");
        goldCount=0;
        battleCry="[insert Battle Cry here]";
    }

    /**
     * Construct Hero object with name only. Hero object will be assign these default values: health of 50, 
     * attack power of 20, defense 10, kill count of 0, gold count of 0, and a battle cry of "[insert Battle Cry here]". 
     */
    public Hero(String name)
    {
        super(name,50,20,10,"[insert greeting here]");
        goldCount=0;
        battleCry="[insert Battle Cry here]";
    }

    /**
     * Construct Hero object with name, health, attack power, and defense. Hero object will be assign these 
     * default values: kill count of 0, gold count of 0, and a battle cry of "[insert battle cry here] 
     */
    public Hero(String name, int health, int attackPower, int defense)
    {
        super(name,health,attackPower,defense,"[insert greeting here]");
        goldCount=0;
        battleCry="[insert Battle Cry here]";
    }
    
    /** 
     * Constructs a Hero object with all properties except goldCount and killCount.
     */
    public Hero(String name, int health, int attackPower, int defense, String greeting, String battleCry)
    {
        super(name, health, attackPower, defense, greeting);
        this.battleCry=battleCry;
        goldCount=0;
        killCount=0;
    }
    
    /**
     * Returns the gold count of this Hero.
     */
    public int getGoldCount()
    {
        return goldCount;
    }

    /**
     * Returns the kill count of this Hero. 
     */
    public int getKillCount()
    {
        return killCount;
    }

    /**
     * Increments the kill count of this Hero.
     */
    public void incKillCount()
    {
        killCount++;
    }

    /**
     * Sets the battle cry of this Hero.
     */
    public void setBattleCry(String battleCry)
    {
        this.battleCry=battleCry;
    }
    
    /**
     * Sets the gold count of this Hero.
     */
    public void setGoldCount(int gold)
    {
        goldCount=gold;
    }
    
    /**
     * Returns a message for this Hero stating name and full stats. HP = health, Att = (maximum) attack power, 
     * Def = (maximum) defense. Example return string: Fred [HP 45] [Att 23] [Def 24] [Kills 4] [Gold 18] 
     */
    public String toString()
    {
       return ""+getName()+" [HP "+getHealth()+"] [Att "+getMaxAttack()+"] [Def "+getMaxDefense()+"] [Kills "+killCount+"] [Gold "+goldCount+"]";
    }
    
    /**
     * Returns the battle cry of this Hero.
     */
    public String yell()
    {
        return battleCry;
    }
}
