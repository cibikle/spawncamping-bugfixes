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
   protected String name;
   protected int skillLevel;
   
   public Skill(String name, int skillLevel) {
      this.name = name;
      this.skillLevel = skillLevel;
   }
   
   public String getName(){
      return name;
   }
   
   public int getSkillLevel() {
      return skillLevel;
   }
   
   public void setSkillLevel(int skillLevel) {
      this.skillLevel = skillLevel;
   }
   
   public void updateSkillLevelByValue(int addend) {
      skillLevel += (addend);
   }
   
   @Override
   public String toString() {
      return name+": "+skillLevel;
   }
}
