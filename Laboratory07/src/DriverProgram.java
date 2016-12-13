//----------------------------------------------------------
//Laboratory 07
//DriverProgram.java
//Manuel Madrigal Valenzuela
//March 11,2016
//----------------------------------------------------------

//
//This class allows us to see the functionality of our unsorted list, which is implemented
//on an underlying memory structure of a CircularDoublyLinkedList
//It shows adding and removing elements from the list
//It also proves the circularity of the list
//I used Card Objects from the Card class from Lab 2, which was modified on Lab 6 to fill the List
public class DriverProgram {
	public static void main(String[] args){
		CircularDoublyLinkedList<Card> deck=new CircularDoublyLinkedList<Card>();
		
		
		for(int i=1;i<5;i++){
			for(int j=1;j<4;j++){
				deck.add(new Card(j,i));
			}
		}
		System.out.println("There are: "+deck.size()+" elements on the list");
		System.out.println(deck);
		
		deck.remove(new Card(1,2));
		System.out.println("We remove the Ace of Diamonds");
		System.out.println("There are: "+deck.size()+" elements on the list");
		System.out.println(deck);
		
		deck.add(new Card(1,2));
		System.out.println("We add the Ace of Diamonds again but now it goes to the end of the list");
		System.out.println("There are: "+deck.size()+" elements on the list");
		System.out.println(deck);
		
		System.out.println("Now we show the circularity of the list:");
		System.out.println("There are: "+deck.size()+" elements on the list");
		deck.reset();
		for(int i=1;i<deck.size()*2.5;i++){
			try {
				System.out.println(i+") "+deck.getNext().toString());
			} catch (ListUnderflowException e) {
				System.out.println(e);
			}
		}
	}
}
