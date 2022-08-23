package gold.math.quiz_1759;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1759 {
	public static int L;
	public static int C;
	public static char[] alpha;
	public static char[] selected;
	public static StringBuilder resultString = new StringBuilder();

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		L = Integer.parseInt(str[0]); // 암호 길이
		C = Integer.parseInt(str[1]); // 암호에 사용될 문자 종류의 개수

		selected = new char[L];
		alpha = new char[C];

		str = br.readLine().split(" ");
		for (int i = 0; i < C; i++) {
			alpha[i] = str[i].charAt(0);
		}
		Arrays.sort(alpha);

		// 조합 구하기
		combination(0, 0);
		System.out.print(resultString);
	}

	public static void combination(int start, int cnt) {
		if (cnt == L) {
			int cnt1 = 0; // 모음 개수
			int cnt2 = 0; // 자음 개수
			
			for(char ch : selected) {
				if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
					cnt1++;
				else
					cnt2++;
			}
			
			if(cnt1 < 1 || cnt2 <2)
				return;
			
			for (char ch : selected) {
				resultString.append(ch);
			}
			resultString.append('\n');
			return;
		}

		for (int i = start; i < C; i++) {
			selected[cnt] = alpha[i];
			combination(i + 1, cnt + 1);
		}

	}

}
