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
   vector<int> dp(N+1);
   dp[1] = 0;
   for (int i = 2; i <= N; i++) {
      dp[i] = dp[i - 1] + 1;
      if (i % 2 == 0)
            dp[i] = min(dp[i], dp[i / 2] + 1);
      if (i % 3 == 0)
         dp[i] = min(dp[i], dp[i / 3] + 1);
   }
   printf("%d\n", dp[N]);

}   