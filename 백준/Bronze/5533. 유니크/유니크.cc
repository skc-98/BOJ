#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<vector<int>> v(n, vector<int>(3));
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < 3; j++) {
			cin >> v[i][j];
		}
	}

	vector<int> score(n, 0);
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < n; j++) {
			int now = v[j][i];
			bool check = true;
			for (int k = 0; k < n; k++) {
				if (j == k) continue;
				if (now == v[k][i]) {
					check = false;
					break;
				}
			}
			if (!check) continue;
			else score[j] += now;
		}
	}

	for (int i = 0; i < n; i++) cout << score[i] << '\n';
	return 0;
}