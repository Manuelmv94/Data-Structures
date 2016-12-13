//----------------------------------------------------------
//Laboratory 09
//DriverProgram.java
//Manuel Madrigal Valenzuela
//April 15,2016
//----------------------------------------------------------

//This class is the driver program for the binary heap.
//It allows us to prove the functionality of the priority queue
public class DriverProgram {
	
	public static void main(String[] args){
		Heap<String> pQueue=new Heap<String>();
		
		System.out.println("Enqueue J");
		pQueue.enqueue("J");
		System.out.println(pQueue);
		
		System.out.println("Enqueue W");
		pQueue.enqueue("W");
		System.out.println(pQueue);
		
		System.out.println("Enqueue Y");
		pQueue.enqueue("Y");
		System.out.println(pQueue);
		
		System.out.println("Enqueue K");
		pQueue.enqueue("K");
		System.out.println(pQueue);
		
		System.out.println("Enqueue Q");
		pQueue.enqueue("Q");
		System.out.println(pQueue);
		
		System.out.println("Enqueue T");
		pQueue.enqueue("T");
		System.out.println(pQueue);
		
		System.out.println("Enqueue I");
		pQueue.enqueue("I");
		System.out.println(pQueue);
		
		System.out.println("Enqueue Z");
		pQueue.enqueue("Z");
		System.out.println(pQueue);
		
		//----------------
		
		System.out.println("Dequeue operation:");
		pQueue.dequeue();
		System.out.println(pQueue);
		
		System.out.println("Dequeue operation:");
		pQueue.dequeue();
		System.out.println(pQueue);
		
	}
}
