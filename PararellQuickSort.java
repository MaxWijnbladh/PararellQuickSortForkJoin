

import java.util.concurrent.RecursiveAction;


public class PararellQuickSort extends RecursiveAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int[] arr;
	private final int start;
	private final int end;
	
	
	
		public PararellQuickSort (int[] arr) { 
			this.arr = arr;
			this.start = 0;
			this.end = arr.length - 1;
			
			
			}
		
		public PararellQuickSort(int[] arr, int start, int end) {
	        this.arr = arr;
	        this.start = start;
	        this.end = end;
	     
		}
		
		
		 /**
	  	   * Creates an array of predetermined size, filled with random integers between 1-10
	  	   * @param left: array slot farthest to the left, right: array slot farthest to the right
	  	   * @return the middle point in the array
	  	   */		
		
		 private static int middleValue(int left, int right) {
		        return left + (right - left) / 2;
		    }

		public static int partition(int[] arr, int left, int right) {
	        int pivot = arr[middleValue(left, right)];

	        --left;
	        ++right;

	        while (true) {
	            do
	                ++left;
	            while (arr[left] < pivot);

	            do
	                --right;
	            while (arr[right] > pivot);

	            if (left < right) {
	                int tmp = arr[left];
	                arr[left] = arr[right];
	                arr[right] = tmp;
	            } else {
	                return right;
	            }
	        }
	    }
		
		 /**
	  	   * Sorts an array using Fork/Join
	  	   */
		
		@Override
		protected void compute() {
			//if (arr.length < 1500000)
			//	sQsort(arr,start,end);
			//else{
			int pivot = partition(arr, start, end);
			PararellQuickSort q1 = null;
			
			if (start < pivot)
				//Create new task on the current thread dequeue. Might be executed or might be stolen by other thread.
				q1 = (PararellQuickSort) new PararellQuickSort(arr, start, pivot).fork();
			if (pivot + 1 < end)
				//Do this task immediately 
					new PararellQuickSort(arr, pivot+1, end).invoke();
			
			if (q1 != null)
				//if fork exists, continue working on tasks until fork is completed, then join
			q1.join();	
			
		}
		//}
		
		
		
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
		
}
		
	
		

 

