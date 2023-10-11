#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int find(int v);
void unionsets(int a, int b);

vector<int> parent;

int find(int v) {
	if (parent[v] == v) return v;
	return parent[v] = find(parent[v]);
}

void unionsets(int a, int b) {
	int rootA = find(a);
	int rootB = find(b);
	if (rootA != rootB) {
		parent[rootB] = rootA;
	}
}

bool cmp(const vector<int>& a, const vector<int>& b) {
	return a[2] < b[2];
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<vector<int>> v;
	for (int i = 0; i < m; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		v.push_back({ a,b,c });
	}
	sort(v.begin(), v.end(), cmp);

	parent.resize(n + 1);
	for (int i = 1; i <= n; i++) parent[i] = i;

	int sum = 0;
	for (int i = 0; i < m; i++) {
		if (find(v[i][0]) != find(v[i][1])) {
			unionsets(v[i][0], v[i][1]);
			sum += v[i][2];
		}
	}
	cout << sum;
	return 0;
}