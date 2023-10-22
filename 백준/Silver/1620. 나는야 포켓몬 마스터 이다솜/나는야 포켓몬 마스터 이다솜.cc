#include<iostream>
#include<string>
#include<map>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	map<int, string> mp;
	map<string, int> mp2;

	for (int i = 1; i <= n; i++) {
		string a;
		cin >> a;
		mp.insert(make_pair(i, a));
		mp2.insert(make_pair(a, i));
	}

	for (int i = 1; i <= m; i++) {
		string a;
		cin >> a;
		if (a[0] >= '0' && a[0] <= '9') {
			int t;
			t = stoi(a);
			cout << mp[t] << '\n';
		}
		else {
			cout << mp2[a] << '\n';
		}
	}

	return 0;
}