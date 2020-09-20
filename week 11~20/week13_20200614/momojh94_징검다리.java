/*
 * 2020-06-20
 * https://programmers.co.kr/learn/courses/30/lessons/43236
 * 프로그래머스 코딩테스트 고득점 Kit 이분 탐색
 * 
 * 어렵다. 완빈이 도움 받아서 품.
 *
 * 생각 했던 것
 * 0~distance 지점에서 rocks간의 거리 차이를 List타입 diff에 모두 구하고 오름차순으로 정렬.
 * 이 거리 차이가 제일 작은 (index = 0 인 값)값에 연관된 바위를 제거하고 바위 좌측과 우측에 거리차이를 diff에서 제거하고 바위 제거되면서 생긴 새로운 거리 차이(바위 기준 좌측과 우측 지점 사이의 거리 합)를 다시 diff에 넣음.(heap 처럼 값 넣자마자 오름차순이 되게끔 insert)
 * n개 까지 제거하여서 diff에 index = 0값 리턴
 * 코드 짜기 애매하고 복잡함...
 *
 *
 * 실제 풀이
 * 1. rocks 오름차순으로 정렬하고, 1 ~ distance를 start ~ end범위에 두고 이분 탐색
 * 2. mid값이 각 지점 사이의 거리의 최솟값 중 가장 큰 값이 되도록 주어진 바위를 기준으로 바위 간의 거리와 mid값 비교.
 * 3. 지점 간의 거리가 mid보다 작으면 바위를 제거하고 같거나 크면 바위를 제거하지 않는다.
 * 4. 제거 해야될 바위수와 n값을 비교하여 이분 탐색 범위 조절
 *
 * ex ) rocks = {2, 14, 11, 21, 17}, n = 2, mid = 13, distance = 25
 * 거리차이, 제거한 바위 수, 이전 지점 위치, 바위 위치
 * 2 - 0 = 2 < mid, deletedRockCnt : 1, prePos = 0, rocks 0 ~ 11 14 17 21 ~ distance
 * 11 - 0 = 11 < mid, deletedRockCnt : 2, prePos = 0, rocks 0 ~ 14 17 21 ~ distance 
 * 14 - 0 = 14 >= mid, deletedRockCnt : 2, prePos = 14, rocks 0 ~ 14 17 21 ~ distance
 * 17 - 14 = 3 < mid, deletedRockCnt : 3, prePos = 14, rocks 0 ~ 14 21 ~ distance
 * 21 - 14 = 7 < mid, deletedRockCnt : 4, prePos = 14 , rocks 0 ~ 14 ~ distance
 *
 * 2 < 4
 * n < deletedRockCnt
 * 바위를 덜 제거 해야 된다. -> 예상되는 거리의 최솟값 중 가장 큰 값 mid 보다 낮은 범위 탐색
 * end = mid - 1;
 *
 * n >= deletedRockCnt 일 때
 * 해당 mid 값이 정답 일 수도 있지만 지점 사이의 거리의 최솟값 중 가장 큰 값을 찾아야 되기에 mid 보다 큰 범위도 탐색 해야 된다.
 * start = mid + 1;
 */

import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        answer = binarySearch(distance, rocks, n);
        return answer;
    }

    public static int binarySearch(int distance, int[] rocks, int n){
        Arrays.sort(rocks);
        int start = 1;
        int end = distance;
        int mid = 0;
        int deletedRockCnt = 0;
        int preRockPos = 0;
        int posDiff = 0;

        while (start <= end){
            mid = (start + end) / 2;
            preRockPos = 0;
            deletedRockCnt = 0;

            for(int i = 0; i < rocks.length; i++){
                posDiff = rocks[i] - preRockPos;
                if(posDiff < mid){
                    deletedRockCnt++;
                }else{
                    preRockPos = rocks[i];
                }
            }
            if(distance - preRockPos < mid){
                deletedRockCnt += 1;
            }

            if(n >= deletedRockCnt){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return end;
    }
}
