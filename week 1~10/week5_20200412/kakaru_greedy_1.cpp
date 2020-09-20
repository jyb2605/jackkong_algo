#include <string>
#include <vector>
#include <stack>
using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int cnt = 0;
    for(int i = 1; i <= n; i++){
        int check = 0;
        for(int j = 0; j < lost.size(); j++){
            if(i == lost[j])
                check = 1;
        }
        if(check == 0)
            cnt++;
    }
    for(int i = 0; i < lost.size(); i++){
        for(int j = 0; j < reserve.size(); j++){
            if(lost[i] == reserve[j]){
                cnt++;
                lost[i] = -100;
                reserve[j] = -200;
            }                
        }
    }
    stack<int> s;
    for(int i = 0; i < lost.size(); i++){
        s.push(lost[i]);
    }
    while(!s.empty()){
        int check = 0;
        for(int i = reserve.size()-1; i >= 0; i--){
            if(s.top() == reserve[i]+1){
                s.pop();
                reserve[i] = -1;
                cnt++;
                check = 1;
                break;
            }
            if(s.top() == reserve[i]-1){
                s.pop();
                reserve[i] = -1;
                cnt++;
                check = 1;
                break;
            }
        }
        if(check == 0 && !s.empty())
            s.pop();
    }
    return cnt;
}