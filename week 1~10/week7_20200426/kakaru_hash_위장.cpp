#include <string>
#include <vector>
#include <map>
using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 1;
    map<string, int> m;
    for(int i = 0; i < clothes.size(); i++){
        if(m[clothes[i][1]] == NULL){
            m[clothes[i][1]] = 2;
        }
        else{
            m[clothes[i][1]]++;
        }
    }
    
    for(auto elem : m){
        answer*=elem.second;
    }
    return answer-1;
}