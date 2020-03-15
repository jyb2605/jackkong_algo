#include <iostream>
#include <stack>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;


int main() {
	int N, M, V;
	int x, y;
	cin >> N >> M >> V;


	vector<bool> visited(N+1,false);
	vector<vector<int>> adj(N+1, vector<int>());
	stack<int> s;



	for (int n = 0; n < M; n++) {
		cin >> x >> y;
		adj[x].push_back(y);
		adj[y].push_back(x);
	}
	for (int n = 0; n < N; n++) {
		sort(adj[n].begin(), adj[n].end());
	}

	s.push(V);
	visited[V] = true;
	cout << s.top() << " ";

	while (s.empty() == false) {
		int cur = s.top();
		bool isvisit = false;
		for (int idx = 0; idx < adj[cur].size(); idx++) {
			if (visited[adj[cur][idx]]==true) {
				continue;
			}
			else {
				s.push(adj[cur][idx]);
				visited[adj[cur][idx]] = true;
				cout << s.top() << " ";
				isvisit = true;
				break;
			}			
		}
		if (isvisit == false) {
			s.pop();
		}
	}
	cout << endl;

	visited = vector<bool>(N + 1, false);
	queue<int> q;

	q.push(V);
	visited[V] = true;
	cout << q.front() << " ";

	while (q.empty() == false) {
		int cur = q.front();
		for (int idx = 0; idx < adj[cur].size(); idx++) {
			if (visited[adj[cur][idx]] == false) {
				q.push(adj[cur][idx]);
				visited[adj[cur][idx]] = true;
				cout << adj[cur][idx] << " ";
			}
		}
		q.pop();
	}
	cout << endl;
	return 0;

}
