#include <string>
#include <vector>
#include <queue>
using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue<int, vector<int>, greater<int>> pq;
    for(int i = 0; i < scoville.size(); i++){
        pq.push(scoville[i]);
    }
    while(pq.size() >=2 && pq.top() < K){
        int x, y;
        x = pq.top();
        pq.pop();
        y = pq.top() * 2 + x;
        pq.pop();
        pq.push(y);
        answer++;
    }
    if(pq.top() <K) return -1;
    return answer;    
}