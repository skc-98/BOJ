#include<iostream>
#include<vector>
#include<string>
#include<algorithm>
using namespace std;

bool cmp(const string &s1, const string &s2) {
	if (s1.length() != s2.length()) return s1.length() < s2.length();
	return s1 < s2;
}
bool cmp2(const string& s1, const string& s2) {
	int a = stoi(s1.substr(7));
	int b = stoi(s2.substr(7));
	return a < b;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	cin.ignore();

	vector<string> v;
	vector<string> v2;
	for (int i = 0; i < n; i++) {
		string s;
		getline(cin, s);
		if (s.find("boj.kr/") == 0) v2.push_back(s);
		else v.push_back(s);
	}
	sort(v.begin(), v.end(), cmp);
	sort(v2.begin(), v2.end(), cmp2);

	for (int i = 0; i < v.size(); i++) cout << v[i] << '\n';
	for (int i = 0; i < v2.size(); i++) cout << v2[i] << '\n';

	return 0;
}