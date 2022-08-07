package META2020Q;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P3 {
	static boolean USEFILE=true;
//	static final String filename="timber_sample_input";
	static final String filename="timber_input";
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <=t; testcase++) {
			int n = Integer.parseInt(br.readLine());
			int[][] trees = new int[n][2];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				trees[i][0] = Integer.parseInt(st.nextToken());
				trees[i][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(trees, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o1[0], o2[0]);
				}
			});
			HashMap<Integer, Integer> dp = new HashMap<Integer, Integer>();
			int answer = 0;
			for (int i = 0; i < n; i++) {
				int left = trees[i][0]-trees[i][1];
				int right = trees[i][0]+trees[i][1];
				Integer dpc = dp.get(trees[i][0]);
				if(dpc == null) dpc=0;
				Integer dpl = dp.get(left);
				if(dpl == null) dpl=0;
				Integer dpr = dp.get(right);
				if(dpr == null) dpr=0;
				if(dpc<dpl+trees[i][1]) dp.put(trees[i][0], dpl+trees[i][1]);
				if(dpr<dpc+trees[i][1]) dp.put(right, dpc+trees[i][1]); 
				answer = Math.max(answer,dp.get(trees[i][0]));
				answer = Math.max(answer,dp.get(right));
			}
			System.out.println("Case #"+testcase + ": "+answer);
		}
	}
	public static void main(String[] args) throws Exception {
		if(USEFILE) {
			System.setIn(new FileInputStream(new File(filename+".txt")));
			System.setOut(new PrintStream(new File(filename+".out")));
			solve();
		}else {
			solve();
		}
	}
}
