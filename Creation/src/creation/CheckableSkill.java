/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creation;

/**
 *
 * @author cibikle
 */
public class CheckableSkill extends Skill {
   private boolean checked;
   
   public CheckableSkill(String name, int skillLevel, boolean checked) {
      super(name, skillLevel);
      this.checked = checked;
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
