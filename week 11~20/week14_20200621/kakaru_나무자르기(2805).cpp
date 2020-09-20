#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	vector<int> trees;
	int N, M;
	int answer = 0;
	cin >> N >> M;	
	for (int i = 0; i < N; i++) {
		int x;
		cin >> x;
		trees.push_back(x);
	}
	sort(trees.begin(), trees.end());
	long long left = 0;
	long long right = trees[N - 1];
	while (left <= right) {
		long long mid = (left + right) / 2;
		long long object = 0;
		for (int i = 0; i < N; i++) {
			if (trees[i] > mid) {
				object = object + (trees[i] - mid);
			}
		}
		if (object >= M) {
			answer = mid;
			left = (mid + 1);
		}
		else {
			right = (mid - 1);
		}
	}
	cout << answer << endl;
}