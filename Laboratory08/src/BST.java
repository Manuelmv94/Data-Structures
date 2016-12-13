//----------------------------------------------------------
//Laboratory 08
//BST.java
//Manuel Madrigal Valenzuela
//April 01,2016
//----------------------------------------------------------

//This generic class allow us to implement a generic Binary Search Tree
//We also use classes from previous laboratories such as Lists from lab 7 
//and Queues from lab 5
public class BST<T extends Comparable<T>> implements BSTInterface<T> {

	protected BSTNode<T> root;
	protected boolean found;
	protected UnboundedQueue<T> 	inOrderQueue,
									preOrderQueue,
									postOrderQueue;
	CircularDoublyLinkedList<T>     balanceList;
	
	
	//
	//Constructor by default of our Binary Search Tree
	//pre: none
	//post:none
	public BST(){
		this.root=null;
	} 

	//
	//Returns true if this BST is empty: otherwise returns false.
	//pre: none
	//post:none
	public boolean isEmpty() {
		return(this.root==null);
	}

	//
	//Returns the number of elements on the Node
	//pre: none
	//post:none
	private int recSize(BSTNode<T> Node){
		if(Node==null){
			return 0;
		}else{
			return this.recSize(Node.getLeft())+this.recSize(Node.getRight())+1;
		}
	}
	
	//
	//Returns the number of elements on this BST.
	//pre: none
	//post:none
	public int size() {
		return this.recSize(this.root);
	}
	
	//
	//Returns true if the Node contains an element e such that
	//e.compareTo(element)==0; otherwise, returns false.	
	//pre: none
	//post:none
	private boolean recContains(T element,BSTNode<T> Node){
		if(Node==null){
			return false;
		}
		else if(element.compareTo(Node.getInfo())<0){
			return this.recContains(element,Node.getLeft());
		}
		else if(element.compareTo(Node.getInfo())>0){
			return this.recContains(element,Node.getRight());
		}else{
			return true;
		}
	}
	
	//
	//Returns true if this BST contains an element e such that
	//e.compareTo(element)==0; otherwise, returns false.	
	//pre: none
	//post:none
	public boolean contains(T element) {
		return this.recContains(element, this.root);
	}

	//
	//Returns an element e from the Node such that e.compareTo(element)==0;
	//if no such element exists, returns null;
	//pre: none
	//post:none
	private T recGet(T element, BSTNode<T> Node){
		if(Node==null){
			return null;
		}
		else if(element.compareTo(Node.getInfo())<0){
			return this.recGet(element, Node.getLeft());
		}
		else if(element.compareTo(Node.getInfo())>0){
			return this.recGet(element, Node.getRight());
		}else{
			return Node.getInfo();
		}
	}
	
	//
	//Returns an element e from this BST such that e.compareTo(element)==0;
	//if no such element exists, returns null;
	//pre: none
	//post:none
	public T get(T element) {
		return this.recGet(element, this.root);
	}

	//Removes an element e from Node such that e.compareTo(element)==0
	//and returns true; if no such element exists, returns false.
	//pre: none
	//post:It modifies found, depending whether the element was found or not
	private BSTNode<T> recRemove(T element, BSTNode<T> Node){
		if(Node==null){
			found=false;
		}
		else if(element.compareTo(Node.getInfo())<0){
			Node.setLeft(this.recRemove(element, Node.getLeft()));
		}
		else if(element.compareTo(Node.getInfo())>0){
			Node.setRight(this.recRemove(element, Node.getRight()));
		}
		else{
			Node=this.removeNode(Node);
			found=true;
		}
		return Node; 
	}
	 
	//
	//Removes the information at the node referenced by Node
	//The user's data in the node referenced by Node is no
	//longer in the tree. If Node is a leaf node or has only
	//a non-null child pointer, the node pointed to by Node is
	//removed; otherwise, the user's data is replaced by its 
	//logical predecessor and the predecessor's node is removed.
	//pre: the element was found
	//post:The element is removed from the BST
	private BSTNode<T> removeNode(BSTNode<T> Node){
		T data;
		
		if(Node.getLeft()==null){
			return Node.getRight();
		}
		else if(Node.getRight()==null){
			return Node.getLeft();
		}
		else{
			data=this.getPredecessor(Node.getLeft());
			Node.setInfo(data);
			Node.setLeft(this.recRemove(data, Node.getLeft()));
			return Node;
		}
	}
	
	//
	//Returns the information held in the rightmost node in the tree
	//pre: the element to be removed was found
	//post:none
	private T getPredecessor(BSTNode<T> Node){
		while(Node.getRight()!=null){
			Node=Node.getRight();
		}
		return Node.getInfo();
	}
	
	//
	//Removes an element e from this BST such that e.compareTo(element)==0
	//and returns true; if no such element exists, returns false.
	//pre: none
	//post:The element is removed if found
	public boolean remove(T element) {
		this.root=this.recRemove(element, this.root);
		return found;
	}

	//
	//Adds element to this Node. The tree retains its BST property
	//pre: none
	//post:the element is added in the right possition
	private BSTNode<T> recAdd(T element,BSTNode<T> Node){
		if(Node==null){
			Node=new BSTNode<T>(element);
		}
		else if(element.compareTo(Node.getInfo())<=0){
			Node.setLeft(this.recAdd(element, Node.getLeft()));
		}
		else{
			Node.setRight(this.recAdd(element, Node.getRight()));
		}
		return Node;
	}

	//
	//Adds element to this BST. The tree retains its BST property
	//pre: none
	//post:An element is added to the BST
	public void add(T element) {
		this.root=this.recAdd(element, this.root);
		
	}

	//
	//initializes inOrderQueue with tree elements in inOrder order
	//pre: none
	//post:a Queue is filled with the elements of the tree in inOrder order
	private void inOrder(BSTNode<T> Node){
		if(Node!=null){
			this.inOrder(Node.getLeft());
			this.inOrderQueue.enqueue(Node.getInfo());
			this.inOrder(Node.getRight());
		}
	}
	
	//
	//initializes preOrderQueue with tree elements in preOrder order
	//pre: none
	//post:a Queue is filled with the elements of the tree in preOrder order
	private void preOrder(BSTNode<T> Node){
		if(Node!=null){
			this.preOrderQueue.enqueue(Node.getInfo());
			this.preOrder(Node.getLeft());
			this.preOrder(Node.getRight());
		}
	}
	
	//
	//initializes postOrderQueue with tree elements in postOrder order
	//pre: none
	//post:a Queue is filled with the elements of the tree in postOrder order
	private void postOrder(BSTNode<T> Node){
		if(Node!=null){
			this.postOrder(Node.getLeft());
			this.postOrder(Node.getRight());
			this.postOrderQueue.enqueue(Node.getInfo());
		}
	}
	
	//
	//Initializes current position for an iteration through this BST
	//in order Type order. Returns current number of nodes in the BST
	//pre: none
	//post: A queue is initialized and ready to be traversed
	public int reset(int orderType) {
		
		if(orderType==INORDER){
			inOrderQueue=new UnboundedQueue<T>();
			this.inOrder(this.root);
		}
		else if(orderType==PREORDER){
			preOrderQueue=new UnboundedQueue<T>();
			this.preOrder(this.root);
		}
		else if(orderType==POSTORDER){
			postOrderQueue=new UnboundedQueue<T>();
			this.postOrder(this.root);
		}
		
		return this.size();
	}

	//
	//Preconditions: 
	//					The BST has been reset for orderType
	//					The BST has not been modified since the most recent reset
	//					
	//Returns the element at the current position on this BST for orderType
	//and advances the value of the current position based on the orderTpe
	public T getNext(int orderType) {
		if(orderType==PREORDER){
			try {
				return this.preOrderQueue.dequeue();
			} catch (QueueUnderflowException e) {
				System.out.println(e);
				return null;
			}
		}
		else if(orderType==INORDER){
			try {
				return this.inOrderQueue.dequeue();
			} catch (QueueUnderflowException e) {
				System.out.println(e);
				return null;
			}
		}
		else if(orderType==POSTORDER){
			try {
				return this.postOrderQueue.dequeue();
			} catch (QueueUnderflowException e) {
				System.out.println(e);
				return null;
			}
		}else{
			return null;
		}
	}

	//Returns the number of levels on the Node
	//pre: none
	//post:none
	private int recLevels(BSTNode<T> Node){
		int leftLevels, rightLevels;
		
		if(Node==null){
			return 0;
		}
		else if(Node.getLeft()==null &&Node.getRight()==null){
			return 1;
		}else{
			leftLevels=1+this.recLevels(Node.getLeft());
			rightLevels=1+this.recLevels(Node.getRight());
			if(leftLevels<=rightLevels){
				return rightLevels;
			}else{
				return leftLevels;
			}
		}
	}
	
	//
	//Returns the number of levels on this BST
	//pre: none
	//post:none
	public int levels(){
		return this.recLevels(this.root);
	}
	
	//
	//Inserts the elements of the BST in a manner to reduce the number of levels of the BST
	//pre: none
	//post:an element is added to the tree in an efficiently manner
	private void insertTree(int low, int high) throws ListUnderflowException{
		balanceList.reset();
		if(low==high){
			for(int i=0;i<low;i++){
				if(i==low-1){
					this.add(balanceList.getNext());
				}
				else{
					balanceList.getNext();
				}
			}
			
		}
		else if((low+1)==high){
			for(int i=0;i<low;i++){
				if(i==low-1){
					this.add(balanceList.getNext());
				}
				else{
					balanceList.getNext();
				}
			}
			this.add(balanceList.getNext());
		}
		else{
			int mid=(low+high)/2;
			for(int i=0;i<mid;i++){
				if(i==mid-1){
					this.add(balanceList.getNext());
				}
				else{
					balanceList.getNext();
				}
			}
			this.insertTree(low, mid-1);
			this.insertTree(mid+1, high);
		}
	}
	
	//
	//Reduces the number of levels of the BST to the most efficiently manner
	//pre: none
	//post:The number of levels of the BST is efficiently reduced
	public int balance() throws QueueUnderflowException, ListUnderflowException{
		this.reset(INORDER);
		balanceList= new CircularDoublyLinkedList<T>();
		T data;
		int initialSize=this.size();
		
		for(int i=0;i<initialSize;i++){
			data=this.inOrderQueue.dequeue();
			balanceList.add(data);
			this.remove(data);
		}

		this.insertTree(1, initialSize);
		return this.levels();
		
				
	}
}
