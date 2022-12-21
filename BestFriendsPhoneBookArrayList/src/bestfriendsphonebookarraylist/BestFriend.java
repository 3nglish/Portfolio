/**

  Title:           BFFHelperArrayList
  Semester:        COP3804 – Fall 2018
  @author          Panther Id (5964074)
   Instructor:     C. Charters
  
   Due Date:      9/2/2018
Creates a BestFriend object called and uses different methods such as getters and setters
*  to interact with it.
 */
package bestfriendsphonebookarraylist;


public class BestFriend {
    //Instance variables of the class
    private String firstName ; //First Name
    private String lastName ; //Last Name
    private String nickName ; //Nick Name
    private String cellPhone ;//Cellphone number
    private String email ; //email
    
/**
 * Constructor of the class
 * @param firstName
 * @param lastName
 * @param nickName
 * @param cellPhone
 * @param email 
 */
    public BestFriend(String firstName, String lastName, String nickName, String cellPhone, String email)
    {
        //Set local variables to the instance variables.
        this.firstName = firstName ;
        this.lastName = lastName ;
        this.nickName = nickName ;
        this.cellPhone = cellPhone ;
        this.email = email ;
    }
    /**
     * Second class Constructor
     * @param firstName
     * @param lastName
     * @param nickName 
     */
    public BestFriend(String firstName, String lastName, String nickName)
    {
        //Set local variables to the instance vairables.
        this.firstName = firstName ;
        this.lastName = lastName ;
        this.nickName = nickName ;
    } 
   /**
    * Get the first name.
    * @return firstName
    */
    public String getFirstName()
    {
        return firstName ;
    }
/**
 * Get the last name.
 * @return lastName
 */
    public String getLastName() 
    {
        return lastName ;
    }
/**
 * Get the nick name.
 * @return nickName
 */
    public String getNickName() 
    {
        return nickName ;
    }
/**
 * Get the phone number
 * @return cellPhone
 */
    public String getCellPhone()
    {
        return cellPhone ;
    }
/**
 * Get the email.
 * @return email
 */
    public String getEmail() 
    {
        return email ;
    }
    /**
     * Returns all the data of your friend
     * @return firstName,lastName, nickName, cellPhone, email
     */
    @Override
    public String toString() {
        return  "Your friends name is: " + firstName + " " + lastName + " "
        + " " + nickName + "\n Their number is: " + cellPhone + "\nTheir email"
                + " is: " + email ;    
    }

  /**
   * Tests to see if the BestFriend objs are equal.
   * @param obj
   * @return 
   */
    @Override
    public boolean equals(Object obj)
    {
        BestFriend other;
        if(obj == null)
        { return false;}
        
        if (obj instanceof BestFriend)
        {
            other = (BestFriend) obj;
        }
        else
        { return false; }
       if(firstName.equals(other.firstName) &&
               lastName.equals(other.lastName) &&
               nickName.equals(other.nickName)
               )
       {
           return true;
       }
       else
       {
           return false;
       }
    }
}
