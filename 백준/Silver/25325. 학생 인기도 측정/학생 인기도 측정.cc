#include<iostream>
#include<vector>
#include<string>
#include<algorithm>
using namespace std;

bool cmp(pair<string,int> a, pair<string,int> b){
	if (a.second == b.second) {
		return a.first < b.first;
	}
	return a.second > b.second;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<pair<string, int>> v;

	for (int i = 0; i < n; i++) {
		string a;
		cin >> a;
		v.push_back(make_pair(a, 0));
	}
	cin.ignore();
	for (int i = 0; i < n; i++) {
		string a;
		getline(cin, a);
		string s = "";
		for (int i = 0; i < a.length(); i++) {
			if (a[i] == ' ') {
				for (int j = 0; j < v.size(); j++) {
					if (v[j].first == s) {
						v[j].second++;
						break;
					}
				}
				s = "";
				continue;
			}
			s += a[i];
		}
		if (s != "") {
			for (int j = 0; j < v.size(); j++) {
				if (v[j].first == s) {
					v[j].second++;
					break;
				}
			}
		}
	}
	sort(v.begin(), v.end(), cmp);
	for (int i = 0; i < v.size(); i++) {
		cout << v[i].first << " " << v[i].second << '\n';
	}

	return 0;
}