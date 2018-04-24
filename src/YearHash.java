

public class YearHash {

	MovieAVLTree[] M;// an array of 11 index for alphabets and also special
	// characters
	public int arraysize = 10;

	public YearHash() {
		M = new MovieAVLTree[10];
		for (int i = 0; i < M.length; i++) {
			M[i] = new MovieAVLTree();
		}
	}

	public int StringHashFunction(int WordToHash) {// getting the year
		int HashKeyValue;
		// giving hash index value
		// int CharCode=WordToHash%10;//based on last index
		int CharCode = WordToHash % 10;
		System.out.println(CharCode);
		HashKeyValue = CharCode;
		System.out.println("Hash Key Value " + HashKeyValue);

		return HashKeyValue;
	}

	public void insertMovie(MovieNode m) {// inserting movie int the year hash
											// table
		System.out.println("Year is" + m.year);
		if (Character.isDigit(m.year.charAt(1)))// checking if year is given
		{
			int a = Integer.parseInt(m.year);// changing the string to integer
			M[StringHashFunction(a)].insert(m);// insertion at certain index
		} else
			return;

	}

	String y = "";

	public String searchMoviebyYear(int a) {// searching and printing movies of
											// a certain year
		return y = M[StringHashFunction(a)].printPostorder(a, M[StringHashFunction(a)].root);

	}

}
