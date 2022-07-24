/*
 * 성공여부: 풀이 참고함.
 * 풀이시간: 17분
 * 메모: StringBuilder의 중요성, Java 기본 정렬 알고리즘에 대해 학습할 필요가 있음.
 */

package silver.sorting.quiz_2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
		int n = Integer.parseInt(br.readLine());
		
		List<Integer> nums = new ArrayList<>(n);
		for(int i=0; i<n; i++) {
			nums.add(Integer.valueOf(br.readLine()));
		}
		
		Collections.sort(nums);
		StringBuilder sb = new StringBuilder();
		for(Integer k : nums)
			sb.append(k).append("\n");
		
		System.out.println(sb);
	}

}
