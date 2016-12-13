//----------------------------------------------------------
//Laboratory 09
//GraphOverflowException.java
//Manuel Madrigal Valenzuela
//April 15,2016
//----------------------------------------------------------

//
//This class is an exception thrown when you try to add a vertex into the graph
//but it is already full
public class GraphOverflowException extends Exception {
	
	//
	//this is the default constructor of the exception
	//pre:none
	//post:none
	public GraphOverflowException(){
		super();
	}
	
	//
	//this is the constructor with a string parameter
	//which is showed when the exception is called
	//pre:the parameter has to be a string data type
	//post:none
	public GraphOverflowException(String message){
		super(message);
	}
}
