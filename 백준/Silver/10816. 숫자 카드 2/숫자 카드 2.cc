#include<iostream>
#include<map>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	map<int, int> mp;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		if (mp.find(a) != mp.end()) mp[a]++;
		else mp[a] = 1;
	}

	int m;
	cin >> m;

	int ans;
	for (int i = 0; i < m; i++) {
		int a;
		cin >> a;
		if (mp.find(a) != mp.end()) cout << mp[a] << " ";
		else cout << 0 << " ";
	}

	return 0;
}