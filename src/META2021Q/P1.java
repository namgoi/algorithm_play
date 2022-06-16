package META2021Q;

import java.io.*;

public class P1 {
	static boolean USEFILE=true;
//	static final String filename="consistency_chapter_1_sample_input";
//	static final String filename="consistency_chapter_1_validation_input";
	static final String filename="consistency_chapter_1_input";
	static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <=t; testcase++) {
			char[] arr=br.readLine().toCharArray();
			int[] mo=new int[26];
			int[] ja=new int[26];
			int maxmo = 0;
			int maxja = 0;
			int cntmo = 0;
			int cntja = 0;
			for (int i = 0; i < arr.length; i++) {
				if(arr[i]== 'A' ||arr[i]== 'E'||arr[i]== 'I'||arr[i]== 'O'||arr[i]== 'U') {
					mo[arr[i]-'A']++;
					cntmo++;
					if(maxmo<mo[arr[i]-'A']) maxmo=mo[arr[i]-'A'];
				}else {
					ja[arr[i]-'A']++;
					cntja++;
					if(maxja<ja[arr[i]-'A']) maxja=ja[arr[i]-'A'];
				}
			}
			int answer1 = (cntmo-maxmo)*2+cntja;
			int answer2 = (cntja-maxja)*2+cntmo;
			if(answer1<answer2) {
				System.out.println("Case #"+testcase+": "+answer1);
			}else {
				System.out.println("Case #"+testcase+": "+answer2);
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
