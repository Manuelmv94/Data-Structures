//----------------------------------------------------------
//Laboratory 03
//UnboundedStack.java
//Manuel Madrigal Valenzuela
//February 5, 2015
//----------------------------------------------------------

//
//This generic class allow us to create an Unbounded stack, which is implemented
//on an underlying memory structure of a LinkedList
//To create the LinkedList, I used the LinkedLiStNode generic class of Lab2
//
public class UnboundedStack<Type> implements UnboundedStackInterface<Type> {
	private LinkedListNode<Type> top,next;
	
	//
	//Constructor for the UnboundedStack
	//
	public UnboundedStack(){
		this.top=null;
		this.next=null;
	}
	
	//
	// throws StackUnderflowException if the stack is empty
	// otherwise removes and returns the object at location Top
	//pre:none
	//post:the top element is removed from the stack, if there is any
	//
	public Type pop() throws StackUnderflowException {
		if(this.top!=null){
			LinkedListNode<Type> aux=this.top;
			this.next=this.top.getLink();
			this.top=this.next;
			return aux.getInfo();
		}else{
			throw new StackUnderflowException();
		}
	}

	//
	// throws StackUnderflowException if the stack is empty
	// otherwise returns the object at location Top
	//pre:none
	//post:none
	//
	public Type top() throws StackUnderflowException {
		if(this.top!=null){
			return this.top.getInfo();
		}else{
			throw new StackUnderflowException();
		}
	}

	//
	// returns True if the stack is empty; otherwise returns False
	//pre:none
	//post:none
	//
	public boolean isEmpty() {
		if(this.top==null){
			return true;
		}else{
			return false;
		}
	}

	//
	// places the object in the Stack at location Top 
	//pre:none
	//post:A new element is placed on the Unbounded stack
	//
	public void push(Type element) {
		this.next=new LinkedListNode<Type>(element);
		if(!this.isEmpty()){
			this.next.setLink(this.top);
		}
		this.top=this.next;	
	}

}
