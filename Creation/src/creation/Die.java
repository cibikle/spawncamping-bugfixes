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

    public int getMin(int addend) {
        return 1 + addend;
    }

    public int getMax() {
        return sizeOfDie;
    }

    public int getMax(int addend) {
        return sizeOfDie + addend;
    }

    public double getAvg() {
        return (sizeOfDie + 1) / 2;
    }

    public double getAvg(int addend) {
        return ((sizeOfDie + 1) / 2) + addend;
    }

    public int roll() {
        return r.nextInt(sizeOfDie) + 1;
    }

    public int roll(int addend) {
        return r.nextInt(sizeOfDie) + 1 + addend;
    }
}
