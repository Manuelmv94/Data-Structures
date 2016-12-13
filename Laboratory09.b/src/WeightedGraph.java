//----------------------------------------------------------
//Laboratory 09
//WeightedGraph.java
//Manuel Madrigal Valenzuela
//April 15,2016
//----------------------------------------------------------

//This class implements a Weighted Directional Graph stored internally
//in a Linked Adjacency List
public class WeightedGraph<T extends Object & Comparable<T>> implements WeightedGraphInterface<T> {
	private static final int NULL_EDGE=-1;
	private static final int DEFCAP=50;
	private int numVertices;
	private int maxVertices;
	private T[] vertices;
	private edgeNode[] edges;
	private boolean[] marks;
	
	//This is the constructor by default of our class
	//It initializes the Graph with a default size
	public WeightedGraph(){
		this.numVertices=0;
		this.maxVertices=this.DEFCAP;
		this.vertices=(T[]) new Object[DEFCAP];
		this.edges=new edgeNode[DEFCAP];
		this.marks=new boolean[DEFCAP];
	}
	
	//This is the constructor with parameters of our class
	//It initializes the Graph with a given size
	public WeightedGraph(int maxSize){
		this.numVertices=0;
		this.maxVertices=maxSize;
		this.vertices=(T[]) new Object[maxSize];
		this.edges=new edgeNode[maxSize];
		this.marks=new boolean[maxSize];
	}
	
	//
	// Returns true if this graph is empty; otherwise, returns false.
	//pre: none
	//post: none
	public boolean isEmpty() {
		return(this.numVertices==0);
	}

	//
	// Returns true if this graph is full; otherwise, returns false.
	//pre: none
	//post none
	public boolean isFull() {
		return(this.numVertices==this.maxVertices);
	}

	//
	// If the graph is not full and the vertex is not already on the graph, 
	//adds vertex to this graph, otherwise throws GraphOverflowException(if the case)
	//and just ignore the method call
	//pre:none
	//post:if the graph is not full and the vertex wasnt already in the graph,
	//	   a vertex is added to the graph
	public void addVertex(T vertex) throws GraphOverflowException {
		if(this.isFull()){
			throw new GraphOverflowException();
		}else{
			if (!this.hasVertex(vertex)){
				this.vertices[this.numVertices++]=vertex;
			}
		}
		
	}

	//
	// Returns true if this graph contains vertex; otherwise, returns false.
	//pre: none
	//post:none
	public boolean hasVertex(T vertex) {
		boolean found=false;
		for(int i=0;i<this.numVertices;i++){
			if(vertices[i].compareTo(vertex)==0){
				found=true;
				break;
			}
		}
		return found;
	}

	//
	//If vertexes exist, Adds an edge with the specified weight from fromVertex to toVertex.
	//otherwise, throws VertexNotFoundException
	//pre: none
	//post: if vertexes exist, an edge is created between 2 vertexes
	public void addEdge(T fromVertex, T toVertex, int weight) {
		int fromIndex=this.findVertex(fromVertex);
		int toIndex=this.findVertex(toVertex);
		edgeNode newEdge;
		
		if(fromIndex!=-1 && toIndex!=-1){
			newEdge= new edgeNode(toIndex,weight);
			newEdge.setLink(this.edges[fromIndex]);
			this.edges[fromIndex]=newEdge;
		}else{
			throw new VertexNotFoundException();
		}
		
	}

	//
	//If vertexes does not exist, throws VertexNotFoundException,otherwise
	// If edge from fromVertex to toVertex exists, returns the weight of edge;
	// otherwise, returns a special "null-edge" value.
	//pre: none
	//post: none
	public int weightIs(T fromVertex, T toVertex) {
		int fromIndex=this.findVertex(fromVertex);
		int toIndex=this.findVertex(toVertex);
		edgeNode actualNode;
		int weight=this.NULL_EDGE;
		
		if(fromIndex==-1 || toIndex==-1){
			throw new VertexNotFoundException();
		}else{
			actualNode=this.edges[fromIndex];
			while(actualNode!=null){
				if(actualNode.getIndex()==toIndex){
					weight=actualNode.getWeight();
					break;
				}else{
					actualNode=actualNode.getLink();
				}
			}
			return weight;
		}
	}
	
	//Returns the index of a given vertex
	//If the vertex is not on the graph, return -1
	//pre: none
	//post:none
	private int findVertex(T vertex){
		int found=-1;
		for(int i=0;i<this.numVertices;i++){
			if(this.vertices[i].compareTo(vertex)==0){
				found=i;
				break;
			}
		}
		return found;
	}
	
	//
	//If vertex does not exist, throws VertexNotFoundException, otherwise
	// Returns a queue of the vertices that are adjacent from vertex.
	//pre: none
	//post: none
	public UnboundedQueueInterface<T> getToVertices(T vertex) {
		UnboundedQueue<T> myQueue =new UnboundedQueue<T>();
		edgeNode actualNode;
		int fromIndex=this.findVertex(vertex);
		if(fromIndex==-1){
			throw new VertexNotFoundException();
		}else{
			actualNode=this.edges[fromIndex];
			while(actualNode!=null){
				myQueue.enqueue(this.vertices[actualNode.getIndex()]);
				actualNode=actualNode.getLink();
			}
			
			return myQueue;
		}
	}

	// Sets marks for all vertices to false.
	//pre:none
	//post: resets the marks array
	public void clearMarks() {
		for(int i=0;i<this.maxVertices;i++){
			this.marks[i]=false;
		}
		
	}
	
	//
	//If vertex does not exist, throws VertexNotFoundException, otherwise
	// Sets mark for vertex to true.
	//pre: none
	//post: the array slot of the marks array corresponding to the given vertex is marked
	public void markVertex(T vertex) {
		int index=this.findVertex(vertex);
		if(index==-1){
			throw new VertexNotFoundException();
		}else{
			this.marks[index]=true;
		}
		
	}
	
	//
	//If vertex does not exist, throws VertexNotFoundException, otherwise
	// Returns true if vertex is marked; otherwise, returns false.
	//pre: none
	//post: none
	public boolean isMarked(T vertex) {
		int index=this.findVertex(vertex);
		if(index==-1){
			throw new VertexNotFoundException();
		}else{
			return this.marks[index];
		}
	}
	//
	//If vertex does not exist, throws VertexNotFoundException, otherwise
	// Returns an unmarked vertex if any exist; otherwise, returns null.
	//pre: none
	//post:none
	public T getUnmarked() {
		T toReturn=null;
		for(int i=0;i<this.numVertices;i++){
			if(!this.marks[i]){
				toReturn=this.vertices[i];
				break;
			}
		}
		return toReturn;
	}

}
