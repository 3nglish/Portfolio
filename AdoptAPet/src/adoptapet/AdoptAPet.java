/**
  Title:           AdoptAPet
  Semester:        COP3804 – Fall 2018
  @author          Panther Id (5964074)
   Instructor:     C. Charters
  
   Due Date:      11/21/2018
Create an AdoptAPet object and display a menu to the user calling the appropriate
* methods depending on which number they input
 */
package adoptapet ;

import java.util.InputMismatchException ;
import java.util.LinkedList ;
import java.util.PriorityQueue ;
import java.util.Queue ;
import java.util.Scanner ;

public class AdoptAPet 
{
    //Instance variables of the class
    Scanner keyboard = new Scanner(System.in) ;//Keyboard to get input from user
    Queue<Pet> dogQueue = new LinkedList<>() ;//Queue for dogs
    Queue<Pet> catQueue = new LinkedList<>() ;//Queue for cats 
    PriorityQueue<Pet> shelter = new PriorityQueue<>() ;//Queue to enter oldest pet
    private String name ;//Name of pet
    private int  dob ;//Date of birth of pet
    private String species ;//Species of pet
    Pet aPet ;//Pet object
    
    public static void main(String[] args) 
    {
        //Create a default adopt a pet object to call methods on
        AdoptAPet test = new AdoptAPet() ; 
        test.displayMenu() ;//Display a menu for the user
    }
    
    /**
     * Display a menu to the user and call the appropriate methods depending on
     * the users number choice 
     */
      public void displayMenu() 
    {
     //boolean variable to keep going until the user no longer wishes to use the menu
      boolean keepGoing = true ;//Set the variable to true
      
      while (keepGoing)  
      {
        try //Try handling the user input
      {
            
      System.out.println("Please select an option.") ; 
       int menuOption ;//Menu option for user input
       do //Keep calling methods for the user until...
       {
           System.out.println("1. Donate a Cat") ;
           System.out.println("2. Donate a Dog") ;
           System.out.println("3. Adopt a Cat") ;
           System.out.println("4. Adopt a Dog") ;
           System.out.println("5. Adopt Oldest Pet") ;
           System.out.println("6. Exit") ;
           menuOption = keyboard.nextInt() ;//Set menu option to the next int
           keyboard.nextLine() ;//Clear the bufer in the keyboard
           //Menu option
           switch (menuOption)
            {
               case 1: //Menu option equal 1
                 enqueueCats() ;//Call enqueueCats
                  break ;
               case 2://Menu option equal 2
                 enqueueDogs() ;//Call enqueueDogs
                  break ;
               case 3://Menu option equal 3
                 dequeueCats() ;//Call dequeueCats
                break ;
               case 4://Menu option equal 4
                dequeueDogs();//Call dequeueDogs
                  break ;
               case 5://Menu option equal 5
                dequeueShelter();//Call dequeueOldest
               break ;
               case 6://Menu option equal 6
                   keepGoing = false ;//Set boolean to false
                   System.out.println("Thanks for using!") ;
                   break ; 
           }
        }while (menuOption != 6) ; //When menu option becomes 6 stop the loop
        }
        //Catch input mismatch exception
        catch (InputMismatchException e)
        {
            System.out.println("Sorry you can only enter a number 1-6 please try again") ;
            keyboard.nextLine() ;
        }
        //Catch any other exception
        catch (Exception e)
        {
            System.out.println("Sorry you can only enter a number 1-6 please try again") ;
            keyboard.nextLine() ;
        }
    }
    }
      
      /**
       * Ask user for appropriate information to create a pet object and add it 
       * to the cat queue and the shelter queue
       */
      public void enqueueCats()
      {
          System.out.println("What is the name of the cat you are donating") ;
          name = keyboard.nextLine() ;//Name equal to the next input from the user
          System.out.println("When was your cat born(format yyyymmdd)") ;
          dob = keyboard.nextInt() ;//Dob equal to the next int from the user
          keyboard.nextLine() ;//Clear  the buffer
          System.out.println("What type of cat is it") ;
          species = keyboard.next() ;//Species equal to the next input from the user
          //Create a new pet object using the input from the user
          aPet = new Pet (name, dob, species) ;
          catQueue.add(aPet) ;//Add the pet to the cat queue
          shelter.add(aPet) ;//Add the pet to the shelter queue
          //Print the pet that was added
          System.out.println(aPet + " Has been added!\n") ;
       
      }
    
       /**
       * Ask user for appropriate information to create a pet object and add it 
       * to the dog queue and the shelter queue
       */
       public void enqueueDogs()
      {
          System.out.println("What is the name of the dog you are donating");
          name = keyboard.nextLine() ;//Name equal to the next input from the user
          System.out.println("When was your dog born(format yyyymmdd)") ;
          dob = keyboard.nextInt() ;//Dob equal to the next int from the user
          keyboard.nextLine() ;//Clear  the buffer
          System.out.println("What type of dog is it") ;
          species = keyboard.next() ;//Species equal to the next input from the user
          //Create a new pet object using the input from the user
          aPet = new Pet (name, dob, species) ;
          dogQueue.add(aPet) ;//Add the pet to the dog queue
          shelter.add(aPet) ;//Add the pet to the shelter queue
           //Print the pet that was added
          System.out.println(aPet + " Has been added!\n") ;
      }
       
       /**
        * Remove the oldest cat from the queue and the shelter and print it out
        */
       public void dequeueCats()
       {
            Pet temp ; //Pet object to use for methods
            temp = catQueue.remove() ;//Set the object to the remove cat queue method
            shelter.remove(temp) ;//Remove the same object from the shelter
            System.out.println("You have adopted " + temp + "\n") ; //Display it to the user
       }
       
        /**
        * Remove the oldest cat from the queue and the shelter and print it out
        */
       public void dequeueDogs()
       {
            Pet temp ;//Pet object to use for methods
            temp = dogQueue.remove() ;//Set the object to the remove dog queue method
            shelter.remove(temp) ;//Remove the same object from the shelter
            System.out.println("You have adopted " + temp +"\n") ; //Display it to the user
       }
       
       /**
        * Remove the oldest cat or dog from the queue and depending on which was
        * removed also remove it from the appropriate queue
        */
       public void dequeueShelter()
       {
           Pet temp ;//Pet object to use for methods
           temp =  shelter.remove() ;//Set the object to the remove shelter queue method
           //If the object exists in the catqueue 
           if(catQueue.contains(temp))
           {
            //Remove it and display it to the user
             System.out.println("You have adopted " + catQueue.remove() + "\n") ;
           }
           else if (dogQueue.contains(temp))
           {
               //Remove it and display it to the user
                System.out.println("You have adopted " + dogQueue.remove() + "\n") ;
           }
       }
}
