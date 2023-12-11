#include<iostream>
#include<algorithm>
#include<vector>
#include<string>
using namespace std;

bool cmp(const pair<char, int>& a, const pair<char, int>& b) {
	if (a.first == b.first) {
		return a.second > b.second;
	}
	else {
		if (a.first == 'B') return true;
		else if (a.first == 'S') {
			if (b.first == 'B') return false;
			else return true;
		}
		else if (a.first == 'G') {
			if (b.first == 'B' || b.first == 'S') return false;
			else return true;
		}
		else if (a.first == 'P') {
			if (b.first == 'B' || b.first == 'S' || b.first == 'G') return false;
			else return true;
		}
		else return false;
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<string> v;
	for (int i = 1; i <= n; i++) {
		string a;
		cin >> a;
		v.push_back(a);
	}

	vector<pair<char, int>> v2;
	for (int i = 0; i < v.size(); i++) {
		string s = "";
		for (int j = 1; j < v[i].length(); j++) {
			s += v[i][j];
		}
		v2.push_back(make_pair(v[i][0], stoi(s)));
	}
	vector<pair<char, int>> v3;
	v3 = v2;
	sort(v3.begin(), v3.end(), cmp);

	if (v2 == v3) cout << "OK";
	else {
		cout << "KO" << '\n';
		for (int i = 0; i < v3.size(); i++) {
			if (v2[i] != v3[i]) {
				cout << v3[i].first << v3[i].second << " ";
			}
		}
	}

	return 0;
}