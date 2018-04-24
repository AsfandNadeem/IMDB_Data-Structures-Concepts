

public class DirectorAVLTree {
	private DirectorAVLNode loc;
	private DirectorAVLNode parent;
	public DirectorAVLNode root;
	private int n;

	public boolean isEmpty() {
		if (root == null)
			return true;
		else
			return false;
	}

	void insert(DirectorNode d, MovieNode m) {// insertion of director at an
												// index in
												// a tree and also
												// linking his/her movie list
		DirectorAVLNode newNode = new DirectorAVLNode();
		newNode.data = d;
		if (isEmpty()) {
			root = newNode;

		}

		else {
			loc = root;
			while (loc != null) {

				if (loc.data.name.equals(d.name))// if same director found
													// ,don't add
				{
					break;
				}

				if (loc.data.name.compareTo(d.name) > 0) {// comparing actors to
															// balance AVL tree
					parent = loc;
					loc = loc.left;
				} else if (loc.data.name.compareTo(d.name) < 0) {
					parent = loc;
					loc = loc.right;
				}

			}

			if (loc == null)// if new director is to be added
			{

				if (d.name.compareTo(parent.data.name) > 0) {
					parent.right = newNode;// comparing with parent and adding
											// to right having higher value
					newNode.data.DM.SearchandaddAtFront(m);// add movie to its
															// movie linked list

				} else if (d.name.compareTo(parent.data.name) < 0) {
					parent.left = newNode;// comparing with parent and adding to
											// left having higher value
					newNode.data.DM.SearchandaddAtFront(m);// add movie to its
															// movie linked list

				}
			} else {
				loc.data.DM.SearchandaddAtFront(m);// else same actor is found
													// already linked
													// add a movie to its
													// existing linked list
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

	}

	public void rightRotate(DirectorAVLNode node) {
		DirectorAVLNode x = new DirectorAVLNode();
		x = node;
		DirectorAVLNode y = new DirectorAVLNode();
		y = node.left;
		x.left = y.right;
		y.right = x;
		if (x == root) {
			root = y;
		}
		int result = this.Balancecheck(root);
		return;
	}

	public void leftRotate(DirectorAVLNode node) {
		DirectorAVLNode x = new DirectorAVLNode();
		x = node;
		DirectorAVLNode y = new DirectorAVLNode();
		y = node.right;
		x.right = y.left;
		y.left = x;
		root = y;
		int result = this.Balancecheck(root);
		return;
	}

	public int rightcheck(DirectorAVLNode node) {
		if (node == null) {
			return 0;
		}

		int left = rightcheck(node.left) + 1;
		int right = rightcheck(node.right) + 1;

		if (left > right) {
			return left;
		} else
			return right;
	}

	public int leftcheck(DirectorAVLNode node) {
		if (node == null) {
			return 0;
		}

		int left = leftcheck(node.left) + 1;
		int right = leftcheck(node.right) + 1;

		if (left > right) {
			return left;
		}

		else
			return right;
	}

	public int Balancecheck(DirectorAVLNode node) {
		int right = rightcheck(node.right) + 1;
		int left = leftcheck(node.left) + 1;
		int max = left - right;
		return max;
	}

	public void Delete(DirectorNode d) {
		loc = null;
		parent = null;
		loc = root;

		if (isEmpty() == true) {
			System.out.println("No tree exists");
		}

		else {
			while (loc != null && loc.data.name != d.name) {
				if (loc.data.name.compareTo(d.name) > 0) {
					parent = loc;
					loc = loc.left;
				} else if (loc.data.name.compareTo(d.name) < 0) {
					parent = loc;
					loc = loc.right;
				}
			}
			if (loc == null) {
				System.out.println(d + " is not found so can't be deleted");
			}

			else if (loc.data.name == d.name && loc != root) {
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
						DirectorAVLNode newP = null;
						DirectorAVLNode del = null;
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
						DirectorAVLNode newP = null;
						DirectorAVLNode del = null;
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

	public String SearchbyName(String d) {// searching director based on name as
											// tree is balanced so we are doing
											// it
											// iteratively
		loc = null;
		parent = null;
		loc = root;
		String c = null;

		if (isEmpty() == true) {
			c = "No tree exists";
		}

		else {
			while (loc != null && !loc.data.name.equalsIgnoreCase(d)) {
				if (loc.data.name.compareTo(d) >= 0) {
					loc = loc.left;
				} else {
					loc = loc.right;
				}
			}
			if (loc == null) {
				c = d + " is not found";
			} else {
				c = "Director is: " + loc.data.name + "\nMovie Are:" + loc.data.DM.moviesPrint();
			}

		}
		return c;
	}

	public void printINorder(DirectorAVLNode a) {// extra void method for
													// printing all

		if (a != null) {
			printINorder(a.left);
			System.out.println("Director is: " + a.data.name);
			System.out.println("Movie Are:");
			a.data.DM.VoidmoviesPrint();
			System.out.println(" ");
			printINorder(a.right);
		}
	}

}
