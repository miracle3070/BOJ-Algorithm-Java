/*
 * 성공여부: 성공!
 * 풀이시간: 15분
 * 메모: 컬렉션 프레임워크로 해결하는 것이 시간복잡도면에서 효율적인지 알아볼 것.
 */

package silver.sorting.quiz11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] strArr = br.readLine().split(" ");
		
		List<Integer> arr = new ArrayList<>(n);
		Integer num;
		for(String str : strArr) {
			num = Integer.valueOf(str);
			arr.add(num);
		}
		
		Collections.sort(arr);
		
		int[] memory = new int[n];
		memory[0] = arr.get(0);
		for(int i=1; i<n; i++) {
			memory[i] = arr.get(i) + memory[i-1];
		}
		
		int sum = 0;
		for(int a : memory) {
			sum += a;
		}
	
		System.out.println(sum);
	}

}
