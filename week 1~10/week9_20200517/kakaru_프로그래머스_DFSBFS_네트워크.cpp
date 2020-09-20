#include <string>
#include <vector>
#include <stack>
using namespace std;

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    bool ispush;
    stack<int> s;
    vector<bool> visited(computers.size(), false);
    for(int i = 0; i < n; i++){
        if(visited[i] == false){
            answer++;   
            visited[i] = true;
            s.push(i);    
        }
        while(!s.empty()){
            ispush = false;
            for(int j = 0; j < n; j++){
                if((computers[s.top()][j] == 1) && (visited[j]==false)){
                    s.push(j);
                    visited[j] = true;
                    ispush = true;
                    break;
                }
            }
            if(ispush == false){
                s.pop();
            }
        }
    }
    
    return answer;
}