/*
 * 2020-09-22
 * 2018 kakao [1차]캐시

TreeSet에서 City 비교할 때 City내의 String 비교만으로 처리되는 것이 아직 안됨.
생각을 잘 못함.

어차피 기존에 cache에서 city를 add할 때 index 중간에 들어갈 경우는 없고
마지막 자리에 add됨.

cache size가 꽉 찰 경우도 가장 첫 번째 index(LRU에 의해 가장 오랫동안 참조되지 않은 city)를
remove하면된다.

LinkedList 형태에 자료구조를 사용하면 된다.

 */

import java.util.LinkedHashSet;
import java.util.Iterator;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if(cacheSize == 0) {
            return cities.length * 5;
        }

        for(int idx = 0; idx < cities.length; idx++) {
            cities[idx] = cities[idx].toLowerCase();
        }

        LinkedHashSet<String> cache = new LinkedHashSet<>();

        for(String city : cities) {
            city = city.toLowerCase();

            if(cache.contains(city)) {
                answer += 1;
                cache.remove(city);
                cache.add(city);
            } else {
                answer += 5;
                if(cache.size() >= cacheSize) {
                    cache.remove(cache.iterator().next());
                }
                cache.add(city);
            }
        }
        return answer;
    }
}