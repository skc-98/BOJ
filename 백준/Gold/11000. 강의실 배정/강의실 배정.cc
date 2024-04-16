#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	
	vector<pair<int, int>> v;
	for (int i = 0; i < n; i++) {
		int a, b;
		cin >> a >> b;
		v.push_back(make_pair(a, b));
	}
	sort(v.begin(), v.end());

	priority_queue<int, vector<int>, greater<int>> q;
	q.push(v[0].second);
	for (int i = 1; i < n; i++) {
		if (v[i].first >= q.top()) q.pop();
		q.push(v[i].second);
	}
	cout << q.size();
	return 0;
}