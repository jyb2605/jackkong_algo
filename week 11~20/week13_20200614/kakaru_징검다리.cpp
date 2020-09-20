#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(int distance, vector<int> rocks, int n) {
    int answer = 0;
    sort(rocks.begin(), rocks.end());
    int left = 1;
    int right = distance;
    while(left <= right){
        int mid = (left + right) / 2;
        int cnt = 0;
        int na = 0;
        for(int i = 0 ; i < rocks.size(); i++){
            if(rocks[i] - na >= mid){
                na = rocks[i];
            }
            else{
                cnt++;
            }
        }
        if(distance - rocks[rocks.size()-1] < mid){
            cnt++;
        }
        
        if(cnt > n){
            right = mid -1;
        }
        else{
            answer = mid;
            left = mid +1;
        }
    }
    return answer;
}