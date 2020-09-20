#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <math.h>
#include <stdio.h>
using namespace std;

vector<int> DP;
int n, k;
vector<int> coin;

int mincoin(int k) {
	if (DP[k] != 0)
		return DP[k];
	DP[k] = 1e9;
	for (int i = 0; i < n; i++) {
		if (k > coin[i]) {
			DP[k] = min(DP[k], mincoin(k - coin[i]) + 1);
		}
	}
	return DP[k];
}

int main() {
	scanf("%d %d", &n, &k);
	DP = vector<int>(10001, 0);
	coin = vector<int>(n, 0);
	for (int i = 0; i < n; i++) {
		int x;
		scanf("%d", &x);
		coin[i] = x;
		DP[coin[i]] = 1;
	}
	int result = mincoin(k);
	if (result == 1e9)
		result = -1;

	printf("%d\n", result);
}