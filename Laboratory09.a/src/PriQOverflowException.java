//----------------------------------------------------------
//Laboratory 09
//PriQOverflowException.java
//Manuel Madrigal Valenzuela
//April 15,2016
//----------------------------------------------------------


//
//This class is an exception thrown when you try to enqueue an element into the queue
//but it is already full
public class PriQOverflowException extends RuntimeException {
	
	//
	//this is the default constructor of the exception
	//pre:none
	//post:none
	public PriQOverflowException(){
		super();
	}
	
	//
	//this is the constructor with a string parameter
	//which is showed when the exception is called
	//pre:the parameter has to be a string data type
	//post:none
	public PriQOverflowException(String message){
		super(message);
	}
}
