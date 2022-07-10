package META2021Q;

import java.io.*;

public class P2 {
	static boolean USEFILE=true;
	static final int INF=1_000_000_000;
//	static final String filename="consistency_chapter_2_sample_input";
//	static final String filename="consistency_chapter_2_validation_input";
	static final String filename="consistency_chapter_2_input";
	static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <=t; testcase++) {
			char[] arr=br.readLine().toCharArray();
			int k = Integer.parseInt(br.readLine());
			int[][] map = new int[26][26];
			for (int from = 0; from < 26; from++) {
				for (int to = 0; to < 26; to++) {
					if(from==to) map[from][to]=0;
					else map[from][to]=INF;
				}
			}			
			for (int i = 0; i < k; i++) {
				char[] tmp=br.readLine().toCharArray();
				map[tmp[0]-'A'][tmp[1]-'A']=1;
			}
			int[] alphacnt = new int[26];
			for (int i = 0; i < arr.length; i++) {
				alphacnt[arr[i]-'A']++;
			}
			
			for (int middle = 0; middle < 26; middle++) {
				for (int from = 0; from < 26; from++) {
					for (int to = 0; to < 26; to++) {
						if(map[from][to]>map[from][middle]+map[middle][to]) {
							map[from][to]=map[from][middle]+map[middle][to];
						}
					}
				}
			}
			int answer = INF;
			for_letter:
			for (int letter = 0; letter < 26; letter++) {
				int tmp=0;
				for (int i = 0; i < 26; i++) {
					if(alphacnt[i]==0) continue;
					if(map[i][letter]==INF) continue for_letter;
					tmp+=alphacnt[i]*map[i][letter];
				}
				if(answer>tmp) answer=tmp;
			}
			if(answer == INF) {
				System.out.println("Case #"+testcase+": -1");	
			}else{
				System.out.println("Case #"+testcase+": "+answer);
			}
			
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

