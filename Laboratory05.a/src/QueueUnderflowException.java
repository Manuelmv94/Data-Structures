//----------------------------------------------------------
//Laboratory 05
//QueueUnderflowException.java
//Manuel Madrigal Valenzuela
//February 26, 2015
//----------------------------------------------------------

//
//This class is an exception thrown when you try to access an element from the queue
//but the queue is empty
//
public class QueueUnderflowException extends Exception {
	
	//
	//this is the default constructor of the exception
	//pre:none
	//post:none
	//
	public QueueUnderflowException(){
		super();
	}
	
	//
	//this is the constructor with a string parameter
	//which is showed when the exception is called
	//pre:the parameter has to be a string data type
	//post:none
	//
	public QueueUnderflowException(String message){
		super(message);
	}
}
