import java.util.*;
import java.io.*;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static int T;
	
	public static void main(String[] args) throws Exception{
		T = sc.nextInt();
		sc.nextLine();

		
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] nArr = inputArr(N);
			int[] mArr = inputArr(M);
			int max;
			
			if(nArr.length > mArr.length) {
				max = calMax(mArr, nArr);
			} else {
				max = calMax(nArr, mArr);
			}
			
			System.out.printf("#%d %d\n", testCase, max);
		}
		sc.close();
	}

	private static int[] inputArr(final int size){
		int[] inputArr = new int[size];
		for(int idx = 0; idx < size; idx++) {
			inputArr[idx] = sc.nextInt();
		}
		
		return inputArr;
	}
	
	private static int calMax(final int[] smallList, final int[] bigList) {
		int max = 0;
		
		for(int standard = 0; standard <= bigList.length - smallList.length; standard++) {
			int sum = 0;
			for(int idx = 0; idx < smallList.length; idx++) {
				sum += smallList[idx] * bigList[standard + idx];
			}
			max = Math.max(max, sum);
		}
		return max;
	}
}
