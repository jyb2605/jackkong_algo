#include <iostream>
#include <vector>
#include <queue>
using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
	vector<int> answer;
	queue<int> q;
	vector<int> procp;
	for (int i = 0; i < progresses.size(); i++) {
		procp.push_back(progresses[i]);
	}
	for (int i = 0; i < progresses.size(); i++) {
		q.push(progresses[i]);
	}
	while (!q.empty()) {
		int result = 0;
		for (int i = 0; i < progresses.size(); i++) {
			progresses[i] += speeds[i];
			if (!q.empty() && q.front() == procp[i] && progresses[i] >= 100) {
				q.pop();
				result++;
			}
		}
		if (result > 0) {
			answer.push_back(result);
		}
	}
	return answer;
}