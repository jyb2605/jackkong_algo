#include <string>
#include <vector>
#include <algorithm>
#include <stack>
using namespace std;
int answer = 0;
void targetnumber(int sum, vector<int> numbers, int idx, int target){
    if(idx == numbers.size() && sum == target){
        answer++;
        return;
    }
    if(idx >= numbers.size())
        return;
    targetnumber(sum + numbers[idx], numbers, idx+1, target);
    targetnumber(sum - numbers[idx], numbers, idx+1, target);    
}

int solution(vector<int> numbers, int target){

    targetnumber(0, numbers, 0, target);
    
    return answer;
}