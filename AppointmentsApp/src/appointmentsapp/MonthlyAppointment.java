/**

  Title:           MonthlyAppointment
  Semester:        COP3804 – Fall 2018
  @author          Panther Id (5964074)
   Instructor:     C. Charters
  
   Due Date:      9/25/2018
Creates a MonthlyAppointment object which is a sub class (that 
* extends appointment) , and uses different methods
*  to interact with the appointment.
 */
package appointmentsapp;


public class MonthlyAppointment extends Appointment 
{
    //Instance Variables of the class
    int day;
    int month;
    int year;
   
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
    public MonthlyAppointment(String des, String lName, int hour, int min, int day, int month, int year)
     {
         super(des,lName,hour,min);
         this.day = day;
         this.month = month;
         this.year = year;
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
     * Change the day each appointment object has
     * @param day 
     */
    public void setDay(int day) 
    {
        this.day = day;
    }
    
/**
 * Get the month
 * @return month
 */
    public int getMonth() 
    {
        return month;
    }
    
/**
 * Change the month each appointment object has
 * @param month 
 */
    public void setMonth(int month) 
    {
        this.month = month;
    }

    /**
     * Get the year
     * @return year
     */
    public int getYear() 
    {
        return year;
    }

    /**
     * Change the year each appointment object has
     * @param year 
     */
    public void setYear(int year) 
    {
        this.year = year;
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

