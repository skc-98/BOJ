#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

bool cmp(int a, int b) {
	return a > b;
}

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
	sort(v.begin(), v.end(), cmp);
	int max = 0;
	for (int i = 0; i < v.size(); i++) {
		int time = i + 2 + v[i];
		if (max < time) max = time;
	}
	cout << max;
	return 0;
}