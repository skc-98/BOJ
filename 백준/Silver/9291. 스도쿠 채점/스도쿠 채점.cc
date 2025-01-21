#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	for (int tc = 1; tc <= n; tc++) {
		vector<vector<int>> v(9, vector<int>(9));
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				cin >> v[i][j];
			}
		}

		bool ans = true;
		for (int i = 0; i < 9; i++) {
			bool check[10] = { 0, };
			for (int j = 0; j < 9; j++) {
				check[v[i][j]] = true;
			}
			for (int j = 1; j <= 9; j++) if (!check[j]) ans = false;
		}

		for (int i = 0; i < 9; i++) {
			bool check[10] = { 0, };
			for (int j = 0; j < 9; j++) {
				check[v[j][i]] = true;
			}
			for (int j = 1; j <= 9; j++) if (!check[j]) ans = false;
		}

		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				bool check[10] = { 0, };
				for (int row = 0; row < 3; row++) {
					for (int col = 0; col < 3; col++) {
						check[v[i+row][j+col]] = true;
					}
				}
				for (int j = 1; j <= 9; j++) if (!check[j]) ans = false;
			}
		}

		if (!ans) {
			cout << "Case " << tc << ": INCORRECT\n";
			continue;
		}
		else {
			cout << "Case " << tc << ": CORRECT\n";
		}
	}

	return 0;
}