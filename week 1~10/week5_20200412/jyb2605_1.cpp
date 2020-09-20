#include <string>
#include <vector>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = n - lost.size();
    vector<bool> possible(n+2, true);
    for(int idx = 0; idx < lost.size(); idx++)
        possible[lost[idx]] = false;
    vector<int> tmp;
    
    for(int idx = 0; idx < reserve.size(); idx++){
        if(!possible[reserve[idx]]){
            possible[reserve[idx]] = true;
            answer++;
        }
        else
            tmp.push_back(reserve[idx]);
    }
    reserve = tmp;
    
    
    for(int idx = 0; idx < reserve.size(); idx++){
        if(possible[reserve[idx] - 1] == false){
            possible[reserve[idx] - 1] = true;
            answer++;
        }else if(possible[reserve[idx] + 1] == false){
            possible[reserve[idx] + 1] = true;
            answer++;
        }
    }
    
    return answer;
}
