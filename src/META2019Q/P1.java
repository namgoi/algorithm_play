package META2019Q;

import java.io.*;
import java.util.*;

public class P1 {
	static boolean USEFILE=true;
//	static final String filename="leapfrog_ch_1_sample_input";
	static final String filename="leapfrog_ch_1_input";
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <=T; testcase++) {
			String answer = solve2(br.readLine().toCharArray());
			System.out.println("Case #"+testcase+": "+answer);
		}
	}
	private static String solve2(char[] str) {
		int len = str.length;
		int bcnt=0;
		for (int i = 0; i < len; i++) {
			if(str[i]=='B') bcnt++;
		}
		if(bcnt<(len/2)) return "N";
		if(bcnt==len-1) return "N";
		return "Y";
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
