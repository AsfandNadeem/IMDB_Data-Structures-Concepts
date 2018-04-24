


public class DirectorNode {
	String name;
	String fblikes;
	DirectorMovieList DM;// List of movies that director has directed
	
	

	public DirectorNode(String name, String fblikes) {// contructor for directornode
		                                              // also linking a link list
		                                             // of its movies
		this.name = name;
		this.fblikes = fblikes;
		DM=new DirectorMovieList();	
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getFblikes() {
		return fblikes;
	}



	public void setFblikes(String fblikes) {
		this.fblikes = fblikes;
	}



	public DirectorMovieList getDM() {
		return DM;
	}



	public void setDM(DirectorMovieList dM) {
		DM = dM;
	}
	
	

    
}
