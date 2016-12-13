//----------------------------------------------------------
//Laboratory 10
//TestHarness.java
//Manuel Madrigal Valenzuela
//April 29,2016
//----------------------------------------------------------

import java.text.DecimalFormat;
import java.util.Random;

//This class is a stand-alone program designed to facilitate
//testing of the implementation of Sorting algorithms
public class TestHarness {
	final int DEF_SIZE=50;
	int SIZE;
	int[] values;
	
	//Constructor by default
	public TestHarness(){
		this.SIZE=DEF_SIZE;
		this.values=new int[this.SIZE];
		this.initValues();
	}
	
	//Constructor with parameters
	public TestHarness(int SIZE){
		this.SIZE=SIZE;
		this.values=new int[this.SIZE];
		this.initValues();
	}
	
	//
	// Initializes the values array with random integers from 0 to 99.
	//pre:none
	//post: values within the array are in random order
	public void initValues(){
		Random rand = new Random();
		for (int i=0;i<this.SIZE;i++){
			this.values[i]=Math.abs(rand.nextInt())%100;
		}
	}
	
	//
	// Returns true if the array values are sorted and false otherwise.
	//pre:none
	//post:none
	public boolean isSorted(){
		boolean sorted=true;
		for(int i=0;i<(this.SIZE-1);i++){
			if(this.values[i]>this.values[i+1]){
				sorted=false;
			}
		}
		return sorted;
	}
	
	//
	// Swaps the integers at locations index1 and index2 of the values array. 
	//pre: index1 and index2 are >= 0 and < SIZE.
	//post:two values of the array are swapped
	public void swap(int index1, int index2){
		int temp=this.values[index1];
		this.values[index1]=this.values[index2];
		this.values[index2]=temp;
	}
	
	//
	// Prints all the values integers.
	//pre:none
	//post:Values are shown on console
	public void printValues(){
		int value;
		DecimalFormat fmt=new DecimalFormat("00");
		System.out.println("The values array is:\n");
		for(int i=0;i<this.SIZE;i++){
			value=this.values[i];
			if(((i+1)%10)==0){
				System.out.println(fmt.format(value));
			}else{
				System.out.print(fmt.format(value)+" ");
			}
		}
		System.out.println();
	}
	
	//
	//returns the array of integers
	//pre:none
	//post:none
	public int[] getArray(){
		return this.values;
	}
	
	//
	//returns the size of the array
	//pre:none
	//post:none
	public int getSize(){
		return this.SIZE;
	}
	
	
	
	
	
	
	
	
}
