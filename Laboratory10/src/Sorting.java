//----------------------------------------------------------
//Laboratory 10
//Sorting.java
//Manuel Madrigal Valenzuela
//April 29,2016
//----------------------------------------------------------

//This class implements the sorting of an array using different approaches
public class Sorting {
	TestHarness local;
	int[] values;
	int size;

	//Constructor of the Sorting Class
	//pre: the TestHarness is already initialized
	//post: the attributes of the sorting class are initialized
	public Sorting(TestHarness global){
		this.local=global;
		this.values=this.local.getArray();
		this.size=this.local.getSize();
	}

	//------------SELECTION SORT

	// Returns the index of the smallest value in
	// values[startIndex]..values[endIndex].
	//pre:none
	//post:none
	public int minIndex(int startIndex, int endIndex){
		int indexOfMn= startIndex;
		for(int i=startIndex+1;i<=endIndex;i++){
			if(this.values[i]<this.values[indexOfMn]){
				indexOfMn=i;
			}
		}
		return indexOfMn;
	}

	//
	// Sorts the values array using the selection sort algorithm
	//pre:none
	//post:Array is sorted
	public void selectionSort(){
		int endIndex=this.size-1;
		for (int i=0;i<endIndex;i++){
			this.local.swap(i, this.minIndex(i, endIndex));
		}
	}

	//------------BUBBLE SORT

	// Switches adjacent pairs that are out of order 
	// between values[startIndex]..values[endIndex] 
	// beginning at values[endIndex].
	//pre:none
	//post:adjacent pairs out of order are switched
	public void bubbleUp(int startIndex,int endIndex){
		for(int i=endIndex;i>startIndex;i--){
			if(this.values[i]<this.values[i-1]){
				this.local.swap(i, i-1);
			}
		}
	}

	//
	// Sorts the values array using the bubble sort algorithm.
	//pre:none
	//post:Array is sorted
	public void bubbleSort(){
		int current=0;
		while(current<(this.size-1)){
			this.bubbleUp(current, this.size-1);
			current++;
		}
	}
	//------------SHORT BUBBLE SORT

	// Switches adjacent pairs that are out of order 
	// between values[startIndex]..values[endIndex] 
	// beginning at values[endIndex].
	// Returns false if a swap was made; otherwise, returns true.
	//pre:none
	//post:adjacent pairs out of order are switched
	public boolean bubbleUp2(int startIndex,int endIndex){
		boolean sorted=true;
		for(int i=endIndex;i>startIndex;i--){
			if(this.values[i]<this.values[i-1]){
				this.local.swap(i, i-1);
				sorted=false;
			}
		}
		return sorted;
	}

	//
	// Sorts the values array using the bubble sort algorithm.
	// The process stops as soon as values is sorted.
	//pre:none
	//post:Array is sorted
	public void shortBubble(){
		int current=0;
		boolean sorted=false;
		while((current<(this.size-1))&& !sorted){
			sorted=this.bubbleUp2(current, this.size-1);
			current++;
		}
	}
	//------------INSERTION SORT
	//
	// Upon completion, values[0]..values[endIndex] are sorted.
	//pre:none
	//post:array is sorted
	public void insertElement(int startIndex, int endIndex){
		boolean finished=false;
		int current=endIndex;
		boolean moreToSearch=true;
		while (moreToSearch && !finished){
			if(this.values[current]<this.values[current-1]){
				this.local.swap(current, current-1);
				current--;
				moreToSearch=(current!=startIndex);
			}else{
				finished=true;
			}
		}
	}

	//
	// Sorts the values array using the insertion sort algorithm.
	//pre:none
	//post:array is sorted
	public void insertionSort(){
		for(int i=1;i<this.size;i++){
			this.insertElement(0, i);
		}
	}

	//------------MERGE SORT
	// 
	// Sorts values[leftFirst]..values[rightLast] by merging the two subarrays.	
	// Preconditions: values[leftFirst]..values[leftLast] are sorted.
	//                values[rightFirst]..values[rightLast] are sorted.
	// Post: the two subarrays are merged
	public void merge(int leftFirst,int LeftLast, int rightFirst, int rightLast){
		int[] tempArray=new int[this.size];
		int index=leftFirst;
		int saveFirst=leftFirst;
		while((leftFirst<=LeftLast)&&(rightFirst<=rightLast)){
			if(this.values[leftFirst]<this.values[rightFirst]){
				tempArray[index]=this.values[leftFirst];
				leftFirst++;
			}else{
				tempArray[index]=this.values[rightFirst];
				rightFirst++;
			}
			index++;
		}
		while(leftFirst<=LeftLast){
			tempArray[index]=this.values[leftFirst];
			leftFirst++;
			index++;
		}
		while(rightFirst<=rightLast){
			tempArray[index]=this.values[rightFirst];
			rightFirst++;
			index++;
		}

		for(index=saveFirst;index<=rightLast;index++){
			this.values[index]=tempArray[index];
		}
	}

	//
	// Sorts the values array using the merge sort algorithm.
	//pre:none
	//post:Array is sorted
	public void mergeSort(int first,int last){
		if(first<last){
			int middle=(first+last)/2;
			this.mergeSort(first,middle);
			this.mergeSort(middle+1,last);
			this.merge(first, middle, middle+1, last);
		}
	}
	//------------QUICK SORT
	//Array is divided in sub arrays
	//pre:none
	//post:Array is divided
	public int split(int first,int last){
		int splitVal=this.values[first];
		int saveF=first;
		boolean onCorrectSide;

		first++;
		do{
			onCorrectSide=true;
			while (onCorrectSide){				// move first toward last
				if(this.values[first]>splitVal){
					onCorrectSide=false;
				}else{
					first++;
					onCorrectSide=(first<=last);
				}
			}

			onCorrectSide=(first<=last);
			while(onCorrectSide){				// move last toward first
				if(this.values[last]<=splitVal){
					onCorrectSide=false;
				}else{
					last--;
					onCorrectSide=(first<=last);
				}
			}

			if(first<last){
				this.local.swap(first, last);
				first++;
				last--;
			}
		}while(first<=last);

		this.local.swap(saveF,last);
		return last;
	}

	//
	// Sorts the values array using the quick sort algorithm.
	//pre:none
	//post:Array is sorted
	public void quickSort(int first, int last){
		if(first<last){
			int splitPoint;
			splitPoint=this.split(first, last);
			// values[first]..values[splitPoint - 1] <= splitVal
			// values[splitPoint] = splitVal
			// values[splitPoint+1]..values[last] > splitVal

			this.quickSort(first, splitPoint-1);
			this.quickSort(splitPoint+1, last);
		}
	}

	//------------HEAP SORT

	// If either child of hole is larger than item this returns the index
	// of the larger child; otherwise it returns the index of hole.
	//pre:none
	//post:none
	public int newHole(int hole, int lastIndex, int item){
		int left = (hole * 2) + 1;
		int right = (hole * 2) + 2;
		if (left > lastIndex)
			// hole has no children
			return hole;         
		else
			if (left == lastIndex)
				// hole has left child only
				if (item < values[left])             
					// item < left child
					return left;
				else
					// item >= left child
					return hole;
			else
				// hole has two children 
				if (values[left] < values[right])
					// left child < right child
					if (values[right] <= item)
						// right child <= item
						return hole;
					else
						// item < right child
						return right;
				else
					// left child >= right child
					if (values[left] <= item)
						// left child <= item
						return hole;
					else
						// item < left child
						return left;
	}

	//
	// Inserts item into the tree and ensures shape and order properties.
	// Precondition: Current root position is "empty".
	// Post: element is inserted into the tree
	public void reheapDown(int item, int root, int lastIndex){
		int hole = root;   // current index of hole
		int newhole;       // index where hole should move to

		newhole = newHole(hole, lastIndex, item);   // find next hole
		while (newhole != hole)
		{
			values[hole] = values[newhole];      // move value up
			hole = newhole;                      // move hole down
			newhole = newHole(hole, lastIndex, item);     // find next hole
		}
		values[hole] = item;           // fill in the final hole
	}
	
	// Sorts the values array using the heap sort algorithm.
	//pre:none
	//post: Array is sorted
	public void heapSort(){
		int index;
		// Convert the array of values into a heap.
		for (index = this.size/2 - 1; index >= 0; index--)
			reheapDown(values[index], index, this.size - 1);

		// Sort the array.
		for (index = this.size - 1; index >=1; index--)
		{
			this.local.swap(0, index);
			reheapDown(values[0], 0, index - 1);
		}
	}














}
