#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<pair<int, int>> v;
	for (int i = 0; i < n; i++) {
		int a, begin, end;
		cin >> a >> begin >> end;
		v.push_back(make_pair(begin, end));
	}
	sort(v.begin(), v.end());

	priority_queue<int, vector<int>, greater<int>> pq;
	pq.push(v[0].second);
	for (int i = 1; i < v.size(); i++) {
		if (v[i].first >= pq.top()) pq.pop();
		pq.push(v[i].second);
	}
	cout << pq.size();
	return 0;
}