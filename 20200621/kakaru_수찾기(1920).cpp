#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <stdio.h>
using namespace std;

int main()	{
	int x,N,M;
	scanf("%d",&N);
	vector<int> A,B;
	for (int i = 0; i < N; i++) {
		scanf("%d", &x);
		A.push_back(x);
	}
	sort(A.begin(), A.end());
	cin >> M;
	for (int i = 0; i < M; i++) {
		scanf("%d", &x);
		B.push_back(x);
	}
	for (int i = 0; i < M; i++) {
		int left = 0;
		int right = N-1;
		int answer = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (A[mid] == B[i]) {
				answer = 1;
				break;
			}
			else if (A[mid] < B[i]) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		printf("%d\n", answer);
	}


}