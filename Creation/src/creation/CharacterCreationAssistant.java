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

   //private static final String mainMenu = "(N)ew, (O)pen, (H)elp, (Q)uit";
   private static final String mainMenu = "(N)ew, (H)elp, (Q)uit";
   private static BufferedReader kb;
   private static boolean run = true;
   private static final String[] characteristics3d6 = {"3d6", "STR", "CON", "POW", "DEX", "CHA"};
   private static final String[] characteristics2d6Plus6 = {"2d6+6", "INT", "SIZ"};
   private static final String[] characteristics3d6Plus3 = {"3d6+3", "EDU"};
   private static final String[] characteristics2d6Plus17 = {"2d6+17", "AGE"};
   private static final String[] characteristicSkillNames = {"Effort", "Endurance",
      "Luck", "Agility", "Charisma", "Idea", "N/A", "Know"};
   private static final Skill[] baseSkillSet = {
      new CheckableSkill("Appraise", 15, false),
      new Skill("Art", 05),
      new Skill("Athletics", 10),
      new CheckableSkill("Bargain", 05, false),
      new CheckableSkill("Bureaucracy", 05, false),
      new CheckableSkill("Climb", 40, false),
      new CheckableSkill("Command", 05, false),
      new Skill("Computer Use", 05),
      new Skill("Craft", 05),
      new Skill("Cthulhu Mythos", 0),
      new CheckableSkill("Demolition", 0, false),
      new CheckableSkill("Disguise", 05, false),
      new Skill("Drive", 20),
      new CheckableSkill("Etiquette", 05, false),
      new CheckableSkill("Fast Talk", 05, false),
      new CheckableSkill("Fine Manipulation", 05, false),
      new CheckableSkill("First Aid", 30, false),
      new CheckableSkill("Gaming", 10, false),
      new CheckableSkill("Grapple", 25, false),
      new Skill("Heavy Machine", 05),
      new CheckableSkill("Hide", 10, false),
      new CheckableSkill("Insight", 05, false),
      new CheckableSkill("Jump", 25, false),
      new CheckableSkill("Knowledge (Accounting)", 10, false),
      new CheckableSkill("Knowledge (Espionage)", 00, false),
      new CheckableSkill("Knowledge (Law)", 05, false),
      new CheckableSkill("Knowledge (Occult)", 05, false),
      new CheckableSkill("Knowledge (Politics)", 05, false),
      new CheckableSkill("Language (Own: EDUx5%)", 40, false),
      new CheckableSkill("Listen", 25, false),
      new Skill("Medicine", 05),
      new CheckableSkill("Navigate", 10, false),
      new Skill("Perform", 05),
      new CheckableSkill("Persuade", 15, false),
      new Skill("Pilot", 00),
      new CheckableSkill("Psychotherapy", 00, false),
      new Skill("Repair", 15),
      new CheckableSkill("Research", 25, false),
      new CheckableSkill("Ride", 05, false),
      new Skill("Science (see p42)", 00),
      new CheckableSkill("Sense", 10, false),
      new CheckableSkill("Slight of Hand", 05, false),
      new Skill("Sorcery", 00),
      new CheckableSkill("Spot", 25, false),
      new Skill("Status", 15),
      new CheckableSkill("Stealth", 10, false),
      new CheckableSkill("Swim", 25, false),
      new CheckableSkill("Teach", 10, false),
      new Skill("Technology Use", 05),
      new CheckableSkill("Track", 10, false)
   };
   private static final Skill[] artSpecializations = {
      new CheckableSkill("Art (Calligraphy)", 05, false),
      new CheckableSkill("Art (Drawing)", 05, false),
      new CheckableSkill("Art (Painting)", 05, false),
      new CheckableSkill("Art (Photograpy)", 05, false),
      new CheckableSkill("Art (Sculpture)", 05, false),
      new CheckableSkill("Art (Writing)", 05, false)
   };
   private static final Skill[] athleticsSpecializations = {
      new CheckableSkill("Athletics (Acrobatics)", 10, false),
      new CheckableSkill("Athletics (American Football)", 10, false),
      new CheckableSkill("Athletics (Association Footcall)", 10, false),
      new CheckableSkill("Athletics (Baseball)", 10, false),
      new CheckableSkill("Athletics (Basketball)", 10, false),
      new CheckableSkill("Athletics (Bowling)", 10, false),
      new CheckableSkill("Athletics (Cricket)", 10, false),
      new CheckableSkill("Athletics (Cycling)", 10, false),
      new CheckableSkill("Athletics (Golf)", 10, false),
      new CheckableSkill("Athletics (Hockey)", 10, false),
      new CheckableSkill("Athletics (Rugby)", 10, false),
      new CheckableSkill("Athletics (Skating)", 10, false),
      new CheckableSkill("Athletics (Skiing)", 10, false),
      new CheckableSkill("Athletics (Tennis)", 10, false),
      new CheckableSkill("Athletics (Track & Field)", 10, false)
   };
   private static final Skill[] computerUseSpecializations = {
      new CheckableSkill("Computer Use (Art)", 05, false),
      new CheckableSkill("Computer Use (Design)", 05, false),
      new CheckableSkill("Computer Use (Forensics)", 05, false),
      new CheckableSkill("Computer Use (Gaming)", 05, false),
      new CheckableSkill("Computer Use (Magic)", 05, false),
      new CheckableSkill("Computer Use (Hacking)", 05, false),
      new CheckableSkill("Computer Use (Maintenance)", 05, false),
      new CheckableSkill("Computer Use (Programming)", 05, false),
      new CheckableSkill("Computer Use (Repair)", 05, false)
   };
   private static final Skill[] craftSpecializations = {
      new CheckableSkill("Craft (Carpentry)", 05, false),
      new CheckableSkill("Craft (Cooking)", 05, false),
      new CheckableSkill("Craft (Letherworking)", 05, false),
      new CheckableSkill("Craft (Pottery)", 05, false),
      new CheckableSkill("Craft (Sewing)", 05, false),
      new CheckableSkill("Craft (Woodworking)", 05, false)
   };
   private static final Skill[] driveSpecializations = {
      new CheckableSkill("Drive (Automobile)", 20, false),
      new CheckableSkill("Drive (Industrial Mover)", 20, false),
      new CheckableSkill("Drive (Motorcycle)", 20, false),
      new CheckableSkill("Drive (Tank)", 20, false)
   };
   private static final Skill[] heavyMachineSpecializations = {
      new CheckableSkill("Heavy Machine (Boiler)", 05, false),
      new CheckableSkill("Heavy Machine (Bulldozer)", 05, false),
      new CheckableSkill("Heavy Machine (Crane)", 05, false),
      new CheckableSkill("Heavy Machine (Engine)", 05, false),
      new CheckableSkill("Heavy Machine (Turbine)", 05, false),
      new CheckableSkill("Heavy Machine (Wrecker)", 05, false)
   };
   private static final Skill[] knowledgeSpecializations = {
      new CheckableSkill("Knowledge (Anthropology)", 01, false),
      new CheckableSkill("Knowledge (Archaeology)", 01, false),
      new CheckableSkill("Knowledge (Art History)", 01, false),
      new CheckableSkill("Knowledge (Business)", 01, false),
      new CheckableSkill("Knowledge (Folklore)", 05, false),
      new CheckableSkill("Knowledge (Group)", 00, false),
      new CheckableSkill("Knowledge (History)", 20, false),
      new CheckableSkill("Knowledge (Linguistics)", 00, false),
      new CheckableSkill("Knowledge (Literature)", 05, false),
      new CheckableSkill("Knowledge (Natural History)", 10, false),
      new CheckableSkill("Knowledge (Philosophy)", 01, false),
      new CheckableSkill("Knowledge (Region)", 00, false),
      new CheckableSkill("Knowledge (Religion)", 05, false),
      new CheckableSkill("Knowledge (Streetwise)", 05, false),};
   private static final Skill[] languageSpecializations = {
      new CheckableSkill("Language (Arabic)", 0, false),
      new CheckableSkill("Language (Enochian)", 0, false),
      new CheckableSkill("Language (Old Enochian)", 0, false),
      new CheckableSkill("Language (German)", 0, false),
      new CheckableSkill("Language (Latin)", 0, false),};
   private static final Skill[] medicineSpecializations = {
      new CheckableSkill("Medicine (Dermatology)", 05, false),
      new CheckableSkill("Medicine (Family Medicine)", 05, false),
      new CheckableSkill("Medicine (Immunology)", 05, false),
      new CheckableSkill("Medicine (Internal Medicine)", 05, false),
      new CheckableSkill("Medicine (Neurology)", 05, false),
      new CheckableSkill("Medicine (Nuclear Medicine)", 05, false),
      new CheckableSkill("Medicine (Oncology)", 05, false),
      new CheckableSkill("Medicine (Pathology)", 05, false),
      new CheckableSkill("Medicine (Pediatrics)", 05, false),
      new CheckableSkill("Medicine (Radiology)", 05, false),
      new CheckableSkill("Medicine (Surgery)", 05, false)
   };
   private static final Skill[] performSpecializations = {
      new CheckableSkill("Perform (Act)", 05, false),
      new CheckableSkill("Perform (Dance)", 05, false),
      new CheckableSkill("Perform (Juggle)", 05, false),
      new CheckableSkill("Perform (Play Instrument)", 05, false),
      new CheckableSkill("Perform (Recite)", 05, false),
      new CheckableSkill("Perform (Sing)", 05, false)
   };
   private static final Skill[] pilotSpecializations = {
      new CheckableSkill("Pilot (Battleship)", 00, false),
      new CheckableSkill("Pilot (Helicopter)", 00, false),
      new CheckableSkill("Pilot (Hot Air Balloon)", 00, false),
      new CheckableSkill("Pilot (Hovercraft)", 00, false),
      new CheckableSkill("Pilot (Jet Airliner)", 00, false),
      new CheckableSkill("Pilot (Jet Boat)", 00, false),
      new CheckableSkill("Pilot (Jet Fighter)", 00, false),
      new CheckableSkill("Pilot (Ocean Liner)", 00, false),
      new CheckableSkill("Pilot (Propeller Plane)", 00, false)
   };
   private static final Skill[] repairSpecializations = {
      new CheckableSkill("Repair (Electrical)", 15, false),
      new CheckableSkill("Repair (Electronic)", 15, false),
      new CheckableSkill("Repair (Hydraulic)", 15, false),
      new CheckableSkill("Repair (Mechanical)", 15, false),
      new CheckableSkill("Repair (Plumbing)", 15, false),
      new CheckableSkill("Repair (Structural)", 15, false)
   };
   private static final Skill[] scienceSpecializations = {
      new CheckableSkill("Science (Astronomy)", 01, false),
      new CheckableSkill("Science (Biology)", 01, false),
      new CheckableSkill("Science (Botany)", 01, false),
      new CheckableSkill("Science (Chemistry)", 01, false),
      new CheckableSkill("Science (Cryptology)", 01, false),
      new CheckableSkill("Science (Forensics)", 01, false),
      new CheckableSkill("Science (Genetics)", 01, false),
      new CheckableSkill("Science (Geology)", 01, false),
      new CheckableSkill("Science (Mathematics)", 10, false),
      new CheckableSkill("Science (Meteorology)", 01, false),
      new CheckableSkill("Science (Pharmacy)", 01, false),
      new CheckableSkill("Science (Physics)", 01, false),
      new CheckableSkill("Science (Planetology)", 01, false),
      new CheckableSkill("Science (Psychology)", 05, false),
      new CheckableSkill("Science (Thaumaturgy)", 00, false),
      new CheckableSkill("Science (Zoology)", 05, false)
   };
   private static final Skill[] technologyUseSpecializations = {
      new CheckableSkill("Technology Use (Communications)", 05, false),
      new CheckableSkill("Technology Use (Electronic Security)", 05, false),
      new CheckableSkill("Technology Use (Electronics)", 05, false),
      new CheckableSkill("Technology Use (Sensor System)", 05, false),
      new CheckableSkill("Technology Use (Surveillance)", 05, false),
      new CheckableSkill("Technology Use (Traps)", 05, false)
   };
   private static final Skill[] baseCombatSkills = {
      new Skill("Artillery (various)", 00),
      new CheckableSkill("Brawl", 25, false),
      new CheckableSkill("Dodge", 06, false),
      new CheckableSkill("Firearm (Assault Rifle)", 15, false),
      new CheckableSkill("Firearm (Esoteric)", 00, false),
      new CheckableSkill("Firearm (Exotic)", 05, false),
      new CheckableSkill("Firearm (Pistol)", 20, false),
      new CheckableSkill("Firearm (Rifle)", 25, false),
      new CheckableSkill("Firearm (Shotgun)", 30, false),
      new CheckableSkill("Firearm (SMG)", 15, false),
      new Skill("Heavy Weapon (various)", 00),
      new Skill("Melee Weapon (various)", 00),
      new Skill("Missile Weapon (various)", 00),
      new CheckableSkill("Throw", 25, false)
   };
   private static final Skill[] artillerySpecializations = {
      new CheckableSkill("Artillery (Cannon)", 0, false),
      new CheckableSkill("Artillery (Rocket Launcher)", 0, false),
      new CheckableSkill("Artillery (Turret)", 0, false),
      new CheckableSkill("Artillery (Vehicular Weapon)", 0, false)
   };
   private static final Skill[] heavyWeaponSpecializations = {
      new CheckableSkill("Heavy Weapon (Bazooka)", 0, false),
      new CheckableSkill("Heavy Weapon (Grenade Launcher)", 0, false),
      new CheckableSkill("Heavy Weapon (Heavy Machine Gun)", 0, false),
      new CheckableSkill("Heavy Weapon (Minigun)", 0, false),
      new CheckableSkill("Heavy Weapon (Rocket Launcher)", 0, false)
   };
   private static final Skill[] meleeWeaponSpecializations = {
      new CheckableSkill("Melee Weapon (Axe)", 00, false),
      new CheckableSkill("Melee Weapon (Club)", 00, false),
      new CheckableSkill("Melee Weapon (Garrote)", 00, false),
      new CheckableSkill("Melee Weapon (Knife)", 00, false),
      new CheckableSkill("Melee Weapon (Spear)", 00, false),
      new CheckableSkill("Melee Weapon (Staff)", 00, false),
      new CheckableSkill("Melee Weapon (Sword)", 00, false),
      new CheckableSkill("Melee Weapon (Whip)", 00, false)
   };
   private static final Skill[] missileWeaponSpecializations = {
      new CheckableSkill("Missile Weapon (Archery)", 00, false),
      new CheckableSkill("Missile Weapon (Blowgun)", 00, false),
      new CheckableSkill("Missile Weapon (Boomerang)", 00, false),
      new CheckableSkill("Missile Weapon (Bow)", 00, false),
      new CheckableSkill("Missile Weapon (Crossbow)", 00, false),
      new CheckableSkill("Missile Weapon (Dart)", 00, false),
      new CheckableSkill("Missile Weapon (Javelin)", 00, false),
      new CheckableSkill("Missile Weapon (Shuriken)", 00, false),
      new CheckableSkill("Missile Weapon (Sling)", 00, false),
      new CheckableSkill("Missile Weapon (Spear)", 00, false),
      new CheckableSkill("Missile Weapon (Throwing Axe)", 00, false),
      new CheckableSkill("Missile Weapon (Throwing Knife)", 00, false)
   };
   private static final String add20 = "Add 20 Skill points to each of the following skills (skill level may not exceed 75):";
   private static final String[] personalityTypes = {
      "Bruiser",
      "Master",
      "Thinker",
      "Leader",
      "Slacker",
      "Nutter"
   };
   private static final String[] personalityDescs = {
      "Bruiser: Your character believes that solving problems is best handled through quick application of physical force.",
      "Master: Your character believes that technique, craft, and expertise are the keys to success.",
      "Thinker: When confronted with opposition, your character's first instinct is to outsmart their opponent to gain as advantage.",
      "Leader: Your character enjoys calling the shots and persuading others to work.",
      "Slacker: Your character has spent their lifetime dodging responsibility and believe that problems are best avoided altogether.",
      "Nutter: Your character can safely be categorized as insane, though they are functional and able to work within the organization of the Laundry. Rational thought and problem-solving methods are neglected: insane leaps of logic are the primary means of attaining goals."
   };
   private static final String[][] personalityBonuses = {
      {"Brawl", "Climb", "Combat (any two)", "Dodge", "Grapple", "Insight", "Jump", "Ride", "Sense", "Stealth", "Swim", "Throw"},
      {"Appraise", "Combat (any)", "Craft", "Disguise", "Dodge", "Fine Manipulation", "First Aid", "Knowledge (any)", "Navigate", "Pilot", "Ride", "Sleight of Hand", "Stealth"},
      {"Appraise", "Bargain", "Combat (any)", "Disguise", "Insight", "Knowledge (any two)", "Listen", "Research", "Sense", "Spot", "Stealth", "Technology Use (any)"},
      {"Appraise", "Bargain", "Combat (any)", "Command", "Etiquette", "Fast Talk", "Insight", "Knowledge (any)", "Language (any)", "Language (Own)", "Perform", "Persuade", "Sense"},
      {"Bargain", "Bureaucracy", "Disguise", "Dodge", "Fast Talk", "Gaming", "Hide", "Insight", "Language (any)", "Persuade", "Sense", "Slight of Hand", "Spot"},
      {"Command", "Fast Talk", "Hide", "Insight", "Knowledge (any two)", "Research", "Science (any two)", "Sense", "Spot", "Stealth", "Strategy."}
   };
   private static final int personalityBonus = 20;
   private static final String improveSkillPrompt = "Please choose one of the following skills to improve.";
   private static final String skillImprovementsFromPersonalityLimitWarning = "(Skill level cannot exceed 75%.)";
   private static final String pickPersonalityTypePrompt = "How does your character approach life and deal with challenges?\n"
           + "Choose one of the following options by entering its number.";
   private static final String genericChoosePrompt = "Please choose from the following options:";
   private static final String[][] assignmentBonuses = {{"Bureaucracy", "Knowledge (any two)", "Navigate", "Research", "Stealth"},
      {"Computer Use (any)", "Computer Use (Magic", "Science (Mathematics", "Science (Thaumaturgy)", "Sorcery"},
      {"Knowledge (Law)", "Knowledge (Occult)", "Persuade", "Research", "Sorcery"},
      {"Bureaucracy", "Insight", "Knowledge (Occult)", "Stealth", "Sorcery"},
      {"Insight", "Knowledge (Espionage)", "Knowledge (Politics)", "Research", "Tech Use (Surveillance)"},
      {"Computer Use (any three)", "Knowledge (Occult)", "Tech Use (any)"},
      {"Computer Use (Hacking)", "Fast Talk", "Knowledge (Occult)", "Knowledge (Politics)", "Research"},
      {"First Aid", "Medicine (any two)", "Research", "Science (Biology)"},
      {"Science (any three)", "Sense", "Spot"},
      {"Firearms (any)", "Knowledge (Occult)", "Science (Thaumaturgy)", "Sorcery", "Stealth"}};

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
      int[] derivedCharacteristics/* = {2}*/;
      DamageBonus db;
      CharacteristicSkill[] characteristicSkills;
      //println("Right now, only PC creation is supported, but you could probably make NPC creation work. Just FYI.");
      println("-----");
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


      ArrayList<Skill> skills = new ArrayList<Skill>(Arrays.asList(baseSkillSet));
      ArrayList<Skill> combatSkills = new ArrayList<Skill>(Arrays.asList(baseCombatSkills));

      //-----print stuff-------//
      println("-----");
      String[] characteristicNames = {"STR", "CON", "POW", "DEX", "CHA", "INT", "SIZ", "EDU", "AGE"};
      println("Transfer these to your character sheet if you have not already done so:");
      for (int i = 0; i < characteristics.length; i++) {
         println(characteristicNames[i] + ": " + characteristics[i]);
      }
      for (int i = 0; i < characteristicSkillNames.length; i++) {
         if (!characteristicSkillNames[i].equals("N/A")) {
            println(characteristicSkills[i].toString());
         }
      }
      println("Language (Own): " + characteristics[7] * 5);
      println("Dodge: " + characteristics[3] * 2);

      String[] derivedCharacteristicNames = {"HP", "Major Wound Level", "XP Bonus", "MOV", "SAN"};
      for (int i = 0; i < derivedCharacteristicNames.length; i++) {
         println(derivedCharacteristicNames[i] + ": " + derivedCharacteristics[i]);
      }
      println("Damage Bonus: " + db);

      acceptedResponses = new char[1];
      acceptedResponses[0] = 'c';
      c = getValidResponseFromUser("(c)ontinue", acceptedResponses);

      println("-----");

      pickPersonalityType(skills, combatSkills);

      //println("(c)ontinue");
      acceptedResponses[0] = 'c';
      c = getValidResponseFromUser("(c)ontinue", acceptedResponses);

      //PROFESSION AND SKILLS
      println("-----");
      println("Choose a profession from the list below and make a note of all the skills used by that profession (additional information on Professions can be found on pp. 22-27 in the rulebook). "
              + "\nYou may distribute a number of Skill Points among professional skills equal to EDU x 20 (" + characteristics[7] * 20 + ", in your case)."
              + "\nNo skill may be raised higher than 75%. (Language (Own) may start higher than 75% due to the character's EDU, but no additional Skill Points may be added to it.)");
/*      println("--\nAntiquarian - Appraise, Art (any), Bargain, Craft (any), Fine Manipulation, Knowledge (any), Knowledge (History), Research, and two of the following as personal specialties: Art (any), Knowledge (any), or Science (any).");
      println("--\nArtist/Designer - Art (any two), Craft (any), Insight, Knowledge (any appropriate), Language (any), Language (Own), Listen, Research, and Spot.");
      println("--\nClerical Worker - Bargain, Bureaucracy, Computer Use (any), Etiquette, Knowledge (Accounting), Knowledge (any), Knowledge (Law), Language (Own), Persuade, and Research.");
      println("--\nComputer Hacker/Tech - Computer Use (any two), Knowledge (any two), Language (a programming language), Repair (Electrical), Repair (Electronics), Research, Science (Mathematics), Tech Use (any), and choose one of the following as specialties: Bureaucracy, Hide, or Knowledge (Law).");
      println("--\nConsultant - Bureaucracy, Computer Use (any), Fast Talk, Insight, Listen, Language (Own), Persuade, Research, and two of the following as personal specialities: Appraise, Bargain, Etiquette, Knowledge (any), Science (any), or Tech Use (any).");
      println("--\nDilettante - Appraise, Etiquette, and any six of the following skills as personal fields of interest: Art (any), Athletics, Craft (any), Drive (any), Gaming, Knowledge (any), Language (any), Perform (any), Research, Science (any), or Tech Use (any).");
      println("--\nDoctor - First Aid, Language (Own), Medicine, Persuade, Research Spot, and choose any four of the following: Insight, Language (any), Psychotherapy, Science (any), or Science (Biology).");
      println("--\nEngineer/Technician - Computer Use (any), Craft (any), Fine Manipulation, Repair (any), Tech Use (any), and five of the following: Art (Drafting), Artillery (any), Demolition, Drive, Heavy Machine, Knowledge (any), Pilot (any), Repair (any), Research, or Science (any).");
      println("--\nJournalist - Fast Talk Insight, Language (Own), Listen, Persuade, Research, Spot, and three of the following: Art (Photography), Computer Use (any), Craft (Photography), Disguise, Hide, Knowledge (any), Language (any), Stealth.");
      println("--\nLaborer - Brawl, Climb, Craft (any), Drive, Grapple, Heavy Machine, and four others, as appropriate to setting: Appraise, Computer Use (any), Fine Manipulation, Language (any), Repair (Mechanical), Repair (Structural), or Tech Use (any).");
      println("--\nLawyer - Bargain, Bureaucracy, Fast Talk, Insight, Knowledge (any), Knowledge (Law), Language (Own), Perform (Oratory), Persuade, and Research.");
      println("--\nLinguist - Etiquette, Insight, Knowledge (any), Language (any), Language (Own), Listen, Persuade, and any three appropriate Knowledge or Language skills as personal specialties.");
      println("--\nMilitary Officer - Artillery (any), Command, Drive (any), Firearm (any), Navigate, Persuade, Strategy, Teach, and any two other skills as a personal specialty.");
      println("--\nOccultist - Fast Talk, Insight, Knowledge (Anthropology), Knowledge (History), Knowledge (Occult), Language (any), Language (Own), Research, and any two of the following: Computer Use (any), Craft (any), Knowledge (Archaeology), Medicine, or Science (any).");
      println("--\nParapsychologist - Fast Talk, Hide, Insight, Knowledge (any), Knowledge (Occult), Listen, Research, Sense, Spot, and Stealth.");
      println("--\nPhilosopher - Insight, Knowledge (History), Knowledge (Philosophy), Language (any), Language (Own), Persuade, Research, Teach, and any two Knowledge or Science skills as specialties.");
      println("--\nPolice Detective/Officer - Brawl, Knowledge (Law), Listen, Persuade, Spot, and choose five of the following: Brawl, Computer Use (any), Disguise, Dodge, Drive, Fast Talk, Firearm (any), Grapple, Hide, Insight, Knowledge (Streetwise), Language (any), or Stealth.");
      println("--\nProfessor/Scholar/Teacher - Insight, Persuade, Research, Teach, and choose sic other skills as areas of expertise: Appraise, Art (any), Computer Use (any), Craft (any), First Aid, Insight, Knowledge (any), Language (any), Language (Own), Listen, Medicine, Psychotherapy, Repair (any), Science (any), or Tech Use (any).");
      println("--\nScientist - Computer Use (any), Craft (any), Persuade, Research, Tech Use (any), and any five Knowledge or Science skill appropriate to the character's field of study.");
      println("--\nSpy - Dodge, Fast Talk, Hide, Listen, Research, Spot, Stealth, and three of the following: Art (Photography), Brawl, Bureaucracy, Computer Use (any), Disguise, Etiquette, Firearm (any), Grapple, Knowledge (any), Language (any), Language (Own), Navigate, Pilot (any), Psychology, Repair (Electronics), Repair (Mechanical), Ride, Swim, Tech Use (any), Throw, or Track.");
      println("--\nStudent - Language (Own), Research, and eight other skills as courses of study. Common choices: Art (any), Athletics, Computer Use (any), Craft (use), First Aid, Insight, Knowledge (any), Language (any), Listen, Medicine, Perform, Persuade, Psychotherapy, Repair (any), Science (any), or Tech Use (any).");
*/
      acceptedResponses = new char[1];
      acceptedResponses[0] = 'c';
      c = getValidResponseFromUser("(c)ontinue", acceptedResponses);

      //Laundry Assignment & Trainng
      println("-----");
      println("Choose an assignment in The Laundry.");
      println("Skill ratings can go above 75% at this point.");
      String[] assignments = {"Archives", "Computational Demonology", "Contracts and Bindings", "Counter-Possession", "Counter-Subversion", "Information Technology", "Media Relations", "Medical and Psychological", "Occult Forensics", "Plumber", "Choose for me"};
      for (int i = 0; i < assignments.length; i++) {
         println(i + 1 + ". " + assignments[i]);
      }
      //println("assignmnets.length: "+assignments.length);
      int indexOfAssignment = getIntFromUser() - 1;
      while (indexOfAssignment < 0 || indexOfAssignment > assignments.length - 1) {
         println("Index out of bounds: " + (indexOfAssignment + 1));
         //println(pickPersonalityTypePrompt);
         indexOfAssignment = getIntFromUser() - 1;
      }

      if (indexOfAssignment > assignments.length - 2) {
         indexOfAssignment = new Dice(1, assignments.length - 1).rollDice() - 1;
      }

      println("Your character has been assigned to " + assignments[indexOfAssignment] + ".");
      println("Add 10 Skill Points to the following Skills:");
      println(Arrays.toString(assignmentBonuses[indexOfAssignment]));

      println("--\nAlso add 5 to the following Skills (thanks to a 6-week training course):");
      String[] trainingCourse = {"Bureaucracy","Computer Use","Fine Manipulation","Firearm (any--usually Pistol or Exoteric)","Knowledge (Accounting)","Knowledge (Espionage)","Knowledge (Low)","Knowledge (Occult)","Knowledge (Politics)","Spot"};
      String s = Arrays.toString(trainingCourse).replaceAll(", ", "\n");
      s = s.substring(1, s.length()-1);
      println(s);
      println("\n--");
      
      println("Please refer to p. 19 in the rulebook for \"Possessions\" and \"Personalizing Your Character\"");
      println("-----");
   }

   private static int[] getCharacteristicScoresFromUser() throws IOException {
      int[] characteristics = new int[characteristics3d6.length - 1 + characteristics2d6Plus6.length - 1 + characteristics3d6Plus3.length - 1 + characteristics2d6Plus17.length - 1];
      int j = 0;
      int[] x = getSetOfRolls(new Dice(3,6).getMin(), new Dice(3,6).getMax(), characteristics3d6);
      for (int i = 0; i < x.length; i++) {
         characteristics[j] = x[i];
         j++;
      }
      x = getSetOfRolls(new Dice(2,6).getMin(6), new Dice(2,6).getMax(6), characteristics2d6Plus6);
      for (int i = 0; i < x.length; i++) {
         characteristics[j] = x[i];
         j++;
      }
      x = getSetOfRolls(new Dice(3,6).getMin(3), new Dice(3,6).getMax(3), characteristics3d6Plus3);
      for (int i = 0; i < x.length; i++) {
         characteristics[j] = x[i];
         j++;
      }
      x = getSetOfRolls(new Dice(2,6).getMin(17), new Dice(2,6).getMax(17), characteristics2d6Plus17);
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
            characteristics[j] = twoD6.rollDice(6);
            j++;
         }
         for (int i = 0; i < characteristics3d6Plus3.length - 1; i++) {
            characteristics[j] = threeD6.rollDice(3);
            j++;
         }
         for (int i = 0; i < characteristics2d6Plus17.length - 1; i++) {
            characteristics[j] = twoD6.rollDice(17);
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
      derivedCharacteristics[3] = 10; //assumes human character; TODO: support for non-human characters?
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

   private static void deriveTrueBaseLangOwnAndDodge(int[] characteristics, ArrayList<Skill> skills, ArrayList<Skill> combatSkills) {
      skills.get(indexOf(skills, "Language (Own: EDUx5%)")).setSkillLevel(characteristics[7] * 5);//TODO: fix this rubbish
      combatSkills.get(indexOf(combatSkills, "Dodge")).setSkillLevel(characteristics[3] * 2);
   }

   private static int indexOf(ArrayList<Skill> skills, String target) {
      if (skills.isEmpty()) {
         return -1;
      }
      int i = 0;
      for (Skill s : skills) {
         if (s.getName().equals(target)) {
            return i;
         } else {
            i++;
         }
      }

      return -1;
   }

   private static void pickPersonalityType(ArrayList<Skill> skills, ArrayList<Skill> combatSkills) throws IOException {
      int indexOfChosenPersonality;

      println(pickPersonalityTypePrompt);
      //print the types and then get input and then figure out how to apply their choices--how do we handle choosing skills?
      printArrayAsOptionList(personalityDescs);
      println(personalityDescs.length + 1 + ". Choose for me.");

      indexOfChosenPersonality = getIntFromUser() - 1;
      while (indexOfChosenPersonality < 0 || indexOfChosenPersonality > personalityDescs.length) {
         println("Index out of bounds: " + (indexOfChosenPersonality + 1));
         println(pickPersonalityTypePrompt);
         indexOfChosenPersonality = getIntFromUser() - 1;
      }

      if (indexOfChosenPersonality > personalityDescs.length - 1) {
         indexOfChosenPersonality = new Dice(1, 5).rollDice() - 1;
      }

      println(personalityTypes[indexOfChosenPersonality]);
      personalityTypeBonuses(indexOfChosenPersonality, combatSkills);
   }

   private static void personalityTypeBonuses(int indexOfChosenPersonality, ArrayList<Skill> combatSkills) throws IOException {
      //int numOfSkillSpecializations;
      String nutterPenalty;
      if (indexOfChosenPersonality == 5) {
         nutterPenalty = " (and subtract 20 from SAN and choose an appropriate mental/emotional disorder)";
      } else {
         nutterPenalty = "";
      }

      println("Add 20 Skill Points to each of the following skills" + nutterPenalty + ":");
      println(Arrays.toString(personalityBonuses[indexOfChosenPersonality]));

      /*for (int i = 0; i < personalityBonuses[indexOfAssignment].length; i++) {
       if (personalityBonuses[indexOfAssignment][i].contains("any")) {
       if (personalityBonuses[indexOfAssignment][i].contains("two")) {
       numOfSkillSpecializations = 2;
       } else {
       numOfSkillSpecializations = 1;
       }
       for (int j = 0; j < numOfSkillSpecializations; j++) {
       println(personalityBonuses[indexOfAssignment][i]);
       //Combat, Knowledge, Language, Science, Tech Use
       if (personalityBonuses[indexOfAssignment][i].toLowerCase().contains("combat")) {
       println("combat " + j);
       //handle combat
       pickCombatSkillOption(combatSkills);
       } else if (personalityBonuses[indexOfAssignment][i].toLowerCase().contains("knowledge")) {
       println("knowledge " + j);
       //handle knowledge
       } else if (personalityBonuses[indexOfAssignment][i].toLowerCase().contains("language")) {
       println("language " + j);
       //handle language
       } else if (personalityBonuses[indexOfAssignment][i].toLowerCase().contains("science")) {
       println("science " + j);
       //handle science
       } else if (personalityBonuses[indexOfAssignment][i].toLowerCase().contains("technology")) {
       println("technology " + j);
       //handle technology
       } else {
       println("Uh-oh. Reached supposedly unreachable point in pickPersonalityType().");
       println("Please write down the following and contact cibikle@gmail.com:");
       println(personalityBonuses[indexOfAssignment][i]);
       }
       }
       }
         
       //TODO
       }*/
   }

   private static void pickCombatSkillOption(ArrayList<Skill> combatSkills) throws IOException {
      println(genericChoosePrompt);
      for (int i = 0; i < baseCombatSkills.length; i++) {
         println(i + 1 + ". " + baseCombatSkills[i].getName());
      }

      int indexOfChosenSkill = getIntFromUser() - 1;
      while (indexOfChosenSkill < 0 || indexOfChosenSkill > baseCombatSkills.length) {
         println("Index out of bounds: " + (indexOfChosenSkill + 1));
         println(genericChoosePrompt);
         indexOfChosenSkill = getIntFromUser() - 1;
      }

      println("\n" + baseCombatSkills[indexOfChosenSkill].getName());

      if (baseCombatSkills[indexOfChosenSkill].getName().toLowerCase().contains("various")) {
         //list, get choice of options
      } else {
      }
   }

   private static void print(String s) {
      System.out.print(s);
   }

   private static void println() {
      System.out.println();
   }

   private static void println(String s) {
      System.out.println(s);
   }

   private static void printArrayAsOptionList(Object[] a) {
      for (int i = 0; i < a.length; i++) {
         println(i + 1 + ". " + a[i]);
      }
   }
}
