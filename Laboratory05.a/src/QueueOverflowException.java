//----------------------------------------------------------
//Laboratory 05
//QueueOverflowException.java
//Manuel Madrigal Valenzuela
//February 26, 2015
//----------------------------------------------------------

//
//This class is an exception thrown when you try to enqueue an element into the queue
//but it is already full
//
public class QueueOverflowException extends Exception {
	
	//
	//this is the default constructor of the exception
	//pre:none
	//post:none
	//
	public QueueOverflowException(){
		super();
	}
	
	//
	//this is the constructor with a string parameter
	//which is showed when the exception is called
	//pre:the parameter has to be a string data type
	//post:none
	//
	public QueueOverflowException(String message){
		super(message);
	}
}
