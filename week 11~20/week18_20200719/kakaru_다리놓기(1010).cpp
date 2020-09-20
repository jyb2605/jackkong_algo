#define _CRT_SECURE_NO_WARNINGS
#include <vector>
#include <algorithm>
#include <stdio.h>
using namespace std;

vector<vector<int>> DP;

int combination(int m, int n) {
	if (n == m || n == 0)
		return 1;
	if (DP[m][n] != 0)
		return DP[m][n];
	return (DP[m][n] = combination(m - 1, n - 1) + combination(m-1, n));
}

int main() {
	int T;
	scanf("%d", &T);
	while (T--) {
		int N, M;
		scanf("%d %d", &N, &M);
		DP = vector<vector<int>> (32, vector<int>(32,0));
		printf("%d\n", combination(M, N));
	}
}	