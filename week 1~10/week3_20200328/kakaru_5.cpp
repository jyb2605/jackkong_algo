#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> citations) {
    int answer = 0;
    sort(citations.begin(), citations.end());
    for(int i = citations.back(); i >= 0; i--){
        int cnt1 = 0;
        int cnt2 = 0;
        for(int j = 0; j < citations.size(); j++){
            if(citations[j] >= i)
                cnt1++;
            if(citations[j] <= i)
                cnt2++;
        }
        if(i<=cnt1 && i>=cnt2){
             answer = i;
             break;
        }
    }    
    return answer;
}