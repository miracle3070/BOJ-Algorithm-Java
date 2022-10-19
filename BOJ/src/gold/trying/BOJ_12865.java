package gold.trying;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12865 {
	static class Goods implements Comparable<Goods> {
		int value;
		int weight;
		
		public Goods(int value, int weight) {
			this.value = value;
			this.weight = weight;
		}

		@Override
		public int compareTo(Goods o) {
			return o.value - this.value;
		}
	}
	
	public static int maxCnt;
	public static int maxWeight;
	public static int result = 0;
	public static Goods[] goodsArr;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		maxCnt = Integer.parseInt(st.nextToken());
		maxWeight = Integer.parseInt(st.nextToken());
		goodsArr = new Goods[maxCnt];
		
		for(int i=0; i<maxCnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			Goods goods = new Goods(value, weight);
			goodsArr[i] = goods;
		}
		
		Arrays.sort(goodsArr);
		
		subset(0, 0, 0);
		System.out.println(result);
	}
	
	public static void subset(int value, int cnt, int weight) {		
		if(weight > maxWeight)
			return;
		
		if(cnt == maxCnt) {
			if(result < value)
				result = value;
			return;
		}
		
		if(value + goodsArr[cnt].value * (maxCnt - cnt) < result)
			return;
		
		subset(value + goodsArr[cnt].value, cnt+1, weight + goodsArr[cnt].weight);
		subset(value, cnt+1, weight);
	}

}
