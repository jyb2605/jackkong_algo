#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer;
    for(int idx = 0; idx < prices.size(); idx++){
        int count = 0;
        for(int idx2 = idx + 1; idx2 < prices.size(); idx2++){
            count++;
            if(prices[idx] > prices[idx2]){
                break;
            }
        }
        answer.push_back(count);
    }
    
    return answer;
}
