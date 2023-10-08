#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	int n;
	cin >> n;

	vector<pair<int,int>> v;
	for (int i = 1; i <= n; i++) {
		int a, b;
		cin >> a >> b;
		v.push_back(make_pair(a, b));
	}

	vector<int> v2;
	for (int i = 0; i < v.size(); i++) {
		int count = 1;
		for (int j = 0; j < v.size(); j++) {
			if (i != j) {
				if (v[i].first < v[j].first && v[i].second < v[j].second) count++;
			}
		}
		v2.push_back(count);
	}
	for (int i = 0; i < v2.size(); i++) cout << v2[i] << " ";
	return 0;
}