#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <stack>
using namespace std;


int main() {
	string name;
	string result = "";
	int cur = 0;
	int check = 0;
	char oddchar = 0;
	int curr = 0;
	cin >> name;

	sort(name.begin(), name.end());
	while (curr < name.size()) {
		int cnt = 0;
		string tmp;
		for (int i = cur; i < name.size(); i++) {
			if (name[cur] != name[i]) {
				cur = i;
				if (cnt % 2 == 0) {
					break;
				}
				else {
					if (oddchar == 0) {
						check = 0;
						oddchar = name[cur - 1];
						tmp = tmp.substr(1);
						break;
					}
					else {
						check = 1;
						break;
					}
				}
			}
			curr++;
			cnt++;
			tmp += name[cur];
		}
		if (tmp.length() % 2 == 1 && curr == name.size()) {
			if (oddchar == 0) {
				oddchar = tmp[0];
				tmp = tmp.substr(1);
			}
			else {
				check = 1;
			}
		}
		result = result.substr(0, result.length() / 2) + tmp + result.substr(result.length() / 2, result.length());
	}
	if (oddchar != 0)
		result = result.substr(0, result.length() / 2) + oddchar + result.substr(result.length() / 2, result.length());
	if (check == 1) {
		cout << "I'm Sorry Hansoo" << endl;
	}
	else {
		cout << result << endl;
	}


	return 0;
}