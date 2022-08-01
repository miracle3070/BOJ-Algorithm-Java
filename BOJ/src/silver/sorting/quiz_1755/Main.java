/*
 * 성공여부: 성공!
 * 풀이시간: 34분
 * 메모: for문 종료조건을 잘못 설정해서 오래걸림.
 * 
 */

package silver.sorting.quiz_1755;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Num {
	public int number;
	public String name;
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		String[] name = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		Num[] numObjs = new Num[n-m+1];
		String numName = "";
		for(int i = m; i < n+1; i++) {
			Num temp = new Num();
			temp.number = i;
			numName = "";
			int k = i;
			while(k > 0) {
				int remain = k % 10;
				numName = name[remain] + " " + numName;
				k /= 10;				
			}
			temp.name = numName;
			numObjs[i-m] = temp;
		}
		
		Arrays.sort(numObjs, (o1, o2) -> o1.name.compareTo(o2.name));
		int i = 0;
		for(Num obj : numObjs) {
			System.out.print(obj.number + " ");
			
			i++;
			if(i % 10 == 0)
				System.out.println();
		}

	}

}
