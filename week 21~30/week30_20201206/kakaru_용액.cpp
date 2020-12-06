#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdlib>
using namespace std;

int main()
{
	vector<int> A;
	int N;
	cin >> N;
	for (int i = 0; i < N; i++) {
		int x;
		cin >> x;
		A.push_back(x);
	}
	int s = 0, e = A.size() - 1, sum = 0, tmpSum = abs(A[s] + A[e]);
	int x = 0, y = 0;

	while (s<e) {
		sum = A[s] + A[e];
		if (sum == 0) {
			x = A[s], y = A[e];
			break;
		}
		if (abs(sum) <= tmpSum) {
			x = A[s], y = A[e];
			tmpSum = abs(sum);
		}
		if (sum < 0) {
			s++;
		}
		if (sum > 0) {
			e--;
		}
	}
	cout << x <<" "<< y << endl;
	return 0;
}