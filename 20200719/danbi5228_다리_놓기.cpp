#include <iostream>
#include <algorithm>

using namespace std;


int main(){

    int case_Num;
    int N, M;
    cin>>case_Num;

    long long dp[31][31] = {0,};
    dp[0][0] = 1;
    for (int i = 1; i<=30; i++){
        for(int j = 0; j<=i; j++){
            if (j == 0 || j==i){
                dp[i][j] = 1;
                continue;
            }
            dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
        }
    }

    for(int i = 0; i<case_Num; i++){
        cin>>N>>M;
        cout<<dp[M][N]<<endl;
    }

    return 0;
}