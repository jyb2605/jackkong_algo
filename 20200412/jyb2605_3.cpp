#include <string>
#include <vector>
#include <stack>

using namespace std;

string solution(string number, int k) {
    string answer = "";
    int idx = 1;
    stack<char> s;
    s.push(number[0]);
    
    while(k > 0 && idx < number.length()){
        if(s.empty()){
            s.push(number[idx]);
            idx++;
        }else if(s.top() < number[idx]){
            s.pop();
            k--;
        }else{
            s.push(number[idx]);
            idx++; 
        }
    }
    while(idx < number.length()){
        s.push(number[idx]);
        idx++;
    }
    
    while(!s.empty()){
        answer = s.top() + answer;
        s.pop();
    }
    
    if(answer.length() > number.length() - k){
        answer = answer.substr(0, number.length() - k);
    }
    return answer;
}
