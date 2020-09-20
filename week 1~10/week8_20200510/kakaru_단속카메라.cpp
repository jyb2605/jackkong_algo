#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<vector<int>> routes) {
    int answer = 1;
    sort(routes.begin(),routes.end());
    int a = routes[0][1];
    
    for(int i = 1; i < routes.size(); i++){
        if(a > routes[i][0] && a > routes[i][1]){
            a = routes[i][1];
        }
        if(a < routes[i][0]){
            a = routes[i][1];
            answer++;
        }
    }   
    
    return answer;
}