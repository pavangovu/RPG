import static java.lang.System.*;
/** Abstract class for characters that can engage in battles.
 *Introduces health, attack power, and defense attributes.*/
public abstract class BattleCharacter extends Character
{
   private int health, attackPower, defense;
   
   /**Construct BattleCharacter with name, health, attack power, and defense.
   */
   BattleCharacter(String name, int health, int attackPower, int defense)
   {
      super(name);
      this.health=health;
      this.attackPower=attackPower;
      this.defense=defense;
   }

   /**Construct BattleCharacter and set all properties.
   */
   BattleCharacter(String name, int health, int attackPower, int defense, String greeting)
   {
      super(name,greeting);
      this.health=health;
      this.attackPower=attackPower;
      this.defense=defense;
   }

   /**Returns the health of this BattleCharacter.
   */
   public int getHealth()
   {
      return health;
   }

   /**Returns the attack power of this BattleCharacter.
   */
   public int getMaxAttack()
   {
      return attackPower;
   }

   /**Returns the defense level of this BattleCharacter.
   */
   public int getMaxDefense()
   {
      return defense;
   }

   /**Returns a random integer indicating how powerful this attack was.
   */
   public int getRandomAttack()
   {
      double tempStart=0.6*attackPower;
      return Rndm.integer((int)tempStart,attackPower);
   }
   
   /**Returns a random integer indicating how much of an attack will be deflected. 
   */
   public int getRandomDefense()
   {
      double tempStart=0.5*defense;
      return Rndm.integer((int)tempStart,defense);
   }
   
   /**Sets the attack power of this BattleCharacter.
   */
   public void setAttackPower(int attackLevel)
   {
      attackPower=attackLevel;
   }
   
   /**Sets the defense of this BattleCharacter.
   */
   public void setDefense(int defenseLevel)
   {
      defense=defenseLevel;
   }
   
   /**Sets the health of this BattleCharacter.
   */
   public void setHealth(int healthLevel)
   {
      health=healthLevel;
   }
   
   /**Returns a message for this BattleCharacter stating name and battle stats.
   */
   public String toString()
   {
      return super.getName()+"[HP "+health+"] [Att "+attackPower+"] [Def "+defense+"]";
   }
}