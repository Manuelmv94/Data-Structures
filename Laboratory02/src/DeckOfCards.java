//----------------------------------------------------------
//Laboratory 02
//DeckOfCards.java
//Manuel Madrigal Valenzuela
//January 29, 2015
//----------------------------------------------------------

import java.util.Random;
//
//This class let the user create an entire deck of cards and manipulate it 
//
public class DeckOfCards implements DeckOfCardsInterface {
	private Card[] Deck;
	private int cardsLeft;
	private int deal;
	private Random rdm;
	
	
	//
	//This method is the constructor for the DeckOfCards Class
	//pre: none
	//post: attributes are initialized, creating a deck of cards in order
	//
	public DeckOfCards(){
		this.Deck=new Card[52];
		cardsLeft=0; 
		
		for(int i=1;i<5;i++){
			for(int j=1;j<14;j++){
				this.Deck[cardsLeft++]=new Card(j,i);
			}
		}
		
		rdm=new Random();
		this.deal=0;
	}
	
	//
	// shuffles the deck of cards and resets the deal to the beginning of the deck
	//pre: none
	//post: cards are placed randomly on the Deck array
	//
	public void shuffle() {
		Card aux;
		int randomPosition=0;
		
		for (int i=0;i<this.cardsLeft;i++){
			randomPosition=this.rdm.nextInt(this.cardsLeft);
			aux=this.Deck[i];
			this.Deck[i]=this.Deck[randomPosition];
			this.Deck[randomPosition]=aux;
		}
		
		this.deal=0;
		
	}

	//
	// Returns the number of cards that haven't been dealt yet
	//pre: none
	//post:none
	//
	public int cardsLeft() {
		return this.cardsLeft;
	}

	//
	// Deals the next Card. If all cards dealt, starts a new shuffled deck
	//pre: none
	//post:Gives a Card to the next player
	//
	public Card dealCard() {
		Card cardToReturn=this.Deck[this.deal++];
		this.cardsLeft--;
		if(this.deal>51){
			this.cardsLeft=52;
			this.shuffle();
			
		}
		return cardToReturn;
	}
	
	//
	// Returns a string representation of the Deck of Cards
	//pre: none
	//post:none
	//
	public String toString(){
		String baraja="";
		for(int i=0;i<this.Deck.length;i++){
			baraja+=this.Deck[i]+"\n";
		}
		return baraja;
	}
	
}
