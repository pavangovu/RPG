import java.util.Random;
import java.util.Scanner;

/** NPCPavan extends NPC.  Pavan allows our hero to increase any of his stats, without paying
 * anything in return. Essentially, he is the god of my universe. You are lucky if you encounter him.
 * This class realizes the 3 abstract methods of the NPC super class. 
 * When our hero encounters an NPC, the interface will always provide a description
 * of the NPC and allow the hero to talk or barter with the NPC.  
 */
public class NPCPavan extends NPC{

    private Scanner s = new Scanner(System.in);
    /** Default constructor only.  NPCPavan is always constructed as "Pavan". */
    public NPCPavan(){
        super("Pavan", "I am all knowing Pavan");
    }
    /** Returns a description of Pavan. Used to introduce the character.  */
    public String describe(){
        return "There is an ambigious figure meditating in the distance";
    }

    /** Runs a dialogue between the Hero object and Pavan.
     * Since the dialogue is handled within this object, a reference to the 
     * Hero object must be passed in such that the methods of our Hero object are 
     * also accessible. */ 
    public void talk(Hero h){
        System.out.println(">> "+getName()+ ": I am Pavan. My knowledge is vast");
        System.out.println(">> "+h.getName()+": Pavan!! I thought you were just a legend!");
        System.out.println(">> "+getName()+": No, I am real. I can give you anything you desire because I have achieved true enlightenment");
    }

    /** Runs a barter sequence between the Hero object and Pavan.
     * Our hero may choose to increase any of his stats, free of cost.
     * Since the dialogue is handled within this object, a reference to the 
     * Hero object must be passed in such that the methods of our Hero object are 
     * also accessible. */ 
    public void barter (Hero h){
        boolean inputOk = true;
        do {
            System.out.print(">> " + getName() + ": What can I increase for you? [1 Health | 2 Attack | 3 Defense | 4 Gold] >>> ");
            int choice = s.nextInt();
            Random r = new Random();
            String say = ">> ";
            int rand = r.nextInt(10) + 1;
            switch (choice) {
                case 1:
                    h.setHealth(h.getHealth() + rand);
                    say += "Your health has improved by +" + rand;
                    break;
                case 2:
                    h.setAttackPower(h.getMaxAttack() + rand);
                    say += "Your Attack has improved by +" + rand;
                    break;
                case 3:
                    h.setDefense(h.getMaxDefense() + rand);
                    say += "Your Defense has improved by +" + rand;
                    break;
                case 4:
                    h.setGoldCount(h.getGoldCount() + rand);
                    say += "Your Gold Count has improved by +" + rand;
                    break;
                default:
                    System.out.println("Pick the right number please");
                    inputOk = !inputOk;
            }

            System.out.println(say);
            System.out.println(h);
        }while(!inputOk);
    }
}
