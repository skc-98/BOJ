#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	string s;
	vector<string> v;
	for (int i = 0; i < n; i++) {
		cin >> s;
		reverse(s.begin(), s.end());
		v.push_back(s);
	}

	for (int i = 0; i < v.size(); i++) {
		cout << v[i] << '\n';
	}
	return 0;
}