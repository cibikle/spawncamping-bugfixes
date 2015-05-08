/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cibikle
 */
public class RPG_Character implements Serializable {

   private int STR;
   private int CON;
   private int POW;
   private int DEX;
   private int CHA;
   private int INT;
   private int SIZ;
   private int EDU;
   private int AGE;
   private String name;
   private String playerName;
   private DamageBonus db;
   private int maxHP;
   private int majorWoundLevel;
   private int currentHP;
   private int xpBonus;
   private int MOV;
   private int maxSAN;
   private int initialSAN;
   private int madnessThreshold;
   private int currentSAN;
   private String personalityType;
   private CharacteristicSkill[] characteristicSkills = new CharacteristicSkill[8];
   private ArrayList<String> possessions = new ArrayList<String>();
   private ArrayList<Skill> skills = new ArrayList<Skill>();
   private ArrayList<Skill> combatSkills = new ArrayList<Skill>();

   public RPG_Character() {
   }

   public RPG_Character(int STR, int CON, int POW, int DEX, int CHA, int INT,
           int SIZ, int EDU, int AGE, String name, DamageBonus DB,
           int maxHP, int majorWoundLevel, int xpBonus, int MOV, int maxSAN,
           CharacteristicSkill[] characteristicSkills,
           ArrayList<String> possessions, ArrayList<Skill> skills,
           ArrayList<Skill> combatSkills) {
      this.STR = STR;
      this.CON = CON;
      this.POW = POW;
      this.DEX = DEX;
      this.CHA = CHA;
      this.INT = INT;
      this.SIZ = SIZ;
      this.EDU = EDU;
      this.AGE = AGE;
      this.name = name;
      this.db = DB;
      this.maxHP = maxHP;
      this.majorWoundLevel = majorWoundLevel;
      this.xpBonus = xpBonus;
      this.MOV = MOV;
      this.maxSAN = maxSAN;
      this.characteristicSkills = characteristicSkills;
      this.possessions = possessions;
      this.skills = skills;
      this.combatSkills = combatSkills;
   }

   public RPG_Character(int[] characteristsics, String name, DamageBonus DB,
           int[] derivedCharacteristics,
           CharacteristicSkill[] characteristicSkills,
           ArrayList<String> possessions, ArrayList<Skill> skills,
           ArrayList<Skill> combatSkills) {
      this.STR = characteristsics[0];
      this.CON = characteristsics[1];
      this.POW = characteristsics[2];
      this.DEX = characteristsics[3];
      this.CHA = characteristsics[4];
      this.INT = characteristsics[5];
      this.SIZ = characteristsics[6];
      this.EDU = characteristsics[7];
      this.AGE = characteristsics[8];
      this.name = name;
      this.db = DB;
      this.maxHP = derivedCharacteristics[0];
      this.majorWoundLevel = derivedCharacteristics[1];
      this.xpBonus = derivedCharacteristics[2];
      this.MOV = derivedCharacteristics[3];
      this.maxSAN = derivedCharacteristics[4];
      this.characteristicSkills = characteristicSkills;
      this.possessions = possessions;
      this.skills = skills;
      this.combatSkills = combatSkills;
   }

   public RPG_Character loadFromFile(String fileName) {
      FileInputStream in = null;
      try {
         in = new FileInputStream(fileName);
         ObjectInputStream reader = new ObjectInputStream(in);
         return (RPG_Character) reader.readObject();
      } catch (FileNotFoundException ex) {
         Logger.getLogger(RPG_Character.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
         Logger.getLogger(RPG_Character.class.getName()).log(Level.SEVERE, null, ex);
      } catch (ClassNotFoundException ex) {
         Logger.getLogger(RPG_Character.class.getName()).log(Level.SEVERE, null, ex);
      } finally {
         try {
            in.close();
         } catch (IOException ex) {
            Logger.getLogger(RPG_Character.class.getName()).log(Level.SEVERE, null, ex);
         }
      }
      return null;
   }

   public void saveToFile(String fileName) {
      ObjectOutputStream out = null;
      try {
         out = new ObjectOutputStream(new FileOutputStream(fileName));
         out.writeObject(this);
         out.close();
      } catch (FileNotFoundException ex) {
         Logger.getLogger(RPG_Character.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
         Logger.getLogger(RPG_Character.class.getName()).log(Level.SEVERE, null, ex);
      } finally {
         try {
            out.close();
         } catch (IOException ex) {
            Logger.getLogger(RPG_Character.class.getName()).log(Level.SEVERE, null, ex);
         }
      }
   }

   /**
    * @return the STR
    */
   public int getSTR() {
      return STR;
   }

   /**
    * @return the CON
    */
   public int getCON() {
      return CON;
   }

   /**
    * @return the POW
    */
   public int getPOW() {
      return POW;
   }

   /**
    * @return the DEX
    */
   public int getDEX() {
      return DEX;
   }

   /**
    * @return the CHA
    */
   public int getCHA() {
      return CHA;
   }

   /**
    * @return the INT
    */
   public int getINT() {
      return INT;
   }

   /**
    * @return the SIZ
    */
   public int getSIZ() {
      return SIZ;
   }

   /**
    * @return the EDU
    */
   public int getEDU() {
      return EDU;
   }

   /**
    * @return the AGE
    */
   public int getAGE() {
      return AGE;
   }

   /**
    * @return the name
    */
   public String getName() {
      return name;
   }

   /**
    * @return the maxHP
    */
   public int getMaxHP() {
      return maxHP;
   }

   /**
    * @return the majorWoundLevel
    */
   public int getMajorWoundLevel() {
      return majorWoundLevel;
   }

   /**
    * @return the xpBonus
    */
   public int getXpBonus() {
      return xpBonus;
   }

   /**
    * @return the MOV
    */
   public int getMOV() {
      return MOV;
   }

   /**
    * @return the maxSAN
    */
   public int getSAN() {
      return maxSAN;
   }

   /**
    * @return the characteristicSkills
    */
   public CharacteristicSkill[] getCharacteristicSkills() {
      return characteristicSkills;
   }

   /**
    * @return the possessions
    */
   public ArrayList<String> getPossessions() {
      return possessions;
   }

   /**
    * @return the skills
    */
   public ArrayList<Skill> getSkills() {
      return skills;
   }
   
   public Skill getSkill(String skillName) {
      for (Skill s : skills) {
         if (s.getName().equals(skillName)) {
            return s;
         }
      }
      return null;
   }
   
   public Skill getCombatSkill(String skillName) {
      for (Skill s : combatSkills) {
         if (s.getName().equals(skillName)) {
            return s;
         }
      }
      return null;
   }

   /**
    * @return the db
    */
   public DamageBonus getDb() {
      return db;
   }

   public int[] getCharacteristics() {
      int[] characteristics = {STR, CON, POW, DEX, CHA, INT, SIZ, EDU, AGE};
      return characteristics;
   }

   public int[] getDerivedCharacteristics() {
      int[] derivedCharacteristics = {maxHP, majorWoundLevel, xpBonus, MOV, maxSAN};
      return derivedCharacteristics;
   }

   /**
    * @param STR the STR to set
    */
   public void setSTR(int STR) {
      this.STR = STR;
   }

   /**
    * @param CON the CON to set
    */
   public void setCON(int CON) {
      this.CON = CON;
   }

   /**
    * @param POW the POW to set
    */
   public void setPOW(int POW) {
      this.POW = POW;
   }

   /**
    * @param DEX the DEX to set
    */
   public void setDEX(int DEX) {
      this.DEX = DEX;
   }

   /**
    * @param CHA the CHA to set
    */
   public void setCHA(int CHA) {
      this.CHA = CHA;
   }

   /**
    * @param INT the INT to set
    */
   public void setINT(int INT) {
      this.INT = INT;
   }

   /**
    * @param SIZ the SIZ to set
    */
   public void setSIZ(int SIZ) {
      this.SIZ = SIZ;
   }

   /**
    * @param EDU the EDU to set
    */
   public void setEDU(int EDU) {
      this.EDU = EDU;
   }

   /**
    * @param AGE the AGE to set
    */
   public void setAGE(int AGE) {
      this.AGE = AGE;
   }

   /**
    * @param name the name to set
    */
   public void setName(String name) {
      this.name = name;
   }

   /**
    * @param maxHP the maxHP to set
    */
   public void setMaxHP(int maxHP) {
      this.maxHP = maxHP;
   }

   /**
    * @param majorWoundLevel the majorWoundLevel to set
    */
   public void setMajorWoundLevel(int majorWoundLevel) {
      this.majorWoundLevel = majorWoundLevel;
   }

   /**
    * @param xpBonus the xpBonus to set
    */
   public void setXpBonus(int xpBonus) {
      this.xpBonus = xpBonus;
   }

   /**
    * @param MOV the MOV to set
    */
   public void setMOV(int MOV) {
      this.MOV = MOV;
   }

   /**
    * @param SAN the maxSAN to set
    */
   public void setSAN(int SAN) {
      this.maxSAN = SAN;
   }

   /**
    * @param characteristicSkills the characteristicSkills to set
    */
   public void setCharacteristicSkills(CharacteristicSkill[] characteristicSkills) {
      this.characteristicSkills = characteristicSkills;
   }

   /**
    * @param possessions the possessions to set
    */
   public void setPossessions(ArrayList<String> possessions) {
      this.possessions = possessions;
   }

   /**
    * @param skills the skills to set
    */
   public void setSkills(ArrayList<Skill> skills) {
      this.skills = skills;
   }

   /**
    * @param db the db to set
    */
   public void setDb(DamageBonus db) {
      this.db = db;
   }

   public void setCharacteristics(int[] characteristics) {
      STR = characteristics[0];
      CON = characteristics[1];
      POW = characteristics[2];
      DEX = characteristics[3];
      CHA = characteristics[4];
      INT = characteristics[5];
      SIZ = characteristics[6];
      EDU = characteristics[7];
      AGE = characteristics[8];
   }

   public void setDerivedCharacteristics(int[] derivedCharacteristics) {
      maxHP = derivedCharacteristics[0];
      majorWoundLevel = derivedCharacteristics[1];
      xpBonus = derivedCharacteristics[2];
      MOV = derivedCharacteristics[3];
      maxSAN = derivedCharacteristics[4];
   }

   /**
    * @return the combatSkills
    */
   public ArrayList<Skill> getCombatSkills() {
      return combatSkills;
   }

   /**
    * @param combatSkills the combatSkills to set
    */
   public void setCombatSkills(ArrayList<Skill> combatSkills) {
      this.combatSkills = combatSkills;
   }

   /**
    * @return the playerName
    */
   public String getPlayerName() {
      return playerName;
   }

   /**
    * @param playerName the playerName to set
    */
   public void setPlayerName(String playerName) {
      this.playerName = playerName;
   }

   /**
    * @return the currentHP
    */
   public int getCurrentHP() {
      return currentHP;
   }

   /**
    * @param currentHP the currentHP to set
    */
   public void setCurrentHP(int currentHP) {
      this.currentHP = currentHP;
   }

   /**
    * @return the initialSAN
    */
   public int getInitialSAN() {
      return initialSAN;
   }

   /**
    * @param initialSAN the initialSAN to set
    */
   public void setInitialSAN(int initialSAN) {
      this.initialSAN = initialSAN;
   }

   /**
    * @return the madnessThreshold
    */
   public int getMadnessThreshold() {
      return madnessThreshold;
   }

   /**
    * @param madnessThreshold the madnessThreshold to set
    */
   public void setMadnessThreshold(int madnessThreshold) {
      this.madnessThreshold = madnessThreshold;
   }

   /**
    * @return the currentSAN
    */
   public int getCurrentSAN() {
      return currentSAN;
   }

   /**
    * @param currentSAN the currentSAN to set
    */
   public void setCurrentSAN(int currentSAN) {
      this.currentSAN = currentSAN;
   }

   /**
    * @return the personalityType
    */
   public String getPersonalityType() {
      return personalityType;
   }

   /**
    * @param personalityType the personalityType to set
    */
   public void setPersonalityType(String personalityType) {
      this.personalityType = personalityType;
   }
   
   @Override
   public String toString() {
       String character = "";
       character += "STR: "+STR+" - "+characteristicSkills[0]+"\n";
       character += "CON: "+CON+" - "+characteristicSkills[1]+"\n";
       character += "POW: "+POW+" - "+characteristicSkills[2]+"\n";
       character += "DEX: "+DEX+" - "+characteristicSkills[3]+"\n";
       character += "CHA: "+CHA+" - "+characteristicSkills[4]+"\n";
       character += "INT: "+INT+" - "+characteristicSkills[5]+"\n";
       character += "SIZ: "+SIZ+" - "+db+"\n";
       character += "EDU: "+EDU+" - "+characteristicSkills[7]+"\n";
       //etc
       for(Skill s : combatSkills) {
           character += s.toString()+"\n";
       }
       return character;
   }
}