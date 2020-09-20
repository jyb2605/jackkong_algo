#include <string>
#include <vector>
#include <algorithm>
#include <deque>
using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    sort(people.begin(),people.end());    
    deque<int> dq(people.begin(),people.end());
    while(!dq.empty()){
        if(dq.size()==1){
            answer++;
            break;
        }
        if(*dq.begin()+*dq.rbegin() <= limit){
            dq.pop_front();
            dq.pop_back();
            answer++;
        }
        else{
            dq.pop_back();
            answer++;        
        }
    }
    return answer;
}