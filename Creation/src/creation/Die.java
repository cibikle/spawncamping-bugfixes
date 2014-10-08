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
   private int d;
   private Random r;
   
   public Die(int d) {
      this.d = d;
      r = new Random();
   }
   
   public int roll() {
      return r.nextInt(d) + 1;
   }
}
