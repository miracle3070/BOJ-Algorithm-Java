package gold.sliding_window.quiz_15961;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_15961_회전초밥_HW {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int dishCnt = Integer.parseInt(st.nextToken());
		int sushiCnt = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int coupon = Integer.parseInt(st.nextToken());
		
		int[] dishes = new int[dishCnt + k - 1];
		for(int i=0; i<dishCnt; i++) {
			dishes[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<k-1; i++) {
			dishes[dishCnt + i] = dishes[i];
		}
		
		int[] selectedCnt = new int[sushiCnt + 1];
		selectedCnt[coupon] = 1;
		int result = 1;
		int max = result;
		
		// 첫 단계
		for(int i=0; i<k; i++) {
			if(selectedCnt[dishes[i]] == 0) {
				selectedCnt[dishes[i]]++;
				max++;
			} else {
				selectedCnt[dishes[i]]++;
			}
		}
		result = Math.max(result, max);
		
		// 이후 단계
		for(int start=1; start<dishCnt; start++) {
			int end = start + k - 1;
			
			selectedCnt[dishes[start-1]]--;
			if(selectedCnt[dishes[start-1]] == 0)
				max--;
			
			if(selectedCnt[dishes[end]] == 0)
				max++;
			selectedCnt[dishes[end]]++;
			
			result = Math.max(result, max);
		}
		
		bw.write(result + "");
		br.close();
		bw.close();		
	}

}
