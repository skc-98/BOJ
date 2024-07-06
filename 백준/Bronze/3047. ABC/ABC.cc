#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	vector<int> v;
	string s;
	for (int i = 0; i < 3; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}
	cin >> s;
	sort(v.begin(), v.end());
	for (int i = 0; i < s.length(); i++) {
		if (s[i] == 'A') {
			cout << v[0] << " ";
		}
		else if (s[i] == 'B') {
			cout << v[1] << " ";
		}
		else {
			cout << v[2] << " ";
		}
	}

	return 0;
}