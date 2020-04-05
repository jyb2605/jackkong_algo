#include <string>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;

map<int, int> m;

int solution(vector<int> citations) {
	int answer = 0;

	sort(citations.begin(), citations.end());

    for(int i= citations.size() -1; i >=0; i--){
        if(citations[i] > answer){
            answer++;
        }else{
            break;
        }
    }
	return answer;
}
