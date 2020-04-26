#include <string>
#include <vector>
#include <map>
using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    map<string, int> m;
    for(int i = 0; i < completion.size(); i++){
        if(m.find(completion[i]) == m.end()){
            m.insert(make_pair(completion[i],1));
        }
        else{
            m[completion[i]]++;
        }
    }
    for(int i = 0 ; i < participant.size(); i++){
        if(m.find(participant[i]) == m.end()){
            return participant[i];
        }
        else{
            if(m[participant[i]]==0){
                return participant[i];
            }
            m[participant[i]]--;
        }
    }
}