/**

  Title:           DailyAppointment
  Semester:        COP3804 – Fall 2018
  @author          Panther Id (5964074)
   Instructor:     C. Charters
  
   Due Date:      9/25/2018
Creates a DailyAppointment object which is a sub class (that 
* extends appointment) , and uses different methods
*  to interact with the appointment.
 */
package appointmentsapp;


public class DailyAppointment extends Appointment 
{
    //Instance Variables of the class
     int day;
     
   /**
    * Constructor of the Class
    * @param des
    * @param lName
    * @param hour
    * @param min
    * @param day 
    */
    public DailyAppointment(String des, String lName, int hour, int min, int day)
     {
         super(des,lName,hour,min);
         this.day = day;
     }
/**
 * Get the day
 * @return day
 */
    public int getDay() 
    {
        return day;
    }

    /**
     * Set the day
     * @param day 
     */
    public void setDay(int day) 
    {
        this.day = day;
    }
 
/**
 * Prints the data each appointment object has
 * @return The information each appointment holds
 */
    @Override
    public String toString()
    {
       return "On:" + day + "\nYou have " + super.toString();
    }
     
    /**
     * Check if the day the user enters and
     * the day the appointment object has are equal if they are return true
     * @param year
     * @param month
     * @param day
     * @return rightDay
     */
    public boolean occursOn(int year, int month, int day)
    {
        boolean rightDay = true;
        if( day == day)
        {
            return rightDay;
        }  
        else
                {
                    rightDay = false;
                }
        return rightDay;
    }
    
}
