
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;



public class Quicksort {


	 /**
	   * Sorts an array using quicksort
	   * @param arr : the array to be sorted, start: beginning of array, end: end of array
	   */
	

    public static void sQsort(final int[] arr, final int start, final int end) {
    	int left = start;
    	int right = end + 1;
   
        	final int pivot = arr[start];
        	int tmp;
        
        	do {            
        	
        		do {
        			left++;
        		} while (left <= end && arr[left] < pivot);
            
         
        		do {
        			right--;
        		} while (arr[right] > pivot);
            
       
        		if (left < right) {
        			tmp = arr[left];
        			arr[left] = arr[right];
        			arr[right] = tmp;
        		}
                   
        	} while (left <= right);
             
        	tmp = arr[start];
        	arr[start] = arr[right];
        	arr[right] = tmp;
    
        	if (start < right) {
        		sQsort(arr, start, right);
        	}
        	if (left < end) {
        		sQsort(arr, left, end);
        	}
        	}
        	
        
    /**
	   * determines if an array is sorted.
	   * @param the array to be checked
	   * @return true or false depending on if the array is sorted
	   */
    
  
  	  public static boolean isSorted(int[] arr) {
  	    	
  	    		int i;
  	    	
  	    		boolean balanced = true;
  	    		
  	    		for (i = 1; i < arr.length && balanced == true; ++i) {
  	    		
  	    			int left = arr[i-1];
  	    			int right = arr[i];
  	    		
  	    				if (left < right | left == right) {
  	    				balanced = true;
  	    				}
  	    				else {
  	    					balanced = false;
  	    				}
  	    					
  	    			}
  	    		return balanced;
  			
  	    			
  	    		
  	  }
  	  
  	 /**
  	   * Creates an array of predetermined size, filled with random integers between 1-10
  	   * @param the size of the array
  	   * @return the created array
  	   */
  	  
  	  
  	  public static int[] randomArray(int arraySize) {
  		  
  		  int[] arr;
  		  arr = new int[arraySize];
  		  
  		  for (int i = 0; i < arraySize; ++i) {
  			  
  			  arr[i] = 1 + (int)(Math.random() * ((100 - 1) + 1));
  			  
  			  
  			  
  		  }
  		  
  		  return arr;
  		  
  		  
  		  
  	  }
  	  
  	 /**
  	   * Takes two long's and determines which is smaller, or if they are equal
  	   * @param the two long's to be compared
  	   * @return a string with the name of the smallest long
  	   */
  	  
  	  
  	  
  	  public static String fastestAlgorithm(long insertionSort, long sQsort, long pQsort) {
  		  if (insertionSort < sQsort && insertionSort < pQsort)
  			  return "insertionSort";
  		  else if (sQsort < insertionSort && sQsort < pQsort) 
  			  return "sQsort";
  		  else if (pQsort < sQsort && pQsort < insertionSort)
  			  return "Fork/Join";
  		  else return "equal";
  		  }
  		  
  		  
  		 
  		  
  		  
  	  
  	  
  	  /**
  	   * Allows the user the input the length of the array, only accepting valid integers
  	   * @return size of the array
  	   */
  	  
  	  public static int userArraySize() {
  		  @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
  		  for(;;) {
  			  if(!sc.hasNextInt() ) { 
  				  System.out.println("Only integers!: \n"); 
  				  sc.next(); // discard
  				  continue;
  			  } 
  			  int arraySize = sc.nextInt();
  		    	if( arraySize<=0 || arraySize>50000000)
  		    	{
  		    		System.out.print("Number of integers must be in range 1-100000000: \n");
  		    		continue;
  		    	}
  		    	return arraySize;
  		  }
  		  
  				}
    
  	  
  	  public static void insertionSort(final int[] arr) {
        
  		  for (int i = 1; i < arr.length; i++) {
	
  			  int temp = arr[i];
  			  int j;
  			  for (j = i-1; j>= 0 && temp < arr[j] ; j--)
			
  				  arr[j + 1] = arr[j];
  			  arr[j+1] = temp;
  			  
  		  }
		
  	  }
  	  
  	  	public static long milliOrnano(int number) {
  	  		if (number<1000) 
  	  			return System.nanoTime();
  	  		else{
  	  			return System.currentTimeMillis();
  	  		}
  	  	}
  	  	
  	  	public static String msOrns(int number) {
  	  	if (number<1000) 
	  			return "ns";
	  		else{
	  			return "ms";
	  		}
	  	
  	  	}
  	  

  	  public static void sQsort(final int[] arr) {
  		  sQsort(arr, 0, arr.length-1);
  	  	}
    
    
  	  public static void pQsort(final int[] arr) {
  		  ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
  		  pool.invoke(new PararellQuickSort(arr));
  	  }

  
    	
    
    public static void main(String [] args) {
    	
    		
    	
    	    long sortTimeinsert = 0;
	    	System.out.println("************************PARARELL SORTING***************************************");
	    	System.out.println("-------------------------------------------------------------------------------");
	    	System.out.println("ARRAY CREATION");
	    	System.out.println("How many integers do you want your arrays to contain:");
	    	int numbOfInts = userArraySize();
	    	System.out.println("Creating four identical arrays with " + numbOfInts + " integers each...");
	    	int[] arr1 = randomArray(numbOfInts);
	    	int[] arr2 = (int[])arr1.clone();
	    	int[] arr3 = (int[])arr1.clone();
	    	System.out.println("Arrays completed!\n");
	    	System.out.println("-------------------------------------------------------------------------------");
	    	System.out.println("SORTING METHOD: insertionSort\n");
	    		if (numbOfInts < 100000) {	    		
			System.out.println("The Array is sorted: " + isSorted(arr1));
			System.out.println("Sorting...");
			long beforeSort = milliOrnano(numbOfInts);
			insertionSort(arr1);
			long afterSort =  milliOrnano(numbOfInts);
			sortTimeinsert = afterSort - beforeSort;
			System.out.println("Sorting completed!");
			System.out.println("The Array is sorted: " + isSorted(arr1));
			System.out.println("insertionSort method execution time: " + sortTimeinsert + " " + msOrns(numbOfInts) + "\n");
    }
	    		else {
	    			System.out.println("Will consume to much time when the length of the array is " + numbOfInts + " integers long\n");
	    			sortTimeinsert = System.currentTimeMillis();
	    		}
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("SORTING METHOD: sQsort\n");
			System.out.println("The Array is sorted: " + isSorted(arr2));
			System.out.println("Sorting...");
			long beforeSort = milliOrnano(numbOfInts);
			sQsort(arr2);
			long afterSort = milliOrnano(numbOfInts);
			long sortTimesQsort = afterSort - beforeSort;
			System.out.println("Sorting completed!");
			System.out.println("The Array is sorted: " + isSorted(arr2));
			System.out.println("sQsort method execution time: " + sortTimesQsort + " " + msOrns(numbOfInts) + "\n");
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("SORTING METHOD: Fork/Join");
			System.out.println("Available Cores: " + Runtime.getRuntime().availableProcessors() + "\n");
			System.out.println("The Array is sorted: " + isSorted(arr3));
			System.out.println("Sorting...");
			beforeSort = milliOrnano(numbOfInts);
			pQsort(arr3);
			afterSort = milliOrnano(numbOfInts);
			long sortTimepQsort = afterSort - beforeSort;
			System.out.println("Sorting completed!");
			System.out.println("The Array is sorted: " + isSorted(arr3));
			System.out.println("Fork/Join method execution time: " + sortTimepQsort + " " + msOrns(numbOfInts) + "\n");
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("RESULT:\n");
			System.out.println("FASTEST METHOD: " + fastestAlgorithm(sortTimeinsert, sortTimesQsort, sortTimepQsort));
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("*******************************************************************************");
			
	    	
	    }
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//System.out.println("Algorithm comparision");
		/*System.out.println("*****************************************");
		sortAlgorithmTest();
		System.out.println("********************************************************************************");
		
		

		
		beforeSort = System.nanoTime();
		sQsort(arr1);
		afterSort = System.nanoTime();
		sortTime = afterSort - beforeSort;
		System.out.println("sQsort algorithm execution time (Array Size = 10): " + sortTime + " ns");
		beforeSort = System.nanoTime();
		insertionSort(arr2);
		System.out.println("The Array is sorted: " + isSorted(arr2));
		afterSort = System.nanoTime();
		sortTime = afterSort - beforeSort;
		System.out.println("insertionSort algorithm execution time (Array Size = 10): " + sortTime + " ns");*/
		
    	
    	
    }
    
    
    
    
  
    

    		
    	
    			
    		
    				
    		
    		
    		
    	
    	
    	
    

