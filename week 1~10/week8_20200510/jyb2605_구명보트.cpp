#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    sort(people.begin(), people.end());
    vector<bool> check(people.size(), false);
    int front = 0, idx;

    for (idx = people.size() - 1; idx >= 0; idx--) {
        if (check[idx])
            continue;
        if (people[front] + people[idx] <= limit) {
            check[front++] = true; 
        }
        check[idx] = true;
        answer++;
    }
    if (front == idx)
        answer++;

    return answer;
}