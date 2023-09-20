#include<iostream>
#include<string>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<string> v;
	for (int i = 1; i <= n; i++) {
		string a;
		cin >> a;
		v.push_back(a);
	}

	string answer;
	for (int i = 0; i < v[0].length(); i++) {
		int state = 0;
		char p = v[0][i];
		for (int j = 0; j < v.size(); j++) {
			if (p != v[j][i]) state = 1;
		}
		if (state == 0) {
			answer += p;
		}
		else {
			answer += '?';
		}
	}

	cout << answer;
	return 0;
}