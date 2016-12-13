//----------------------------------------------------------
//Laboratory 04
//Fibonacci.java
//Manuel Madrigal Valenzuela
//February 19, 2015
//----------------------------------------------------------

//This class allow us to create a method to get the position desired of the fibonacci's series
//The method can be implemented following two different paths: The recursive and the Non-Recursive
public class Fibonacci {
	//
	//this method implements fibonacci in a recursive way
	//It has to call itself until an initial condition is found
	//pre:none
	//post:the result of the fibonacci is returned until all 
	//	   the previous fibonnacci values are calculated
	//
	public long recursive (int n){
		if(n==0 || n==1){
			return n;
		}else{
			return this.recursive(n-2)+this.recursive(n-1);
		}
	}
	
	//
	//this method implements fibonacci in a non-recursive way
	//We just have to enter the value on a established formula, and the result is 
	//returned right away
	//pre:none
	//post:the result of the fibonacci is returned almost immediately
	//
	public long nonRecursive(int n){
		return (long)((1/Math.sqrt(5))*Math.pow((1+Math.sqrt(5))/2, n)-(1/Math.sqrt(5))*Math.pow((1-Math.sqrt(5))/2, n));
	}
	
	//
	//Here is my driven program
	//This allow us to contrast the differences between 
	//the Recursive and the Non-Recursive ways of implementing Fibonacci
	//
	public static void main(String[] args){
		Fibonacci fibonacci=new Fibonacci();
		double time0,timef,totalTime1,totalTime2;
		long recursiveFib,nonRecursiveFib;
		
		
		System.out.println("Number\t    Fibonacci Recursive\t\ttime\t    Fibonacci Non-Recursive\t\ttime ");
		for(int i=1;i<100;i++){
						
			time0=System.nanoTime();
			recursiveFib=fibonacci.recursive(i);
			timef=System.nanoTime();
			totalTime1=(timef-time0)/1000000000;
			
			time0=System.nanoTime();
			nonRecursiveFib=fibonacci.nonRecursive(i);
			timef=System.nanoTime();
			totalTime2=(timef-time0)/1000000000;
			
			System.out.printf("%6d %24d %16.8f %26d %20.8f",i,recursiveFib,totalTime1,nonRecursiveFib,totalTime2);
			System.out.println();
		}
	}
}
