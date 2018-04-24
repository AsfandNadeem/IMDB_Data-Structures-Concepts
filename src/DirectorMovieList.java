


public class DirectorMovieList {

	DirectorMovieListNode Start;
   DirectorMovieListNode loc;
    DirectorMovieListNode predloc;

	// Constructor
    DirectorMovieList(){
        Start = null;
        
    }
    
    public boolean isEmpty()
    {
		if (Start==null)
		{
			return true;
		}
		else return false;
    }
    
    
    public void SearchandaddAtFront(MovieNode d)// adding the movie to linked
	                                             // list of movies of a
	                                             // certain director
    {
    	    	
    	DirectorMovieListNode newNode = new DirectorMovieListNode();
        newNode.DM=d;
        newNode.next=Start;
        Start=newNode;
    	
        
    }
    
    public String moviesPrint()// method for printning movies of the director
    {
    	loc=null;
    	loc=Start;
    	String c="";
    	while(loc!=null)
    	{
    		c="\n"+loc.DM.title+c;
    		loc=loc.next;
    	}
    	return c;
    }

	public void VoidmoviesPrint() {//extra void method
		    
	    	loc=null;
	    	loc=Start;
	    	while(loc!=null)
	    	{
	    		System.out.println(loc.DM.title);
	    		loc=loc.next;
	    	}
	    }
	
   
}


