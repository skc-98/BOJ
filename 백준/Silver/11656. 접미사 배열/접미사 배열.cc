#include<iostream>
#include<vector>
#include<string>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	cin >> s;
	vector<string> v;
	for (int i = 0; i < s.length(); i++) {
		string a = "";
		for (int j = i; j < s.length(); j++) {
			a += s[j];
		}
		v.push_back(a);
	}
	sort(v.begin(), v.end());

	for (int i = 0; i < v.size(); i++) {
		cout << v[i] << '\n';
	}

	return 0;
}