#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> weight) {
    sort(weight.begin(), weight.end());
    int answer = 0;
   
    for(int idx = 0; idx < weight.size(); idx++){
        if(answer + 1 < weight[idx])
            break;
        else
            answer += weight[idx]; 
    }

    return answer + 1;
}