#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <math.h>
#include <stdio.h>
using namespace std;

int main() {
	int N, K, answer;
	scanf("%d %d", &N, &K);
	long long left = 1;
	long long right = K;
	while (left <= right) {
		int mid = (left + right) / 2;
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			cnt += min(mid / i, N);
		}
		if (cnt < K) {
			left = mid + 1;
		}
		else {
			answer = mid;
			right = mid - 1;
		}
	}
	printf("%d\n", answer);

}	