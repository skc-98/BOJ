#include<iostream>
#include<vector>
#include<string>
#include<algorithm>
using namespace std;

bool cmp(string a, string b) {
	transform(a.begin(), a.end(), a.begin(), ::tolower);
	transform(b.begin(), b.end(), b.begin(), ::tolower);
	return a < b;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	while (1) {
		int n;
		cin >> n;
		if (n == 0) break;

		vector<string> v;
		for (int i = 0; i < n; i++) {
			string s;
			cin >> s;
			v.push_back(s);
		}
		sort(v.begin(), v.end(), cmp);
		cout << v[0] << '\n';
	}
	return 0;
}