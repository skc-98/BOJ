#include<iostream>
#include<vector>
#include<algorithm>
#include<string>
using namespace std;

bool cmp(pair<string, double> a, pair<string, double> b) {
	return a.second > b.second;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	while (1) {
		int n;
		cin >> n;
		if (n == 0) break;

		vector<pair<string, double>> v;
		for (int i = 1; i <= n; i++) {
			string name; double len;
			cin >> name >> len;
			v.push_back(make_pair(name, len));
		}
		stable_sort(v.begin(), v.end(), cmp);

		double max = v[0].second;
		for (int i = 0; i < v.size(); i++) {
			if (v[i].second == max) {
				cout << v[i].first << " ";
			}
			else break;
		}
		cout << '\n';
	}

	return 0;
}