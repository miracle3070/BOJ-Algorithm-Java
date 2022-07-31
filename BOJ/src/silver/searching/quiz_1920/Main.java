/*
 * 성공여부: 성공!
 * 풀이시간: 23분
 * 메모: 자바 stream 다루는 법을 더 익힐 필요가 있음.
 */

package silver.searching.quiz_1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] strArr = br.readLine().split(" ");
		int[] arr = Arrays.asList(strArr).stream()
				.mapToInt(s -> Integer.parseInt(s)).toArray();
		Arrays.sort(arr);
		
		int m = Integer.parseInt(br.readLine());
		strArr = br.readLine().split(" ");
		int find[] = Arrays.asList(strArr).stream().
				mapToInt(s -> Integer.parseInt(s)).toArray();

		StringBuilder sb = new StringBuilder(); // 결과 String
		int target;
		for(int i=0; i<m; i++) {
			target = find[i];
			if(binarySearch(arr, target)) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}
		
		System.out.println(sb);
		
	}
	
	public static boolean binarySearch(int[] arr, int target) {
		int start = 0;
		int end = arr.length-1;
		int mid = (start + end) / 2;
		
		while (start <= end) {
			mid = (start + end) / 2;
			if (arr[mid] < target)
				start = mid+1;
			else if (arr[mid] > target)
				end = mid-1;
			else
				return true;
		}
		
		return false;
	}

}
