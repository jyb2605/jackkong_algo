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
	int s = 0, e = 0, sum = 0, cnt = N+1;
	while (1) {
		if (sum >= M) {
			cnt = min(cnt, e - s);
			sum -= A[s];
			s++;
		}
		else if (e == N)
			break;
		else {
			sum += A[e];
			e++;
		}
	}
	if (cnt == N + 1)
		cnt = 0;
	cout << cnt << endl;
	return 0;
}