//Laboratory 01
//die.java
//Manuel Madrigal Valenzuela
//January 14, 2015

import java.util.Random;

//
//This class let us create a dice and roll it
//
public class die {
	private Random r;
	private int face;
	
	//
	//this is the constructor for the die class
	//pre:none
	//Attributes were initialized
	//
	public die(){
		r=new Random();
		this.face=this.r.nextInt(6)+1;
	}
	
	//
	//This method generates a random number between 1 and 6, as if we rolled the die
	//pre:none
	//post: the face attribute is changed
	//
	public void setFace(){
		this.face=this.r.nextInt(6)+1;
	}
	
	//
	// accessor for the face attribute
	//pre: none
	//post: none
	//
	public int getFace(){
		return this.face;
	}
	
}
