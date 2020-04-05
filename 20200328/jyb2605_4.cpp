#include <vector>
#include <string>
#include <algorithm>
using namespace std;
 
bool cmp(string a, string b) {
    return a + b > b + a;
}
 
string solution(vector<int> numbers) {
    string answer = "";
    vector<string> arr;
    for(int num : numbers){
        arr.push_back(to_string(num));
    }
    sort(arr.begin(), arr.end(), cmp);
    if (arr.at(0) == "0"){
        return "0";
    }
    for(string num : arr){
        answer += num;
    }
    return answer;
}
