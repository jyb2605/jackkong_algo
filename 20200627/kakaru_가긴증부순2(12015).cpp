#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <math.h>
#include <stdio.h>
using namespace std;

int main() {
	int x,A,y;
	vector<int> ai;
	scanf("%d", &A);
	for (int i = 0; i < A; i++) {
		scanf("%d", &x);
		ai.push_back(x);
	}
	vector<int> b;
	b.push_back(ai[0]);
	for (int i = 1; i < ai.size(); i++) {
		if (b.back() < ai[i]) {
			b.push_back(ai[i]);
		}
		if (b.back() > ai[i]) {
			int left = 0;
			int right = b.size()-1;

			while (left <= right) {
				int mid = (left + right) / 2;
				if (b[mid] < ai[i]) {
					left = mid +1;
				}
				else{
					y = mid;
					right = mid - 1;
				}
			}
			b[y] = ai[i];			
		}		
	}
	printf("%d\n", b.size());
}	