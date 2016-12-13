//----------------------------------------------------------
//Laboratory 05
//UnboundedQueue.java
//Manuel Madrigal Valenzuela
//February 26, 2015
//----------------------------------------------------------

//
//This generic class allow us to create an Unbounded Queue, which is implemented
//on an underlying memory structure of a LinkedList
//To create the LinkedList, I used the LinkedLiStNode generic class of Lab2
//
public class UnboundedQueue<Type> implements UnboundedQueueInterface<Type>{
	private LinkedListNode<Type> front,rear,aux;
	
	
	//
	//Constructor for the UnboundedQueue
	//
	public UnboundedQueue(){
		this.front=null;
		this.rear=null;
		this.aux=null;
	}
	
	//
	// Throws QueueUnderflowException if this queue is empty,
	// otherwise removes front element from this queue and returns it.
	//pre:none
	//post:An element is removed from the queue or an exception is thrown
	//
	public Type dequeue() throws QueueUnderflowException {
		if(this.isEmpty()){
			throw new QueueUnderflowException();
		}else{
			this.aux=this.front;
			this.front=this.front.getLink();
			return this.aux.getInfo();
		}

	}

	//
	// Returns true if this queue is empty, otherwise returns false.
	//pre:none
	//post:	none
	//
	public boolean isEmpty() {
		if(this.front==null){
			return true;
		}else{
			return false;
		}
	}
	
	//
	// Adds element to the rear of this queue.
	//pre:the parameter has to be the same data type as the queue
	//post:An element is added to the rear of the queue
	//
	public void enqueue(Type element) {
		if(this.front==null){
			this.front=new LinkedListNode<Type>(element);
			this.rear=this.front;
		}else{
			this.aux=new LinkedListNode<Type>(element);
			this.rear.setLink(this.aux);
			this.rear=this.aux;
		}
		
	}

}
