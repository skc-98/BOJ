#include<iostream>
#include<set>
#include<algorithm>
#include<vector>
using namespace std;

bool cmp(string a, string b) {
	return a > b;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	set<string> s;
	for (int i = 0; i < n; i++) {
		string name, order;
		cin >> name >> order;
		if (order == "enter") {
			s.insert(name);
		}
		else if (order == "leave") {
			s.erase(name);
		}
	}
	vector<string> v;
	for (const string& name : s) v.push_back(name);
	sort(v.begin(), v.end(), cmp);

	for (int i = 0; i < v.size(); i++) cout << v[i] << '\n';
	return 0;
}