/**

  Title:           AirTrafficController
  Semester:        COP3804 – Fall 2018
  @author          Panther Id (5964074)
   Instructor:     C. Charters
  
   Due Date:      11/4/2018
Creates a location object, and uses various methods to interact with it.
*  
 */
package airtrafficcontroller;


public class Location implements Comparable<Location>
{
    //Instance variables of the class
    private int xLoc;
    private int yLoc;

    /**
     * Class constructor
     * @param xLoc
     * @param yLoc 
     */
    public Location(int xLoc, int yLoc)
    {
        this.xLoc = xLoc;
        this.yLoc = yLoc;
    }

    /**
     * Get the location of the x value
     * @return xLoc
     */
    public int getxLoc() 
    {
        return xLoc;
    }

    /**
     * Set the location of the x value
     * @param xLoc 
     */
    public void setxLoc(int xLoc) 
    {
        this.xLoc = xLoc;
    }

    /**
     * Get the location of the y value
     * @return yLoc
     */
    public int getyLoc() 
    {
        return yLoc;
    }

    /**
     * Set the location of the y value
     * @param yLoc 
     */
    public void setyLoc(int yLoc) 
    {
        this.yLoc = yLoc;
    }

    /**
     * Return the information about a location object
     * @return 
     */
    @Override
    public String toString() {
        return "Location(" + "xLoc:" + xLoc + ", yLoc:" + yLoc +")"+ '}';
    }
    
    /**
     * Compare two location object x locations
     * @param otherLoc
     * @return 
     */
    public int compareTo(Location otherLoc)
    {
        if (this.xLoc < otherLoc.xLoc)
            return -1;
        else if (this.xLoc > otherLoc.xLoc)
            return 1;
        else
            return 0;
    }
    
}
