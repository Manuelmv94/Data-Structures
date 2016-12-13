//----------------------------------------------------------
//Laboratory 07
//ListUnderflowException.java
//Manuel Madrigal Valenzuela
//March 11, 2016
//----------------------------------------------------------
//
//This class is an exception thrown when you try to access an element from the List
//but the List is empty
//
public class ListUnderflowException extends Exception {

	//
	//this is the default constructor of the exception
	//pre:none
	//post:none
	//
	public ListUnderflowException(){
		super();
	}
		
	//
	//this is the constructor with a string parameter
	//which is showed when the exception is called
	//pre:the parameter has to be a string data type
	//post:none
	//
	public ListUnderflowException(String message){
		super(message);
	}

}
