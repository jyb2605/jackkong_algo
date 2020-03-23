#include <vector>
#include <iostream>
using namespace std;

void dfs(vector<int> numbers, vector<int> lotto, int cur) {
   if (lotto.size() == 6) {
      for (int i = 0; i < 6; i++) {
         cout << lotto[i] << ' ';
      }
      cout << endl;
      return;
   }
   for (int i = cur; i < numbers.size(); i++) {
      lotto.push_back(numbers[i]);
      dfs(numbers, lotto, i+1);
      lotto.pop_back();
   }
   
}

int main() {
   int x, k;


   vector<int> numbers;
   vector<int> lotto;
   while (1) {
      lotto.clear();
      numbers.clear();
      cin >> k;
      if (k == 0) {
         cout << endl;
         break;
      }
      for (int i = 0; i < k; i++) {
         cin >> x;
         numbers.push_back(x);
      }
      dfs(numbers, lotto, 0);
   }
   return 0DK;
}