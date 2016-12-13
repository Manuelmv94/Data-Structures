//----------------------------------------------------------
//Laboratory 05
//DriverProgram.java
//Manuel Madrigal Valenzuela
//February 26, 2015
//----------------------------------------------------------

import java.util.Scanner;

//
//This class contains a driver program to test the Unbounded Queue
//The user can fill the queue from the console,and as it can't get completely filled
//The user has to enter a blank space to get the queue back
//the queue is printed in the same order as it was introduced (FIFO)
//
public class DriverProgramUnbounded {

	public static void main(String[] args) {
		UnboundedQueue<String> queue=new UnboundedQueue<String>();
		
		System.out.println("You are free to start filling the queue\n"
				+ "enter a blank space to stop filling it");
		
		String nextLine="";
		Scanner sc=new Scanner(System.in);
		
		do{
			nextLine=sc.nextLine();
			if(!(nextLine.isEmpty())){
				queue.enqueue(nextLine);
			}
		}while(!(nextLine.isEmpty()));

		sc.close();

		
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
