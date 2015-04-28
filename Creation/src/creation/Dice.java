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

    private final ArrayList<Die> dice;
    private String name;
    private boolean percentageDice = false;

    public Dice(int numOfDice, int sizeOfDie) {
        this.dice = new ArrayList<Die>();
        name = numOfDice + "d" + sizeOfDie;
        for (int i = 0; i < numOfDice; i++) {
            dice.add(new Die(sizeOfDie));
        }
    }

    public Dice(int[] numOfDice, int[] sizeOfDie) throws Exception {
        this.dice = new ArrayList<Die>();
        if (numOfDice.length != sizeOfDie.length) {
            throw new Exception("Number of number of dice did not match number of number of dice sizes: " + numOfDice.length + ", " + sizeOfDie.length + ".");
        }

        for (int i = 0; i < numOfDice.length; i++) {
            if (i > 0) {
                name += " + ";
            }
            name += numOfDice[i] + "d" + sizeOfDie[i];
            for (int j = 0; j < numOfDice[i]; j++) {
                dice.add(new Die(sizeOfDie[i]));
            }
        }
    }

    public Dice(boolean percentageDice) {
        this.dice = new ArrayList<Die>();
        this.percentageDice = true;
        name = "percentage dice";
        dice.add(new Die(10));
    }

    public int rollDice() {
        int roll = 0;

        if (percentageDice) {
            roll = dice.get(0).roll() * 10;
            roll += dice.get(0).roll();
            return roll;
        } else {
            for (Die d : dice) {
                roll += d.roll();
            }
            return roll;
        }
    }

    public int rollDice(int addend) {
        int roll = 0;

        if (percentageDice) {
            roll = dice.get(0).roll() * 10;
            roll += dice.get(0).roll();
            return roll;
        } else {
            for (Die d : dice) {
                roll += d.roll();
            }
            return roll + addend;
        }
    }

    public int getMin() {
        return dice.size();
    }

    public int getMin(int addend) {
        return dice.size() + addend;
    }

    public int getMax() {
        int max = 0;
        for (Die d : dice) {
            max += d.getMax();
        }
        return max;
    }

    public int getMax(int addend) {
        int max = 0;
        for (Die d : dice) {
            max += d.getMax();
        }
        return max + addend;
    }

    public double getAvg() {
        double avg = 0;
        for (Die d : dice) {
            avg += d.getAvg();
        }
        return avg;
    }

    public double getAvg(int addend) {
        double avg = 0;
        for (Die d : dice) {
            avg += d.getAvg();
        }
        return avg + addend;
    }

    @Override
    public String toString() {
        return name;
    }

    public String toString(int addend) {
        return name + addend;
    }
}
