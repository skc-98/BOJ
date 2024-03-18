#include<iostream>
#include<string>
#include<map>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	map<string, int> mp;
	for (int i = 0; i < n; i++) {
		string a;
		cin >> a;
		mp[a]++;
	}

	int max = 0;
	vector<string> v;
	for (const auto& i : mp) {
		if (max < i.second) {
			v.clear();
			max = i.second;
			v.push_back(i.first);
		}
		else if (max == i.second) {
			v.push_back(i.first);
		}
	}

	for (int i = 0; i < v.size(); i++) {
		cout << v[i] << '\n';
	}

	return 0;
}