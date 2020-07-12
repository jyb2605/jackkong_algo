#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <math.h>
#include <stdio.h>
using namespace std;


int main() {
	int n;
	scanf("%d", &n);
	vector<int> tile(n + 1,0);
	tile[1] = 1;
	tile[2] = 2;
	tile[3] = 3;
	tile[4] = 5;
	for (int i = 5; i <= n; i++) {
		tile[i] = (tile[i - 2] + tile[i-1]) % 10007;
	}
	printf("%d\n", tile[n]);
}	