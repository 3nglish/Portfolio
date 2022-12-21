/**
  Title:           AdoptAPet
  Semester:        COP3804 – Fall 2018
  @author          Panther Id (5964074)
   Instructor:     C. Charters
  
   Due Date:      11/21/2018
Create a pet object and different methods to interact with it
 */
package adoptapet;

public class Pet implements Comparable <Pet>
{
    //Instance variables of the class
    private String name ;
    private int  dob ;
    private String species ;
    
    /**
     * Class constructor to create a pet object
     * @param name
     * @param dob
     * @param species 
     */
    public Pet(String name, int dob, String species)
    {
        //Set the param variables to the instance variables
        this.name = name ;
        this.dob = dob ; 
        this.species = species ;
    }

    /**
     * Get the name of the pet
     * @return name
     */
    public String getName() 
    {
        return name ;
    }

    /**
     * Change the name of the pet
     * @param name 
     */
    public void setName(String name) 
    {
        this.name = name ;
    }

    /**
     * Get the dob of the pet
     * @return dob
     */
    public int getDob() 
    {
        return dob ;
    }

    /**
     * Change the dob of the pet
     * @param dob 
     */
    public void setDob(int dob) 
    {
        this.dob = dob ; 
    }

    /**
     * Get the species of the pet
     * @return species
     */
    public String getSpecies() 
    {
        return species ;
    }
    
    /**
     * Change the species in the pet
     * @param species 
     */
    public void setSpecies(String species) 
    {
        this.species = species ;
    }

    /**
     * return the information about a pet
     * @return pet
     */
    @Override
    public String toString() 
    {
        return "\n{" + "Name:" + name + "\ndob:" + dob + "\nspecies:" + species + '}';
    }
    
    /**
     * Take a pet dob and compare it to another
     * @param aPet
     * @return a sorted pet queue
     */
   public int compareTo(Pet aPet)
    {
       if (this.dob > aPet.dob)
       {    return 1;
       }
       else if (this.dob == aPet.dob)
       {
          return 0; 
       }
       else
           return -1;
    }
    
    
}
