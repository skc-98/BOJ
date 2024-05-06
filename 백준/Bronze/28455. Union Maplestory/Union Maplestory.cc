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

	vector<int> v;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}
	sort(v.begin(), v.end());

	int sum = 0;
	int level = 0;
	if (v.size() > 42) {
		for (int i = v.size() - 1; i >= v.size() - 42; i--) {
			sum += v[i];
			if (v[i] >= 250) level += 5;
			else if (v[i] >= 200) level += 4;
			else if (v[i] >= 140) level += 3;
			else if (v[i] >= 100) level += 2;
			else if (v[i] >= 60) level += 1;
		}
	}
	else {
		for (int i = 0; i < v.size(); i++) {
			sum += v[i];
			if (v[i] >= 250) level += 5;
			else if (v[i] >= 200) level += 4;
			else if (v[i] >= 140) level += 3;
			else if (v[i] >= 100) level += 2;
			else if (v[i] >= 60) level += 1;
		}
	}
	cout << sum << " " << level;
	return 0;
}