//----------------------------------------------------------
//Laboratory 02
//GinRummy.java
//Manuel Madrigal Valenzuela
//January 29, 2015
//----------------------------------------------------------

//
//This class prepares the table as if 2 players were about to play a game of Gin Rummy
//
public class GinRummy {
	private DeckOfCards deck;
	private LinkedListNode<Card> current,next;
	private LinkedListNode<Card> hand1,hand2;
	
	
	//
	//This method is the constructor of the GinRummy class
	//pre: none
	//post:The deck of cards is initialized and shuffled, 
	//	   and the first Node(Containing a card) of each players LinkedList is initialized
	//
	public GinRummy(){
		this.deck=new DeckOfCards();
		this.deck.shuffle();
		this.hand1=new LinkedListNode<Card>(this.deck.dealCard());
		this.hand2=new LinkedListNode<Card>(this.deck.dealCard());
	}
	
	//
	//This method deals 10 cards to each player
	//pre: none
	//post:Two individual LinkedLists are created for each players hand
	//
	public void dealHands(){
		this.current=this.hand1;
		for(int i=0;i<9;i++){
			this.next=new LinkedListNode<Card>(this.deck.dealCard());
			this.current.setLink(this.next);
			this.current=this.next;
		}
		
		this.current=this.hand2;
		for(int i=0;i<9;i++){
			this.next=new LinkedListNode<Card>(this.deck.dealCard());
			this.current.setLink(this.next);
			this.current=this.next;
		}
	}
	
	
	//
	//This method shows the cards of each player
	//pre: none
	//post:the LinkedLists are printed
	//
	public void printHands(){
		System.out.println("Player 1 cards are:");
		this.next=hand1;
		while(this.next!=null){
			System.out.println(this.next.getInfo());
			this.next=this.next.getLink();
		}
		
		System.out.println();
		System.out.println("Player 2 cards are:");
		this.next=hand2;
		while(this.next!=null){
			System.out.println(this.next.getInfo());
			this.next=this.next.getLink();
		}
		
	}
	
	
	//
	//Set of test data to prove the program works
	//
	public static void main(String[] args) {
		GinRummy game=new GinRummy();
		game.dealHands();
		game.printHands();
		
		
	}

}
