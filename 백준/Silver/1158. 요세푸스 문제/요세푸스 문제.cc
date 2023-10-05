#include<iostream>
#include<queue>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n, m;
	cin >> n >> m;

	queue<int> q;
	for (int i = 1; i <= n; i++) q.push(i);

	vector<int> v;
	while (1) {
		if (q.empty() == true) break;
		for (int i = 1; i < m; i++) {
			q.push(q.front());
			q.pop();
		}
		v.push_back(q.front());
		q.pop();
	}
	
	cout << "<";
	for (int i = 0; i < v.size() - 1; i++) {
		cout << v[i] << ", ";
	}
	cout << v[v.size() - 1] << ">";
	return 0;
}