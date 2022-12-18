// 미해결

package gold.trying;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2110_공유기설치 {

	public static int houseCnt;	// 집의 개수
	public static int accessCnt;	// 공유기의 개수
	public static List<Integer> house = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		houseCnt = Integer.parseInt(st.nextToken());
		accessCnt = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<houseCnt; i++) {
			house.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(house);
		
		
		
	}

}
