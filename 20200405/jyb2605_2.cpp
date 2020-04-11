#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int stock, vector<int> dates, vector<int> supplies, int k) {
    int answer = 0;
    int cur = 0;
    priority_queue<int> pq;
    
    
    while(stock < k){
        for(int idx = cur; idx < dates.size() && stock >= dates[idx]; idx++){
            pq.push(supplies[idx]);
            cur++;
        }
        stock += pq.top();
        pq.pop();
        answer++;
    }
    
    return answer;
}
