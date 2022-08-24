import java.util.Random;
import java.util.Scanner;

public class SpideyRPG {
    public static void main(String[] args) {
        //System objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        //Game variables
        String[] enemies = {"Electro", "Scorpion", "Rhino", "Doc Ock", "Vulture", "Shocker", "Venom"};
        int maxEnemyHealth = 1000;
        int enemyAttackDamage = 250;

        String[] heavy = {"Electro", "Scorpion", "Rhino", "Doc Ock", "Vulture", "Shocker", "Venom"};
        int maxHeavyHealth = 300;
        int enemyHeavyDamage = 80;

        String[] sniper = {"Electro", "Scorpion", "Rhino", "Doc Ock", "Vulture", "Shocker", "Venom"};
        int maxSniperHealth = 150;
        int enemySniperDamage = 50;

        String[] goon = {"Electro", "Scorpion", "Rhino", "Doc Ock", "Vulture", "Shocker", "Venom"};
        int maxGoonHealth = 100;
        int enemyGoonDamage = 30;

        //Player variables
        int health = 700; //Spidey's Starting Health
        int attackDamage = 50; //Spidey's Attack Damage
        int numHealthPotions = 3; //Health Potions
        int healthPotionHealAmount = 50;  //How much the potions heal
        int healthPotionDropChance = 50; //50% Chance

        boolean running = true;

        System.out.print("--------Welcome to Oscorp!-------- \n ");

        GAME:
        while (running) {


            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " has appeared! #\n");

            while (enemyHealth > 0) {
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink Health Potion");
                System.out.print("\t3. Run! \n");

                String input = in.nextLine();
                if(input.equals("1")){
                 int damageDealt = rand.nextInt(attackDamage);
                 int damageTaken = rand.nextInt(enemyAttackDamage);

                 enemyHealth -= damageDealt;
                 health -= damageTaken;

                 System.out.println("\t\n> You struck " + enemy + " for " + damageDealt + " damage!");
                 System.out.println("\t> You recieved " + damageTaken + " as payback!");

                 if (health < 1) {
                     System.out.println("\t> Oh no! Spidey has taken too much damage! The Sinister Six has defeated you!");
                     break;
                 }
                }
                else if (input.equals("2")) {
                   if(numHealthPotions > 0) {
                       health += healthPotionHealAmount;
                       numHealthPotions --;
                       System.out.println("\t> You drank a health potion, healing yourself for " + healthPotionHealAmount + "HP."
                       + "\n\t> You now have " + health + " HP."
                       + "\n\t> You have " + numHealthPotions + " health potions left.\n");
                   }
                   else {
                       System.out.println("\t> You have no health potions left! Defeat " + enemy + " for a chance to get one!");
                   }
                }
                else if (input.equals("3")){
                    System.out.println("\tYou run away from " + enemy + "!");
                    continue GAME;
                }
                else {
                    System.out.println("\tInvalid command!\n");

                }
            }
             if (health < 1) {
                 System.out.println("Spidey just barely makes it out of Oscorp!");
                 break;
             }
            System.out.println("-------------------------------------------");
             System.out.println(" # " + enemy + " was defeated! # ");
             System.out.println(" #  You have " + health + "HP left.");
             if(rand.nextInt(100) >  healthPotionDropChance){
                 numHealthPotions++;
                 System.out.println(enemy + " has dropped a health potion. ");
                 System.out.println(" # You now have " + numHealthPotions + " health potion(s). # ");
        }
            System.out.println("-------------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue Fighting");
            System.out.println("2. Leave Oscorp and Regroup");

            String input = in.nextLine();

            while(!input.equals("1") && !input.equals("2")){
                System.out.println("Invalid command!");
                input = in.nextLine();
            }
            if(input.equals("1")){
                System.out.println("You continue on your adventure!");
            }
            else if(input.equals("2")){
                System.out.println("Spidey leaves Oscorp for now...");
                break;
            }
    }
        System.out.println("#######################");
        System.out.println("# THANKS FOR PLAYING! #");
        System.out.println("#######################");
}                         }