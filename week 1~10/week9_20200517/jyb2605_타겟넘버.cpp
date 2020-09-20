#include <string>
#include <vector>

using namespace std;

int answer = 0;

void dfs(vector<int> numbers, int idx, int target, int result) {
	if (idx == numbers.size() && result == target) {
		answer++;
		return;
	}
    if(idx > numbers.size())
        return;

	dfs(numbers, idx + 1, target, result + numbers[idx]);
	dfs(numbers, idx + 1, target, result - numbers[idx]);
}

int solution(vector<int> numbers, int target) {
	dfs(numbers, 0, target, 0);

	return answer;
}
