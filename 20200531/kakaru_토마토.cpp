#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;


int main() {
	int M, N;
	int x;
	cin >> M >> N;
	int rareCnt = 0;
	queue<vector<int>> q;
	vector<vector<int>> tomatoBox(N, vector<int>(M));
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> tomatoBox[i][j];
			if (tomatoBox[i][j] == 0)
				rareCnt++;
			if (tomatoBox[i][j] == 1)
				q.push({ i,j,0 });
		}
	}
	int result;

	while (!q.empty()) {
		vector<int> front = q.front();
		result = front[2];
		q.pop();
		if (front[0] - 1 >= 0 && tomatoBox[front[0] - 1][front[1]] == 0) {
			q.push({ front[0] - 1, front[1], front[2] + 1 });
			tomatoBox[front[0] - 1][front[1]] = 1;
			rareCnt--;
		}
		if (front[0] + 1 <= N - 1 && tomatoBox[front[0] + 1][front[1]] == 0) {
			q.push({ front[0] + 1, front[1], front[2] + 1 });
			tomatoBox[front[0] + 1][front[1]] = 1;
			rareCnt--;
		}
		if (front[1] - 1 >= 0 && tomatoBox[front[0]][front[1] - 1] == 0) {
			q.push({ front[0], front[1] - 1, front[2] + 1 });
			tomatoBox[front[0]][front[1] - 1] = 1;
			rareCnt--;
		}
		if (front[1] + 1 <= M - 1 && tomatoBox[front[0]][front[1] + 1] == 0) {
			q.push({ front[0], front[1] + 1, front[2] + 1 });
			tomatoBox[front[0]][front[1] + 1] = 1;
			rareCnt--;
		}
	}
	if (rareCnt == 0) {
		cout << result << endl;
	}
	else
		cout << -1 << endl;
}