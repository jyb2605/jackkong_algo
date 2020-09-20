#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> routes) {
    int answer = 1;
    sort(routes.begin(), routes.end());
    
    int lastPos = routes[0][1];

    for (int idx = 0; idx < routes.size(); idx++) {
        if (lastPos > routes[idx][1])
            lastPos = routes[idx][1];
        if (lastPos < routes[idx][0]) {
            answer += 1;
            lastPos = routes[idx][1];
        }
    }


    return answer;
}