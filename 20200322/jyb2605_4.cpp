#include <string>
#include <vector>
#include <queue>
#include <deque>

using namespace std;

int solution(vector<int> priorities, int location) {
	int answer = 0;
	int num[10] = { 0, };
	int maxP;
	queue<int, deque<int>> q(deque<int>(priorities.begin(), priorities.end()));

	for (int idx = 0; idx < priorities.size(); idx++) {
		num[priorities[idx]]++;
	}

	for (int idx = 9; idx > 0; idx--) {
		if (num[idx] > 0) {
			maxP = idx;
			break;
		}
	}

	while (!q.empty()) {
		if (q.front() < maxP) {
			q.push(q.front());
			q.pop();
		}
		else {
			answer++;
			num[q.front()]--;
			if (num[q.front()] == 0) {
				for (int idx = q.front() - 1; idx > 0; idx--) {
					if (num[idx] > 0) {
						maxP = idx;
						break;
					}
				}
			}
			q.pop();
			if (location == 0)
				break;
		}

		location--;
		if (location < 0) 
			location += q.size();
		
	}

	return answer;
}
