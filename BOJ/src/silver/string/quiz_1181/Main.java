/*
 * 성공여부: 성공!
 * 풀이시간: 1시간
 * 메모: Java로 List 정렬, 다중 정렬 조건 설정, 중복 제거하는 법을 몰라서 해맴.
 */


package silver.string.quiz_1181;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		sc.nextLine();		
		
		Set<String> set = new HashSet<>();
		String str = null;
		
		for(int i=0; i<cnt; i++) {
			str = sc.nextLine();
			set.add(str);
		}
		sc.close();
		
		List<String> arr = new ArrayList<>(set);
		arr.sort(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() != s2.length())
					return s1.length() - s2.length();
				else {
					return s1.compareTo(s2);
				}
			}
			
		});
		
		for(String s : arr) {
			System.out.println(s);
		}		
	}

}
