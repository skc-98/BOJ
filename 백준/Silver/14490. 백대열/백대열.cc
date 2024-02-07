#include<iostream>
#include<string>
#include<numeric>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	cin >> s;

	string a="";
	vector<int> v;
	for (int i = 0; i < s.length(); i++) {
		if (s[i] == ':') {
			v.push_back(stoi(a));
			a = "";
			continue;
		}
		a += s[i];
	}
	v.push_back(stoi(a));

	int k = gcd(v[0], v[1]);
	for (int i = 0; i < v.size(); i++) {
		v[i] = v[i] / k;
	}
	cout << v[0] << ":" << v[1];
	return 0;
}