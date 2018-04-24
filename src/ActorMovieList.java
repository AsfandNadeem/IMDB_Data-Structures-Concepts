

public class ActorMovieList {

	ActorMovieListNode Start;
	ActorMovieListNode loc;
	ActorMovieListNode predloc;

	// Constructor
	ActorMovieList() {
		Start = null;

	}

	public boolean isEmpty() {
		if (Start == null) {
			return true;
		} else
			return false;
	}

	public void SearchandaddAtFront(MovieNode d) {// adding the movie to linked
													// list of movies of a
													// certain actor

		ActorMovieListNode newNode = new ActorMovieListNode();
		newNode.ActorsMovies = d;
		newNode.next = Start;
		Start = newNode;

	}

	public String moviesPrint() {// method for printning movies of the actor
		loc = null;
		loc = Start;
		String c = "";
		while (loc != null) {
			c = "\n" + loc.ActorsMovies.title + c;
			loc = loc.next;
		}
		return c;
	}

	public String CoactorsPrint(String b) {// printing coactors by going to
											// given actor's linked list of
											// movies
		loc = null;
		loc = Start;
		String c = "";
		while (loc != null) {
			c = loc.ActorsMovies.MA.ConamePrint(b) + c;// going to movies and
														// printing all the
														// actors except the
														// given actor
			loc = loc.next;

		}
		return c;

	}

	public void VoidmoviesPrint() {// extra void method for printing movies
		loc = null;
		loc = Start;

		while (loc != null) {
			System.out.println(loc.ActorsMovies.title);
			loc = loc.next;
		}

	}

}
