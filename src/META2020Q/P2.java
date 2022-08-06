package META2020Q;

import java.io.*;
import java.util.Arrays;

public class P2 {
	static boolean USEFILE=true;
//	static final String filename="alchemy_sample_input";
	static final String filename="alchemy_input";
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <=t; testcase++) {
			int n = Integer.parseInt(br.readLine());
			char[] chararr = br.readLine().toCharArray();
			int A=0;
			int B=0;
			for (int i = 0; i < n; i++) {
				if(chararr[i]=='A') A++;
				else B++;
			}
			if(Math.abs(A-B)==1) {
				System.out.println("Case #"+testcase + ": Y");
			}else {
				System.out.println("Case #"+testcase + ": N");
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
