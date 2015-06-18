package creation;

import java.io.Serializable;

/**
 *
 * @author Christian Bikle
 */
public class Traveller_Character implements Serializable {
    private String name;
    private String playerName;
    private int[] characteristics;
    private int[] characteristicsDMs;
    private String homeworldName;
    private String[] homeworldCharacteristics;
    private Skill[] skills;
    private int age;
    
    public Traveller_Character() {
        
    }
    
    public Traveller_Character(int[] characteristics) {
        this.characteristics = characteristics;
        this.characteristicsDMs = calcCharacteristicDMs(this.characteristics);
    }
    
    public Traveller_Character(int[] characteristics, Skill[] skills) {
        this.characteristics = characteristics;
        this.characteristicsDMs = calcCharacteristicDMs(this.characteristics);
        this.skills = skills;
    }

    public static int[] calcCharacteristicDMs(int[] characteristics) {
        int[] dms = new int[characteristics.length];
        for (int i = 0; i < characteristics.length; i++) {
            if (characteristics[i] >= 6 && characteristics[i] <= 8) {
                dms[i] = 0;
            } else if (characteristics[i] >= 3 && characteristics[i] <= 5) {
                dms[i] = -1;
            } else if (characteristics[i] >= 9 && characteristics[i] <= 11) {
                dms[i] = 1;
            } else if (characteristics[i] >= 1 && characteristics[i] <= 2) {
                dms[i] = -2;
            } else if (characteristics[i] >= 12 && characteristics[i] <= 14) {
                dms[i] = 2;
            } else if (characteristics[i] == 0) {
                dms[i] = -3;
            } else if (characteristics[i] == 15) {
                dms[i] = 3;
            } else {
                System.err.println("Error in rollForCharacteristics(): "
                        + characteristics[i] + " is not a valid value.");
                dms[i] = 0;
            }
        }
        return dms;
    }
}
