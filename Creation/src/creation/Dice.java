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
public class Dice {
   private ArrayList<Die> dice = new ArrayList<Die>();
   private boolean percentageDice = false;
   
   public Dice(int n, int d) {
      for(int i = 0; i < n; i++) {
         dice.add(new Die(d));
      }
   }
   
   public Dice(int[] n, int[] d) throws Exception {
      if(n.length != d.length) {
         throw new Exception("Number of number of dice did not match number of number of dice sizes: "+n+", "+d+".");
      }
      
      for(int i = 0; i < n.length; i++) {
         for(int j = 0; j < n[i]; j++) {
            dice.add(new Die(d[i]));
         }
      }
   }
   
   public Dice(boolean percentageDice) {
      this.percentageDice = true;
      
      dice.add(new Die(10));
   }
   
   public int rollDice() {
      int roll = 0;
      
      if(percentageDice) {
         roll = dice.get(0).roll() * 10;
         roll += dice.get(0).roll();
         return roll;
      } else {
         for(Die d : dice) {
            roll += d.roll();
         }
         return roll;
      }
   }
}