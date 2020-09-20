#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <math.h>
#include <stdio.h>
using namespace std;

int main() {
   int N,M,party;
   scanf("%d %d %d", &N, &M, &party);
   vector<vector<int>> load(N + 1, vector<int>(N + 1, 10000000));
   for (int i = 0; i < M; i++) {
      int x, y, t;
      scanf("%d %d %d", &x, &y, &t);
      load[x][y] = t;
   }

   for (int k = 0; k < N + 1; k++) {
      for (int i = 0; i < N + 1; i++) {
         for (int j = 0; j < N + 1; j++) {
            if (load[i][k] + load[k][j] < load[i][j]) {
               load[i][j] = load[i][k] + load[k][j];
            }
         }
      }
   }
   for (int i = 1; i < N + 1; i++) {
      load[i][i] = 0;
   }
   vector<int> partytime(N + 1,0);
   for (int i = 1; i < N + 1; i++) {
      partytime[i] = load[i][party] + load[party][i];
   }
   sort(partytime.begin(), partytime.end());
   printf("%d\n", partytime[N]);
   return 0;
   }