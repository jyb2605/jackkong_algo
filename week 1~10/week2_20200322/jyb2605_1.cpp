#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> heights) {
	vector<int> answer(heights.size(), 0);

	for (int idx = 0; idx < heights.size()-1; idx++) {
		for (int idx2 = idx + 1; idx2 < heights.size(); idx2++) {
			if (heights[idx] <= heights[idx2])
				break;
			else {
				answer[idx2] = idx + 1;
			}
		}
	}

	return answer;
}
