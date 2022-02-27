import static java.lang.System.*;
/** Abstract class for all game characters.
 * All game characters have names and greetings.*/
public abstract class Character
{
   private String name,greeting;
   /**Default constructor.
    */
   Character()
   {
      name="unnamed";
      greeting="[insert greeting]";
   }
   /**Constructs object with name.
    */
   Character(String name)
   {
      this.name=name;
      greeting="[insert greeting]";
   }
   /**Constructs object with name and greeting message.
    */
   Character(String name, String greeting)
   {
      this.name=name;
      this.greeting=greeting;
   }
   /**Returns the greeting message of this Character.
    */
   public String getGreeting()
   {
      return greeting;
   }
   /**Returns the name of this Character.
    */
   public String getName()
   {
      return name;
   }
   /**Sets the greeting message of this Character.
    */
   public void setGreeting(String greeting)
   {
      this.greeting=greeting;
   }
   /**Sets the name of this Character.
    */
   public void setName(String name)
   {
      this.name=name;
   }
   /**Returns a message for this Character stating the greeting.
    */
   public String toString()
   {
      return name+" says, \""+greeting+"\"";
   }
}