//----------------------------------------------------------
//Laboratory 05
//DriverProgram.java
//Manuel Madrigal Valenzuela
//February 26, 2015
//----------------------------------------------------------

import java.util.Scanner;
//
//This class contains a driver program to test the bounded queue
//It creates a Queue with a predefined size
//The user can fill the queue from the console, and when the queue is full
//the queue is printed in the same order as it was introduced (FIFO)
//The user can also get the queue without filling the whole queue by entering a blank space
//
public class DriverProgram {

	public static void main(String[] args) {
		BoundedQueue<String> queue=new BoundedQueue<String>(7);
		
		System.out.println("You are free to start filling the queue\n"
				+ "enter a blank space to stop filling it");
		
		String nextLine="";
		Scanner sc=new Scanner(System.in);
		
		try{
			do{
				nextLine=sc.nextLine();
				if(!(nextLine.isEmpty())){
					queue.enqueue(nextLine);
				}
			}while(!(nextLine.isEmpty()));
		}catch(QueueOverflowException qOex){
			System.out.println(qOex);
		}finally{
			sc.close();
		}
		
		System.out.println();
		if(queue.isEmpty()){
			System.out.println("Your queue is empty");
		}else{
			System.out.println("Here is your Queue:");
		}
		
		try{
			while(!queue.isEmpty()){
				System.out.println(queue.dequeue());
			}
		}catch(QueueUnderflowException qUex){
			System.out.println(qUex);
		}
		
		
	}

}
