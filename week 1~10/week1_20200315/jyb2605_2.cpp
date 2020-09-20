#include <iostream>
#include <vector>
#include <stack>
using namespace std;

void func(vector<int> numbers, int cur, vector<int> lotto){

    if(lotto.size() == 6){
        for(int idx = 0; idx < 6; idx++){
            cout<<lotto[idx]<<' ';
        }
        cout<<endl;
        return;
    }


    for(int idx = cur; idx < numbers.size(); idx++){
        lotto.push_back(numbers[idx]);
        func(numbers, idx + 1, lotto);
        lotto.pop_back();
    }
}

int main(){
    int num;
    vector<int> numbers;
    vector<int> lotto;

    while(true){
        lotto.clear();
        cin>>num;
        if(num == 0){
            break;
        }
        
        numbers = vector<int>(num);
        for(int idx = 0; idx < num; idx++){
            cin>>numbers[idx];
        }

        func(numbers, 0, lotto);
        cout<<endl;
    }

    return 0;
}