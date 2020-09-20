#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

class cmp {
public:
    bool operator()(vector<int> a, vector<int> b) {
        return a.at(1) > b.at(1);
    }
};
 
int solution(vector<vector<int>> jobs) {
    int answer = 0, idx = 0, time = 0;
    sort(jobs.begin(), jobs.end());
    priority_queue<vector<int>, vector<vector<int>>, cmp> pq;
    
    while (idx < jobs.size() || !pq.empty()) {
        if (jobs.size() > idx && time >= jobs[idx][0]) {
            pq.push(jobs[idx]);
            idx++;
            continue;
        }
        if (!pq.empty()) {
            time += pq.top()[1];
            answer += time - pq.top()[0];
            pq.pop();
        }
        else
            time = jobs[idx][0];
    }
    return answer / jobs.size();
}
