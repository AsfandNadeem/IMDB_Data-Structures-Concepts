

public class MovieActorList {

	MovieActorListNode Start;
	int numItems;
	MovieActorListNode loc;
	MovieActorListNode predloc;

	// Constructor
	MovieActorList() {
		Start = null;
		numItems = 0;
	}

	public boolean isEmpty() {
		if (Start == null) {
			return true;
		} else
			return false;
	}

	public void addAtFront(ActorNode d)// adding actor in the linked list of
										// actorslist of each movie
	{
		MovieActorListNode newNode = new MovieActorListNode();
		newNode.ActorM = d;
		newNode.next = Start;
		Start = newNode;
		numItems++;
	}

	public String namePrint()// method for printing linked list of actors
	{
		loc = null;
		loc = Start;
		String c = "\n";
		while (loc != null) {

			c = "\n" + loc.ActorM.name + c;
			loc = loc.next;
		}
		return c;
	}

	public String ConamePrint(String b)// printing coactors except the one that
										// is given
	{
		loc = null;
		loc = Start;
		String c = "";
		while (loc != null) {
			if (loc.next != null && loc.ActorM.name.equalsIgnoreCase(b))// in
																		// case
																		// if
																		// the
																		// actor
																		// given
																		// is
																		// not
			{ // last in the list
				loc = loc.next;
			}

			else if (loc.ActorM.name.equalsIgnoreCase(b) && loc.next == null)// in
																				// case
																				// if
																				// the
																				// actor
																				// given
																				// is
			// last in the list
			{
				break;
			}

			c = "\n" + loc.ActorM.name + c;
			loc = loc.next;
		}

		return c;

	}

	public void VoidnamePrint()// extar void method for printing names
	{
		loc = null;
		loc = Start;
		while (loc != null) {

			System.out.println(loc.ActorM.name);
			loc = loc.next;
		}
	}

}
