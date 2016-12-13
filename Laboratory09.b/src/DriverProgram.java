//----------------------------------------------------------
//Laboratory 09
//DriverProgram.java
//Manuel Madrigal Valenzuela
//April 15,2016
//----------------------------------------------------------

//This class allow us to test the functionality of our Weighted Directional Graph
public class DriverProgram {
	//
	//Returns true if a path exists on graph, from startVertex to endVertex
	//otherwise, returns false. Uses depth-first search algorithm
	public static <T extends Comparable<T>> boolean isPath(WeightedGraphInterface<T> graph,T startVertex, T endVertex){
		boolean found=false;
		UnboundedStack<T> myStack=new UnboundedStack<T>();
		UnboundedQueue<T> myQueue;
		T vertex;

		graph.clearMarks();
		myStack.push(startVertex);
		do{
			vertex=myStack.top();
			System.out.println(startVertex+" has a path to "+vertex);
			myStack.pop();
			if(vertex.compareTo(endVertex)==0){
				found=true;
			}else{
				graph.markVertex(vertex);
				myQueue=(UnboundedQueue<T>) graph.getToVertices(vertex);
				try {
					while(!myQueue.isEmpty()){
						T newVertex=myQueue.dequeue();
						if(!graph.isMarked(newVertex)){
							myStack.push(newVertex);
						}
					}
				} catch (QueueUnderflowException e) {}
			}
		}while(!myStack.isEmpty() && !found);

		return found;
	}

	//
	//Returns true if a path exists on graph, from startVertex to endVertex
	//otherwise, returns false. Uses breadth-first search algorithm
	public static <T extends Comparable<T>> boolean isPath2(WeightedGraphInterface<T> graph,T startVertex, T endVertex){
		boolean found=false;
		UnboundedQueue<T> externalQueue=new UnboundedQueue<T>();
		UnboundedQueue<T> myQueue;
		T vertex;

		graph.clearMarks();
		externalQueue.enqueue(startVertex);
		do{
			try {
				vertex=externalQueue.dequeue();
				System.out.println(startVertex+" has a path to "+vertex);
				if(vertex.compareTo(endVertex)==0){
					found=true;
				}else{
					graph.markVertex(vertex);
					myQueue=(UnboundedQueue<T>) graph.getToVertices(vertex);
					try {
						while(!myQueue.isEmpty()){
							T newVertex=myQueue.dequeue();
							if(!graph.isMarked(newVertex)){
								externalQueue.enqueue(newVertex);
							}
						}
					} catch (QueueUnderflowException e) {}
				}
			} catch (QueueUnderflowException e1) {}
		}while(!externalQueue.isEmpty() && !found);

		return found;
	}

	public static void main(String[] args){
		WeightedGraph<String> airport =new WeightedGraph<String>(8);

		if(airport.isEmpty()){
			System.out.println("The Weighted Directional graph is empty");
		}
		try {


			airport.addVertex("Culiacán");
			if(airport.hasVertex("Culiacán")){
				System.out.println("A vertex has been added: Culiacán");
			}

			airport.addVertex("Guadalajara");
			if(airport.hasVertex("Guadalajara")){
				System.out.println("A vertex has been added: Guadalajara");
			}
			airport.addVertex("Monterrey");
			if(airport.hasVertex("Monterrey")){
				System.out.println("A vertex has been added: Monterrey");
			}
			airport.addVertex("DF");
			if(airport.hasVertex("DF")){
				System.out.println("A vertex has been added: DF");
			}
			airport.addVertex("Hermosillo");
			if(airport.hasVertex("Hermosillo")){
				System.out.println("A vertex has been added: Hermosillo");
			}
			airport.addVertex("Zacatecas");
			if(airport.hasVertex("Zacatecas")){
				System.out.println("A vertex has been added: Zacatecas");
			}
			airport.addVertex("Puerto Vallarta");
			if(airport.hasVertex("Puerto Vallarta")){
				System.out.println("A vertex has been added: Puerto Vallarta");
			}
			airport.addVertex("Cancún");
			if(airport.hasVertex("Cancún")){
				System.out.println("A vertex has been added: Cancún");
			}
			airport.addVertex("Zapopan");
			if(airport.hasVertex("Zapopan")){
				System.out.println("A vertex has been added: Zapopan");
			}
		} catch (GraphOverflowException e) {
			System.out.println("The graph is full, you can't add a new vertex");
		}

		System.out.println();


		airport.addEdge("Culiacán", "Guadalajara", 688);
		System.out.println("An edge has been added from Culiacán to Guadalajara");
		System.out.println("\tThe distance between them is: "+airport.weightIs("Culiacán", "Guadalajara")+" km");

		airport.addEdge("Guadalajara", "Monterrey", 793);
		System.out.println("An edge has been added from Guadalajara to Monterrey");
		System.out.println("\tThe distance between them is: "+airport.weightIs("Guadalajara", "Monterrey")+" km");

		airport.addEdge("Monterrey", "Zacatecas", 462);
		System.out.println("An edge has been added from Monterrey to Zacatecas");
		System.out.println("\tThe distance between them is: "+airport.weightIs("Monterrey", "Zacatecas")+" km");

		airport.addEdge("Zacatecas", "Hermosillo", 1412);
		System.out.println("An edge has been added from Zacatecas to Hermosillo");
		System.out.println("\tThe distance between them is: "+airport.weightIs("Zacatecas", "Hermosillo")+" km");

		airport.addEdge("DF", "Hermosillo", 622);
		System.out.println("An edge has been added from DF to Hermosillo");
		System.out.println("\tThe distance between them is: "+airport.weightIs("DF", "Hermosillo")+" km");

		airport.addEdge("DF", "Guadalajara", 549);
		System.out.println("An edge has been added from DF to Guadalajara");
		System.out.println("\tThe distance between them is: "+airport.weightIs("DF", "Guadalajara")+" km");

		airport.addEdge("Hermosillo", "Puerto Vallarta", 1308);
		System.out.println("An edge has been added from Hermosillo to Puerto Vallarta");
		System.out.println("\tThe distance between them is: "+airport.weightIs("Hermosillo", "Puerto Vallarta")+" km");

		airport.addEdge("Cancún", "Monterrey", 2309);
		System.out.println("An edge has been added from Cncún to Monterrey");
		System.out.println("\tThe distance between them is: "+airport.weightIs("Cancún", "Monterrey")+" km");

		airport.addEdge("Culiacán", "Puerto Vallarta", 644);
		System.out.println("An edge has been added from Culiacán to Puerto Vallarta");
		System.out.println("\tThe distance between them is: "+airport.weightIs("Culiacán", "Puerto Vallarta")+" km");

		airport.addEdge("Puerto Vallarta", "Cancún", 2475);
		System.out.println("An edge has been added from Puerto Vallarta to Cancún");
		System.out.println("\tThe distance between them is: "+airport.weightIs("Puerto Vallarta", "Cancún")+" km");


		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("If we trie to add an edge between vertexes and one of them does not exist, an exception appears");
		System.out.println("For example if we trie to add an edge from Guadalajara to Zapopan");
		System.out.println("Zapopoan is not on the graph...");
		try{
			airport.addEdge("Guadalajara", "Zapopan", 12);
		}catch(VertexNotFoundException ex){
			ex.printStackTrace();
		}
		System.out.println();
		System.out.println();
		System.out.println("Lets use the depth-first search to find if there is a path from DF to Culiacán");
		if(isPath(airport,"DF","Culiacan")){
			System.out.println("A path exists from DF to Culiacán");
		}else{
			System.out.println("There is not a path from DF to Culiacán");
		}
		System.out.println();
		System.out.println("Lets use the breadth-first search to find if there is a path from DF to Monterrey");
		if(isPath2(airport,"DF","Monterrey")){
			System.out.println("A path exists from DF to Monterrey");
		}else{
			System.out.println("There is not a path from DF to Monterrey");
		}
	}
}
