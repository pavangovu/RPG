import static java.lang.System.*;
import java.util.Scanner;

/** NPCShaman extends NPC.  The shaman allows our hero to heal in exchange for gold.
 * This class realizes the 3 abstract methods of the NPC super class. 
 * When our hero encounters an NPC, the interface will always provide a description
 * of the NPC and allow the hero to talk or barter with the NPC.  
 */
public class NPCShaman extends NPC
{   
    /* Required to realize these abstract methods from NPC
    public abstract String describe ();                 //What text is displayed when the hero first encounters this NPC
    public abstract void talk (Hero hero);              //Displays dialogue between hero and the NPC
    public abstract void barter (Hero hero);            //Handles any action (change of stats) for the player.   
     */
    private Scanner keyboard = new Scanner(System.in);

    /** Default constructor only.  NPCShaman is always constructed as "Thunderduck". */
    public NPCShaman() //constructor
    {
        super("Thunderduck", "Greetings, my child."); //constructor with name & greeting.
        //anytime this object is instantiated, it will have this same name and greeting passed up to its super's constructor.
    }

    /** Returns a description of Thunderduck. Used to introduce the character.  */
    public String describe ()  //What do you see when you first encounter this NPC?
    {
        return "You see an elderly woman sitting on a tree stump weaving sasquatch fur to the headstock of a staff.";
    }

    /** Runs a dialogue between the Hero object and Thunderduck.
     * Since the dialogue is handled within this object, a reference to the 
     * Hero object must be passed in such that the methods of our Hero object are 
     * also accessible. */ 
    public void talk (Hero h)  //What happens when your hero talks to this NPC
    {
        out.println(">> " + getName() + ": I am Thunderduck, a shaman of the Nimbaru tribe.");
        out.println(">> " + h.getName() + ": Shaman?  A healer?");
        out.println(">> " + getName() + ": Yes. I am quite skilled in medicinal magic.");  
    }

    /** Runs a barter sequence between the Hero object and Thunderduck.
     * Our hero may exchange gold for improved health.
     * Since the dialogue is handled within this object, a reference to the 
     * Hero object must be passed in such that the methods of our Hero object are 
     * also accessible. */ 
    public void barter (Hero h) //What happens when your hero barters with this NPC
    {
        out.println(">> " + h.getName() + ": Can you heal me?");
        out.println(">> " + getName() + ": If the price is right. I can heal 1 HP per 1 gold. What are you willing to spend? \n");  
        out.println(h);
        out.print("Give how much gold? :: ");
        int amt = keyboard.nextInt();
        out.println();
        if (amt > h.getGoldCount()) out.println(">> " + getName() + ": You appear low on funds.  Sorry, my child.");
        else if (amt > 0) 
        {
            out.println(">> " + getName() + ": Shokazulu!  You are healed, my child."); 
            out.println(">> Your health improved.");
            h.setHealth(h.getHealth()+amt);
            h.setGoldCount(h.getGoldCount()-amt);
        }
        else out.println(">> " + getName() + ": Very well, then.  Maybe another time.");    
    }
}

