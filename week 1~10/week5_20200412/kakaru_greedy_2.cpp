#include <string>
#include <vector>
#include <stack>
using namespace std;

string solution(string number, int k) {
    string answer = "";
    stack<char> s;
    int count = 0;
    int i = 0;       
    while(count!= k){
        if(s.empty()){
            s.push(number[i]);
            i++;
        }
        else if(s.top() < number[i]){
            s.pop();
            count++;
        }
        else{
            s.push(number[i]);
            i++;
        }
    }
    while(i < number.length()){     
        s.push(number[i]);
        i++;
    }
        
    while(!s.empty()){
        answer = s.top() + answer;
        s.pop();
    }
    if(answer.length() > number.length()-k){
        answer = answer.substr(0, number.length()-k);
    }
    return answer;
}