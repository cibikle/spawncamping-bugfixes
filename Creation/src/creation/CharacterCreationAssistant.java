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
   private static boolean run  = true;
   private static String[] characteristics3d6 = {"3d6", "STR", "CON", "POW","DEX", "CHA"};
   private static String[] characteristics2d6Plus6 = {"2d6+6", "INT","SIZ"};
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
      return kb.readLine().charAt(0);
   }
   
   private static int getIntFromUser() throws IOException {
      String s = kb.readLine();
      try {
         return Integer.parseInt(s);
      } catch (NumberFormatException e) {
         println("Not a number: "+s);
         return -1;
      }
   }
   
   private static String getStringFromUser() throws IOException {
      return kb.readLine();
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
   
   private static void quit() {
      run = false;
      println("Goodbye!");
   }
   
   private static void help() {
      println("Method not yet implemented, which is just about the worst thing to hear right now, I know.");
   }
   
   private static void openCharacter() {
      println("Method not yet implemented, which is just about the worst thing to hear right now, I know.");
   }
   
   private static void newCharacter() throws IOException {
      println("Right now, only PC creation is supported, but you could probably make NPC creation work. Just FYI.");
      
      char c = ' ';
      boolean r = true;
      while(r) {
         println("Autoroll for characteristics?\n(Y)es, roll for me/(N)o, I want to enter my own.");
         c = getCharFromUser();
         switch (Character.toLowerCase(c)) {
            case 'y' :
               r = false;
               autoRollCharacteristicScores();
               break;
            case 'n' :
               r = false;
               getCharacteristicScoresFromUser();
               break;
            default:
               println("Invalid command: "+c);
               break;
         }
      }
   }
   
   private static void getCharacteristicScoresFromUser() throws IOException {
      int[] characteristics = new int[characteristics3d6.length-1 + characteristics2d6Plus6.length-1 + characteristics3d6Plus3.length-1 +characteristics2d6Plus17.length-1];
      getSetOfRolls(3, 18, characteristics3d6);
      getSetOfRolls(8, 18, characteristics2d6Plus6);
      getSetOfRolls(6, 21, characteristics3d6Plus3);
      getSetOfRolls(19, 29, characteristics2d6Plus17);
   }
   
   private static int[] getSetOfRolls(int min, int max, String[] characteristicNames) throws IOException {
      int[] characteristics = new int[characteristicNames.length-1];
      int x = 0;
      char c = ' ';
      println("The following are rolled with "+characteristicNames[0]+".");
      for(int i = 1; i < characteristicNames.length; i++) {
         characteristics[i-1] = -1;
         print(characteristicNames[i]+": ");
         x = getIntFromUser();
         while((x < min || x > max) && characteristics[i-1] == -1) {
            println("Value cannot be lower than "+min+" or higher than "+max+" unless special circumstances apply.\nProceed?  (Y)es/(N)o");
            c = getCharFromUser();
            while(Character.toLowerCase(c) != 'y' && Character.toLowerCase(c) != 'n') {
               println("Invalid response: "+c);
               c = getCharFromUser();
            }
            if (Character.toLowerCase(c) == 'y') {
               characteristics[i-1] = x;
            } else {
               print(characteristicNames[i]+": ");
               x = getIntFromUser();
            }
         }
         characteristics[i-1] = x;
      }
      
      println(Arrays.toString(characteristics));
      
      return characteristics;
   }
   
   private static void autoRollCharacteristicScores() {
      
   }

   private static void print(String s) {
      System.out.print(s);
   }

   private static void println(String s) {
      System.out.println(s);
   }
}
