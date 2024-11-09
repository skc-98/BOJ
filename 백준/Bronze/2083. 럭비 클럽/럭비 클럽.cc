#include<iostream>
#include<string>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	vector<pair<string, string>> v;
	while (1) {
		string s;
		int a, b;
		cin >> s >> a >> b;
		if (s == "#" && a == 0 && b == 0) break;
		if (a > 17 || b >= 80) v.push_back({ s,"Senior" });
		else v.push_back({ s, "Junior" });
	}
	for (int i = 0; i < v.size(); i++) {
		cout << v[i].first << " " << v[i].second << '\n';
	}
	return 0;
}