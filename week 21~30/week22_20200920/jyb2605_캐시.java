import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> caches = new ArrayList<>();
        if(cacheSize == 0) {
            return cities.length * 5;
        }

        for(String city : cities) {
            city = city.toLowerCase();
            if(caches.contains(city)){
                answer += 1;
                caches.remove(city);
                caches.add(0, city);
            }else{
                answer += 5;
                if(caches.size() == cacheSize) {
                    caches.remove(cacheSize - 1);
                }
                caches.add(0, city);
            }
        }

        return answer;
    }
}
