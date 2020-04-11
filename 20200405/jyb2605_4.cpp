#include <string>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

vector<int> solution(vector<string> operations) {
    vector<int> answer;
    deque<int> dq;
    char command;
    int param;
    
    for(int idx = 0; idx < operations.size(); idx++){
        command = operations[idx][0];
        param = stoi(operations[idx].substr(2));
        
        if(command == 'I'){
            dq.push_back(param);
            sort(dq.begin(), dq.end());
        }else{
            if(dq.empty())
                continue;
            else if(param == 1){
                dq.pop_back();
            }else{
                dq.pop_front();
            }
        }
    }
    
    if (dq.empty()) {
        answer.push_back(0);
        answer.push_back(0);
    }
    else {
        answer.push_back(dq.back());
        answer.push_back(dq.front());
    }
    
    return answer;
}
