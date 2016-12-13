//----------------------------------------------------------
//Laboratory 09
//WeightedGraphInterface.java
//Manuel Madrigal Valenzuela
//April 15,2016
//----------------------------------------------------------

//
// Interface for a class that implements a directed graph with weighted edges.
// Vertices are objects of class Type and can be marked as having been visited.
// Edge weights are integers.
// Based on: WeightedGraphInterface.java by Dale/Joyce/Weems Chapter 9
public interface WeightedGraphInterface<Type>{
	boolean isEmpty();
	// Returns true if this graph is empty; otherwise, returns false.
	
	boolean isFull();
	// Returns true if this graph is full; otherwise, returns false.
	
	void addVertex(Type vertex) throws GraphOverflowException;
	// If the graph is not full and the vertex is not already on the graph, 
	//adds vertex to this graph, otherwise throws GraphOverflowException(if the case)
	//and just ignore the method call
	
	boolean hasVertex(Type vertex);
	// Returns true if this graph contains vertex; otherwise, returns false.
	
	void addEdge(Type fromVertex, Type toVertex, int weight);
	//If vertexes exist, Adds an edge with the specified weight from fromVertex to toVertex.
	//otherwise, throws VertexNotFoundException
	
	int weightIs(Type fromVertex, Type toVertex);
	//If vertexes does not exist, throws VertexNotFoundException,otherwise
	// If edge from fromVertex to toVertex exists, returns the weight of edge;
	// otherwise, returns a special "null-edge" value.
	
	UnboundedQueueInterface<Type> getToVertices(Type vertex);
	//If vertex does not exist, throws VertexNotFoundException, otherwise
	// Returns a queue of the vertices that are adjacent from vertex.
	
	void clearMarks();
	// Sets marks for all vertices to false.
	
	void markVertex(Type vertex);
	//If vertex does not exist, throws VertexNotFoundException, otherwise
	// Sets mark for vertex to true.
	
	boolean isMarked(Type vertex);
	//If vertex does not exist, throws VertexNotFoundException, otherwise
	// Returns true if vertex is marked; otherwise, returns false.
	
	Type getUnmarked();
	// Returns an unmarked vertex if any exist; otherwise, returns null.
}