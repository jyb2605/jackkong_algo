#include <string>
#include <vector>
#include <algorithm>
using namespace std;

long long solution(int n, vector<int> times) {
    long long answer = 0;
    sort(times.begin(),times.end());
    unsigned long long left = 0;
    unsigned long long total;
    unsigned long long mid;
    unsigned long long right = times[times.size()-1] * n;
    while(left <= right){
        total = 0;
        mid = (left + right) / 2;
        for(int i = 0; i < times.size(); i++){
            total += mid / times[i];
        }
        if(total >= n){
            answer = mid;
            right = mid - 1;
        }
        else{
            left = mid + 1;
        }
    }
    return answer;
}