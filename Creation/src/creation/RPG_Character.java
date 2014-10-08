/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creation;

import java.util.ArrayList;

/**
 *
 * @author cibikle
 */
public class RPG_Character {
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
   private Dice DB;
   private boolean negativeDB;
   private int maxHP;
   private int majorWoundLevel;
   private int xpBonus;
   private int MOV;
   private int SAN;
   private ArrayList<CharacteristicSkill> characteristicSkills = new ArrayList<CharacteristicSkill>();
   private ArrayList<String> possessions = new ArrayList<String>();
   private ArrayList<Skill> skills = new ArrayList<Skill>();

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
    * @return the DB
    */
   public Dice getDB() {
      return DB;
   }

   /**
    * @return the negativeDB
    */
   public boolean isNegativeDB() {
      return negativeDB;
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
    * @return the SAN
    */
   public int getSAN() {
      return SAN;
   }
   
   /**
    * @return the characteristicSkills
    */
   public ArrayList<CharacteristicSkill> getCharacteristicSkills() {
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
    * @param DB the DB to set
    */
   public void setDB(Dice DB) {
      this.DB = DB;
   }

   /**
    * @param negativeDB the negativeDB to set
    */
   public void setNegativeDB(boolean negativeDB) {
      this.negativeDB = negativeDB;
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
    * @param SAN the SAN to set
    */
   public void setSAN(int SAN) {
      this.SAN = SAN;
   }
   
   /**
    * @param characteristicSkills the characteristicSkills to set
    */
   public void setCharacteristicSkills(ArrayList<CharacteristicSkill> characteristicSkills) {
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
   
   public RPG_Character() {
      
   }
   
   public RPG_Character(int STR, int CON, int POW, int DEX, int CHA, int INT, 
           int SIZ, int EDU, int AGE, String name, Dice DB, boolean negativeDB, 
           int maxHP, int majorWoundLevel, int xpBonus, int MOV, int SAN, 
           ArrayList<String> possessions, ArrayList<Skill> skills) {
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
      this.DB = DB;
      this.negativeDB = negativeDB;
      this.maxHP = maxHP;
      this.majorWoundLevel = majorWoundLevel;
      this.xpBonus = xpBonus;
      this.MOV = MOV;
      this.SAN = SAN;
      this.possessions = possessions;
      this.skills = skills;
   }
}
