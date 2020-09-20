#include <iostream>

#include <string>
#include <vector>
#include <queue>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    
    int idx = 0;

    while(idx < progresses.size()){
        for(int i = 0; i < progresses.size(); i++){
            progresses[i] += speeds[i];
        }

        int count = 0;
        while(idx < progresses.size() && progresses[idx] >= 100){
            count++;
            idx++;
        }

        if(count != 0){
            answer.push_back(count);
        }
    }

    return answer;
}

int main(){
    vector<int> progresses = {93,30,55};
    vector<int> speeds = {1, 30, 5};
    vector<int> answer = solution(progresses, speeds);

    for(int cur : answer){
        cout<< cur << ' ';
    }

    return 0;
}