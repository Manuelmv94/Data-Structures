//----------------------------------------------------------
//Laboratory 03
//DriverProgramUnbounded.java
//Manuel Madrigal Valenzuela
//February 5, 2015
//----------------------------------------------------------

import java.util.Scanner;

//
//This class contains a driver program to test the Unbounded stack
//The user can fill the stack from the console,and as it can't get completely filled
//The user has to enter a blank space to get the stack back
//the stack is printed in opposite order as it was introduced
//printing from top to bottom
//
public class DriverProgramUnbounded {

	public static void main(String[] args) {
		UnboundedStack<String> stack=new UnboundedStack<String>();
		System.out.println("You are free to start filling the Unbounded stack\n"
				+ "enter a blank space to stop filling it");
		String nextLine="";
		Scanner sc=new Scanner(System.in);
		do{
			nextLine=sc.nextLine();
			if(!(nextLine.isEmpty())){
				stack.push(nextLine);
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
