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

      println(Arrays.toString(characteristics));

   }

   private static int[] getCharacteristicScoresFromUser() throws IOException {
      int[] characteristics = new int[characteristics3d6.length - 1 + characteristics2d6Plus6.length - 1 + characteristics3d6Plus3.length - 1 + characteristics2d6Plus17.length - 1];
      int j = 0;
      int[] x = getSetOfRolls(3, 18, characteristics3d6);
      for(int i = 0; i < x.length; i++) {
         characteristics[j] = x[i];
         j++;
      }
      x = getSetOfRolls(8, 18, characteristics2d6Plus6);
      for(int i = 0; i < x.length; i++) {
         characteristics[j] = x[i];
         j++;
      }
      x = getSetOfRolls(6, 21, characteristics3d6Plus3);
      for(int i = 0; i < x.length; i++) {
         characteristics[j] = x[i];
         j++;
      }
      x = getSetOfRolls(19, 29, characteristics2d6Plus17);
      for(int i = 0; i < x.length; i++) {
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

   private static int[] autoRollCharacteristicScores() {

      return null;
   }

   private static void print(String s) {
      System.out.print(s);
   }

   private static void println(String s) {
      System.out.println(s);
   }
}
