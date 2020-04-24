#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    int N, M, k;
    cin >> N >> M >> k;
    
    vector<vector<int>> ground(N+2,vector<int>(N+2,5));
    vector<vector<int>> a(N+2,vector<int>(N+2));
    vector<vector<vector<int>>> namu(N+2,vector<vector<int>>(N+2,vector<int>()));
    
    for(int i = 1; i < N+1; i++){
        for(int j = 1; j < N+1; j++){
            cin >> a[i][j];
        }
    }
    while(M--){
        int x, y, year;
        cin >> x >> y >> year;
        namu[x][y].push_back(year);
    }
    while(k--){
        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < N+1; j++){
                sort(namu[i][j].begin(), namu[i][j].end());
                int storage = 0;
                vector<int> tmp;
                for(int p = 0; p <namu[i][j].size(); p++){
                    if(ground[i][j] >= namu[i][j][p]){
                        ground[i][j] -= namu[i][j][p];
                        tmp.push_back(namu[i][j][p]+1);                        
                    }
                    else{
                        storage += namu[i][j][p]/2;
                    }
                }
                ground[i][j] += storage;
                namu[i][j] = tmp;
            }
        }
        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < N+1; j++){
                for(int p = 0; p <namu[i][j].size(); p++){
                    if(namu[i][j][p]%5 == 0){
                        namu[i-1][j-1].push_back(1);
                        namu[i][j-1].push_back(1);
                        namu[i+1][j-1].push_back(1);
                        namu[i-1][j].push_back(1);
                        namu[i+1][j].push_back(1);
                        namu[i-1][j+1].push_back(1);
                        namu[i][j+1].push_back(1);
                        namu[i+1][j+1].push_back(1);
                    }
                }
            }
        }
        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < N+1; j++){
                ground[i][j] += a[i][j];
            }
        }
        
    }
    
    int answer = 0;
    for(int i = 1; i < N + 1; i++){
        for(int j = 1; j < N + 1; j++){
            answer += namu[i][j].size();
        }
    }
    cout<<answer<<endl;
    return 0;
}