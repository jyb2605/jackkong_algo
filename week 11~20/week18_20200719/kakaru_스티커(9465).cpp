#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <math.h>
#include <stdio.h>
using namespace std;


int main() {
	
	int T;
	scanf("%d", &T);
	int cnt = 0;
	while (cnt < T) {
		int result = 0;
		int n;
		scanf("%d", &n);
		vector<vector<int>> sticker(2,vector<int>(n+1,0));
		vector<vector<int>> DP(2, vector<int>(n + 1, 0));
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j < n+1; j++) {
				int x;
				scanf("%d", &x);
				sticker[i][j] = x;
			}
		}
		DP[0][0] = 0;
		DP[1][0] = 0;
		DP[0][1] = sticker[0][1];		
		DP[1][1] = sticker[1][1];
		for (int i = 2; i < n + 1; i++) {
			DP[0][i] = max(sticker[0][i] + DP[1][i - 1], sticker[0][i] + DP[1][i - 2]);
			DP[1][i] = max(sticker[1][i] + DP[0][i - 1], sticker[1][i] + DP[0][i - 2]);			
		}
		printf("%d\n", max(DP[0][n], DP[1][n]));
		cnt++;
	}	
}	