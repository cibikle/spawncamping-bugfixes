/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creation;

/**
 *
 * @author cibikle
 */
public class Skill {
   private String name;
   private int skillLevel;
   private boolean checked;
   
   public Skill(String name, int skillLevel, boolean checked) {
      this.name = name;
      this.skillLevel = skillLevel;
      this.checked = checked;
   }
   
   public String getName(){
      return name;
   }
   
   public int getSkillLevel() {
      return skillLevel;
   }
   
   public boolean getChecked() {
      return checked;
   }
   
   public void setChecked() {
      checked = true;
   }
   
   public void clearChecked() {
      checked = false;
   }
   
   public void setSkillLevel(int skillLevel) {
      this.skillLevel = skillLevel;
   }
   
   public void updateSkillLevelByValue(int addend) {
      skillLevel += (addend);
   }
   
   public String toString() {
      return name+": "+skillLevel;
   }
   
/*   public int resolveCheck(int addend) {
      updateSkillLevelByValue(addend);
      clearChecked();
      return skillLevel;
   }
   
   public int autoResolveCheck(int xpBonus) {
      Dice percentageDice = new Dice(true);
      int result = percentageDice.rollDice();
      if(result + xpBonus > skillLevel) {
         Dice improvementDie = new Dice(1, 6);
         result = improvementDie.rollDice();
         updateSkillLevelByValue(result);
      }
      clearChecked();
      return skillLevel;
   }*/
 }
