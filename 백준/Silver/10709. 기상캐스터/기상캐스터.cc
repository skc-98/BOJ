#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<vector<char>> v(n, vector<char>(m));
	vector<vector<int>> ans(n, vector<int>(m));
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> v[i][j];
		}
	}

	int count;
	for (int i = 0; i < n; i++) {
		count = -1;
		for (int j = 0; j < m; j++) {
			if (v[i][j] == 'c') {
				ans[i][j] = 0;
				count = 0;
			}
			else if (v[i][j] == '.') {
				if (count == -1) {
					ans[i][j] = -1;
				}
				else {
					count++;
					ans[i][j] = count;
				}
			}
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cout << ans[i][j] << " ";
		}
		cout << '\n';
	}

	return 0;
}