import static java.lang.System.*;
import java.util.Scanner;
import java.util.Collections;

/**This is where the actual RPG is handled. In this class, all the characters, 
 *elements, and logic are put together to create the overall gameplay experience.
 */
public class RPGRunner
{
    private static Hero user;
    private static Enemy monster;
    private static Scanner keyboard=new Scanner(System.in);
    private static NPC stranger;

    /**
     * Basic main. Contains the initial gameplay logistics.
     */
    public static void main(String[] args)
    {
        //initial game setup__happens only one time in the game__never changes
        System.out.println("**Please make fullscreen for proper gameplay experience.**\n\n");
        System.out.print("What's your name, hero? :: ");
        String heroName=keyboard.nextLine();
        System.out.print("What do you usually say to greet others? :: ");
        String heroGreeting=keyboard.nextLine();
        System.out.print("What is your battle cry? :: ");
        String heroBattleCry=keyboard.nextLine();
        pL();
        user=new Hero(heroName,50,20,10,heroGreeting,heroBattleCry);
        System.out.println("Welcome, "+user.getName()+". Here are your stats.");
        System.out.println(user);
        pL();
        System.out.println("You find yourself in a dense forest.");
        System.out.print("Press enter to venture further into the wilderness...");
        keyboard.nextLine();
        pL();

        //the actual game begins here__the game ends only if the hero dies (or if the user quits out of boredom)
        int encounter=0;
        monster=new Enemy("Robot",Rndm.integer(1,user.getHealth()),Rndm.integer(1,user.getMaxAttack()),Rndm.integer(1,user.getMaxDefense()),"Opponent detected","Resistance is futile","Robot blasts you with heat vision");
        while(user.getHealth()>0)
        {
            encounter=Rndm.integer(1,10);
            if(encounter>4)//NPC
            {
                int type=Rndm.integer(1,3);
                if(type==1)//shaman
                    stranger=new NPCShaman();
                if(type==2)//warrior
                    stranger=new NPCWarrior();
                if(type==3)
                    stranger=new NPCPavan();
                Interact();
                //g();
                //pL();
                //keyboard.nextLine();
            }
            else//enemy
            {

                Battle();
                g();
                pL();
                //keyboard.nextLine();
            }
            System.out.println(user);        
            System.out.print("Press enter to venture further into the wilderness...");
            keyboard.nextLine();
            g();
            pL();
        }
    }

    /**
     * Prints a separator line. Provides clarity in user interface and gameplay.
     */
    public static void pL()
    {
        int size=192;
        while(size>=0)
        {
            System.out.print("_");
            size--;
        }
        System.out.println("");
    }

    /**
     * Prints a separator gap. Provides clarity in user interface and gameplay.
     */
    public static void g()
    {
        int size=10;
        while(size>=0)
        {
            System.out.println("");
            size--;
        }
    }

    /**
     * Runs an interaction sequence between the Hero and the NPC. This method is only called if the Hero encounters an NPC, which is determined in the Main.
     */
    public static void Interact()
    {
        int choice;
        Scanner keyboard = new Scanner(System.in);
        out.println(">> "+stranger.describe());
        out.println(">> "+stranger.getName()+": "+stranger.getGreeting()+"\n");
        do
        {
            out.print("(1)Talk  (2)Barter  (3)View Stats  (4)Leave  :: ");
            choice = keyboard.nextInt();
            g();
            pL();
            if (choice==1) {
                out.println(">> "+user.getName()+": "+user.getGreeting());
                stranger.talk(user);
            }
            if (choice==2) { stranger.barter(user); }
            if (choice==3) { out.println(user); }
            out.println();
        } while (choice !=4);

    }
    
 /**
     * Runs an battle sequence between the Hero and the enemy. This method is only called if the Hero encounters an enemy, which is determined in the Main. Either the hero or the enemy will end up dead after this sequence.
     */
    public static void Battle()
    {
        int choice=1;
        System.out.println(">> Enemy encountered! It is "+monster.getName()+".");
        System.out.println(">> "+monster.getName()+": "+monster.getGreeting()+".\n");

        while((choice==1&&user.getHealth()>0)&&monster.getHealth()>0)
        {
            System.out.println(monster);
            System.out.println(user);
            System.out.print("<1>Attack or <2>Flee :: ");
            choice=keyboard.nextInt();
            System.out.println("");
            if(choice==1)//attack
            {
                int damage=-1;
                while(damage<1)
                    damage=(user.getRandomAttack()-monster.getRandomDefense())+5;
                System.out.print(">>\""+user.yell()+"\"... "+damage+" damage to "+monster.getName()+".");
                keyboard.nextLine();
                keyboard.nextLine();
                monster.setHealth(monster.getHealth()-damage);
                damage=-1;
                while(damage<1)
                    damage=(monster.getRandomAttack()-user.getRandomDefense());
                if(monster.getHealth()>0)
                {
                    System.out.print(">>Robot punches you. "+damage+" damage to "+user.getName()+".");
                    user.setHealth(user.getHealth()-damage);
                    keyboard.nextLine();
                }
                g();
                pL();
            }
            if(choice==2)//flee
            {
                int damage=-1;
                while(damage<1)
                    damage=(monster.getRandomAttack()-user.getRandomDefense());
                System.out.println(">>As you run away, Robot blasts you with its heat vision. "+damage+" damage to "+user.getName()+".");
                user.setHealth(user.getHealth()-damage);
                //System.out.print(">>You manage to get away...");
                keyboard.nextLine();
                keyboard.nextLine();
            }
        }
        if(monster.getHealth()<0)
        {
            System.out.println(">>You defeated "+monster.getName());
            System.out.println(">>You collected 10 gold from the corpse");
            System.out.println(">>You took "+monster.getName()+"'s weapon (+10 to Att).");
            System.out.println(">>Your stats improve.");
            keyboard.nextLine();
            user.setGoldCount(user.getGoldCount()+10);
            user.setAttackPower(user.getMaxAttack()+10);
            user.incKillCount();
            monster=new Enemy("Robot",Rndm.integer(1,user.getHealth()),Rndm.integer(1,user.getMaxAttack()),Rndm.integer(1,user.getMaxDefense()),"Opponent detected","Resistance is futile","Robot blasts you with heat vision");
        }
        if(user.getHealth()<0)
        {
            //System.out.println(user);
            g();
            pL();
            System.out.print("You have been slain. RIP, hero...");
            keyboard.nextLine();
            System.out.println("\nFinal Stats:");
            System.out.println(user);
            System.out.print("Strike the return key to exit game...");
            keyboard.nextLine();
            System.exit(0);
        }
    }

}
