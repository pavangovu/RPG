import static java.lang.System.*;
import java.util.Scanner;

/** 
 * NPCWarrior extends NPC. The warrior allows our hero to exchange stat points. You must be willing to give up some 
 * of your defense power to receive an item in return. This class realizes the 3 abstract methods of the NPC super 
 * class. When our hero encounters an NPC, the interface will always provide a description of the NPC and allow the 
 * hero to talk or barter with the NPC. 
 */
public class NPCWarrior extends NPC
{   
    /* Required to realize these abstract methods from NPC
    public abstract String describe ();                 //What text is displayed when the hero first encounters this NPC
    public abstract void talk (Hero hero);              //Displays dialogue between hero and the NPC
    public abstract void barter (Hero hero);            //Handles any action (change of stats) for the player.   
     */
    private Scanner keyboard = new Scanner(System.in);
    private int need;

    /** 
     * Default constructor only. NPCWarrior is always constructed as "Ravum Greymane". At time of construction, 
     * warrior is assigned a need of defense in order to facilitate the barter sequence.
     */ 
    public NPCWarrior() //constructor
    {
        super("Ravum Greymane", "I'm glad you came along.");
        need=1;
        //constructor with name & greeting.
        //anytime this object is instantiated, it will have this same name and greeting passed up to 
        //its super's constructor.
    }

    /** 
     * Returns a description of Ravum Greymane, used to introduce the character.
     */
    public String describe ()  //What do you see when you first encounter this NPC?
    {
        return "A fellow warrior approaches you sensing you are no danger.";
    }

    /** Runs a dialogue between the Hero object and Ravum Greymane.
     * Since the dialogue is handled within this object, a reference to the 
     * Hero object must be passed in such that the methods of our Hero object are 
     * also accessible. */ 
    public void talk (Hero h)  //What happens when your hero talks to this NPC
    {
        //out.println(">> " + h.getName() + ": Hello.");
        out.println(">> " + getName() + ": I need some help. I was battling a horde of ogres down in that gorge, but to little avail.");
        out.println(">> " + h.getName() + ": Need me to put a few down for you?");
        out.println(">> " + getName() + ": No. Thanks, but I battle alone. I just need to strengthen my defenses.");
        out.println(">> " + getName() + ": **Ravum Greymane sizes you up.**");
        out.println(">> " + getName() + ": Any armor you could part with?");
    }

    /** Runs a barter sequence between the Hero object and Ravum Greymane. Our hero 
     * may acquire a boost in certain stats in exchange for defense ability.  
     * Since the dialogue is handled within this object, a reference to the Hero 
     * object must be passed in such that the methods of our Hero object are also 
     * accessible.*/ 
    public void barter (Hero h) //What happens when your hero barters with this NPC
    {
        out.println(">> " + h.getName() + ": What do you have to offer in trade?");
        if(need==1)
            out.println(">> " + getName() + ": Give me something worth 5 Def and I'll offer you one of these: \n>> Item 1: Berries (double HP) or Item 2: Sword (double Att) ");  
        if(need==2)
            out.println(">> " + getName() + ": Give me something worth 5 Att and I'll offer you one of these: \n>> Item 1: Berries (double HP) or Item 2: Sword (double Att) "); 
        out.println(h);
        if(need==1)
            out.print(">> Trade 5 Def for which item? (1)Item 1 (2)Item 2 (3)Pass :: ");

        if(need==2)
            out.print(">> Trade 5 Att for which item? (1)Item 1 (2)Item 2 (3)Pass :: "); 
        int choice = keyboard.nextInt();
        out.println();
        if (choice>2) out.println(">> " + getName() + ": Very well, then.  Maybe another time."); 
        if (h.getMaxDefense()<5) out.println(">> You do not have enough defense. Come back later.");
        else if(choice<3) 
        {
            if(choice==1)
            {
                out.println(">> " + getName() + ": Here you go."); 
                out.println(">> Your HP improved.");
                h.setHealth(h.getHealth()*2);
                h.setDefense(h.getMaxDefense()-5);
            }
            if(choice==2)
            {
                out.println(">> " + getName() + ": Here you go."); 
                out.println(">> Your Att improved.");
                h.setAttackPower(h.getMaxAttack()*2);
                h.setDefense(h.getMaxDefense()-5);
            }
        }
        else out.println("bad input");  
    }
}

