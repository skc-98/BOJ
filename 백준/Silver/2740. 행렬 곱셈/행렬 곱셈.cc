#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<vector<int>> m1(n, vector<int>(m));
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			int a;
			cin >> a;
			m1[i][j] = a;
		}
	}

	int x, y;
	cin >> x >> y;

	vector<vector<int>> m2(x, vector<int>(y));
	for (int i = 0; i < x; i++) {
		for (int j = 0; j < y; j++) {
			int a;
			cin >> a;
			m2[i][j] = a;
		}
	}

	vector<vector<int>> ans(n, vector<int>(y));
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < y; j++) {
			ans[i][j] = 0;
			for (int k = 0; k < m; k++) {
				ans[i][j] += (m1[i][k] * m2[k][j]);
			}
		}
	}

	for (int i = 0; i < ans.size(); i++) {
		for (int j = 0; j < ans[i].size(); j++) {
			cout << ans[i][j] << " ";
		}
		cout << '\n';
	}

	return 0;
}