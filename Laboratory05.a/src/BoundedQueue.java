//----------------------------------------------------------
//Laboratory 05
//BoundedQueue.java
//Manuel Madrigal Valenzuela
//February 26, 2015
//----------------------------------------------------------

//
//This generic class allow us to create a Bounded Queue, which is implemented
//on an underlying memory that is an array
//
public class BoundedQueue<Type> implements BoundedQueueInterface<Type>{
	
	private int QueueSize;
	private Type[] BoundedQueue;
	private int front,rear;
	private int numElements;

	
	//
	//this is the constructor of the bounded queue, it receives an int parameter
	//which is going to be the size of the queue
	//pre:the parameter has to be a primitive data type "int";
	//post:The queue is initialized but it is empty
	//
	public BoundedQueue(int QueueSize){
		this.QueueSize=QueueSize;
		this.BoundedQueue=(Type[]) new Object[this.QueueSize];
		this.front=0;
		this.rear=this.front-1;
		this.numElements=0;
	}
	
	//
	// Throws QueueUnderflowException if this queue is empty,
	// otherwise removes front element from this queue and returns it.
	//pre:none
	//post:An element is removed from the queue or an exception is thrown
	//
	public Type dequeue() throws QueueUnderflowException {
		if(this.isEmpty()){
			throw new QueueUnderflowException("You can't dequeue any other element, it is already empty");
		}
		else{
			Type auxiliar=this.BoundedQueue[front];
			this.BoundedQueue[front]=null;
			this.front=(this.front+1)%this.QueueSize;
			this.numElements--;
			return auxiliar;
		}
	}
	
	//
	// Returns true if this queue is empty, otherwise returns false.
	//pre:none
	//post:	none
	//
	public boolean isEmpty() {
		if(this.numElements==0){
			return true;
		}else{
			return false;
		}
	}
	
	//
	// Throws QueueOverflowException if this queue is full,
	// otherwise adds element to the rear of this queue.
	//pre:none
	//post:Adds an element to the queue or an exception is thrown
	//
	public void enqueue(Type element) throws QueueOverflowException {
		if (this.isFull()){
			throw new QueueOverflowException("You can't add another element to the Queue, it is already full");
		}else{
			this.rear=(this.rear+1)%this.QueueSize;
			this.BoundedQueue[rear]=element;
			this.numElements++;
		}	
	}
	
	//
	// Returns true if this queue is full, otherwise returns false.
	//pre:none
	//post:none
	//
	public boolean isFull() {
		if(this.QueueSize==this.numElements){
			return true;
		}else{
			return false;
		}
	}

}
