#include <string>
#include <vector>
using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    int idx = 0;
    while(idx < progresses.size()){
        int result = 0;
        for(int i = idx; i < progresses.size(); i++){
            progresses[i] += speeds[i];
        }
        for(int i = idx; i < progresses.size(); i++){
            if(progresses[i] >= 100){
                result++;
                idx = i + 1;
            }
            else{
                break;
            }
        }
        if(result>0)
            answer.push_back(result);            
    }
    
    return answer;
}