#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <stdio.h>
using namespace std;

int main() {
	int T, n;
	scanf("%d", &T);
	int ct = 0;
	vector<int> hab;
	hab.push_back(1);
	hab.push_back(2);
	hab.push_back(4);
	for (int i = 3; i <= 11; i++) {
		int y = 0;
		y = hab[i - 1] + hab[i - 2] + hab[i - 3];
		hab.push_back(y);
	}
	for (int i = 0; i < T; i++) {
		scanf("%d", &n);
		printf("%d\n", hab[n-1]);
	}
}