#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	vector<int> A;
	int N, M;
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		int x;
		cin >> x;
		A.push_back(x);
	}
	int s = 0, e = A.size() - 1, sum = 0, cnt = 0, chk = 0;;
	sort(A.begin(), A.end());
	while (1) {
		sum = A[s] + A[e];
		if (sum == M) {
			s++;
			e--;
			cnt++;
			chk += 2;
		}
		else if (A[s] + A[e] > M) {
			e--;
			chk++;
		}
		else if (A[s] + A[e] < M) {
			s++;
			chk++;
		}
		if (chk > A.size()-2)
			break;
	}
	cout << cnt << endl;
	return 0;
}