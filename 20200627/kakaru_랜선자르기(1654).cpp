#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <stdio.h>
using namespace std;

int main() {
   int K, N, x;
   int answer;
   vector<int> lansun;
   scanf("%d %d", &K, &N);
   for (int i = 0; i < K; i++) {
      scanf("%d", &x);
      lansun.push_back(x);
   }
   sort(lansun.begin(), lansun.end());
   long long int left = 1;
   long long int right = lansun[K - 1];
   while (left <= right) {
      int cnt = 0;
      long long int mid = (left + right) / 2;
      for (int i = 0; i < K; i++) {
         cnt += (lansun[i] / mid);
      }
      if (cnt >= N) {
         answer = mid;
         left = mid+1;
      }
      else {
         right = mid-1;
      }
   }
   printf("%d\n", answer);

}