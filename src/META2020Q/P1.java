package META2020Q;

import java.io.*;
import java.util.Arrays;

public class P1 {
	static boolean USEFILE=true;
//	static final String filename="travel_restrictions_sample_input";
	static final String filename="travel_restrictions_input";
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <=T; testcase++) {
			int N = Integer.parseInt(br.readLine());
			char[] in = br.readLine().toCharArray();
			char[] out = br.readLine().toCharArray();
			char[][] map = new char[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(map[i],'N');
				map[i][i]='Y';
				for (int j = i+1; j < N; j++) {
					if(out[j-1]=='N') break;
					if(in[j]=='N') break;
					map[i][j]='Y';
				}
				for (int j = i-1; j >=0; j--) {
					if(out[j+1]=='N') break;
					if(in[j]=='N') break;
					map[i][j]='Y';
				}
			}
			System.out.println("Case #"+testcase+":");
			for (int i = 0; i < N; i++) {
				System.out.println(map[i]);	
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
