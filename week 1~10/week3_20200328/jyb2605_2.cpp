#include <string>
#include <vector>
#include <stack>

using namespace std;

int solution(string arrangement) {
    int answer = 0;
    stack<char> s;
    
    for(int idx = 0; idx < arrangement.length(); idx++){
        if(arrangement[idx] == '('){
            s.push(arrangement[idx]);
        }else{
            if(arrangement[idx - 1] == '('){
                s.pop();
                answer += s.size();
            }else{
                s.pop();
                answer++;
            }
        }
    }
    
    return answer;
}
