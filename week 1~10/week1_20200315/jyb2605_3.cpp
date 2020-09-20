#include <iostream>
#include <queue>
#include <vector>
using namespace std;


int main(){
    int N, result = 0;
    cin>>N;
    vector<vector<char> > map(N, vector<char>(N));
    vector<vector<bool> > visited(N, vector<bool>(N, false));
    queue<pair<int, int> > q;

    getchar();
    for(int row = 0; row < N; row++){
        for(int col =0; col < N; col++){
            map[row][col] = getchar();
        }
        getchar();
    }

    for(int row = 0; row < N; row++){
        for(int col = 0; col < N; col++){
            if(!visited[row][col]){
                // BFS
                q.push(make_pair(row, col));
                visited[row][col] = true;
                char cur = map[row][col];

                while(!q.empty()){
                    pair<int, int> front = q.front();
                    q.pop();
                    int x = front.first;
                    int y = front.second;

                    if(y > 0 && map[x][y - 1] == cur && !visited[x][y - 1]){
                        q.push(make_pair(x, y - 1));
                        visited[x][y - 1] = true;
                    }
                    if(y < N - 1 && map[x][y + 1] == cur && !visited[x][y + 1]){
                        q.push(make_pair(x, y + 1));
                        visited[x][y + 1] = true;
                    }
                    if(x < N - 1 && map[x + 1][y] == cur && !visited[x + 1][y]){
                        q.push(make_pair(x + 1, y));
                        visited[x + 1][y] = true;
                    }
                    if(x > 0 && map[x - 1][y] == cur && !visited[x - 1][y]){
                        q.push(make_pair(x - 1, y));
                        visited[x - 1][y] = true;
                    }
                }
                result++;
            }
        }
    }
    cout<<result<<' ';
    result = 0;

    visited = vector<vector<bool> >(N, vector<bool>(N, false));

    for(int row = 0; row < N; row++){
        for(int col =0; col < N; col++){
            if(map[row][col] == 'G'){
                map[row][col] = 'R';
            }
        }
    }

    for(int row = 0; row < N; row++){
        for(int col = 0; col < N; col++){
            if(!visited[row][col]){
                // BFS
                q.push(make_pair(row, col));
                visited[row][col] = true;
                char cur = map[row][col];

                while(!q.empty()){
                    pair<int, int> front = q.front();
                    q.pop();
                    int x = front.first;
                    int y = front.second;

                    if(y > 0 && map[x][y - 1] == cur && !visited[x][y - 1]){
                        q.push(make_pair(x, y - 1));
                        visited[x][y - 1] = true;
                    }
                    if(y < N - 1 && map[x][y + 1] == cur && !visited[x][y + 1]){
                        q.push(make_pair(x, y + 1));
                        visited[x][y + 1] = true;
                    }
                    if(x < N - 1 && map[x + 1][y] == cur && !visited[x + 1][y]){
                        q.push(make_pair(x + 1, y));
                        visited[x + 1][y] = true;
                    }
                    if(x > 0 && map[x - 1][y] == cur && !visited[x - 1][y]){
                        q.push(make_pair(x - 1, y));
                        visited[x - 1][y] = true;
                    }
                }
                result++;
            }
        }
    }

    cout<<result<<endl;
}