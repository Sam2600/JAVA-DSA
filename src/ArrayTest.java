import java.util.Arrays;

public class ArrayTest {

	private int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

	public static void main(String[] args) {

		ArrayTest arrTest = new ArrayTest();

		// int[] arrayWithNewLength = arrTest.insertArrLength(arrTest.arr,
		// arrTest.arr.length - 1);
		// System.out.println(Arrays.toString(arrayWithNewLength));

		// int[] oddNumArray = arrTest.removeOddNumbers(arrTest.arr);
		// System.out.println(Arrays.toString(oddNumArray));

		// int[] reversedArray = arrTest.reverseArray(arrTest.arr);
		// System.out.println(Arrays.toString(reversedArray));

		// int minValArr = arrTest.minValueOfArr(arrTest.arr);
		// System.out.println(minValArr);

		// int secLargest = arrTest.secondLargestVal(arrTest.arr);
		// System.out.println(secLargest);

		// int[] zeroEndArr = arrTest.zeroToTheEnd(arrTest.arr);
		// System.out.println(Arrays.toString(zeroEndArr));

		// int missNum = arrTest.findMissNum(arrTest.arr);
		// System.out.println(missNum);
		
		boolean isPalindrome = arrTest.isPalindrome("addxxdda");
		System.out.println(isPalindrome);
	}

	public int minValueOfArr(int[] arr) {
		int min = arr[0];

		for (int i : arr) {

			if (min > i) {
				min = i;
			}
		}

		return min;
	}

	public int[] reverseArray(int[] arr) {
		int start = 0;

		int end = arr.length - 1;

		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;

			start++;
			end--;
		}

		return arr;
	}

	public int[] removeOddNumbers(int[] arr) {

		int count = 0;

		for (int i : arr) {
			if (i % 2 != 0) {
				count++;
			}
		}

		int[] oddArr = new int[count];

		int index = 0;

		for (int i : arr) {
			if (i % 2 != 0) {
				oddArr[index] = i;
				index++;
			}
		}

		return oddArr;
	}

	public int[] insertArrLength(int[] arr, int extra_length) {
		int[] newArr = new int[arr.length + extra_length];

		for (int i = 0; i < arr.length - 1; i++) {
			newArr[i] = arr[i];
		}

		return newArr;
	}

	public int secondLargestVal(int[] arr) {

		int largest = 0;
		int secLargest = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > largest) {
				secLargest = largest;
				largest = arr[i];
			} else if (arr[i] < largest && arr[i] > secLargest) {
				secLargest = arr[i];
			}
		}

		return secLargest;
	}

	public int[] zeroToTheEnd(int[] arr) {

		int j = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] != 0 && arr[j] == 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}

			if (arr[j] != 0) {
				j++;
			}
		}

		return arr;
	}

	public int findMissNum(int[] arr) {

		int temp = ((arr.length + 1) * (arr.length + 2)) / 2;

		for (int i : arr) {
			temp = temp - i;
		}

		return temp;
	}

	public boolean isPalindrome(String word) {

		 char[] charArray = word.toCharArray();
		 
		 int start = 0;
		 int end = charArray.length - 1;
		 
		 while (start < end) {
			
			 if(charArray[start] == charArray[end]) {
				start++;
				end--;
			 } else {
				 return false;
			 }
		}
		 
		 return true;
	}
}
