#include <iostream>

#include <string>
#include <queue>
#include <vector>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
    int totalWeight = 0;
    vector<int> bridges(bridge_length, 0);
    deque<int> weights(truck_weights.begin(), truck_weights.end());
    
    do {
        answer++;
        // bridge logic
        // last pop
        if(bridges[bridge_length - 1] != 0){
            totalWeight -= bridges[bridge_length - 1];
            bridges[bridge_length - 1] = 0;
        }

        // shift
        for(int idx = bridge_length - 2; idx >= 0; idx--){
            bridges[idx + 1] = bridges[idx];
            bridges[idx] = 0;
        }

        // push
        if(!weights.empty() && totalWeight + weights.front() <= weight){
            bridges[0] = weights.front();
            totalWeight += weights.front();
            weights.pop_front();
        }
    }while(totalWeight > 0 || !weights.empty());
    
    return answer;
}

int main(){
    vector<int> weights = {7,4,5,6};
    cout<< solution(2, 10, weights)<<endl;

    return 0;
}