#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N, M, K;


int food[11][11];
int cur_food[11][11];
vector<int> live[12][12];
vector<int> dead[11][11];

void spring() {

	for (int i = 1; i < N + 1; i++) {
		for (int j = 1; j < N + 1; j++) {
			sort(live[i][j].begin(), live[i][j].end());
			
			for (int k = 0; k < live[i][j].size(); k++) {
				if (live[i][j][k] <= cur_food[i][j]) {
					cur_food[i][j] -= live[i][j][k];
					live[i][j][k]++;
				}
				else 
					live[i][j][k] *= -1;
			}

			for (int k = live[i][j].size() - 1; k >= 0; k--) {
				int age = live[i][j][k];
				if (age < 0) {
					live[i][j].pop_back();
					dead[i][j].push_back(age*(-1));
				}
				else
					break;
			}

		}
	}
}


void summer() {
	for (int i = 1; i < N + 1; i++) {
		for (int j = 1; j < N + 1; j++) {
			for (int k = 0; k < dead[i][j].size(); k++) {
				cur_food[i][j] += (dead[i][j][k] / 2);
			}
			dead[i][j].clear();
		}
	}
}

void autumn() {
	for (int i = 1; i < N + 1; i++) {
		for (int j = 1; j < N + 1; j++) {
			for (int k = 0; k < live[i][j].size(); k++) {
				if (live[i][j][k] % 5 == 0) {
					live[i-1][j-1].push_back(1);
					live[i-1][j].push_back(1);
					live[i][j-1].push_back(1);
					live[i - 1][j + 1].push_back(1);
					live[i + 1][j - 1].push_back(1);
					live[i + 1][j].push_back(1);
					live[i][j + 1].push_back(1);
					live[i + 1][j + 1].push_back(1);
				}
			}
		}
	}
}

void winter() {
	for (int i = 1; i < N + 1; i++) {
		for (int j = 1; j < N + 1; j++) {
			cur_food[i][j] += food[i][j];
		}
	}
}

int main() {
	
	cin >> N >> M >> K;
	
	for (int i = 1; i < N + 1; i++) {
		for (int j = 1; j < N + 1; j++) {
			cin >> food[i][j];
			cur_food[i][j] = 5;
		}
	}

	int x, y, age;

	for (int i = 0; i < M; i++) {
		cin >> x >> y >> age;
		live[x][y].push_back(age);
	}

	for (int i = 0; i < K; i++) {
		spring();
		summer();
		autumn();
		winter();
	}

	long long result = 0;

	for (int i = 1; i < N + 1; i++) {
		for (int j = 1; j < N + 1; j++) {
			result += live[i][j].size();
		}
	}

	cout << result << endl;

	return 0;
}
