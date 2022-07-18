package implementation.bronze.quiz_10870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = Integer.parseInt(str);
		
		if (n == 0) {
			System.out.println(0);
		}
		
		else if (n == 1) {
			System.out.println(1);
		}
		else {
			int[] memory = new int[n+1];
			memory[0] = 0;
			memory[1] = 1;
			
			for(int i=2; i<(n+1); i++) {
				memory[i] = memory[i-1] + memory[i-2];
			}
			
			System.out.println(memory[n]);
		}
		
	}

}
