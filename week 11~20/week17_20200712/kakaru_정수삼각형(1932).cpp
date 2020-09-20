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
	vector<vector<int>> nt(N+1,vector<int>(N+1,0));
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= i; j++) {
			int x;
			scanf("%d", &x);
			nt[i][j] = x;
		}
	}
	for (int i = 2; i <= N; i++) {
		for (int j = 1; j <= i; j++) {
			if (j == 1) {
				nt[i][j] += nt[i - 1][j];
			}
			else if (j == i) {
				nt[i][j] += nt[i - 1][j - 1];
			}
			else {
				if (nt[i - 1][j - 1] > nt[i - 1][j]) {
					nt[i][j] += nt[i - 1][j - 1];
				}
				else {
					nt[i][j] += nt[i - 1][j];
				}
			}
		}
	}
	int answer = nt[N][1];
	for (int i = 1; i <= N; i++) {
		if (nt[N][i] > answer)
			answer = nt[N][i];
	}
	printf("%d\n", answer);
}	