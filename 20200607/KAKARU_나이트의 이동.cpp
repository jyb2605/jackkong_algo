#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;


int main() {
	int tc;
	int N;
	int sx, sy;
	int dx, dy;
	int cnt = 0;
	cin >> tc;
	while (cnt < tc) {
		cin >> N;
		cin >> sx >> sy;
		cin >> dx >> dy;
		queue<vector<int>> q;
		vector<vector<bool>> visited(N, vector<bool>(N, false));
		q.push({ sx, sy, 0 });
		visited[sx][sy] = true;
		while (1) {			
			vector<int> front = q.front();
			q.pop();
			if (dx == front[0] && dy == front[1]) {
				cout << front[2] << endl;
				break;
			}
			if ((front[0] - 2) >= 0 && (front[1] - 1) >= 0 && visited[front[0] - 2][front[1] - 1] == false
			) {
				q.push({ (front[0] - 2), (front[1] - 1), front[2] + 1 });
				visited[front[0]-2][front[1]-1] = true;
			}
			if ((front[0] - 2) >= 0 && (front[1] + 1) < N && visited[front[0]-2][front[1]+1] == false) {
				q.push({ (front[0] - 2), (front[1] + 1), front[2] + 1 });
				visited[front[0]-2][front[1]+1] = true;
			}
			if ((front[0] - 1) >= 0 && (front[1] - 2) >= 0 && visited[front[0]-1][front[1]-2] == false) {
				q.push({ (front[0] - 1), (front[1] - 2), front[2] + 1 });
				visited[front[0] - 1][front[1] - 2] = true;
			}
			if ((front[0] - 1) >= 0 && (front[1] + 2) < N && visited[front[0] - 1][front[1] + 2] == false) {
				q.push({ (front[0] - 1), (front[1] + 2), front[2] + 1 });
				visited[front[0] - 1][front[1] + 2] = true;
			}
			if ((front[0] + 1) < N && (front[1] + 2) < N && visited[front[0] + 1][front[1] +2] == false) {
				q.push({ (front[0] + 1), (front[1] + 2), front[2] + 1 });
				visited[front[0] + 1][front[1] + 2] = true;
			}
			if ((front[0] + 1) < N && (front[1] - 2) >= 0 && visited[front[0] + 1][front[1] - 2] == false) {
				q.push({ (front[0] + 1), (front[1] - 2), front[2] + 1 });
				visited[front[0] + 1][front[1] - 2] = true;
			}
			if ((front[0] + 2) < N && (front[1] + 1) < N && visited[front[0] + 2][front[1] + 1] == false) {
				q.push({ (front[0] + 2), (front[1] + 1), front[2] + 1 });
				visited[front[0] + 2][front[1] + 1] = true;
			}
			if ((front[0] + 2) < N && (front[1] - 1) >= 0 && visited[front[0] + 2][front[1] - 1] == false) {
				q.push({ (front[0] + 2), (front[1] - 1), front[2] + 1 });
				visited[front[0] + 2][front[1] - 1] = true;
			}
		} 
		cnt++;
		
	}
}