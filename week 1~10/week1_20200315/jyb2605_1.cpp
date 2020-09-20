#include <iostream>
#include <stack>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    int N, M, V;
    int x, y;

    cin>> N>>M>>V;

//DFS
    stack<int> s;
    vector<bool> visited(M+1, false);
    vector< vector<int> > adj(N+1, vector<int>());

    for(int idx = 0; idx < M; idx++){
        cin>>x>>y;
        adj[x].push_back(y);
        adj[y].push_back(x);
    }

    for(int idx = 0; idx < M; idx++){
        sort(adj[idx].begin(), 
                adj[idx].end());
    }

    visited[V] = true;
    cout<<V<<' ';
    s.push(V);

    while(s.empty() == false){
        int cur = s.top();
        bool isVisit = false;
        for(int idx = 0; idx < adj[cur].size(); idx++){
            if(visited[adj[cur][idx]]){
                continue;
            }else{
                visited[adj[cur][idx]] = true;
                cout<<adj[cur][idx]<<' ';
                s.push(adj[cur][idx]);
                isVisit = true;
                break;
            }
        }

        if(isVisit == false){
            s.pop();
        }
    }

    cout<<endl;

//BFS
    queue<int> q;
    visited = vector<bool>(N+1, false);

    visited[V] = true;
    cout<<V<<' ';
    q.push(V);

    while(q.empty() == false){
        int front = q.front();
        for(int idx = 0; idx < adj[front].size(); idx++){
            if(visited[adj[front][idx]] == false){
                visited[adj[front][idx]] = true;
                cout<<adj[front][idx]<<' ';
                q.push(adj[front][idx]);
            }
        }
        q.pop();
    }

    cout<<endl;
    
    return 0;
}