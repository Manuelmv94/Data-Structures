//----------------------------------------------------------
//Laboratory 07
//ListInterface.java
//Manuel Madrigal Valenzuela
//March 11, 2016
//----------------------------------------------------------

public interface ListInterface<Type>{
	
  int size();
  // Returns the number of elements on this list.
  void add(Type element);
  // Adds element to this list.
  boolean remove (Type element);
  // Removes an element e from this list such that e.equals(element)
  // and returns true; if no such element exists, returns false. 
  boolean contains (Type element);
  // Returns true if this list contains an element e such that 
  // e.equals(element); otherwise, returns false.
  Type get(Type element);
  // Returns an element e from this list such that e.equals(element);
  // if no such element exists, returns null.
  String toString();
  // Returns a nicely formatted string that represents this list.
  void reset();
  // Initializes current position for an iteration through this list,
  // to the first element on this list.
  Type getNext() throws ListUnderflowException;
  // Preconditions: The list is not empty
  //                The list has been reset
  // The list has not been modified since the most recent reset
  //
  // Returns the element at the current position on this list.
  // If the current position is the last element, then it advances the 
  // value of the current position to the first element; otherwise, it 
  // advances the value of the current position to the next element.
}