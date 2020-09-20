#include <string>
#include <vector>
#include <queue>
using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue<int, vector<int>, greater<int>> pq;
    
    for(int num : scoville)
        pq.push(num);
    
    while(pq.size() >= 2 && pq.top() < K){
        int tmp = pq.top();
        pq.pop();
        tmp += pq.top() * 2;
        pq.pop();
        pq.push(tmp);
        answer++;
    }
    
    if(pq.top() < K)
        answer = -1;
    
    return answer;
}
