import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        List<Character> bonuses = Arrays.asList('S', 'D', 'T');
        List<Character> options = Arrays.asList('*', '#');

        List<String> chunks = new ArrayList<>();

        int preIdx = 0;
        for(int idx = 0; idx < dartResult.length(); idx++) {
            if(bonuses.contains(dartResult.charAt(idx))) {
                if(idx + 1 < dartResult.length() && options.contains(dartResult.charAt(idx + 1))) {
                    idx += 1;
                }
                chunks.add(dartResult.substring(preIdx, idx + 1));
                preIdx = idx + 1;
            }
        }

        int[] points = new int[chunks.size()];

        for(int idx = 0; idx < chunks.size(); idx++) {
            int value;
            String chunk = chunks.get(idx);

            //number
            if(!chunk.contains("10")) {
                value = Integer.parseInt(chunk.substring(0, 1));
            }else{
                value = Integer.parseInt(chunk.substring(0, 2));
            }

            //bonus
            if(chunk.contains("D")) {
                value = (int) Math.pow(value, 2);
            }else if(chunk.contains("T")){
                value = (int) Math.pow(value, 3);
            }

            //option
            if(chunk.charAt(chunk.length() - 1) == '#') {
                value *= -1;
            }else if(chunk.charAt(chunk.length() - 1) == '*') {
                value *= 2;
                if(idx > 0) {
                    points[idx - 1] *= 2;
                }
            }

            points[idx] = value;
        }

        return Arrays.stream(points).sum();
    }
}
