/**

  Title:           AirTrafficController
  Semester:        COP3804 – Fall 2018
  @author          Panther Id (5964074)
   Instructor:     C. Charters
  
   Due Date:      11/4/2018
Creates an AirTrafficController object, then uses the object to process a file
* read the information and storing each element in an array. Sort the array and 
* then find the minimum distance between each object in the array.
*  
 */
package airtrafficcontroller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class AirTrafficController {

   static int currentSize = 0 ;
   static Location[] myLocations = new Location[currentSize] ;
    
    public static void main(String[] args) 
    {
        AirTrafficController myATC = new AirTrafficController() ;
        
            myATC.processFile();
            myATC.selectionSort(myLocations) ;
            myATC.findMinDist(); 
            
    }
    
    /**
     * Process a file (airplanesInMiami.txt) read the file, create an object for
     * each element and store each element in an array.
     */
    public void processFile() 
    {
        //Instance variables of the class
        boolean tryAgain ;
        Scanner keyboard = new Scanner(System.in) ;
        String fileName ;
        File aFile ;
        Scanner inFile = null ;
        int xLoc ;
        int yLoc ;
        Location aLocation; 
        int numRecs ;
        
        //While tryagain is true keep asking for the name of the file
        do
        {
           try
           {
               System.out.println("What is the name of the input file?(airplanesInMiami.txt)") ;
               fileName = keyboard.nextLine() ;
               aFile = new File(fileName) ;
               inFile = new Scanner(aFile) ;
               tryAgain = false ;
           }
           catch (FileNotFoundException e)
           {
               System.out.println("Please enter a different file name.") ;
               tryAgain = true ;
           }
            catch (Exception e)
           {
               tryAgain = true ;
            System.out.println("Sorry, file corrupted.  Cannot proceed. Contact Support") ; 
            
           }
        }
        while (tryAgain == true) ;
        
        //Read the first element in the file and store it in numrecs
        numRecs = inFile.nextInt() ;
        inFile.nextLine() ;
        
        //Use the number of elements in the array as the size
        myLocations = new Location[numRecs] ;
        int t = 0 ; //Index in the array
        while (inFile.hasNext()) //While there are still elements in the file
       {
            try
            {
                String k = inFile.nextLine() ; //Read the line
                String[] p = k.split(",") ; //Spilt the line by comma and store in an array
                xLoc = Integer.parseInt(p[0]) ; //Set the x Location to the first element in the array
                yLoc = Integer.parseInt(p[1].replace(" ", "")) ;//Set the y Location to the second element in the array
                aLocation = new Location (xLoc, yLoc) ; //Create a location object
                 myLocations[t] = aLocation ; //Place the location object in the array
                 t++ ; //Increment the index
            }
            
            catch (InputMismatchException e)
            {
                System.out.println("Bad record skipping...") ;
                inFile.nextLine() ;
            }
             catch (Exception e)
           {
            System.out.println("Bad record skipping...") ; 
            inFile.nextLine() ;
           }
       }
       for (int i = 0 ; i < numRecs ; i++)
       {
           System.out.println(myLocations[i]) ;
       }
    }
    
    /**
     * Sort the array by the x location
     * @param myLocations 
     */
    public void selectionSort(Location[] myLocations)
    {
        for (int i = myLocations.length - 1 ; i >= 1 ; i--)
        {
            int maxIndex = 0 ;
            for (int index = 1 ; index <= i ; index++)
            {
                if (myLocations[index].getxLoc() > myLocations[maxIndex].getxLoc())
                   maxIndex = index ;
            }
            
            Location temp = myLocations[maxIndex] ;
            myLocations[maxIndex] = myLocations[i] ;
            myLocations[i] = temp ;
            
        }
        //Print the sorted array by the x Location
        int count = 0 ; //index
        System.out.println("\nSorted by x...") ;
        while(count != myLocations.length) //while the index isnt equal to length
        {
            System.out.println(myLocations[count]) ; //Print out the information at that index
            count++ ; //Increment the index
        }
    }
    
    /**
     * Go through the sorted array and calculate the  distance between each
     * location object, the closet location objects will get a warning.
     */
    public void findMinDist()
    {
        int x2  = myLocations[1].getxLoc() ; //Set x2 to the second x in the array
        int y2 = myLocations[1].getyLoc() ; //Set y2 to the second y in the array
        int x1 = myLocations[0].getxLoc() ; //Set x1 to the first x in the array
        int y1 = myLocations[0].getyLoc() ; //Set y2 to the first y in the array
        
        //calculate the distance between the first and second index
        double minDistance = Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2
                - x1, 2)) ;
        System.out.println("\n" + myLocations[0]+ " and " 
                            + myLocations[1] + " are to close!") ;
        System.out.println("Starting distance is... " + minDistance) ;
        for(int i = 2 ; i < myLocations.length ; i++)
        {
            for (int j = i-1 ; j < i ; j++)
            {
                double distance = Math.sqrt(Math.pow(myLocations[i].getyLoc() - myLocations[j].getyLoc(), 2) +
                Math.pow(myLocations[i].getxLoc()  - myLocations[j].getxLoc(), 2)) ;
                //if the distance is less than the smallest distance set the smallest to the distance
                if(distance <= minDistance)
                {
                    minDistance = distance ;
                    System.out.println(myLocations[j]+ " and " 
                            + myLocations[i] + " are to close!") ;
                    System.out.println("The current distance is... " + distance) ;

                }
                
            }
        }
        
    }
   
}
