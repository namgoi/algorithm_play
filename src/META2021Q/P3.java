package META2021Q;

import java.io.*;

public class P3 {
	static boolean USEFILE=true;
	static final int INF=1_000_000_000;
//	static final String filename="xs_and_os_sample_input";
//	static final String filename="xs_and_os_validation_input";
	static final String filename="xs_and_os_input";
	static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <=t; testcase++) {
			int size = Integer.parseInt(br.readLine());
			int[] row = new int[size];
			int[] col = new int[size];
			char[][] map = new char[size][size];
			for (int y = 0; y < size; y++) {
				map[y]=br.readLine().toCharArray();
				for (int x = 0; x < size; x++) {
					if(map[y][x]=='O') {
						row[y]=INF;
						col[x]=INF;
					}else if(map[y][x]=='.') {
						if(row[y]!=INF) row[y]++;
						if(col[x]!=INF) col[x]++;
					}
				}
			}
			int answer = INF;
			int min = INF;
			for (int i = 0; i < size; i++) {
				if(row[i]!=INF) {
					if(row[i]<min) {
						answer=1;
						min=row[i];
					}else if(row[i]==min) {
						answer++;
					}
				}
			}
			for (int i = 0; i < size; i++) {
				if(col[i]!=INF) {
					if(col[i]<min) {
						answer=1;
						min=col[i];
					}else if(col[i]==min) {
						answer++;
						if(min==1) {
							for (int y = 0; y < size; y++) {
								if(row[y]==1 && map[y][i]=='.') answer--;
							}
						}
					}
				}
			}
			if(answer == INF) {
				System.out.println("Case #"+testcase+": Impossible");	
			}else{
				System.out.println("Case #"+testcase+": "+min+" " +answer);
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

