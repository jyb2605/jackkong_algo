#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <math.h>
#include <stdio.h>
using namespace std;
vector<vector<int>> descent;
vector<int> DP;

int main() {
	int x, y;
	scanf("%d %d", &x, &y);
	vector<vector<int>> computers(x + 1, vector<int>(x + 1, 100));
	for (int i = 1; i <= x; i++) {
		for (int j = 1; j <= x; j++) {
			if (i == j)
				computers[i][j] = 0;
		}
	}
	for (int i = 0; i < y; i++) {
		int c1, c2;
		scanf("%d %d", &c1, &c2);
		computers[c1][c2] = 1;
		computers[c2][c1] = 1;
	}
	
	for (int m = 1; m <= x; m++) {
		for (int s = 1; s <= x; s++) {
			for (int e = 1; e <= x; e++) {
				if (computers[s][e] > computers[s][m] + computers[m][e])
					computers[s][e] = computers[s][m] + computers[m][e];
			}
		}
	}
	int cnt = 0;
	for (int i = 1; i <= x; i++) {
		if (computers[1][i] >= 1 && computers[1][i] < 100)
			cnt++;
	}
	printf("%d\n", cnt);
	
}	