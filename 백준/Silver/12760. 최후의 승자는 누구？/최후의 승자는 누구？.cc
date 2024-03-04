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

	int n, m;
	cin >> n >> m;

	vector<int> point(n);
	vector<vector<int>> v(n, vector<int>(m));
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> v[i][j];
		}
		sort(v[i].begin(), v[i].end(), cmp);
	}

	vector<int> maxplayer;
	for (int i = 0; i < m; i++) {
		int max = 0;
		for (int j = 0; j < v.size(); j++) {
			if (max < v[j][i]) {
				max = v[j][i];
				maxplayer.clear();
				maxplayer.push_back(j);
			}
			else if (max == v[j][i]) maxplayer.push_back(j);
		}
		for (int j = 0; j < maxplayer.size(); j++) {
			point[maxplayer[j]]++;
		}
	}

	int maxpoint = 0;
	vector<int> maxp;
	for (int i = 0; i < point.size(); i++) {
		if (point[i] > maxpoint) {
			maxpoint = point[i];
			maxp.clear();
			maxp.push_back(i);
		}
		else if (maxpoint == point[i]) maxp.push_back(i);
	}
	for (int i = 0; i < maxp.size(); i++) {
		cout << maxp[i]+1 << " ";
	}
	return 0;
}