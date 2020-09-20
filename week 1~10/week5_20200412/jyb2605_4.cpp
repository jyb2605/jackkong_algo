#include <string>
#include <vector>
#include <functional>
#include <queue>

using namespace std;

int solution(int n, vector<vector<int>> costs) {
    int answer = 0;
    vector<vector<int>> adj(n, vector<int>(n, 0));
    vector<bool> visited(n, false);
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    
    for(int idx = 0; idx < costs.size(); idx++){
        adj[costs[idx][0]][costs[idx][1]] = costs[idx][2];
        adj[costs[idx][1]][costs[idx][0]] = costs[idx][2];
    }
    
    int count = 1;
    visited[0] = true;
    for(int idx = 0; idx < n; idx++){
        if(adj[0][idx] != 0){
            pq.push(make_pair(adj[0][idx], idx));        
        }
    }
    
    while(!pq.empty()){
        if(count >= n)
            break;
        pair<int, int> top = pq.top();
        pq.pop();
        if(visited[top.second])
            continue;            
        
        visited[top.second] = true;
        count++;
        answer += top.first;
        
        for(int idx = 0; idx < n; idx++){
            if(adj[top.second][idx] != 0 && !visited[idx]){
                pq.push(make_pair(adj[top.second][idx], idx));        
            }
        }
    }
    
    return answer;
}
