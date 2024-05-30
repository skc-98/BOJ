#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
using namespace std;

int d[256] = { 0, };
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int max = 0;
	string s;
	while (getline(cin, s)) {
		for (int i = 0; i < s.length(); i++) {
			d[s[i]]++;
		}
	}

	vector<char> v;
	for (int i = 'a'; i <= 'z'; i++) {
		if (max < d[i]) {
			max = d[i];
			v.clear();
			v.push_back(char(i));
		}
		else if (max == d[i]) {
			v.push_back(char(i));
		}
	}
	sort(v.begin(), v.end());
	for (int i = 0; i < v.size(); i++) cout << v[i];
	return 0;
}