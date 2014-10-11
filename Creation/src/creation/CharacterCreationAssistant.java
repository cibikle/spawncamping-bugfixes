/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
   private static Skill[] baseSkillSet = {
      new Skill("Appraise", 15, false),
      new Skill("Art (Calligraphy)", 05, false),
      new Skill("Art (Drawing)", 05, false),
      new Skill("Art (Painting)", 05, false),
      new Skill("Art (Photograpy)", 05, false),
      new Skill("Art (Sculpture)", 05, false),
      new Skill("Art (Writing)", 05, false),
      new Skill("Athletics (Acrobatics)", 10, false),
      new Skill("Athletics (American Football)", 10, false),
      new Skill("Athletics (Association Footcall)", 10, false),
      new Skill("Athletics (Baseball)", 10, false),
      new Skill("Athletics (Basketball)", 10, false),
      new Skill("Athletics (Bowling)", 10, false),
      new Skill("Athletics (Cricket)", 10, false),
      new Skill("Athletics (Cycling)", 10, false),
      new Skill("Athletics (Golf)", 10, false),
      new Skill("Athletics (Hockey)", 10, false),
      new Skill("Athletics (Rugby)", 10, false),
      new Skill("Athletics (Skating)", 10, false),
      new Skill("Athletics (Skiing)", 10, false),
      new Skill("Athletics (Tennis)", 10, false),
      new Skill("Athletics (Track & Field)", 10, false),
      new Skill("Bargain", 05, false),
      new Skill("Bureaucracy", 05, false),
      new Skill("Climb", 40, false),
      new Skill("Command", 05, false),
      new Skill("Computer Use (Art)", 05, false),
      new Skill("Computer Use (Design)", 05, false),
      new Skill("Computer Use (Forensics)", 05, false),
      new Skill("Computer Use (Gaming)", 05, false),
      new Skill("Computer Use (Magic)", 05, false),
      new Skill("Computer Use (Hacking)", 05, false),
      new Skill("Computer Use (Maintenance)", 05, false),
      new Skill("Computer Use (Programming)", 05, false),
      new Skill("Computer Use (Repair)", 05, false),
      new Skill("Craft (Carpentry)", 05, false),
      new Skill("Craft (Cooking)", 05, false),
      new Skill("Craft (Letherworking)", 05, false),
      new Skill("Craft (Pottery)", 05, false),
      new Skill("Craft (Sewing)", 05, false),
      new Skill("Craft (Woodworking)", 05, false),
      new Skill("Cthulhu Mythos", 0, false),
      new Skill("Demolition", 0, false),
      new Skill("Disguise", 05, false),
      new Skill("Drive (Automobile)", 20, false),
      new Skill("Drive (Industrial Mover)", 20, false),
      new Skill("Drive (Motorcycle)", 20, false),
      new Skill("Drive (Tank)", 20, false),
      new Skill("Etiquette", 05, false),
      new Skill("Fast Talk", 05, false),
      new Skill("Fine Manipulation", 05, false),
      new Skill("First Aid", 30, false),
      new Skill("Gaming", 10, false),
      new Skill("Grapple", 25, false),
      new Skill("Heavy Machine (Boiler)", 05, false),
      new Skill("Heavy Machine (Bulldozer)", 05, false),
      new Skill("Heavy Machine (Crane)", 05, false),
      new Skill("Heavy Machine (Engine)", 05, false),
      new Skill("Heavy Machine (Turbine)", 05, false),
      new Skill("Heavy Machine (Wrecker)", 05, false),
      new Skill("Hide", 10, false),
      new Skill("Insight", 05, false),
      new Skill("Jump", 25, false),
      new Skill("Knowledge (Accounting)", 10, false),
      new Skill("Knowledge (Anthropology)", 01, false),
      new Skill("Knowledge (Archaeology)", 01, false),
      new Skill("Knowledge (Art History)", 01, false),
      new Skill("Knowledge (Business)", 01, false),
      new Skill("Knowledge (Espionage)", 00, false),
      new Skill("Knowledge (Folklore)", 05, false),
      new Skill("Knowledge (Group)", 00, false),
      new Skill("Knowledge (History)", 20, false),
      new Skill("Knowledge (Law)", 05, false),
      new Skill("Knowledge (Linguistics)", 00, false),
      new Skill("Knowledge (Literature)", 05, false),
      new Skill("Knowledge (Natural History)", 10, false),
      new Skill("Knowledge (Occult)", 05, false),
      new Skill("Knowledge (Philosophy)", 01, false),
      new Skill("Knowledge (Politics)", 05, false),
      new Skill("Knowledge (Region)", 00, false),
      new Skill("Knowledge (Religion)", 05, false),
      new Skill("Knowledge (Streetwise)", 05, false),
      new Skill("Language (Own)", 40, false),
      new Skill("Language (Other)", 0, false),
      new Skill("Listen", 25, false),
      new Skill("Medicine (Dermatology)", 05, false),
      new Skill("Medicine (Family Medicine)", 05, false),
      new Skill("Medicine (Immunology)", 05, false),
      new Skill("Medicine (Internal Medicine)", 05, false),
      new Skill("Medicine (Neurology)", 05, false),
      new Skill("Medicine (Nuclear Medicine)", 05, false),
      new Skill("Medicine (Oncology)", 05, false),
      new Skill("Medicine (Pathology)", 05, false),
      new Skill("Medicine (Pediatrics)", 05, false),
      new Skill("Medicine (Radiology)", 05, false),
      new Skill("Medicine (Surgery)", 05, false),
      new Skill("Navigate", 10, false),
      new Skill("Perform (Act)", 05, false),
      new Skill("Perform (Dance)", 05, false),
      new Skill("Perform (Juggle)", 05, false),
      new Skill("Perform (Play Instrument)", 05, false),
      new Skill("Perform (Recite)", 05, false),
      new Skill("Perform (Sing)", 05, false),
      new Skill("Persuade", 15, false),
      new Skill("Pilot (Battleship)", 00, false),
      new Skill("Pilot (Helicopter)", 00, false),
      new Skill("Pilot (Hot Air Balloon)", 00, false),
      new Skill("Pilot (Hovercraft)", 00, false),
      new Skill("Pilot (Jet Airliner)", 00, false),
      new Skill("Pilot (Jet Boat)", 00, false),
      new Skill("Pilot (Jet Fighter)", 00, false),
      new Skill("Pilot (Ocean Liner)", 00, false),
      new Skill("Pilot (Propeller Plane)", 00, false),
      new Skill("Psychotherapy", 00, false),
      new Skill("Repair (Electrical)", 15, false),
      new Skill("Repair (Electronic)", 15, false),
      new Skill("Repair (Hydraulic)", 15, false),
      new Skill("Repair (Mechanical)", 15, false),
      new Skill("Repair (Plumbing)", 15, false),
      new Skill("Repair (Structural)", 15, false),
      new Skill("Research", 25, false),
      new Skill("Ride", 05, false),
      new Skill("Science (Astronomy)", 01, false),
      new Skill("Science (Biology)", 01, false),
      new Skill("Science (Botany)", 01, false),
      new Skill("Science (Chemistry)", 01, false),
      new Skill("Science (Cryptology)", 01, false),
      new Skill("Science (Forensics)", 01, false),
      new Skill("Science (Genetics)", 01, false),
      new Skill("Science (Geology)", 01, false),
      new Skill("Science (Mathematics)", 10, false),
      new Skill("Science (Meteorology)", 01, false),
      new Skill("Science (Pharmacy)", 01, false),
      new Skill("Science (Physics)", 01, false),
      new Skill("Science (Planetology)", 01, false),
      new Skill("Science (Psychology)", 05, false),
      new Skill("Science (Thaumaturgy)", 00, false),
      new Skill("Science (Zoology)", 05, false),
      new Skill("Sense", 10, false),
      new Skill("Slight of Hand", 05, false),
      new Skill("Sorcery", 00, false),
      new Skill("Spot", 25, false),
      new Skill("Status", 15, false),
      new Skill("Stealth", 10, false),
      new Skill("Swim", 25, false),
      new Skill("Teach", 10, false),
      new Skill("Technology Use (Communications)", 05, false),
      new Skill("Technology Use (Electronic Security)", 05, false),
      new Skill("Technology Use (Electronics)", 05, false),
      new Skill("Technology Use (Sensor System)", 05, false),
      new Skill("Technology Use (Surveillance)", 05, false),
      new Skill("Technology Use (Traps)", 05, false),
      new Skill("Track", 10, false)
   };
   private static Skill[] baseCombatSkills = {
      new Skill("Artillery (Cannon)", 0, false),
      new Skill("Artillery (Rocket Launcher)", 0, false),
      new Skill("Artillery (Turret)", 0, false),
      new Skill("Artillery (Vehicular Weapon)", 0, false),
      new Skill("Brawl", 25, false),
      new Skill("Dodge", 06, false),
      new Skill("Firearm (Assault Rifle)", 15, false),
      new Skill("Firearm (Esoteric)", 00, false),
      new Skill("Firearm (Exotic)", 05, false),
      new Skill("Firearm (Pistol)", 20, false),
      new Skill("Firearm (Rifle)", 25, false),
      new Skill("Firearm (Shotgun)", 30, false),
      new Skill("Firearm (SMG)", 15, false),
      new Skill("Heavy Weapon (Bazooka)", 0, false),
      new Skill("Heavy Weapon (Grenade Launcher)", 0, false),
      new Skill("Heavy Weapon (Heavy Machine Gun)", 0, false),
      new Skill("Heavy Weapon (Minigun)", 0, false),
      new Skill("Heavy Weapon (Rocket Launcher)", 0, false),
      new Skill("Melee Weapon (Axe)", 00, false),
      new Skill("Melee Weapon (Club)", 00, false),
      new Skill("Melee Weapon (Garrote)", 00, false),
      new Skill("Melee Weapon (Knife)", 00, false),
      new Skill("Melee Weapon (Spear)", 00, false),
      new Skill("Melee Weapon (Staff)", 00, false),
      new Skill("Melee Weapon (Sword)", 00, false),
      new Skill("Melee Weapon (Whip)", 00, false),
      new Skill("Missile Weapon (Archery)", 00, false),
      new Skill("Missile Weapon (Blowgun)", 00, false),
      new Skill("Missile Weapon (Boomerang)", 00, false),
      new Skill("Missile Weapon (Bow)", 00, false),
      new Skill("Missile Weapon (Crossbow)", 00, false),
      new Skill("Missile Weapon (Dart)", 00, false),
      new Skill("Missile Weapon (Javelin)", 00, false),
      new Skill("Missile Weapon (Shuriken)", 00, false),
      new Skill("Missile Weapon (Sling)", 00, false),
      new Skill("Missile Weapon (Spear)", 00, false),
      new Skill("Missile Weapon (Throwing Axe)", 00, false),
      new Skill("Missile Weapon (Throwing Knife)", 00, false),
      new Skill("Throw", 25, false),};
      private static final String add20 = "Add 20 Skill points to each of the following skills:\n\t";
      private static String[] personalityDescs = {
         "1. Bruiser: Your character believes that solving problems is best handled through quick application of physical force.\n"
              + add20
              + "Brawl, Climb, Combat (any two), Dodge, Grapple, Insight, Jump, Ride, Sense, Stealth, Swim, and Throw.\n",
         "2. Master: Your character believes that technique, craft, and expertise are the keys to success.\n"
              + add20
              + "Appraise, Combat (any), Craft, Disguise, Dodge, Fine Manipulation, First Aid, Knowledge (any), Navigate, Pilot, Ride, Sleight of Hand, and Stealth",
         "3. Thinker: When confronted with opposition, your character's first instinct is to outsmart their opponent to gain as advantage.\n"
              + add20
              + "Appraise, Bargain, Combat (any), Disguise, Insight, Knowledge (any two), Listen Research, Sense, Spot, Stealth, and any one Technical skill.",
         "4. Leader: Your character enjoys calling the shots and persuading other to work.\n"
              + add20
              + "Appraise, Bargain, Combat (any), Command, Etiquette, Fast Talk, Insight, Knowledge (any), Language (any), Language (Own), Perform, Persuade, and Sense.",
         "5. Slacker: Your character has spent their lifetime dodging responsibility and believe that problems are best avoided altogether.\n"
              + add20
              + "Bargain, Bureaucracy, Disguise, Dodge, Fast Talk, Gaming, Hide, Insight, Language (any), Persuade, Sense, Slight of Hand, and Spot",
         "6. Nutter: Your character can safely be categorized as insane, though they are functional and able to work within the organization of the Laundry. Rational thought and problem-solving methods are neglected: insane leaps of logic are the primary means of attaining goals.\n"
              + add20
              + "Command, Fast Talk, Hide, Insight, Knowledge (any two), Research, Science (any two), Sense, Spot, Stealth, Strategy.\n"
              + "Further, reduce SAN by 20 and choose an appropriate mental disorder."
      };

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
      
      ArrayList<Skill> skills = new ArrayList<Skill>(Arrays.asList(baseSkillSet));
      ArrayList<Skill> combatSkills = new ArrayList<Skill>(Arrays.asList(baseCombatSkills));
      println(skills.toString().replaceAll(",", "\n"));
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

   private static void pickPersonalityType(ArrayList<Skill> skills, ArrayList<Skill> combatSkills) {
      println("How does your character approach life and deal with challenges?\n"
              + "Choose one of the following options by entering its number or leave it to (c)hance.\n"
              );
      //print the types and then get input and then figure out how to apply their choices--how do we handle choosing skills?
      
   }
   
   private static void print(String s) {
      System.out.print(s);
   }

   private static void println(String s) {
      System.out.println(s);
   }
}
