#include<iostream>
#include<vector>
using namespace std;

int dx[4] = { 0, 1, 0, -1 };
int dy[4] = { -1, 0, 1, 0 };
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<vector<int>> v(n, vector<int>(n));

	int x = 0, y = 0;
	int num = n * n;
	int direction = 0;
	int ansx = 0, ansy = 0;
	for (int i = 0; i < n * n; i++) {
		v[x][y] = num;
		if (num == m) {
			ansx = x + 1;
			ansy = y + 1;
		}
		num--;
		int nx = x + dx[direction];
		int ny = y + dy[direction];
		if (nx < 0 || nx >= n || ny < 0 || ny >= n || v[nx][ny] != 0) {
			direction = (direction + 1) % 4;
			nx = x + dx[direction];
			ny = y + dy[direction];
		}
		x = nx;
		y = ny;
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cout << v[i][j] << " ";
		}
		cout << '\n';
	}
	cout << ansx << " " << ansy;
	return 0;
}