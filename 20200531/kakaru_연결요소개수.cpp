#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <stack>
using namespace std;


int main() {
	int N, M;
	int x, y;
	stack<int> s;
	cin >> N >> M;
	vector<vector<int>> graph(N+1, vector<int>());
	vector<bool> visited(N+1, false);
	
	for (int n = 0; n < M; n++) {
		cin >> x >> y;
		graph[x].push_back(y);
		graph[y].push_back(x);
	}
	
	int cnt = 0;
	for (int idx = 1; idx < N + 1; idx++) {
		if (visited[idx] == false) {
			s.push(idx);
			visited[idx] = true;
			while (!s.empty()) {
				int cur = s.top();
				bool isvisit = false;
				for (int i = 0; i < graph[cur].size(); i++) {
					if (visited[graph[cur][i]] == true) {
						continue;
					}
					else {
						s.push(graph[cur][i]);
						visited[graph[cur][i]] = true;
						isvisit = true;
						break;
					}
				}
				if (isvisit == false) {
					s.pop();
				}
			}
			cnt++;
		}
		else
			continue;
	}

		cout << cnt << endl;
		return 0;

}