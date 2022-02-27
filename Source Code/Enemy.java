import static java.lang.System.*;
/**Class for Enemy extends BattleCharacter.
 * Introduces a taunt message and attack move message.*/
public class Enemy extends BattleCharacter
{
    private String taunt,attackMove;

    /**Default Enemy constructor. Enemy object will be assigned a name of "Unnamed enemy47", health 
     * of 1, attack power of 1, defense 1, taunt of "[insert taunt here]", and an attack move of "[insert
     * attack move here]".
     */
    public Enemy()
    {
        super("[Unamed enemy47",1,1,1,"[insert greeting here]");
        taunt="[insert taunt here]";
        attackMove="[insert Attack Move here]";
    }

    /**Construct Enemy object with full properties.
     */
    public Enemy(String name, int health, int attackPower, int defense, String greeting, String taunt, String attackMove)
    {
        super(name,health,attackPower,defense,greeting);
        this.taunt=taunt;
        this.attackMove=attackMove;
    }

    /**Returns the attack move message of this Enemy. 
     */
    public String attackMessage()
    {
        return attackMove;
    }

    /**Sets the attack move message of this Enemy. 
     */
    public void setAttackMove(String attackMove)
    {
        this.attackMove=attackMove;
    }

    /**Sets the taunt message of this Enemy. 
     */
    public void setTaunt(String taunt)
    {
        this.taunt=taunt;
    }

    /**Returns the taunt message of this Enemy.  
     */
    public String tauntMessage()
    {
        return taunt;
    }
    
}
