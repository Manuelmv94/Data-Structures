//----------------------------------------------------------
//Laboratory 09
//VertexNotFoundException.java
//Manuel Madrigal Valenzuela
//April 15,2016
//----------------------------------------------------------

//
//This class is an exception thrown when you try to add a vertex into the graph
//but it is already full
public class VertexNotFoundException extends RuntimeException {
	
	//
	//this is the default constructor of the exception
	//pre:none
	//post:none
	public VertexNotFoundException(){
		super();
	}
	
	//
	//this is the constructor with a string parameter
	//which is showed when the exception is called
	//pre:the parameter has to be a string data type
	//post:none
	public VertexNotFoundException(String message){
		super(message);
	}
}
