/**

  Title:           OneTimeAppointment
  Semester:        COP3804 – Fall 2018
  @author          Panther Id (5964074)
   Instructor:     C. Charters
  
   Due Date:      9/25/2018
Creates an OTAAppointment object which is a sub class (that 
* extends monthlyappointment) , and uses different methods
*  to interact with the appointment.
 */
package appointmentsapp;


public class OneTimeAppointment extends MonthlyAppointment 
{
    /**
     * Class constructor
     * @param des
     * @param lName
     * @param hour
     * @param min
     * @param day
     * @param month
     * @param year 
     */
    public OneTimeAppointment(String des, String lName, int hour, int min, int day, int month, int year)
    {
        super(des, lName, hour, min, day, month, year);
    }
     /**
 * Prints the data each appointment object has
 * @return The information each appointment holds
 */  
    @Override
    public String toString()
    {
         return "On:" + month + "/" + day + "/" + year
                 + "\nYou have " + super.toString();
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
        if(year == year && month == month && day == day)
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
