/**

  Title:           Appointment
  Semester:        COP3804 – Fall 2018
  @author          Panther Id (5964074)
   Instructor:     C. Charters
  
   Due Date:      9/25/2018
Use The abstract class appointment and it subclasses by putting each appointment in an array
 */
package appointmentsapp;

import java.util.Arrays;
import javax.swing.JOptionPane;


public class AppointmentsApp {
    public Appointment[] myApp; //Appointment Array
    final int LENGTH = 2 ; //Holds the length of the array
    int currentSize = 0 ; //Current size of the array
  
public AppointmentsApp()
    {
        myApp = new Appointment[LENGTH] ; // intaizlizing the array
    }
  /**
   * makes an appointment object and adds it to the list of arrays.
   * @param r 
   */
public void makeAppointment(Appointment r)
{
    if(currentSize < myApp.length) //If the current size is less than length.
        {
            myApp[currentSize] = r ; //Add the appointment to the list.   
            currentSize++ ; //Increment current size.
        }
        else //Else currentSize is greater than the length
        {
             Appointment [] myTemp = new Appointment[myApp.length * 2]; //Create a new array double the original length.
            for(int i = 0; i < myApp.length; i++) //Traverse the array.
            myTemp[i] = myApp[i]; //copy each element to the new array.
            myApp = myTemp; //Set a pointer to the old array to the new.
             myApp[currentSize] = r;//Add the appointment to the list.  
             currentSize++ ; //Increment currentsize.
        }
    }

/**
 * Ask the user for a specific date, and then traverse the array to find an appointment with that date.
 */
public void checkAppointment()
{
      String input = JOptionPane.showInputDialog("Enter the month");
         int month = Integer.parseInt(input);
         input = JOptionPane.showInputDialog("Enter the day");
         int day = Integer.parseInt(input);
         input = JOptionPane.showInputDialog("Enter the year");
         int year = Integer.parseInt(input);
      

         for (int i = 0; i < currentSize; i++)
         {
             if(myApp[i].occursOn(year, month, day))
             {
                 System.out.println( myApp[i]);
                 
             }
         }           
}
   
    public static void main(String[] args) 
    {
        AppointmentsApp z = new AppointmentsApp();
        String input = JOptionPane.showInputDialog("How many appointments do you wish to make");
        int keepGoing = Integer.parseInt(input);
        int counter = 0;
        
        while(keepGoing != counter)
        {
            JOptionPane.showMessageDialog(null, "Please make a selection!");
            input = JOptionPane.showInputDialog("Press 1 for One Time Appointment."
                    + " Press 2 for Daily Appointment."
                    + " Press 3 for Monthly Appointment.");
   int answer = Integer.parseInt(input);
    if(answer == 1)
        {
    String des = JOptionPane.showInputDialog("What is the description of your Appointment?") ; 
    String lName = JOptionPane.showInputDialog("What is your last name");
    input = JOptionPane.showInputDialog("What month is your appointment?") ; 
    int month = Integer.parseInt(input);
    input = JOptionPane.showInputDialog("What year is your appointment?") ; 
    int year = Integer.parseInt(input);
    input = JOptionPane.showInputDialog("What day is your appointment?") ; 
    int day = Integer.parseInt(input);
    input = JOptionPane.showInputDialog("What hour is your appointment?") ;
    int hour = Integer.parseInt(input);
    input = JOptionPane.showInputDialog("What minute is your appointment?") ; 
    int min = Integer.parseInt(input);
    Appointment oneTimeAppointment = new OneTimeAppointment(des,lName,hour,min,day,year,month);
    z.makeAppointment(oneTimeAppointment);
    JOptionPane.showMessageDialog(null, "Your appointment has been added!");
          }
    else if (answer == 2)
    {
        String des = JOptionPane.showInputDialog("What is the description of your Appointment?") ; 
        String lName = JOptionPane.showInputDialog("What is your last name");
        input = JOptionPane.showInputDialog("What day is your appointment?") ;
        int day = Integer.parseInt(input);
        input = JOptionPane.showInputDialog("What hour is your appointment?") ;
        int hour = Integer.parseInt(input);
        input = JOptionPane.showInputDialog("What minute is your appointment?") ;
        int min = Integer.parseInt(input);
        Appointment dailyAppointment = new DailyAppointment(des,lName,hour,min,day);
        z.makeAppointment(dailyAppointment);
        JOptionPane.showMessageDialog(null, "Your appointment has been added!");
    }
    else if (answer == 3)
    {
    String des = JOptionPane.showInputDialog("What is the description of your Appointment?") ; 
    String lName = JOptionPane.showInputDialog("What is your last name");
    input = JOptionPane.showInputDialog("What month is your appointment?") ; 
    int month = Integer.parseInt(input);
    input = JOptionPane.showInputDialog("What year is your appointment?") ;
    int year = Integer.parseInt(input);
    input = JOptionPane.showInputDialog("What day is your appointment?") ; 
    int day = Integer.parseInt(input);
    input = JOptionPane.showInputDialog("What hour is your appointment?") ; 
    int hour = Integer.parseInt(input);
    input = JOptionPane.showInputDialog("What minute is your appointment?") ; 
    int min = Integer.parseInt(input); 
    Appointment monthlyAppointment = new MonthlyAppointment(des,lName,hour,min,day,year,month);
    z.makeAppointment(monthlyAppointment);
    JOptionPane.showMessageDialog(null, "Your appointment has been added!");
    
    }
          counter++;
        }

        do
        {
         JOptionPane.showMessageDialog(null, "Please enter the date you wish to look up.");
         
       
             z.checkAppointment();
             input = JOptionPane.showInputDialog("Do you wish to look up another appointment? \nEnter yes or no.");
             if(input.equals("yes"))
             {
                  z.checkAppointment();
                  
             }
             else if (input.equals("no"))
             {
                 
                 System.out.println("Thank  you for using your appointment calendar.");
             }
         
         
        }
        while(!input.equals("no"));
    }
    
}
