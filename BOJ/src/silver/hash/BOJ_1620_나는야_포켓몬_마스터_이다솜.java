package silver.hash;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1620_나는야_포켓몬_마스터_이다솜 {

	public static int monsterCnt;
	public static int quizCnt;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		monsterCnt = Integer.parseInt(st.nextToken());
		quizCnt = Integer.parseInt(st.nextToken());

		String[] monsterArr = new String[monsterCnt + 1];
		Map<String, Integer> monsterMap = new HashMap<>();

		for (int i = 1; i <= monsterCnt; i++) {
			String monster = br.readLine();
			monsterArr[i] = monster;
			monsterMap.put(monster, i);
		}

		for (int i = 1; i <= quizCnt; i++) {
			String str = br.readLine();
			if(isInteger(str))
				System.out.println(monsterArr[Integer.parseInt(str)]);
			else
				System.out.println(monsterMap.get(str));
		}

	}
	
	public static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}

}
