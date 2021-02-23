import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		if(str == "0") {
			System.out.println(0);
		}
		else {
			for(int i = 0; i < str.length(); i++) {
				int a = Integer.parseInt(new Character(str.charAt(i)).toString());
				if(i == 0) {
					if((a / 2) / 2 % 2 == 1) {
						sb.append(1);
						sb.append((a / 2) % 2);	
						sb.append(a % 2);
					}else {
						if((a / 2) % 2 == 1) {
							sb.append(1);
						}	
						sb.append(a % 2);
					}
				}
				else {
					sb.append((a / 2) / 2 % 2);		
					sb.append((a / 2) % 2);	
					sb.append(a % 2);				
				}
			}
			System.out.println(sb);
		}
		
	}
}
