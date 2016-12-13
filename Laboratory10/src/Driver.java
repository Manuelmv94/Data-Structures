//----------------------------------------------------------
//Laboratory 10
//Driver.java
//Manuel Madrigal Valenzuela
//April 29,2016
//----------------------------------------------------------

//This class allow us to test functionality of our Sorting algorithms
public class Driver {
	public static void main(String[] args){
		double time0,timef;
		double totalt1,totalt2,totalt3,totalt4,totalt5,totalt6,totalt7;
		TestHarness fifty=new TestHarness(50);
		TestHarness fivehund=new TestHarness(500);
		TestHarness fivetho=new TestHarness(5000);
		TestHarness fiftytho=new TestHarness(50000);
		
		Sorting fiftys =new Sorting(fifty);
		Sorting fivehunds=new Sorting(fivehund);
		Sorting fivethos=new Sorting(fivetho);
		Sorting fiftythos=new Sorting(fiftytho);
		
		System.out.println("    N\t  Selection\t Bubble     Short Bubble    Insertion\t Merge Sort\tQuick Sort    HeapSort");
		
		time0=System.nanoTime();
		fiftys.selectionSort();
		timef=System.nanoTime();
		totalt1=(timef-time0)/1000000;
		fifty.initValues();
		
		time0=System.nanoTime();
		fiftys.bubbleSort();
		timef=System.nanoTime();
		totalt2=(timef-time0)/1000000;
		fifty.initValues();
		
		time0=System.nanoTime();
		fiftys.shortBubble();
		timef=System.nanoTime();
		totalt3=(timef-time0)/1000000;
		fifty.initValues();
		
		time0=System.nanoTime();
		fiftys.insertionSort();
		timef=System.nanoTime();
		totalt4=(timef-time0)/1000000;
		fifty.initValues();
		
		time0=System.nanoTime();
		fiftys.mergeSort(0, fifty.getArray().length-1);
		timef=System.nanoTime();
		totalt5=(timef-time0)/1000000;
		fifty.initValues();
		
		time0=System.nanoTime();
		fiftys.quickSort(0, fifty.getArray().length-1);
		timef=System.nanoTime();
		totalt6=(timef-time0)/1000000;
		fifty.initValues();
		
		time0=System.nanoTime();
		fiftys.heapSort();
		timef=System.nanoTime();
		totalt7=(timef-time0)/1000000;
		fifty.initValues();
		
		System.out.printf("%5d %13.6f %13.6f %13.6f %13.6f %13.6f %13.6f %13.6f\n",50,totalt1,totalt2,totalt3,totalt4,totalt5,totalt6,totalt7);
		
		time0=System.nanoTime();
		fivehunds.selectionSort();
		timef=System.nanoTime();
		totalt1=(timef-time0)/1000000;
		fivehund.initValues();
		
		time0=System.nanoTime();
		fivehunds.bubbleSort();
		timef=System.nanoTime();
		totalt2=(timef-time0)/1000000;
		fivehund.initValues();
		
		time0=System.nanoTime();
		fivehunds.shortBubble();
		timef=System.nanoTime();
		totalt3=(timef-time0)/1000000;
		fivehund.initValues();
		
		time0=System.nanoTime();
		fivehunds.insertionSort();
		timef=System.nanoTime();
		totalt4=(timef-time0)/1000000;
		fivehund.initValues();
		
		time0=System.nanoTime();
		fivehunds.mergeSort(0, fivehund.getArray().length-1);
		timef=System.nanoTime();
		totalt5=(timef-time0)/1000000;
		fivehund.initValues();
		
		time0=System.nanoTime();
		fivehunds.quickSort(0, fivehund.getArray().length-1);
		timef=System.nanoTime();
		totalt6=(timef-time0)/1000000;
		fivehund.initValues();
		
		time0=System.nanoTime();
		fivehunds.heapSort();
		timef=System.nanoTime();
		totalt7=(timef-time0)/1000000;
		fivehund.initValues();
		
		System.out.printf("%5d %13.6f %13.6f %13.6f %13.6f %13.6f %13.6f %13.6f\n",500,totalt1,totalt2,totalt3,totalt4,totalt5,totalt6,totalt7);
		
		time0=System.nanoTime();
		fivethos.selectionSort();
		timef=System.nanoTime();
		totalt1=(timef-time0)/1000000;
		fivetho.initValues();
		
		time0=System.nanoTime();
		fivethos.bubbleSort();
		timef=System.nanoTime();
		totalt2=(timef-time0)/1000000;
		fivetho.initValues();
		
		time0=System.nanoTime();
		fivethos.shortBubble();
		timef=System.nanoTime();
		totalt3=(timef-time0)/1000000;
		fivetho.initValues();
		
		time0=System.nanoTime();
		fivethos.insertionSort();
		timef=System.nanoTime();
		totalt4=(timef-time0)/1000000;
		fivetho.initValues();
		
		time0=System.nanoTime();
		fivethos.mergeSort(0, fivetho.getArray().length-1);
		timef=System.nanoTime();
		totalt5=(timef-time0)/1000000;
		fivetho.initValues();
		
		time0=System.nanoTime();
		fivethos.quickSort(0, fivetho.getArray().length-1);
		timef=System.nanoTime();
		totalt6=(timef-time0)/1000000;
		fivetho.initValues();
		
		time0=System.nanoTime();
		fivethos.heapSort();
		timef=System.nanoTime();
		totalt7=(timef-time0)/1000000;
		fivetho.initValues();
		
		System.out.printf("%5d %13.6f %13.6f %13.6f %13.6f %13.6f %13.6f %13.6f\n",5000,totalt1,totalt2,totalt3,totalt4,totalt5,totalt6,totalt7);
		
		time0=System.nanoTime();
		fiftythos.selectionSort();
		timef=System.nanoTime();
		totalt1=(timef-time0)/1000000;
		fiftytho.initValues();
		
		time0=System.nanoTime();
		fiftythos.bubbleSort();
		timef=System.nanoTime();
		totalt2=(timef-time0)/1000000;
		fiftytho.initValues();
		
		time0=System.nanoTime();
		fiftythos.shortBubble();
		timef=System.nanoTime();
		totalt3=(timef-time0)/1000000;
		fiftytho.initValues();
		
		time0=System.nanoTime();
		fiftythos.insertionSort();
		timef=System.nanoTime();
		totalt4=(timef-time0)/1000000;
		fiftytho.initValues();
		
		time0=System.nanoTime();
		fiftythos.mergeSort(0, fiftytho.getArray().length-1);
		timef=System.nanoTime();
		totalt5=(timef-time0)/1000000;
		fiftytho.initValues();
		
		time0=System.nanoTime();
		fiftythos.quickSort(0, fiftytho.getArray().length-1);
		timef=System.nanoTime();
		totalt6=(timef-time0)/1000000;
		fiftytho.initValues();
		
		time0=System.nanoTime();
		fiftythos.heapSort();
		timef=System.nanoTime();
		totalt7=(timef-time0)/1000000;
		fiftytho.initValues();
		
		System.out.printf("%5d %13.6f %13.6f %13.6f %13.6f %13.6f %13.6f %13.6f\n",50000,totalt1,totalt2,totalt3,totalt4,totalt5,totalt6,totalt7);
	}
}
