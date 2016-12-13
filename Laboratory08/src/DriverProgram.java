//----------------------------------------------------------
//Laboratory 08
//DriverProgram.java
//Manuel Madrigal Valenzuela
//April 01,2016
//----------------------------------------------------------

//
//This class allow us to test our Binary Search Tree, testing methods such as adding,
//removing, traversing and efficientating the number of levels of the BST
public class DriverProgram {
	
	public static void main(String[] args) {
		BST<String> tree=new BST<String>();
		
		tree.add("Song 01");
		tree.add("Song 02");
		tree.add("Song 03");
		tree.add("Song 04");
		tree.add("Song 12");
		tree.add("Song 08");
		tree.add("Song 05");
		tree.add("Song 14");
		tree.add("Song 17");
		tree.add("Song 21");
		tree.add("Song 19");
		tree.add("Song 15");
		tree.add("Song 22");
		tree.add("Song 24");
		tree.add("Song 07");
		tree.add("Song 06");
		tree.add("Song 16");
		tree.add("Song 13");
		tree.add("Song 20");
		tree.add("Song 18");
		tree.add("Song 09");
		tree.add("Song 11");
		tree.add("Song 10");
		tree.add("Song 23");
		
		
		System.out.println("There has been placed several strings in the BST simulating a playlist\n");
		
		System.out.println("This is the output of the BST with an INORDER traverse");
		System.out.println("There are "+tree.levels()+" levels in the BST");
		tree.reset(1);
		for(int i=0;i<tree.size();i++){
			System.out.println(tree.getNext(1));
		}
		
		System.out.println("\nThis is the output of the BST with an PREORDER traverse");
		System.out.println("There are "+tree.levels()+" levels in the BST");
		tree.reset(2);
		for(int i=0;i<tree.size();i++){
			System.out.println(tree.getNext(2));
		}
		
		System.out.println("\nThis is the output of the BST with an POSTORDER traverse");
		System.out.println("There are "+tree.levels()+" levels in the BST");
		tree.reset(3);
		for(int i=0;i<tree.size();i++){
			System.out.println(tree.getNext(3));
		}
		
		System.out.println("\nNow we remove some objects from the BST");
		tree.remove("Song 13"); 
		tree.remove("Song 14"); 
		tree.remove("Song 15"); 
		tree.remove("Song 16"); 
		tree.remove("Song 17"); 
		tree.remove("Song 18");
		tree.remove("Song 19"); 
		tree.remove("Song 20");
		tree.remove("Song 21"); 
		
		System.out.println("\nHere is again the output of the BST with an INORDER traverse");
		System.out.println("There are "+tree.levels()+" levels in the BST");
		tree.reset(1);
		for(int i=0;i<tree.size();i++){
			System.out.println(tree.getNext(1));
		}
		
		System.out.println("\nWe add the objects we removed and noticed that the number of levels is very inefficient");
		tree.add("Song 13");
		tree.add("Song 14");
		tree.add("Song 15");
		tree.add("Song 16");
		tree.add("Song 17");
		tree.add("Song 18");
		tree.add("Song 19");
		tree.add("Song 20");
		tree.add("Song 21");

		System.out.println("\nHere is again the output of the BST with an INORDER traverse");
		System.out.println("There are "+tree.levels()+" levels in the BST");
		tree.reset(1);
		for(int i=0;i<tree.size();i++){
			System.out.println(tree.getNext(1));
		}
		
		System.out.println("\nNow we perform the balance method and observe that the number of levels has decreased");
		
		try {
			tree.balance();
		} catch (QueueUnderflowException e) {
		} catch (ListUnderflowException e) 	{}
		
		System.out.println("\nHere is again the output of the BST with an INORDER traverse");
		System.out.println("There are "+tree.levels()+" levels in the BST");
		tree.reset(1);
		for(int i=0;i<tree.size();i++){
			System.out.println(tree.getNext(1));
		}

		System.out.println("The BST has been efficiently reordered leaving only "+tree.levels()+" levels");
		
	}

}
