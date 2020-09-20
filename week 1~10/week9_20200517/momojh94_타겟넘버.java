/*
 * 2020-05-23
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 * 프로그래머스 코딩테스트 고득점 Kit
 * 참고 : https://lkhlkh23.tistory.com/74
 *
 * 배열에 있는 숫자 요소 하나가 노드, 인덱스가 깊이 +연산과 -연산 모두 해서
 * 모든 경우의 수 탐색 후 target과 같은 것만 갯수 체크해서 반환
 */

class Solution {
    int answer;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int sum, int idx){
        if(idx == numbers.length){
            if(sum == target){
                answer += 1;
            }
            return;
        }
        
        dfs(numbers, target, sum + numbers[idx], idx + 1);
        dfs(numbers, target, sum - numbers[idx], idx + 1);
    }
}