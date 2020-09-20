#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    queue<pair<int,int>> cpq;  
    queue<int> pq;    
    for(int i = 0; i < priorities.size(); i++){           
        cpq.push(pair<int, int>(priorities[i],i));
    }
    sort(priorities.begin(), priorities.end());
    for(int i = priorities.size() - 1; i >=  0 ; i--){
        pq.push(priorities[i]);
    }
    while(!pq.empty()){
        int num1 = cpq.front().first; 
        int num2 = cpq.front().second;
        if(pq.front() == cpq.front().first){         
            answer++;        
            if(cpq.front().second == location){
               break;
            }
            pq.pop(); 
            cpq.pop();         
        }
        else{
            cpq.pop();
            cpq.push(pair<int, int>(num1,num2));
        }        
    }
    return answer;
}