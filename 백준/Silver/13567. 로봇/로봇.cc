#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	int x = 0, y = 0;
	vector<pair<string, int>> v;
	for (int i = 0; i < m; i++) {
		string s; int a;
		cin >> s >> a;
		v.push_back({ s,a });
	}

	int dir = 1;
	for (int i = 0; i < v.size(); i++) {
		if (v[i].first == "MOVE") {
			if (dir == 1) {
				x += v[i].second;
			}
			else if (dir == 2) {
				y += v[i].second;
			}
			else if (dir == 3) {
				x -= v[i].second;
			}
			else if (dir == 4) {
				y -= v[i].second;
			}
		}
		else if (v[i].first == "TURN") {
			if (v[i].second == 0) {
				dir++;
				if (dir >= 5) dir -= 4;
			}
			else if (v[i].second == 1) {
				dir--;
				if (dir < 1) dir += 4;
			}
		}
		if (x < 0 || x >= n || y < 0 || y >= n) {
			cout << -1;
			return 0;
		}
	}
	cout << x << " " << y;
	return 0;
}