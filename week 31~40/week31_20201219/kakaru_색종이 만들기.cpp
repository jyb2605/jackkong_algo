#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdlib>
using namespace std;
int colorPaper[129][129];
int w = 0, b = 0;

void cutPaper(int x, int y, int n) {
	int tmp = 0;
	for (int i = x; i < x+n; i++) {
		for (int j = y; j < y+n; j++) {
			if (colorPaper[i][j] == 1)
				tmp++;
		}
	}
	if (tmp == 0) {
		w++;
	}
	else if(tmp == n * n){
		b++;
	}
	else {
		cutPaper(x, y, n / 2);
		cutPaper(x + n / 2, y, n / 2);
		cutPaper(x , y + n / 2, n / 2);
		cutPaper(x + n / 2, y + n / 2, n / 2);
	}
	
	return;
}
int main()
{
	int N;
	cin >> N;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cin >> colorPaper[i][j];
		}
	}
	cutPaper(1, 1, N);
	cout << w << endl << b << endl;
	return 0;
}