#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#include<cmath>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<int> v(26);
	for (int i = 0; i < n; i++) {
		string s;
		cin >> s;
		for (int j = 0; j < s.length(); j++) {
			int a = s[j] - 'A';
			v[a] += pow(10, s.length() - j - 1);
		}
	}
	sort(v.begin(), v.end(), greater<int>());

	int num = 9;
	int ans = 0;
	for (int i = 0; i < 26; i++) {
		if (v[i] != 0) {
			ans += v[i] * num;
			num--;
		}
	}
	cout << ans;
	return 0;
}