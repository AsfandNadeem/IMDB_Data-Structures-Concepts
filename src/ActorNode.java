

public class ActorNode {

	String name;
	String fblikes;

	ActorMovieList AM;// List of movies that actor has done

	public ActorNode() {

	}

	public ActorNode(String name, String fblikes)// contructor for actornode
													// also linking a link list
													// of its movies

	{
		super();
		this.name = name;
		this.fblikes = fblikes;
		this.AM = new ActorMovieList();

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

	public ActorMovieList getAM() {
		return AM;
	}

	public void setAM(ActorMovieList aM) {
		AM = aM;
	}

}
