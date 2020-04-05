#include <string>
#include <vector>
#include <stack>
using namespace std;

int solution(string arrangement) {
    int answer = 0;
    stack<char> pipe;
    for(int i = 0; i < arrangement.length(); i++){
        if(arrangement[i]==')'&&arrangement[i-1]=='('){
            pipe.pop();
            answer += pipe.size();
        }
        else if(arrangement[i]==')'&&arrangement[i-1]==')'){
            pipe.pop();
            answer += 1;
        }
        else{
            pipe.push(arrangement[i]);
        }
    }
    return answer;
}