#include <string>
#include <vector>
#include <stack>
using namespace std;

stack<int> s;
vector<bool> visited;
vector<vector<int>> adj;

int solution(int n, vector<vector<int>> computers) {
	int answer = 0;
	visited = vector<bool>(n, false);
	adj = vector<vector<int>> (n, vector<int>());

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (i != j && computers[i][j]) {
				adj[i].push_back(j);
				adj[j].push_back(i);
			}
		}
	}

	for (int i = 0; i < n; i++) {
		if (visited[i]) {
			continue;
		}
		else {
			s.push(i);
			visited[i] = true;
			answer++;
		}

		while (!s.empty()) {
			int top = s.top();
			bool isPush = false;
			for (int j = 0; j < adj[top].size(); j++) {
				if (!visited[adj[top][j]]) {
					s.push(adj[top][j]);
					visited[adj[top][j]] = true;
					isPush = true;
					break;
				}
			}

			if (!isPush) {
				s.pop();
			}
		}
	}

	return answer;
}
