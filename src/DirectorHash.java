

public class DirectorHash {

	DirectorAVLTree[] D;// an array of 27 index for alphabets and also special
						// characters
	public int arraysize = 27;

	public DirectorHash() {
		D = new DirectorAVLTree[27];
		for (int i = 0; i < D.length; i++) {
			D[i] = new DirectorAVLTree();
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

	public void insertDirector(DirectorNode d, MovieNode m) {// inserting a
																// director
																// with a movie
																// linking
																// to
																// its linked
																// list
		System.out.println("Director is " + d.name);
		D[StringHashFunction(d.name)].insert(d, m);

	}

	public String searchDirector(String a) {// searching director by going to
											// certain
											// index
		return D[StringHashFunction(a)].SearchbyName(a);
	}

}
