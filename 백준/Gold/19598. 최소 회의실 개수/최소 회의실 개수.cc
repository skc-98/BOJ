#include<iostream>
#include<queue>
#include<vector>
#include<algorithm>
using namespace std;

struct cmp {
	bool operator()(const int& a, const int& b) {
		return a > b;
	}
};

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<pair<int, int>> v;
	for (int i = 0; i < n; i++) {
		int begin, end;
		cin >> begin >> end;
		v.push_back(make_pair(begin, end));
	}
	sort(v.begin(), v.end());

	priority_queue<int, vector<int>, cmp> pq;
	pq.push(v[0].second);

	for (int i = 1; i < v.size(); i++) {
		if (pq.top() <= v[i].first) {
			pq.pop();
		}
		pq.push(v[i].second);
	}

	cout << pq.size();
	return 0;
}