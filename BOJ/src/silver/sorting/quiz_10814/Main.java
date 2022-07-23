/*
 * 성공여부: 성공!
 * 풀이시간: 9분
 * 메모: -
 */

package silver.sorting.quiz_10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Member {
	public int age;
	public String name;
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		List<Member> members = new ArrayList<>(n);
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			String[] strArr = str.split(" ");
			
			Member temp = new Member();
			temp.age = Integer.parseInt(strArr[0]);
			temp.name = strArr[1];
			members.add(temp);			
		}
		
		members.sort((m1, m2) -> m1.age - m2.age);
		for(Member m : members) {
			System.out.println(m.age + " " + m.name);
		}
		
	}

}
