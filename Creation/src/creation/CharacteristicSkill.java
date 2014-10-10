/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creation;

/**
 *
 * @author cibikle
 */
public class CharacteristicSkill {

   private String name;
   private int skillLevel;

   public CharacteristicSkill(String name,int skillLevel) {
      this.name = name;
      this.skillLevel = skillLevel;
   }

   /**
    * @return the name
    */
   public String getName() {
      return name;
   }

   /**
    * @return the skillLevel
    */
   public int getSkillLevel() {
      return skillLevel;
   }

   /**
    * @param name the name to set
    */
   public void setName(String name) {
      this.name = name;
   }

   /**
    * @param skillLevel the skillLevel to set
    */
   public void setSkillLevel(int skillLevel) {
      this.skillLevel = skillLevel;
   }
   
   public String toString() {
      return name+": "+skillLevel;
   }
}
