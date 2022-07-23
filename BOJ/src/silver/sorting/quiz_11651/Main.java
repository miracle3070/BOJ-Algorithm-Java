/*
 * 성공여부: 성공!
 * 풀이시간: 10분
 * 메모: 정렬 조건 설정하는 법을 좀 더 숙달시킬 것.
 */

package silver.sorting.quiz_11651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Position {
	public int x;
	public int y;
}


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		List<Position> arr = new ArrayList<>(n);
		String str = null;
		for(int i=0; i<n; i++) {
			str = br.readLine();
			String[] strArr = str.split(" ");
			
			Position pos = new Position();
			pos.x = Integer.parseInt(strArr[0]);
			pos.y = Integer.parseInt(strArr[1]);
			arr.add(pos);
		}
		
		arr.sort(new Comparator<Position>() {	
			@Override
			public int compare(Position p1, Position p2) {
				if (p1.y != p2.y)
					return p1.y - p2.y;
				else
					return p1.x - p2.x;
			}
		});
		
		for(Position p : arr) {
			System.out.println(p.x + " " + p.y);
		}
	}

}
