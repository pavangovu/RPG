import static java.lang.System.*;
/** 
 * NPC class is abstract and extends Character. This class has 3 abstract methods that must be realized for all NPC 
 * sub classes. When our hero encounters an NPC, the interface will always provide a description of the NPC and allow 
 * the hero to talk or barter with the NPC. 
 */
public abstract class NPC extends Character
{
    /**
     * Default NPC constructor.
     */
    public NPC()
    {
        super();
    }

    /**
     * Construct NPC with name and greeting message.
     */
    public NPC(String name, String greeting)
    {
        super(name,greeting);
    }

    /**
     * Runs a barter sequence between the Hero object and the NPC object. Since the sequence is handled within the 
     * NPC object, a reference to the Hero object must be passed in such that the methods of our Hero object are 
     * also accessible. 
     */
    public abstract void barter(Hero h);

    /**
     * Returns a description of the NPC. Used to introduce the character.
     */
    public abstract String describe();

    /**
     * Runs a dialogue between the Hero object and the NPC object. Since the dialogue is handled within the NPC 
     * object, a reference to the Hero object must be passed in such that the methods of our Hero object are also 
     * accessible.
     */
    public abstract void talk(Hero h);

}