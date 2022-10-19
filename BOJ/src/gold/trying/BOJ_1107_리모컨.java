/*package gold.trying;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1107_리모컨 {
	public static int[] isBroken = new int[10];
	public static int result;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int target = Integer.parseInt(br.readLine());
		int brokenCnt = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<brokenCnt; i++) {
			int n = Integer.parseInt(st.nextToken());
			isBroken[n] = 1;
		}
		
		int current = 100;
		result = Math.abs(current - target);
		
		int flag = checkFirstNum(target);
		
		
		System.out.println(result);
	}


}
*/