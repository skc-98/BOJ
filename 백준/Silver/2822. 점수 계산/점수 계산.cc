#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	vector<int> v;
	for (int i = 1; i <= 8; i++) {
		int n;
		cin >> n;
		v.push_back(n);
	}

	vector<pair<int, int>> index;
	for (int i = 0; i < v.size(); i++) {
		index.push_back(make_pair(v[i], i));
	}

	sort(index.begin(), index.end());

	int sum = 0;
	for (int i = index.size() - 1; i >= index.size() - 5; i--) {
		sum += index[i].first;
	}

	cout << sum << '\n';
	vector<int> v3;
	for (int i = index.size() - 1; i >= index.size() - 5; i--) {
		v3.push_back(index[i].second + 1);
	}
	sort(v3.begin(), v3.end());

	for (int i = 0; i < v3.size(); i++) {
		cout << v3[i] << " ";
	}

	return 0;
}