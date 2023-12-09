#include<iostream>
#include<vector>
#include<algorithm>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<string> v;
	for (int i = 0; i < n; i++) {
		string a;
		cin >> a;
		v.push_back(a);
		sort(v[i].begin(), v[i].end());
	}
	sort(v.begin(), v.end());
	int count = 1;
	string cur = v[0];
	for (int i = 1; i < v.size(); i++) {
		if (v[i] != cur) {
			count++;
			cur = v[i];
		}
	}
	cout << count;
	return 0;
}