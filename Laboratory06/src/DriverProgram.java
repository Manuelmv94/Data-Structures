//----------------------------------------------------------
//Laboratory 06
//DriverProgram.java
//Manuel Madrigal Valenzuela
//March 4, 2015
//----------------------------------------------------------
import java.util.Scanner;
//
//This class creates two distinct Sorted Lists, 
//one made of die objects and another one of Card Objects.
//The classes that describe this objects were taken from Lab 1 and Lab 2 respectively,
//and only suffered a few changes, implementing the "Comparable" interface and the corresponding method.
//This driver exercises this two lists through a menu in a loop.
//The menu allow us to decide with which list we want to work,
//allowing us to add, remove and know how many elements are in each of the lists list
public class DriverProgram {
	 
	public static void main (String args[]){
		SortedList<die> dieList=new SortedList<die>();
		SortedList<Card> cardList=new SortedList<Card>();
		
		String nextLine="";
		String Suit="";
		String rank="";
		
		Scanner sc=new Scanner(System.in);
		
		boolean exit=false;
		boolean exitList=false;
		
		while(exit!=true){
			System.out.println("\nMENU\n"
					+ "Enter the number acording the option\n"
					+ "1)Die List\n"
					+ "2)Cards List\n"
					+ "3)exit");
			nextLine=sc.nextLine();
			if(nextLine.equals("3")){
				exit=true;
			}else if(nextLine.equals("1")){
				while(exitList!=true){
					System.out.println("\nDice List\n"
							+ "Number of elements in the list: "+dieList.size()+"\n"
							+ "1)Add a die\n"
							+ "2)Remove a die\n"
							+ "3)Back to Menu");
					nextLine=sc.nextLine();
					if(nextLine.equals("1")){
						dieList.add(new die());
						System.out.println("A die with a random value was added to the list");
					}else if(nextLine.equals("2")){
						if(dieList.size()>0){	
							System.out.println("The dice List is the following:");
							System.out.println(dieList);
							System.out.println("Enter the number of the die to be removed");
							
							nextLine=sc.nextLine();
							try{
								if(dieList.remove(new die(Integer.parseInt(nextLine)))==true){
									System.out.println("The element was removed succesful");
								}else{
									System.out.println("The element does not exist on the list");
								}
							}catch(RuntimeException e){
								System.out.println("Incorrect input");
							}
						}else{
							System.out.println("The list is already empty");
						}
					}else if(nextLine.equals("3")){
						exitList=true;
					}else{
						System.out.println("Incorrect input\n");
					}
				}
				exitList=false;
			}else if(nextLine.equals("2")){
				while(exitList!=true){
					System.out.println("\n\nCards List\n"
							+ "Number of elements in the list: "+cardList.size()+"\n\n"
							+ "1)Add a card\n"
							+ "2)Remove a card\n"
							+ "3)Back to Menu");
					nextLine=sc.nextLine();
					if(nextLine.equals("1")){
						
						System.out.println("Enter the suit of the card to be added\n"
								+ "1)Clubs\n2)Diamonds\n3)Hearts\n4)Spades");
						Suit=sc.nextLine();
						System.out.println("Enter the rank of the card to be removed\n"
											+ "From 1(Ace) to 13(King)");
						rank=sc.nextLine();
						
						
						try{
							Card newCard=new Card(Integer.parseInt(rank),Integer.parseInt(Suit));
							if (newCard.getRank()>0 && newCard.getRank()<14 && newCard.getSuit()>0 && newCard.getSuit()<5){
								cardList.add(newCard);
								System.out.println("A new "+ newCard +" card was added to the list");
							}else{
								System.out.println("Incorrect input, the card was not added");
							}
						}catch(RuntimeException e){
							System.out.println("Incorrect input, the card was not added");
						}
					}else if(nextLine.equals("2")){
						if(cardList.size()>0){
							System.out.println("The Cards List is the following:");
							System.out.println(cardList);
							System.out.println("Enter the suit of the card to be removed\n"
											+ "1)Clubs\n2)Diamonds\n3)Hearts\n4)Spades");
							Suit=sc.nextLine();
							System.out.println("Enter the rank of the card to be removed\n"
									+ "From 1(Ace) to 13(King)");
							rank=sc.nextLine();
							
							try{
								if(cardList.remove(new Card(Integer.parseInt(rank),Integer.parseInt(Suit)))==true){
									System.out.println("The element was removed succesful");
								}else{
									System.out.println("The element does not exist on the list");
								}
							}catch(RuntimeException e){
								System.out.println("Incorrect input, try again");
							}
						}else{
							System.out.println("The list is already empty");
						}
					}else if(nextLine.equals("3")){
						exitList=true;
					}else{
						System.out.println("Incorrect input\n");
					}
				}
				exitList=false;
			}else{
				System.out.println("Incorrect input\n");
			}
		}
		sc.close();
		
	}
	
	
}
