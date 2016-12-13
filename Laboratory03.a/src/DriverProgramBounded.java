//----------------------------------------------------------
//Laboratory 03
//DriverProgramBounded.java
//Manuel Madrigal Valenzuela
//February 5, 2015
//----------------------------------------------------------

import java.util.Scanner;
//
//This class contains a driver program to test the bounded stack
//It creates a Stack with a predefined size
//The user can fill the stack from the console, and when the stack is full
//the stack is printed in opposite order as it was introduced
//printing from top to bottom
//The user can also get the stack without filling the whole stack by entering a blank space
//
public class DriverProgramBounded {

	public static void main(String[] args) {
		BoundedStack<String> stack=new BoundedStack<String>(7);
		System.out.println("You are free to start filling the stack\n"
				+ "enter a blank space to stop filling it");
		String nextLine="";
		Scanner sc=new Scanner(System.in);
		do{
			nextLine=sc.nextLine();
			if(!(nextLine.isEmpty())){
				try{
					stack.push(nextLine);
					if(stack.isFull()){
						System.out.println();
						while(!stack.isEmpty()){
							System.out.println(stack.pop());
						}
						sc.close();
						break;
					}
				}catch(StackOverflowException ex0){
					//do nothing
				}catch(StackUnderflowException ex1){
					//do nothing
				}
			}
		}while(!(nextLine.isEmpty()));
		
		try{
			if(stack.top()!=null){
				while(!stack.isEmpty()){
					System.out.println(stack.pop());
				}
			}
		}catch(StackUnderflowException ex){
			//do nothing
		}
		
		
	}
	

}
