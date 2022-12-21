/**

  Title:           BFFHelperArrayList
  Semester:        COP3804 – Fall 2018
  @author          Panther Id (5964074)
   Instructor:     C. Charters
  
   Due Date:      9/2/2018
Creates an array list object called called "myBFFs", and uses different methods
*  to interact with the arrayList.
 */
package bestfriendsphonebookarraylist;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class BFFHelperArrayList {
    ArrayList<BestFriend> myBFFs ; //Creates a new arraylist 
    
    public BFFHelperArrayList()
    {
        myBFFs = new ArrayList<BestFriend>() ; // intaizlizing the list
    }
    
    /**
     * Adds a friend called newFriend to the array list.
     */
    public void addAFriend()
    {   
        String fName = JOptionPane.showInputDialog("What is your friends First Name?") ; //Ask user for first name and store in a variable
        String lName = JOptionPane.showInputDialog("What is your friends last Name?") ; //Ask user for last name and store...
        String nName = JOptionPane.showInputDialog("What is your friends middle Name?") ; //Ask user for middle name and store...
        String phoneNum = JOptionPane.showInputDialog("What is your friends Phone Number?") ; //Ask user for phoneNum and store...
        String email = JOptionPane.showInputDialog("What is your friends email?") ;  //Ask user for email and store.
        BestFriend newFriend = new BestFriend(fName, lName, nName, phoneNum, email); //Put the data in a constructor.
        System.out.println(newFriend.toString()); //Print out the new friend added
        myBFFs.add(newFriend);//Add the friend to the list.   
    }
    
    /**
     * changes a friend data based on what is entered.
     */
    public void changeAFriend()
    {
       BestFriend found ; //Creates a new BestFriend obj.
       int pos ; //Creates a variable for holding position.
       pos = searchAFriend(); //position = index of friend your looking for.
       found = myBFFs.get(pos) ; // Get the information at index(pos) and store in found.
       System.out.println(found) ; //Print found.
       String firstName = JOptionPane.showInputDialog("Enter the new Frist Name.") ; //Ask user for new first Name. 
       String lastName = JOptionPane.showInputDialog("Enter the new Last Name.") ; //Ask for new last name.  
       String nickName = JOptionPane.showInputDialog("Enter the new Nick Name.") ;//Ask for new nick name.
       String email = JOptionPane.showInputDialog("Enter the new email.") ;//Ask for new email.
       String phone = JOptionPane.showInputDialog("Enter the new phone Number.") ;//Ask for new phone num.  
       BestFriend sameFriend = new BestFriend(firstName, lastName, nickName, email, phone) ; //Using a constructor to store the variables we asked for.
            myBFFs.set(pos,sameFriend); //set the obj back into the array list.
    }
    
    /**
     * Removes a friend from the array list
     */
    public void removeAFriend()
    {
        int pos ; //Creates a variable for holding the position.
        BestFriend found ; //Creates a BestFriend obj.  
        pos = searchAFriend() ; //Store the index in pos. 
        found =myBFFs.get(pos) ; //Get the information at, pos and store in found.    
        System.out.println(found) ; //Print found.
        String input = JOptionPane.showInputDialog("Are you sure you want to " //Ask user if they want to delete.
       + "delete this friend" + " \n enter yes or no.") ;
       if(input.equals("yes")) //If answer is " yes ".
       {
          myBFFs.remove(found) ; //remove BestFriend obj found from the list.
          System.out.println("Your friend has been deleted!") ;//Tell user their friend has been deleted. 
       }
       else if (input.equals("no")) // else answer is " no ".
       {
            System.out.println("Your friend has not been deleted!"); //Tell user their friend has not been delted.
       }   
    }
    /**
     * Display one friend or all friends depending on response from user.
     */
    public void displayAFriend()
    {
        BestFriend found  ; //Create BestFriend obj found.
        
        String input = JOptionPane.showInputDialog("Would you like to see " +
                "One friend or all your friends? Press 1 "
        +"For one friend, Press 2 for ALL friends!") ; //Ask the user for their choice. 
         int answer = Integer.parseInt(input) ;//Convert answer to int.
  
     if (answer == 1) //If the answer is " 1 ".
     {
         int pos = searchAFriend() ; // Get the index of the friend, set it to position.
        
         {
             found =myBFFs.get(pos) ; // Get the information at pos.
             System.out.println(found) ; //Print the data.
         }
     }
     else if(answer == 2)//Else answer is " 2 ".
     {
          for(int i = 0 ; i < myBFFs.size(); i++)//traversing the list
       {
           found  = myBFFs.get(i) ; //set found to the data got at each index.
           System.out.println(found) ; // Print the data.
       }
     }
    }
    /**
     * Search for a specific friend with the data entered.
    @return i (the index)
    */
    public int  searchAFriend()
    {
        String fName = JOptionPane.showInputDialog("What is your friends First Name?") ; //Ask for first Name.
        String lName = JOptionPane.showInputDialog("What is your friends last Name?") ; //Ask for last Name.
        String nName = JOptionPane.showInputDialog("What is your friends nick Name?") ; //Ask for nick Name.
        BestFriend searchObj = new BestFriend(fName, lName, nName); //Create a BestFriend obj using the data we pass to it.
         int i = 0 ; //the index being returned
         boolean found = false ;
         while( i < myBFFs.size()&& !found) //While i< the size and true (!found)
         {
             if(searchObj.equals(myBFFs.get(i))) //if BestFriend obj = to the obj at current index
             {
                 found = true ; //return true
             }
             else
             {
                 i++; //else incrument
             }
         }
         if(!found) //if true
         {
             System.out.println("Friend not found."); //Print not found and set i to negative 1.
             i= -1;
         }
         return i; //Return the index.
    }
}

