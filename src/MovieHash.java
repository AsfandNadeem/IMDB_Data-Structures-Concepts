

public class MovieHash {

	MovieAVLTree[] M;// An array of 27 indexes,each having a tree of its own,for alphabets and special characters
	public int arraysize = 27;

	public MovieHash() {// constructor
		M = new MovieAVLTree[27];
		for (int i = 0; i < M.length; i++) {
			M[i] = new MovieAVLTree();
		}
	}

	public int StringHashFunction(String WordToHash) {// assigning indexes using
														// ASCII code of first
														// charcter
		int HashKeyValue = 1;
		for (int i = 0; i < 1; i++) {
			if (Character.isAlphabetic(WordToHash.charAt(i))) {//indexes of alphabets
				int CharCode = WordToHash.charAt(i) - 64;
				int HKVTemp = HashKeyValue;
				HashKeyValue = (HashKeyValue * 27 + CharCode) % arraysize;
				System.out.println("Hash Key Value " + HKVTemp + " * 27 + Character Code " + CharCode + " % arraySize "
						+ arraysize + " = " + HashKeyValue);
			} else if (!Character.isAlphabetic(WordToHash.charAt(i))) {//indexes of special characters
				HashKeyValue = 0;

			}

		}
		return HashKeyValue;
	}

	public void insertMovie(MovieNode m) {// inserting movie in the hash table
		System.out.println("Movie is " + m.title);
		M[StringHashFunction(m.title)].insert(m);// checking index and making a tree at that index

	}

	public String searchMovie(String a) {// searching movies by checking the
											// index
		return M[StringHashFunction(a)].SearchbyName(a);
	}

	public String searchByHGenre(String a) {// searching genre at all the
											// indexes
		String g = "";
		for (int i = 0; i < M.length; i++) {
			g = "" + M[i].SearchByGenre(a, M[i].root) + g;
		}
		return g;
	}

	public String searchByHRating(double a, double b) {// searching rating range
														// at all the indexes
		String r = "";
		for (int i = 0; i < M.length; i++) {
			r = "" + M[i].SearchByRating(a, b, M[i].root) + r;
		}
		return r;
	}

}
