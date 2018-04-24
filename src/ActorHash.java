

public class ActorHash {

	ActorAVLTree[] A;// an array of 27 index for alphabets and also special
						// characters
	public int arraysize = 27;

	public ActorHash() {
		A = new ActorAVLTree[27];
		for (int i = 0; i < A.length; i++) {
			A[i] = new ActorAVLTree();
		}
	}

	public int StringHashFunction(String WordToHash) {
		int HashKeyValue = 1;
		for (int i = 0; i < 1; i++) {
			if (Character.isAlphabetic(WordToHash.charAt(i)))// indexes of
																// alphabets
			{
				int CharCode = WordToHash.charAt(i) - 64;
				int HKVTemp = HashKeyValue;
				HashKeyValue = (HashKeyValue * 27 + CharCode) % arraysize;
				System.out.println("Hash Key Value " + HKVTemp + " * 27 + Character Code " + CharCode + " % arraySize "
						+ arraysize + " = " + HashKeyValue);
			} else if (!Character.isAlphabetic(WordToHash.charAt(i)))// indexes
																		// of
																		// characters
			{
				HashKeyValue = 0;

			}

		}
		return HashKeyValue;
	}

	public void insertActor(ActorNode a, MovieNode m) {// inserting an actor
														// with a movie linking
														// to
														// its linked list
		System.out.println("Actor is " + a.name);
		A[StringHashFunction(a.name)].insert(a, m);

	}

	public String searchActor(String a) {// searching actor by going to certain
											// index
		return A[StringHashFunction(a)].SearchbyName(a);
	}

	public String PrintCoActors(String a)// printing co actors by going to
											// certain index
	{
		return A[StringHashFunction(a)].printCoActors(a);
	}

}
