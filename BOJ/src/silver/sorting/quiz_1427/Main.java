/*
 * 성공여부: 성공!
 * 풀이시간: 9분
 * 메모: 기본 정렬 기준에 역순으로 적용하는 것(내림차순 정렬)만 알면 쉽게 해결
 */

package silver.sorting.quiz_1427;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		
		int temp;
		List<Integer> arr = new ArrayList<>();
		for(char ch : str.toCharArray()) {
			temp = ch - '0';
			arr.add(temp);
		}
		
		arr.sort(Comparator.reverseOrder());
		for(Integer n : arr) {
			System.out.print(n);
		}		
	}
}
