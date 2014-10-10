/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creation;

/**
 *
 * @author cibikle
 */
public class DamageBonus {
   private Dice db;
   private boolean negativeDB;
   
   public DamageBonus(Dice db, boolean negativeDB) {
      this.db = db;
      this.negativeDB = negativeDB;
   }

   /**
    * @return the db
    */
   public Dice getDb() {
      return db;
   }

   /**
    * @return the negativeDB
    */
   public boolean isNegativeDB() {
      return negativeDB;
   }

   /**
    * @param db the db to set
    */
   public void setDb(Dice db) {
      this.db = db;
   }

   /**
    * @param negativeDB the negativeDB to set
    */
   public void setNegativeDB(boolean negativeDB) {
      this.negativeDB = negativeDB;
   }
   
   public String toString() {
      String s = db.toString();
      if(negativeDB) {
         s = "-" + s;
      }
      
      return s;
   }
}
