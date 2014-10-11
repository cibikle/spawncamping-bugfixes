/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author cibikle
 */
public class CharacterCreationAssistant {

   private static String mainMenu = "(N)ew, (O)pen, (H)elp, (Q)uit";
   private static BufferedReader kb;
   private static boolean run = true;
   private static String[] characteristics3d6 = {"3d6", "STR", "CON", "POW", "DEX", "CHA"};
   private static String[] characteristics2d6Plus6 = {"2d6+6", "INT", "SIZ"};
   private static String[] characteristics3d6Plus3 = {"3d6+3", "EDU"};
   private static String[] characteristics2d6Plus17 = {"2d6+17", "AGE"};
   private static String[] characteristicSkillNames = {"Effort", "Endurance",
      "Luck", "Agility", "Charisma", "Idea", "N/A", "Know"};

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) throws IOException {
      println("Hello! and welcome to Character Creation Assistant for \"The Laundry RPG\".");
      kb = new BufferedReader(new InputStreamReader(System.in));
      mainMenu();

   }

   private static char getCharFromUser() throws IOException {
      try {
         return getStringFromUser().charAt(0);
      } catch (StringIndexOutOfBoundsException e) {
         return ' ';
      }
   }

   private static int getIntFromUser() throws IOException {
      String s = getStringFromUser();
      try {
         return Integer.parseInt(s);
      } catch (NumberFormatException e) {
         println("Not a number: " + s);
         return -1;
      }
   }

   private static String getStringFromUser() throws IOException {
      return kb.readLine();
   }

   private static char getValidResponseFromUser(String msg, char[] acceptedResponses) throws IOException {
      println(msg);
      char c = getCharFromUser();
      while (!characterArrayContains(acceptedResponses, c)) {
         println("Invalid response: " + c);
         println(msg);
         c = getCharFromUser();
      }

      return c;
   }

   private static boolean characterArrayContains(char[] charArray, char c) {
      for (int i = 0; i < charArray.length; i++) {
         if (charArray[i] == c) {
            return true;
         }
      }
      return false;
   }

   private static void mainMenu() throws IOException {
      while (run) {
         println("Main menu: " + mainMenu);
         char c = getCharFromUser();
         switch (Character.toLowerCase(c)) {
            case 'n':
               newCharacter();
               break;
            case 'o':
               openCharacter();
               break;
            case 'h':
               help();
               break;
            case 'q':
               quit();
               break;
            default:
               println("Invalid command: " + c);
               break;
         }
      }

   }

   private static void quit() throws IOException {
      char[] acceptedResponses = {'y', 'n', 'q'};
      char c = getValidResponseFromUser("Are you sure you want to quit?  (Y)es/(N)o", acceptedResponses);
      switch (c) {
         case 'q'://same as case 'y'
         case 'y':
            run = false;
            println("Goodbye!");
            break;
         case 'n':
            break;
      }
   }

   private static void help() {
      println("Method not yet implemented, which is just about the worst thing to hear right now, I know.");
   }

   private static void openCharacter() {
      println("Method not yet implemented, which is just about the worst thing to hear right now, I know.");
   }

   private static void newCharacter() throws IOException {
      int[] characteristics = {1};
      int[] derivedCharacteristics = {2};
      DamageBonus db;
      CharacteristicSkill[] characteristicSkills;
      println("Right now, only PC creation is supported, but you could probably make NPC creation work. Just FYI.");
      char[] acceptedResponses = {'y', 'n', 'a', 'q'};
      char c = getValidResponseFromUser("Autoroll for characteristics?\n(Y)es, roll for me/(N)o, I want to enter my own.", acceptedResponses);
      switch (Character.toLowerCase(c)) {
         case 'y':
            characteristics = autoRollCharacteristicScores();
            break;
         case 'n':
            characteristics = getCharacteristicScoresFromUser();
            break;
         case 'a':
            println("Returning to main menu.");
            return;
         case 'q':
            quit();
            return;
      }

      derivedCharacteristics = deriveDerivedCharacteristics(characteristics);
      db = calculateDamageBonus(characteristics[0], characteristics[6]);
      characteristicSkills = deriveCharacteristicSkills(characteristics);
      println(Arrays.toString(characteristics));
      println(Arrays.toString(derivedCharacteristics));
      println(db.toString());
      println(Arrays.toString(characteristicSkills));

   }

   private static int[] getCharacteristicScoresFromUser() throws IOException {
      int[] characteristics = new int[characteristics3d6.length - 1 + characteristics2d6Plus6.length - 1 + characteristics3d6Plus3.length - 1 + characteristics2d6Plus17.length - 1];
      int j = 0;
      int[] x = getSetOfRolls(3, 18, characteristics3d6);
      for (int i = 0; i < x.length; i++) {
         characteristics[j] = x[i];
         j++;
      }
      x = getSetOfRolls(8, 18, characteristics2d6Plus6);
      for (int i = 0; i < x.length; i++) {
         characteristics[j] = x[i];
         j++;
      }
      x = getSetOfRolls(6, 21, characteristics3d6Plus3);
      for (int i = 0; i < x.length; i++) {
         characteristics[j] = x[i];
         j++;
      }
      x = getSetOfRolls(19, 29, characteristics2d6Plus17);
      for (int i = 0; i < x.length; i++) {
         characteristics[j] = x[i];
         j++;
      }

      return characteristics;
   }

   private static int[] getSetOfRolls(int min, int max, String[] characteristicNames) throws IOException {
      int[] characteristics = new int[characteristicNames.length - 1];
      int x = 0;
      char c = ' ';

      println("The following are rolled with " + characteristicNames[0] + ".");
      for (int i = 1; i < characteristicNames.length; i++) {
         characteristics[i - 1] = -1;
         x = getValidRollFromUser(min, max, characteristicNames[i] + ": ");

         characteristics[i - 1] = x;
      }

      println(Arrays.toString(characteristics));

      return characteristics;
   }

   private static int getValidRollFromUser(int min, int max, String prompt) throws IOException {
      String msg = "Value cannot be lower than " + min + " or higher than " + max + " unless special circumstances apply.\nProceed?  (Y)es/(N)o";
      char[] acceptedResponses = {'y', 'n', 'q'};

      println(prompt);
      int x = getIntFromUser();
      while (x < min || x > max) {
         char c = getValidResponseFromUser(msg, acceptedResponses);
         switch (Character.toLowerCase(c)) {
            case 'q':
               quit();
               return -1;
            case 'n':
               println(prompt);
               x = getIntFromUser();
               break;
            case 'y':
               return x;
         }
      }

      return x;
   }

   private static int[] autoRollCharacteristicScores() throws IOException {
      int[] characteristics = new int[characteristics3d6.length - 1 + characteristics2d6Plus6.length - 1 + characteristics3d6Plus3.length - 1 + characteristics2d6Plus17.length - 1];
      int j;
      Dice threeD6 = new Dice(3, 6);
      Dice twoD6 = new Dice(2, 6);
      String msg = "(K)eep or (R)eroll?";
      char[] acceptedResponses = {'k', 'r', 'a', 'q'};

      do {
         j = 0;
         for (int i = 0; i < characteristics3d6.length - 1; i++) {
            characteristics[j] = threeD6.rollDice();
            j++;
         }
         for (int i = 0; i < characteristics2d6Plus6.length - 1; i++) {
            characteristics[j] = twoD6.rollDice() + 6;
            j++;
         }
         for (int i = 0; i < characteristics3d6Plus3.length - 1; i++) {
            characteristics[j] = threeD6.rollDice() + 3;
            j++;
         }
         for (int i = 0; i < characteristics2d6Plus17.length - 1; i++) {
            characteristics[j] = twoD6.rollDice() + 17;
            j++;
         }
         println(Arrays.toString(characteristics));
      } while (Character.toLowerCase(getValidResponseFromUser(msg, acceptedResponses)) == 'r');

      return characteristics;
   }

   private static int[] deriveDerivedCharacteristics(int[] characteristics) {
      //hp, mwl, xpbonus, mov, san
      int[] derivedCharacteristics = new int[5];
      derivedCharacteristics[0] = (int) (((characteristics[1] + characteristics[6]) / 2.0) + 0.5);
      derivedCharacteristics[1] = (int) ((derivedCharacteristics[0] / 2.0) + 0.5);
      derivedCharacteristics[2] = (int) ((characteristics[5] / 2.0) + 0.5);
      derivedCharacteristics[3] = 10;
      derivedCharacteristics[4] = (int) (characteristics[2] * 5);
      return derivedCharacteristics;
   }

   private static CharacteristicSkill[] deriveCharacteristicSkills(int[] characteristics) {
      CharacteristicSkill[] characteristicSkills = new CharacteristicSkill[characteristics.length - 1];
      for (int i = 0; i < characteristicSkills.length; i++) {
         characteristicSkills[i] = new CharacteristicSkill(characteristicSkillNames[i], characteristics[i] * 5);
      }
      return characteristicSkills;
   }

   private static DamageBonus calculateDamageBonus(int str, int siz) {
      int basis = str + siz;
      if (basis < 13) {
         return new DamageBonus(new Dice(1, 6), true);
      } else if (basis < 17) {
         return new DamageBonus(new Dice(1, 4), true);
      } else if (basis < 25) {
         return new DamageBonus(new Dice(0, 4), false);
      } else if (basis < 33) {
         return new DamageBonus(new Dice(1, 4), false);
      } else if (basis < 41) {
         return new DamageBonus(new Dice(1, 6), false);
      } else {
         return new DamageBonus(new Dice(2, 6), false);
      }
   }

   private static void print(String s) {
      System.out.print(s);
   }

   private static void println(String s) {
      System.out.println(s);
   }
}
