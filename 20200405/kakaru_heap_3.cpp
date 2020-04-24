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
	int answer = 0;
	int cur = 0;
	int stock = 0;
	int result = 0;
	int s = 0;
	sort(jobs.begin(), jobs.end());
	priority_queue<vector<int>, vector<vector<int>>, cmp> q;
	while (cur < jobs.size() || !q.empty()) {
		for (int i = cur; i < jobs.size() && jobs[i][0] <= stock; i++) {
			q.push(jobs[i]);
			cur++;
		}
		if (!q.empty()) {
			result = stock + q.top()[1] - q.top()[0];
			stock += q.top()[1];
			s += result;
			q.pop();
		}
		else{
			stock = jobs[cur][0];
		}
	}
	answer = s / jobs.size();
	return answer;
}