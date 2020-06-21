#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> budgets, int M) {
    int answer = 0;
    int total;  
    int mid;
    sort(budgets.begin(), budgets.end());    
    int left = 0, right= budgets[budgets.size()-1];
    while(left <= right){
        mid = (left + right) / 2;
        total = 0;
        for(int i = 0; i < budgets.size(); i++){
            if(budgets[i] > mid){
                total += mid;
            }
            else{
                total+=budgets[i];
            }
        }
        if(total <= M){
            answer = mid;
            left = mid + 1;
        }
        else{
            right = mid - 1;
        }
    }
    return answer;
}