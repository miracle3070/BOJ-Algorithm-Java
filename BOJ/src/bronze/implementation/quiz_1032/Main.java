// 성공여부: 성공!

package bronze.implementation.quiz_1032;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = Integer.parseInt(br.readLine());
		String[] str = new String[cnt];
		for(int i=0; i<cnt; i++) {
			str[i] = br.readLine();
		}
		
		int[] check = new int[str[0].length()];
		
		for(int i=1; i<cnt; i++) {
			for(int k=0; k<str[0].length(); k++) {
				if(str[0].charAt(k) != str[i].charAt(k))
					check[k] = 1;
			}
		}
		
		StringBuilder result = new StringBuilder();
		for(int k=0; k<str[0].length(); k++) {
			if(check[k] == 0)
				result.append(str[0].charAt(k));
			else
				result.append('?');
		}
		
		System.out.println(result);
		
	}

}
