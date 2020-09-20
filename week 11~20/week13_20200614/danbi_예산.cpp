#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> budgets, int M) {
    int answer = 0;
    
    sort(budgets.begin(), budgets.end());
    int left_ = 0; // !!!!!!!!!!!!!!!!!!!!!! 전부 10 10 10 이고 찾아야 하는 값이 10보다 작을 수 잇음
    int right_ = budgets[budgets.size()-1];
    // int big_num_cnt = 0;
    long long mid_;
    
    // int budgets_size = budgets.size();
    long long sum_elem = 0;
    
    while(left_ <= right_){ //!!!!!!!!!!!!!!!!!
        mid_ = (left_+right_)/2;
        sum_elem = 0;
        
        for(int i = 0; i<budgets.size(); i++){
            if (budgets[i] >= mid_){
                sum_elem += mid_;
            }
            else{
                sum_elem += budgets[i];
            }
        }
        
        if (sum_elem > M){
            right_ = mid_-1;
        }
        else {
            left_ = mid_+1;
            answer = mid_;
        }
    }
//     answer = mid_;
    return answer;
}
