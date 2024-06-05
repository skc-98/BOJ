#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<pair<int,int>> v;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		v.push_back(make_pair(a, 0));
	}
	sort(v.begin(), v.end());

	int count = 0;
	for (int i = 0; i < v.size(); i++) {
		int check = v[i].first;
		if (v[i].second == 0) {
			v[i].second = 1;
			count++;
		}
		else continue;
		for (int j = i+1; j < v.size(); j++) {
			if (v[j].second == 0 && v[j].first > check) {
				v[j].second = 1;
				check = v[j].first;
			}
		}
	}
	cout << count;
	return 0;
}