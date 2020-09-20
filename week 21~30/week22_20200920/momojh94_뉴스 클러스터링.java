/*
 * 2020-09-20
 * 2018 kakao [1차] 뉴스 클러스터링
 */

import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        char c1, c2;
        String keyStr;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        StringBuffer sb = new StringBuffer();
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Set<String> keyStrSets = new HashSet<>();
        int diffSetsCnt = 0;
        int sumSetsCnt = 0;
        int diffSetsCntTotal = 0;
        int sumSetsCntTotal = 0;
        int map1Value = 0;
        int map2Value = 0;
        
        for(int idx = 0; idx < str1.length() - 1; idx++) {
            c1 = str1.charAt(idx);
            c2 = str1.charAt(idx + 1);
            if(97 <= c1 && c1 <= 122 && 97 <= c2 && c2 <= 122) {
                sb.delete(0, sb.length());
                sb.append(c1);
                sb.append(c2);
                keyStr = sb.toString();
                keyStrSets.add(keyStr);
                if(map1.containsKey(keyStr)) {
                    map1.put(keyStr, map1.get(keyStr) + 1);
                } else {
                    map1.put(keyStr, 1);
                }
            }
        }
        
        for(int idx = 0; idx < str2.length() - 1; idx++) {
            c1 = str2.charAt(idx);
            c2 = str2.charAt(idx + 1);
            if(97 <= c1 && c1 <= 122 && 97 <= c2 && c2 <= 122) {
                sb.delete(0, sb.length());
                sb.append(c1);
                sb.append(c2);
                keyStr = sb.toString();
                keyStrSets.add(keyStr);
                if(map2.containsKey(keyStr)) {
                    map2.put(keyStr, map2.get(keyStr) + 1);
                } else {
                    map2.put(keyStr, 1);
                }
            }
        }
        
        if(map1.isEmpty() && map2.isEmpty()) {
            return 65536;
        }
		
        Iterator iter = keyStrSets.iterator();
        while(iter.hasNext()) {
            keyStr = iter.next().toString();
            map1Value = map1.containsKey(keyStr) ? map1.get(keyStr) : -1;
            map2Value = map2.containsKey(keyStr) ? map2.get(keyStr) : -1;
            
            diffSetsCnt = Math.min(map1Value, map2Value);
            sumSetsCnt = Math.max(map1Value, map2Value);
            
            diffSetsCnt = diffSetsCnt < 0 ? 0 : diffSetsCnt;
            sumSetsCnt = sumSetsCnt < 0 ? 0 : sumSetsCnt;
            
            diffSetsCntTotal += diffSetsCnt;
            sumSetsCntTotal += sumSetsCnt;
        }
        
        answer = (int)(((float)diffSetsCntTotal / (float)sumSetsCntTotal) * 65536f);
        
        return answer;
    }
}