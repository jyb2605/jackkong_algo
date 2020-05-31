import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String sorted = input.chars()
            .sorted()
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
        char odd = 0;
        String result = "";

        int idx = 0;
        char cur;
        while(idx < sorted.length()){
            cur = sorted.charAt(idx);
            StringBuilder tmp = new StringBuilder();
            tmp.append(cur);
            for(int i = idx + 1; i < sorted.length() && sorted.charAt(i) == cur; i++){
                tmp.append(cur);
            }


            if(tmp.length() % 2 == 1 && odd == 0){
                odd = cur;
                result = result.substring(0, result.length() / 2) + tmp.toString().substring(1) + result.substring(result.length() / 2);
            }else if(tmp.length() % 2 == 1 && odd != 0){
                System.out.println("I'm Sorry Hansoo");
                return;
            }else{
                result = result.substring(0, result.length() / 2) + tmp.toString() + result.substring(result.length() / 2);
            }

            idx += tmp.length();
        }

        if(odd != 0){
            result = result.substring(0, result.length() / 2) + odd + result.substring(result.length() / 2);
        }
        System.out.println(result);
    }
}
