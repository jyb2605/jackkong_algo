#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <math.h>
#include <stdio.h>
using namespace std;

int main() {
	int N, M;
	scanf("%d %d", &N, &M);
	vector<vector<int>> kb(N + 1, vector<int>(N + 1, 100));
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			if (i == j)
				kb[i][j] = 0;
		}
	}
	for (int i = 0; i < M; i++) {
		int f1, f2;
		scanf("%d %d", &f1, &f2);
		kb[f1][f2] = 1;
		kb[f2][f1] = 1;
	}
	
	for (int m = 1; m <= N; m++) {
		for (int s = 1; s <= N; s++) {
			for (int e = 1; e <= N; e++) {
				if (kb[s][e] > kb[s][m] + kb[m][e])
					kb[s][e] = kb[s][m] + kb[m][e];
			}
		}
	}
	vector<int> minValue(N + 1, 0);
	
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			minValue[i] += kb[i][j];
		}
	}
	int result = minValue[1];
	int who = 1;
	for (int i = 2; i <= N; i++) {
		if (result > minValue[i]) {
			who = i;
			result = minValue[i];
		}
	}
	
	printf("%d\n", who);
}	