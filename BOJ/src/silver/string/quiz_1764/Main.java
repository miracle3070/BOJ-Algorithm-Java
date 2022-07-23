/*
 * 성공여부: 성공!
 * 풀이시간: 40분
 * 메모: 이진탐색 아이디어 떠올리는데 시간 걸림 + 반복문 종료 조건 넣는걸 빼먹음.
 */

package silver.string.quiz_1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] nums = str.split(" ");
		
		int n = Integer.parseInt(nums[0]); // 듣도 못한 사람 수
		int m = Integer.parseInt(nums[1]); // 보도 못한 사람 수
		
		List<String> notListen = new ArrayList<>(n);
		List<String> notSaw = new ArrayList<>(m);
		
		// 듣도 못한 사람들 입력받기
		for(int i=0; i < n; i++) {
			notListen.add(br.readLine());
		}
		
		// 보도 못한 사람들 입력받기
		for(int i=0; i < m; i++) {
			notSaw.add(br.readLine());
		}
		
		Collections.sort(notListen);
		Collections.sort(notSaw);
		
		List<String> result = new ArrayList<>();
		int cnt = 0;
		for(String target : notListen) {
			int start = 0;
			int end = m-1;
			int mid = (start + end) / 2;
			while (start <= end) {
				mid = (start + end) / 2;
				if (target.compareTo(notSaw.get(mid)) < 0)
					end = mid-1;
				else if (target.compareTo(notSaw.get(mid)) > 0)
					start = mid+1;
				else {
					result.add(target);
					cnt++;
					break; // 이거 넣는걸 까먹어서 오래걸림.
				}
					
			}	
		}		
		
		Collections.sort(result);
		
		// 결과 출력
		System.out.println(cnt);
		for(String s : result) {
			System.out.println(s);
		}		
	}

}
