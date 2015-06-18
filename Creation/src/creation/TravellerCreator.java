/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creation;

import java.util.Arrays;

/**
 *
 * @author Christian Bikle
 */

/**
 * (From page 5 of the 2008 Traveller book.  Yes, I'm aware I shouldn't be 
 * reproducing this without permission.  I'll throw it out when I'm done.)
 * 
 * 1. Roll characteristics and determine characteristic modifiers
 * 2. a. Choose a homeworld
 *    b. Gain background skills
 * 3. a. Choose a career. You cannot choose a career you already have.
 *    b. Roll to qualify for that career.
 *    c. If you qualify for that career, go to Step 4.
 *    d. If you do not qualify for a career, then you can go to the Draft or
 * enter the Drifter career. The Draft can put you back into a career you have
 * been forced to leave, at your old rank. You can only apply for the Draft
 * once.
 * 4. If this is your first time in this career, get your basic training.
 * 5. Choose a specialization for this career.
 * 6. a. Choose one of the Skills and Training tables for this career and roll
 * on it.
 *    b. Roll for survival on this career.
 *    c. If you succeed, go to Step 7.
 *    d. If you did not succeed, then events have forced you from this career.
 * Roll on the Mishap table, then go to Step 9.
 * 7. a. Roll for Events.
 *    b. Optionally, establish a Connection with another player character.
 * 8. a. Roll for Advancement.
 *    b. If you succeed, choose one of the skills and training tables for this
 * career and roll on it. Increase your rank and take any bonus skills from
 * the Ranks table for this career.
 *    c. If you roll less than the number of turns spent in this career, you
 * must leave this career.
 *    d. Military characters (Army, Navy, Marines) can roll for commission
 * instead of rolling for advancement.
 * 9. Increase your age by 4 years. If your character is 34 or older, roll for
 * Aging.
 * 10. If you are leaving the career, roll for Benefits.
 * 11. If you have left your current career, then go to Step 3 to choose a new
 * career, or to Step 12 if you wish to finish your character. Otherwise, go to
 * Step 5.
 * 12. Finalize any Connections with other characters.
 * 13. Choose a Campaign Skill Pack and allocate skills from that pack.
 * 14. Purchase starting equipment and, if you can afford it, a spacecraft.
 * 
 */

public class TravellerCreator {
    static String homeworldCharacteristicsAndSkills[] = {"Agricultural: Animals 0\n",
"Asteroid: Zero-G 0\n",
"Desert: Survival 0\n",
"Fluid Oceans: Seafarer 0\n",
"Garden: Animals 0\n",
"High Technology: Computers 0\n",
"High Population: Streetwise 0\n",
"Ice-Capped: Vacc Suit 0\n",
"Industrial: Trade 0\n",
"Low Technology: Survival 0\n",
"Poor: Animals 0\n",
"Rich: Carouse 0\n",
"Water World: Seafarer 0\n",
"Vacuum: Vacc Suit 0"};
    
    public static void main(String[] args) {
        int[] characteristics = {0,0,0,0,0};
        for(int i = 0; i < 5; i++) {
            characteristics = rollForCharacteristics();
        }
        Traveller_Character newcharacter = new Traveller_Character(characteristics);
        chooseHomeworld();
    }
/**
 * characteristic rolls and dice modifiers
*/
    public static int[] rollForCharacteristics() {
        Dice ch = new Dice(2, 6);
        int[] characteristics = new int[6];
        int[] dms = new int[6];
        for(int i = 0; i < characteristics.length; i++) {
            characteristics[i] = ch.rollDice();
            dms = Traveller_Character.calcCharacteristicDMs(characteristics);
        }
        Arrays.sort(characteristics);
        Arrays.sort(dms);
        System.out.println(Arrays.toString(characteristics));
        System.out.println(Arrays.toString(dms));
        
        return characteristics;
    }

    /**
     * choose homeworld (mostly for background skills) and gain bg skills
     */
    public static void chooseHomeworld() {
        //list the possible keywords (are there mutually exclusive keywords?)
        String instructions = "Homeworld: Growing up on your homeworld gave you skills that\n" +
"depend on the planet’s nature. You can select any skill that matches\n" +
"your homeworld’s planetary description and trade codes. If you\n" +
"came from a planet already established by Traveller books or by the\n" +
"Referee, then consult those sources for the planet’s description.\n" +
"Otherwise, just note down what traits you chose for your homeworld\n" +
"– you can generate the world later using the rules on page 167.";
        System.out.println(instructions);
        System.out.println(Arrays.toString(homeworldCharacteristicsAndSkills));
    }
}


