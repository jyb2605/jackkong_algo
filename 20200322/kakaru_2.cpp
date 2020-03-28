#include <string>
#include <vector>
#include <queue>
using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
	vector<int> bridge(bridge_length, 0);
	int answer = 0;
	int total_weight = 0;
	queue<int> q;
	for (int i = 0; i < truck_weights.size(); i++) {
		q.push(truck_weights[i]);
	}
	do {
		total_weight -= bridge[bridge_length - 1];
		bridge[bridge_length - 1] = 0;
		for (int idx = bridge_length - 2; idx >= 0; idx--) {
			bridge[idx + 1] = bridge[idx];
			bridge[idx] = 0;
		}
		if (!q.empty() && total_weight + q.front() <= weight) {
			bridge[0] = q.front();
			total_weight += q.front();
			q.pop();
		}
		answer++;
	} while (!q.empty()|| total_weight > 0);


	return answer;
}

