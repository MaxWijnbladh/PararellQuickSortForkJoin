import static org.junit.Assert.*;

import org.junit.Test;


public class QuicksortTest {

	@Test
	public void testIsSorted() {
		int[] arr1 = Quicksort.randomArray(10);
    	int[] arr2 = Quicksort.randomArray(100);   
    	int[] arr3 = Quicksort.randomArray(1000);   	
    	int[] arr4 = Quicksort.randomArray(10000);  
    	int[] arr5 = Quicksort.randomArray(100000);
    	int[] arr6 = Quicksort.randomArray(1000000);
    	int[] arr7 = Quicksort.randomArray(10000000);
    	assertFalse(Quicksort.isSorted(arr1));
    	assertFalse(Quicksort.isSorted(arr2));
    	assertFalse(Quicksort.isSorted(arr3));
    	assertFalse(Quicksort.isSorted(arr4));
    	assertFalse(Quicksort.isSorted(arr5));
    	assertFalse(Quicksort.isSorted(arr6));
    	assertFalse(Quicksort.isSorted(arr7));
    	Quicksort.pQsort(arr1);
    	Quicksort.pQsort(arr2);
    	Quicksort.pQsort(arr3);
    	Quicksort.pQsort(arr4);
    	Quicksort.pQsort(arr5);
    	Quicksort.pQsort(arr6);
    	Quicksort.pQsort(arr7);
    	assertTrue(Quicksort.isSorted(arr1));
    	assertTrue(Quicksort.isSorted(arr2));
    	assertTrue(Quicksort.isSorted(arr3));
    	assertTrue(Quicksort.isSorted(arr4));
    	assertTrue(Quicksort.isSorted(arr5));
    	assertTrue(Quicksort.isSorted(arr6));
    	assertTrue(Quicksort.isSorted(arr7));
	}
	

	@Test
	public void testRandomArray() {
		int i = 0;
		int[] testArray = null;
		for (i = 0; i <= 1000; i++)
			testArray = Quicksort.randomArray(i);
	
		assertEquals(testArray.length, i-1);
	}
	

	@Test
	public void testFastestAlgorithm() {
		long Time1 = System.nanoTime();
		long Time2 = System.nanoTime();
		long Time3 = System.nanoTime();
		String Test1 = Quicksort.fastestAlgorithm(Time1,Time2,Time3);
		String Test2 = Quicksort.fastestAlgorithm(Time3,Time1,Time2);
		String Test3 = Quicksort.fastestAlgorithm(Time2,Time3,Time1);
		String Test4 = Quicksort.fastestAlgorithm(Time1,Time1,Time1);
		assertEquals(Test1,"insertionSort");
		assertEquals(Test2,"sQsort");
		assertEquals(Test3,"Fork/Join");
		assertEquals(Test4,"equal");
	}


	@Test
	public void testMsOrns() {
		int number1 = 999;
		int number2 = 1000;
		String Test1 = Quicksort.msOrns(number1);
		String Test2 = Quicksort.msOrns(number2);
		assertEquals(Test1,"ns");
		assertEquals(Test2,"ms");
	}

	@Test
	public void testSQsortIntArray() {
		int[] arr1 = Quicksort.randomArray(10);
    	int[] arr2 = Quicksort.randomArray(100);   
    	int[] arr3 = Quicksort.randomArray(1000);   	
    	int[] arr4 = Quicksort.randomArray(10000);  
    	int[] arr5 = Quicksort.randomArray(100000);
    	int[] arr6 = Quicksort.randomArray(1000000);
    	int[] arr7 = Quicksort.randomArray(10000000);
    	assertFalse(Quicksort.isSorted(arr1));
    	assertFalse(Quicksort.isSorted(arr2));
    	assertFalse(Quicksort.isSorted(arr3));
    	assertFalse(Quicksort.isSorted(arr4));
    	assertFalse(Quicksort.isSorted(arr5));
    	assertFalse(Quicksort.isSorted(arr6));
    	assertFalse(Quicksort.isSorted(arr7));
    	Quicksort.sQsort(arr1);
    	Quicksort.sQsort(arr2);
    	Quicksort.sQsort(arr3);
    	Quicksort.sQsort(arr4);
    	Quicksort.sQsort(arr5);
    	Quicksort.sQsort(arr6);
    	Quicksort.sQsort(arr7);
    	assertTrue(Quicksort.isSorted(arr1));
    	assertTrue(Quicksort.isSorted(arr2));
    	assertTrue(Quicksort.isSorted(arr3));
    	assertTrue(Quicksort.isSorted(arr4));
    	assertTrue(Quicksort.isSorted(arr5));
    	assertTrue(Quicksort.isSorted(arr6));
    	assertTrue(Quicksort.isSorted(arr7));
		
	}
	
	@Test
	public void testInsertSort() {
		int[] arr1 = Quicksort.randomArray(10);
    	int[] arr2 = Quicksort.randomArray(100);   
    	int[] arr3 = Quicksort.randomArray(1000);   	 	
    	assertFalse(Quicksort.isSorted(arr1));
    	assertFalse(Quicksort.isSorted(arr2));
    	assertFalse(Quicksort.isSorted(arr3));   
    	Quicksort.insertionSort(arr1);
    	Quicksort.insertionSort(arr2);
    	Quicksort.insertionSort(arr3); 
    	assertTrue(Quicksort.isSorted(arr1));
    	assertTrue(Quicksort.isSorted(arr2));
    	assertTrue(Quicksort.isSorted(arr3));
    
	}
	
	
	
	@Test
	public void testPQsort() {
		int[] arr1 = Quicksort.randomArray(10);
    	int[] arr2 = Quicksort.randomArray(100);   
    	int[] arr3 = Quicksort.randomArray(1000);   	
    	int[] arr4 = Quicksort.randomArray(10000);  
    	int[] arr5 = Quicksort.randomArray(100000);
    	int[] arr6 = Quicksort.randomArray(1000000);
    	int[] arr7 = Quicksort.randomArray(10000000);
    	assertFalse(Quicksort.isSorted(arr1));
    	assertFalse(Quicksort.isSorted(arr2));
    	assertFalse(Quicksort.isSorted(arr3));
    	assertFalse(Quicksort.isSorted(arr4));
    	assertFalse(Quicksort.isSorted(arr5));
    	assertFalse(Quicksort.isSorted(arr6));
    	assertFalse(Quicksort.isSorted(arr7));
    	Quicksort.pQsort(arr1);
    	Quicksort.pQsort(arr2);
    	Quicksort.pQsort(arr3);
    	Quicksort.pQsort(arr4);
    	Quicksort.pQsort(arr5);
    	Quicksort.pQsort(arr6);
    	Quicksort.pQsort(arr7);
    	assertTrue(Quicksort.isSorted(arr1));
    	assertTrue(Quicksort.isSorted(arr2));
    	assertTrue(Quicksort.isSorted(arr3));
    	assertTrue(Quicksort.isSorted(arr4));
    	assertTrue(Quicksort.isSorted(arr5));
    	assertTrue(Quicksort.isSorted(arr6));
    	assertTrue(Quicksort.isSorted(arr7));
	}



}
