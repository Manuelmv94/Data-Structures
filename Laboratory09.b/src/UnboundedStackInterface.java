//----------------------------------------------------------
//Laboratory 03
//UnboundedStackInterface.java
//Manuel Madrigal Valenzuela
//February 5, 2015
//----------------------------------------------------------

//
//This generic interface has specific methods that are going to be implemented on 
//the Unbounded stack
//
public interface UnboundedStackInterface<Type> extends StackInterface<Type>{
	
	void push(Type element);
	// places the object in the Stack at location Top 
}
