//----------------------------------------------------------
//Laboratory 02
//DeckOfCardsInterface.java
//Manuel Madrigal Valenzuela
//January 29, 2015
//----------------------------------------------------------


//
//Interface given to implement on DeckOfCards Class
//

public interface DeckOfCardsInterface {
	
	public void shuffle() ;
	// shuffles the deck of cards and resets the deal 
	// to the beginning of the deck
	
	public int cardsLeft() ;
	// returns the number of undealt cards
	
	public Card dealCard() ;
	// if all cards dealt, shuffles cards
	// returns next card
	
	public String toString() ;
	// returns a string representation of the entire deck of cards
}
