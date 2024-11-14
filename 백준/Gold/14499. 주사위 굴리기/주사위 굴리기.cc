#include<iostream>
#include<vector>
using namespace std;

int dice[6] = { 0,0,0,0,0,0 };
int map[21][21];
int dx[4] = { 0, 0, -1, 1 };
int dy[4] = { 1, -1, 0, 0 };
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m, x, y, num;
	cin >> n >> m >> x >> y >> num;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];
		}
	}

	vector<int> order(num);
	for (int i = 0; i < num; i++) {
		cin >> order[i];
	}

	for (int i = 0; i < order.size(); i++) {
		int dir = order[i];
		int nx = x + dx[dir - 1];
		int ny = y + dy[dir - 1];
		if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

		x = nx;
		y = ny;
		int tmp;
		if (dir == 1) {
			tmp = dice[0];
			dice[0] = dice[3];
			dice[3] = dice[5];
			dice[5] = dice[2];
			dice[2] = tmp;
		}
		else if (dir == 2) {
			tmp = dice[0];
			dice[0] = dice[2];
			dice[2] = dice[5];
			dice[5] = dice[3];
			dice[3] = tmp;
		}
		else if (dir == 3) {
			tmp = dice[0];
			dice[0] = dice[4];
			dice[4] = dice[5];
			dice[5] = dice[1];
			dice[1] = tmp;
		}
		else if (dir == 4) {
			tmp = dice[0];
			dice[0] = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[4];
			dice[4] = tmp;
		}
		
		if (map[x][y] == 0) {
			map[x][y] = dice[5];
		}
		else {
			dice[5] = map[x][y];
			map[x][y] = 0;
		}
		cout << dice[0] << '\n';
	}

	return 0;
}