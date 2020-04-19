#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(string name) {
    int answer = 0;
    int length = name.length();
    int maxMove = length - 1;
    int a, z, next;
    
    for(int idx = 0; idx < length; idx++){
        a = name[idx] - 'A';
        z = 'Z' - name[idx] + 1;
        
        if( a > z) answer += z;
        else    answer += a;
        
        next = idx + 1;
        
        while(next < length && name[next] == 'A') next++;
        
        maxMove = min(maxMove, idx + length - next + min(idx, length - idx));
    }
    
    answer += maxMove;
    
    return answer;
}
