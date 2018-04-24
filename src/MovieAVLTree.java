

public class MovieAVLTree {
	private MovieAVLNode loc;
	private MovieAVLNode parent;
	public MovieAVLNode root;
	private int n;

	public boolean isEmpty() {
		if (root == null)
			return true;
		else
			return false;
	}

	void insert(MovieNode d) {//insertion of movieNode at hash index tree iteratively
		MovieAVLNode newNode = new MovieAVLNode();
		newNode.data = d;
		if (isEmpty()) {//insertion 
			root = newNode;
			n++;
		} else {
			loc = root;
			while (loc != null) {
				if (loc.data.title.compareTo(d.title) > 0) {//comparing the loc node with with the node to be inserted
					parent = loc;
					loc = loc.left;
				} else if (loc.data.title.compareTo(d.title) < 0) {
					parent = loc;
					loc = loc.right;
					//loc will become null eventually and parent will be the node on whose left or right the
					//new node will be inserted
				} else {//not inserting same actors;
					d = null;
					loc = null;
					parent = null;
					newNode = null;
					return;
				}
			}
			if (d.title.compareTo(parent.data.title) > 0) {//comparing the value of node and linking to left
				                                    //or right of the parent
				parent.right = newNode;
				n++;
			} else if (d.title.compareTo(parent.data.title) < 0) {
				parent.left = newNode;
				n++;
			} else {
				d = null;
				loc = null;
				parent = null;
				newNode = null;
				return;
			}
		}

		loc = null;
		loc = root;//starting from the 

		int balance = Balancecheck(loc);//generating balance factor
		if (balance <= -2) {
			leftRotate(loc);
		}

		else if (balance >= 2) {
			rightRotate(loc);
		} else
			return;

	}


	public void rightRotate(MovieAVLNode node) {//right rotation based on the balance factor
		MovieAVLNode x = new MovieAVLNode();
		x = node;
		MovieAVLNode y = new MovieAVLNode();
		y = node.left;
		x.left = y.right;
		y.right = x;
		if (x == root) {
			root = y;
		}
		int result = this.Balancecheck(root);
		return;
	}

	public void leftRotate(MovieAVLNode node) {//Left rotation based on the balance factor
		MovieAVLNode x = new MovieAVLNode();
		x = node;
		MovieAVLNode y = new MovieAVLNode();
		y = node.right;
		x.right = y.left;
		y.left = x;
		root = y;
		int result = this.Balancecheck(root);
		return;
	}

	public int rightcheck(MovieAVLNode node) {//checking the height of right side of the node//Recursion
		if (node == null) {
			return 0;
		}

		int left = rightcheck(node.left) + 1;//and also checking the max height till end of tree
		int right = rightcheck(node.right) + 1;//and also checking the max height till end of tree

		if (left > right) {
			return left;
		} else
			return right;//returning max
	}

	public int leftcheck(MovieAVLNode node) {//checking the height of left side of the node//Recursion
		if (node == null) {
			return 0;
		}

		int left = leftcheck(node.left) + 1;//and also checking the max height till end of tree
		int right = leftcheck(node.right) + 1;//and also checking the max height till end of tree

		if (left > right) {
			return left;
		}

		else
			return right;//returning max
	}

	public int Balancecheck(MovieAVLNode node) {//Balance factor returning method
		int right = rightcheck(node.right) + 1;//checking the height to its right
		int left = leftcheck(node.left) + 1;//checking the height to its left
		int BalanceFact = left - right;//balance factor formula
		return BalanceFact;//returning balance factor
	}

	public void Delete(MovieNode d) {
		loc = null;
		parent = null;
		loc = root;

		if (isEmpty() == true) {
			System.out.println("No tree exists");
		}

		else {
			while (loc != null && loc.data.title != d.title) {
				if (loc.data.title.compareTo(d.title) > 0) {
					parent = loc;
					loc = loc.left;
				} else if (loc.data.title.compareTo(d.title) < 0) {
					parent = loc;
					loc = loc.right;
				}
			}
			if (loc == null) {
				System.out.println(d + " is not found so can't be deleted");
			}

			else if (loc.data.title == d.title && loc != root) {
				if (parent.left == loc) {
					if (loc.left == null && loc.right == null) {
						parent.left = null;
						loc = null;
						System.out.println(d + " is found and deleted");
						System.gc();
					} else if (loc.left != null && loc.right == null) {
						parent.left = loc.left;
						loc = null;
						System.out.println(d + " is found and deleted");
						System.gc();
					} else if (loc.right != null && loc.left == null) {
						parent.left = loc.right;
						loc = null;
						System.out.println(d + " is found and deleted");
						System.gc();
					} else if (loc.right != null && loc.left != null) {
						MovieAVLNode newP = null;
						MovieAVLNode del = null;
						newP = loc;
						del = loc;
						if (loc.left.right == null) {
							loc = loc.left;
							parent.left = loc;
							loc.right = newP.right;
							del = null;
							newP = null;
							System.gc();
						} else if (loc.left.right != null) {
							loc = loc.left;
							while (loc.right != null) {
								newP = loc;
								loc = loc.right;
							}
							newP.right = loc.left;
							parent.left = loc;
							loc.left = del.left;
							loc.right = del.right;
							del = null;
							System.out.println(d + " is found and deleted");
							System.gc();
						}

					}
				} else if (parent.right == loc) {
					if (loc.left == null && loc.right == null) {
						parent.right = null;
						loc = null;
						System.out.println(d + " is found and deleted");
						System.gc();
					} else if (loc.left != null && loc.right == null) {
						parent.right = loc.left;
						loc = null;
						System.out.println(d + " is found and deleted");
						System.gc();
					} else if (loc.right != null && loc.left == null) {
						parent.right = loc.right;
						loc = null;
						System.out.println(d + " is found and deleted");
						System.gc();
					} else if (loc.right != null && loc.left != null) {
						MovieAVLNode newP = null;
						MovieAVLNode del = null;
						newP = loc;
						del = loc;
						if (loc.left.right == null) {
							loc = loc.left;
							parent.right = loc;
							loc.right = newP.right;
							del = null;
							newP = null;
							System.out.println(d + " is found and deleted");
							System.gc();
						} else if (loc.left.right != null) {
							loc = loc.left;
							while (loc.right != null) {
								newP = loc;
								loc = loc.right;
							}
							newP.right = loc.left;
							parent.right = loc;
							loc.left = del.left;
							loc.right = del.right;
							del = null;
							System.out.println(d + " is found and deleted");
							System.gc();
						}

					}
				}
			}

		}

		loc = null;
		loc = root;

		int balance = Balancecheck(loc);
		if (balance <= -2) {
			leftRotate(loc);
		}

		else if (balance >= 2) {
			rightRotate(loc);
		} else
			return;

	}

	
	public String SearchbyName(String d) {//Searcching iteratively as the tree is balanced
		                                  //minimising our search complexity
		loc = null;
		parent = null;
		loc = root;
		String c = null;

		if (isEmpty() == true) {
			c = "No tree exists";
		}

		else {
			while (loc != null && !loc.data.title.contains(d)) {
				if (loc.data.title.compareTo(d) >= 0) {
					loc = loc.left;
				} else {
					loc = loc.right;
				}
			}
			if (loc == null) {
				c = d + " is not found";
			} else {
				c = loc.data.title + "\nDirector name :" + loc.data.MD.name + "\nIMDB Rating is :" + loc.data.imdb_score
						+ "\nContent Rating is :" + loc.data.content_rating + "\nLanguage is :" + loc.data.language
						+ "\nCountry is :" + loc.data.country + "\nGenre's are :" + loc.data.genre + "\nYear is :"
						+ loc.data.year + "\nActors Are :" + loc.data.MA.namePrint();
			}

		}
		return c;

	}

	String g = "";

	public String SearchByGenre(String a, MovieAVLNode b) {//Printing movies based on genre
		                                           // by searching movies recursively
		if (b != null) {//postorder traversal
			SearchByGenre(a, b.left);
			SearchByGenre(a, b.right);
			if (b.data.genre.contains(a)) {
				g = "\n" + b.data.title + " " + b.data.genre + g;
			} else {
				return "";
			}
		}
		return g;
	}

	String r = "";

	public String SearchByRating(double a, double b, MovieAVLNode c) {
		//Printing movies based on rating range
        // by searching movies recursively doing postorder traversal
		if (c != null) {
			SearchByRating(a, b, c.left);
			SearchByRating(a, b, c.right);
			if (Double.parseDouble(c.data.imdb_score) >= a && Double.parseDouble(c.data.imdb_score) <= b) {
				r = "\n" + c.data.title + " " + c.data.imdb_score + r;
			} else {
				return "";
			}
		}
		return r;
	}
	
	
	

	String y = "";

	public String printPostorder(int l, MovieAVLNode a) {// for year
		if (a != null) {
			//Printing movies based on Year
	        // by searching movies recursively doing postorder traversal
			printPostorder(l, a.left);
			printPostorder(l, a.right);
			int year = Integer.parseInt(a.data.year);
			// String year=Integer.toString(l);
			if (year == l) {
				y = "\n" + a.data.title + " " + a.data.year + y;
			} else {
				return "";
			}
		}
		return y;
	}

	public void printINorder(MovieAVLNode a) {

		if (a != null) {
			printINorder(a.left);
			System.out.println(a.data.title);
			System.out.println("IMDB Score: " + a.data.imdb_score);
			System.out.println("Director name :" + a.data.MD.name);
			System.out.println("Genre,s are :" + a.data.genre);
			System.out.println("Actors Are :");
			a.data.MA.VoidnamePrint();
			System.out.println(" ");
			printINorder(a.right);
		}
	}

}
