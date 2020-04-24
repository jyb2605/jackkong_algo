#include <string>
#include <vector>
#include <deque>
#include <algorithm>
using namespace std;

vector<int> solution(vector<string> operations) {
    vector<int> answer;
    deque<int> dq;
    for(int i = 0; i < operations.size(); i++){
        if(operations[i][0] == 'I'){
            int num = stoi(operations[i].substr(2));
            dq.push_back(num);
            sort(dq.begin(), dq.end());
        }
        if(!dq.empty() && operations[i][0] == 'D' && operations[i].substr(2) == "1"){
            dq.pop_back();
        }
        if(!dq.empty() && operations[i][0] == 'D' && operations[i].substr(2) == "-1"){
            dq.pop_front();
        }
    }
    if (!dq.empty()) {
		answer.push_back(dq.back());
		answer.push_back(dq.front());
	}
	else {
		answer.push_back(0);
		answer.push_back(0);
	}
    return answer;
}