/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creation;

import java.util.Random;

/**
 *
 * @author cibikle
 */
public class Die {
   private final int sizeOfDie;
   private final Random r;
   
   public Die(int sizeOfDie) {
      this.sizeOfDie = sizeOfDie;
      r = new Random();
   }
   
   public int getSizeOfDie() {
       return sizeOfDie;
   }
   
    public int getMin() {
        return 1;
    }

    public int getMax() {
        return sizeOfDie;
    }

    public double getAvg() {
        return (sizeOfDie + 1) / 2;
    }
   
   public int roll() {
      return r.nextInt(sizeOfDie) + 1;
   }
}
