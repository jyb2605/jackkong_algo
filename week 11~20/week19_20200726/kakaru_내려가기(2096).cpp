#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <math.h>
#include <stdio.h>
using namespace std;

int main() {
	int N;
	scanf("%d", &N);
	vector<vector<int>> scores(N + 1, vector<int>(4, 0));
	vector<vector<int>> maxScore(N + 1, vector<int>(4, 0));
	vector<vector<int>> minScore(N + 1, vector<int>(4, 0));
	for (int i = 1; i < N + 1; i++) {
		for (int j = 1; j < 4; j++) {
			int x;
			scanf("%d", &x);
			scores[i][j] = x;
		}
	}
	maxScore[1][1] = scores[1][1];
	maxScore[1][2] = scores[1][2];
	maxScore[1][3] = scores[1][3];

	minScore[1][1] = scores[1][1];
	minScore[1][2] = scores[1][2];
	minScore[1][3] = scores[1][3];

	for (int i = 2; i <= N; i++) {
		maxScore[i][1] = max(scores[i][1] + maxScore[i - 1][1], scores[i][1] + maxScore[i - 1][2]);
		maxScore[i][2] = max(scores[i][2] + maxScore[i - 1][1], scores[i][2] + maxScore[i - 1][2]);
		maxScore[i][2] = max(maxScore[i][2], scores[i][2] + maxScore[i - 1][3]);
		maxScore[i][3] = max(scores[i][3] + maxScore[i - 1][2], scores[i][3] + maxScore[i - 1][3]);
	}
	int maxResult = max(maxScore[N][1], maxScore[N][2]);
	maxResult = max(maxResult, maxScore[N][3]);
	printf("%d\n", maxResult);
	for (int i = 2; i <= N; i++) {
		minScore[i][1] = min(scores[i][1] + minScore[i - 1][1], scores[i][1] + minScore[i - 1][2]);
		minScore[i][2] = min(scores[i][2] + minScore[i - 1][1], scores[i][2] + minScore[i - 1][2]);
		minScore[i][2] = min(minScore[i][2], scores[i][2] + minScore[i - 1][3]);
		minScore[i][3] = min(scores[i][3] + minScore[i - 1][2], scores[i][3] + minScore[i - 1][3]);
	}
	int minResult = min(minScore[N][1], minScore[N][2]);
	minResult = min(minResult, minScore[N][3]);
	printf("%d\n", minResult);
}