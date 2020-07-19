#include <iostream>
#include <algorithm>

using namespace std;


int main(){

    int case_Num;
    cin>>case_Num;

    for (int i = 0; i<case_Num; i++){
        int arr_Num, answer1=0, answer2=0;;
        cin>>arr_Num;

        int input_arr[2][100000]={0,};
        int dp[2][100000] ={0,};

        for(int j=0; j<2;j++){
            //input
            for(int k=0; k<arr_Num;k++){
                cin>>input_arr[j][k];
            }
        }

        dp[0][0] = input_arr[0][0];
        dp[1][0] = input_arr[1][0];
        dp[0][1] = dp[1][0] + input_arr[0][1];
        dp[1][1] = dp[0][0] + input_arr[1][1];

        for(int j = 2; j<arr_Num; j++){

            int sum0_1 = dp[1][j-2];
            int sum0_2 = dp[1][j-1];

            dp[0][j] = input_arr[0][j]+max(sum0_1, sum0_2);

            int sum1_1 = dp[0][j-2];
            int sum1_2 = dp[0][j-1];
            dp[1][j] = input_arr[1][j]+max(sum1_1, sum1_2);
        }

        cout<<max(dp[0][arr_Num-1], dp[1][arr_Num-1])<<endl;

    }
    return 0;
}


// 예제만 나옴 ㅜ
// int main(){

//     int case_Num;
//     cin>>case_Num;

//     for (int i = 0; i<case_Num; i++){
//         int arr_Num, answer1=0, answer2=0;;
//         cin>>arr_Num;

//         int input_arr[2][100000]={0,};
//         int dp[2][100000] ={0,};

//         for(int j=0; j<2;j++){
//             //input
//             for(int k=0; k<arr_Num;k++){
//                 cin>>input_arr[j][k];
//             }
//         }

//         //case1 : 위쪽 줄 선택
//         int low = 0;
//         int opp = 1;
//         answer1 += input_arr[0][0];
//         for(int j=1;j<arr_Num-1;j+=2){
//             int tmp;
//             tmp = low;
//             low = opp;
//             opp = tmp;
            
//             int sum1 = (input_arr[low][j]+input_arr[opp][j+1]);
//             int sum2 = input_arr[opp][j+1];
//             int sum3 = input_arr[low][j+1];

//             answer1 += max((input_arr[low][j]+input_arr[opp][j+1]), max(input_arr[opp][j+1], input_arr[low][j+1]));

//             if (sum2<sum3){
//                 low = opp;
//             }
//             if(max(sum2,sum3) < sum1){
//                 low = opp;
//             }
//             // cout<<answer1<<endl;
//         }

//         //case2 : 아래쪽 줄 선택
//         low = 1;
//         opp = 0;
//         answer2 += input_arr[1][0];
//         for(int j=1;j<arr_Num-1;j+=2){
//             int tmp;
//             tmp = low;
//             low = opp;
//             opp = tmp;

//             int sum1 = (input_arr[low][j]+input_arr[opp][j+1]);
//             int sum2 = input_arr[opp][j+1];
//             int sum3 = input_arr[low][j+1];

//             answer2 += max((input_arr[low][j]+input_arr[opp][j+1]), max(input_arr[opp][j+1], input_arr[low][j+1]));

//             if (sum2<sum3){
//                 low = opp;
//             }
//             if(max(sum2,sum3) < sum1){
//                 low = opp;
//             }
//         }
//         // cout<<answer1<<endl;
//         // cout<<answer2<<endl;
//         cout<<max(answer1, answer2)<<endl;

//     }
//     return 0;
// }