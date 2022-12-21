
/**

  Title:           BFFHelperArrayList
  Semester:        COP3804 – Fall 2018
  @author          Panther Id (5964074)
   Instructor:     C. Charters
  
   Due Date:      9/2/2018
Creates an arraylistHelper object called called "test", and uses different methods
 to interact with the arrayList.
 */
package bestfriendsphonebookarraylist;
import javax.swing.JOptionPane;
public class BestFriendsPhoneBookArrayList {


    public static void main(String[] args) {
          BFFHelperArrayList test = new BFFHelperArrayList(); //Creates a new BFFHelper obj
        int answer ; // Creates a variable to store the answer
       
        do
        {
            //Get an answer from the user.
            String input = JOptionPane.showInputDialog("Press 1, to add a Friend"
            + " Press 2, to change a friend's info " + "Press 3, to remove a friend "
            + "Press 4, to display your friends" + " Press 5, to exit") ;
            answer = Integer.parseInt(input); 
            if (answer == 1) //If answer equals 1
            {
                
                test.addAFriend() ; //Call the addAFriend method
            }
            else if (answer == 2) //If answer equals 2
            {
                test.changeAFriend() ; //Call the changeAFriend method
            }
            else if (answer == 3) //If answer equals 3
            {
                test.removeAFriend() ;//Call the removeAFriend method
            }
            else if (answer == 4)// If answer equals 4
            {
                test.displayAFriend() ;//Call the displayAFriend method
            }
        }
        while(answer != 5) ;//Exit when answer becomes 5
        
        
    }
    
}
