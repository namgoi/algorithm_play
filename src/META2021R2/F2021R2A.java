package META2021R2;
import java.io.*;
import java.util.*;

public class F2021R2A {
	//time(ms)=921
	static boolean USEFILE=true;
	static final String dir="input/META2021R2/";
//	static final String filename="runway_sample_input";
//	static final String filename="runway_sample_input2";
//	static final String filename="runway_validation_input";
	static final String filename=dir+"runway_input";
	static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <=t; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int �����=Integer.parseInt(st.nextToken());
			int �𵨼�=Integer.parseInt(st.nextToken());
			int[][] arr = new int[�𵨼�][2];
			int answer=0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < �𵨼�; i++) {
				int ��Ÿ��=Integer.parseInt(st.nextToken());
				arr[i][0]=��Ÿ��;
				arr[i][1]=1;
			}
			Comparator<int[]> comp = new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[0]==o2[0]) return o1[1]-o2[1]; 
					return o1[0]-o2[0];
				}
			};
			Arrays.sort(arr, comp);
			for (int j = 0; j < �����; j++) {
				int[] next = new int[�𵨼�];
				st = new StringTokenizer(br.readLine());
				for (int i = 0; i < �𵨼�; i++) {
					int ��Ÿ��=Integer.parseInt(st.nextToken());
					next[i]=��Ÿ��;
				}
				Arrays.sort(next);
				int arrindex =0;
				int[][] arr2 = new int[�𵨼�][2];
				boolean[] isuse = new boolean[�𵨼�]; 
				for (int i = 0; i < �𵨼�; i++) {
					while(arrindex<�𵨼� && arr[arrindex][0]<=next[i]) {
						if(arr[arrindex][0]==next[i]) {
							arr2[i][0]=arr[arrindex][0];
							arr2[i][1]=arr[arrindex][1];
							isuse[arrindex]=true;
							arrindex++;
							break;
						}
						arrindex++;
					}
				}
				arrindex =0;
				for (int i = 0; i < �𵨼�; i++) {
					if(arr2[i][0]==0) {
						while(arrindex<�𵨼� && isuse[arrindex]) {
							arrindex++;
						}
						if(arr[arrindex][1]==0) answer++;
						arr2[i][0]=next[i];
						arrindex++;
					}
				}
				arr=arr2;
				Arrays.sort(arr, comp);
			}
			System.out.println("Case #"+testcase+": "+answer);
			
		}
	}
	public static void main(String[] args) throws Exception {
		Long start = System.currentTimeMillis();
		if(USEFILE) {
			System.setIn(new FileInputStream(new File(filename+".txt")));
			System.setOut(new PrintStream(new File(filename+".out")));
			solve();
		}else {
			solve();
		}
		System.err.println("time(ms)=" + (System.currentTimeMillis() - start));
	}
}

