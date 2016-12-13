//----------------------------------------------------------
//Laboratory 02
//Card.java
//Manuel Madrigal Valenzuela
//January 29, 2015
//----------------------------------------------------------

//
//This class let the user create a typical playing Card from a deck, with 52 possibilities
//
public class Card implements Comparable<Card> {
	private int rank;
	private int suit;
	private static final String[] rankString={"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
	private static final String[] suitString={"Clubs","Diamonds","Hearts","Spades"};
	
	//
	//This method is the constructor for the Card class
	//pre: none
	//post: attributes are initialized with certain restrictions, because not all numbers are valid
	//
	public Card(int rank,int suit){
		if(rank>0 && rank<14){
			this.rank=rank;
		}else{
			System.out.println("Rank of card is outside the boundries");
		}
		if(suit>0 && suit<5){
			this.suit=suit;
		}else{
			System.out.println("Suit of card is out of boundries");
		}
		
	}
	
	
	//
	//getter for the rank attribute of the card
	//pre: none
	//post: none
	//
	public int getRank(){
		return this.rank;
	}
	
	//
	//getter for the Suit attribute of the card
	//pre: none
	//post: none
	//
	public int getSuit(){
		return this.suit;
	}
	
	
	//
	//This method let the user visualize the content of the Card object 
	//pre: none
	//post: none
	//
	public String toString(){
		return this.rankString[this.rank-1]+" of "+this.suitString[this.suit-1];
		
	}


	@Override
	public int compareTo(Card card) {
		if(this.suit<card.suit){
			return -1;
		}else if(this.suit>card.suit){
			return 1;
		}else{
			if(this.rank<card.rank){
				return -1;
			}
			else if(this.rank>card.rank){
				return 1;
			}else{
				return 0;
			}
		}
	}

}
