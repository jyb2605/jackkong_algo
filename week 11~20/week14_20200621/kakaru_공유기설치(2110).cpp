#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
   vector<int> house;
   int N, C;
   int answer = 0;
   cin >> N >> C;
   for (int i = 0; i < N; i++) {
      int x;
      cin >> x;
      house.push_back(x);
   }
   sort(house.begin(), house.end());
   int left = 0; 
   int right = house[N-1];
   while(left <= right){
      int mid = (left + right) / 2;
      int cnt = 1;
      int na = house[0];
      for (int i = 1; i < N; i++) {
         if ((house[i]-na) >= mid) {
            cnt++;
            na = house[i];
         }
      }
      if (cnt < C) {
         right = mid - 1;
      }
      else {
         answer = mid;
         left = mid + 1;
      }
   }
   cout << answer << endl;
}