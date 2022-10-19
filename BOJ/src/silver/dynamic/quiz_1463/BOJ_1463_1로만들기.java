package silver.dynamic.quiz_1463;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1463_1로만들기 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] memory = new int[n+1];
		Arrays.fill(memory, (int)(1e9));
		
		memory[0] = 0;
		memory[1] = 0;
		
		for(int k=1; k*3 <= n; k++) {
			memory[k*3] = Math.min(memory[k*3], memory[k] + 1);
		}
		
		for(int k=1; k*2 <= n; k++) {
			memory[k*2] = Math.min(memory[k*2], memory[k] + 1);
		}
		
		for(int k=1; k <= n-1; k++) {
			memory[k+1] = Math.min(memory[k+1], memory[k] + 1);
		}
		
		System.out.println(memory[n]);
	}

}
