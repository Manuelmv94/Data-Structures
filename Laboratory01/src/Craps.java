//Laboratory 01
//Craps.java
//Manuel Madrigal Valenzuela
//January 14, 2015

//
//This class implements the logic of a  a dice game known as craps
//
public class Craps {
	private die dice1;
	private die dice2;
	private int face1;
	private int face2;
	private int sum;
	private int n;
	private int point;
	private enum Status{
		WON, LOST, CONTINUE
	};
	private Status S;
	private static final String[][] calls={
			{"SNAKE EYES","ACE DEUCE","EASY FOUR","FEVER FIVE","EASY SIX","SEVEN OUT"},
			{"ACE DEUCE","HARD FOUR","FEVER FIVE","EASY SIX","SEVEN OUT","EASY EIGHT"},
			{"EASY FOUR","FEVER FIVE","HARD SIX","SEVEN OUT","EASY EIGHT","NINA"},
			{"FEVER FIVE","EASY SIX","SEVEN OUT","HARD EIGHT","NINA","EASY TEN"},
			{"EASY SIX","SEVEN OUT","EASY EIGHT","NINA","HARD TEN","YO-LEVEN"},
			{"SEVEN OUT","EASY EIGHT","NINA","EASY TEN","YO-LEVEN","BOXCARS"}
	};
	
	//
	//This method is the constructor for the Craps class
	//pre: none
	//post: attributes are initialized
	//
	public Craps(){
		this.dice1=new die();
		this.dice2=new die();
		this.face1=this.dice1.getFace();
		this.face2=this.dice2.getFace();
		sum=this.face1+this.face2;
		n=1;
		System.out.println("Player rolled: "+this.face1+" + "+this.face2+" = "+this.sum+"   "+this.calls[this.face1-1][this.face2-1]+"!");
		this.selecStatus();
		if(S==Status.CONTINUE){
			System.out.println("Your Point is "+this.point);
		}

	}
	
	//
	//This method selects the status of the game to check if you keep playing
	//pre: The dice are rolled
	//post: The status if selected 
	//
	public void selecStatus(){
		if(n==1){
			if(sum==7 || sum==11){
				S=Status.WON;
			}else if(sum==2 || sum==3 || sum==12){
				S=Status.LOST;
			}else{
				S=Status.CONTINUE;
				this.point=this.sum;
			}
		}else{
			if(sum==7){
				S=Status.LOST;
			}else if(sum==point){
				S=Status.WON;
			}else{
				S=Status.CONTINUE;
			}
		}
	}
	
	//
	//This method prints the result of the game after it is over
	//pre: the game status is not CONTINUE
	//post: the result is showed to the user
	//
	public void result(){
		if(S==Status.WON){
			System.out.println("You win");
		}else{
			System.out.println("You lose");
		}
	}
	
	//
	//this method keeps rolling the dices until the player wins or loses
	//pre:attributes were initialized
	//post:The game is over and the result is showed to the user
	//
	public void start(){
		while(S==Status.CONTINUE){
			this.dice1.setFace();
			this.dice2.setFace();
			this.face1=this.dice1.getFace();
			this.face2=this.dice2.getFace();
			sum=this.face1+this.face2;
			n++;
			System.out.println("Player rolled: "+this.face1+" + "+this.face2+" = "+this.sum+"   "+this.calls[this.face1-1][this.face2-1]+"!");
			this.selecStatus();
		}
		this.result();
	}
		
	//
	// this method allow us to test the program
	//
	public static void main(String[] args) {
		Craps game=new Craps();
		game.start();
	}

}
