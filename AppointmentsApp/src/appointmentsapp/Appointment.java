/**

  Title:           Appointment
  Semester:        COP3804 – Fall 2018
  @author          Panther Id (5964074)
   Instructor:     C. Charters
  
   Due Date:      9/25/2018
Creates an appointment object which is an abstract class, and uses different methods
*  to interact with the appointment.
 */
package appointmentsapp;


public abstract class Appointment {
   //Instance variables of the class
   private String des ;
   private String lName ;
   private int hour ;
   private int min ;
   
/**
 * Prints the data each appointment object has
 * @return The information each appointment holds
 */
    @Override
    public String toString() {
        return des + " with " +
                lName + " at " + hour + ":" + min ;
    }

   /**
    * Constructor of the class
    * @param des
    * @param lName
    * @param hour
    * @param min 
    */
   public Appointment(String des, String lName, int hour, int min)
   {
       this.des = des;
       this.lName = lName;
       this.hour = hour;
       this.min = min;
   }
   /**
    * Gets the description of each appointment 
    * @return  des
    */
    public String getDes() 
    {
        return des;
    }
    
/**
 * Change the description of your appointment
 * @param des 
 */
    public void setDes(String des) 
    {
        this.des = des;
    }

    /**
     * Get the last Name
     * @return lName
     */
    public String getLname() 
    {
        return lName;
    }

    /**
     * Set the last Name
     * @param lName 
     */
    public void setLname(String lName)
    {
        this.lName = lName;
    }
    
    /**
     * Gets the hour
     * @return hour
     */
    public int getHour()
    {
        return hour;
    }
    
    /**
     * Set the hour
     * @param hour 
     */
    public void setHour(int hour)
    {
        this.hour = hour;
    }
/**
 * Get min
 * @return min
 */
    public int getMin() 
    {
        return min;
    }
/**
 * Change the minute
 * @param min 
 */
    public void setMin(int min) 
    {
        this.min = min ;
    }
    
     /**
      * Abstract method to determine if the dates are equal
      * @param year
      * @param month
      * @param day
      * @return 
      */
    public abstract boolean occursOn(int year, int month, int day);
    
}
