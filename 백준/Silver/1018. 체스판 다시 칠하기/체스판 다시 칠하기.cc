#include<iostream>
using namespace std;

char white[8][8] = {
    'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B',
    'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W',
    'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B',
    'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W',
    'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B',
    'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W',
    'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B',
    'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'
};

char black[8][8] = {
    'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W',
    'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B',
    'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W',
    'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B',
    'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W',
    'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B',
    'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W',
    'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'
};

char d[51][51];

int wf(int n, int m) {
    int count = 0;
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if (d[n + i][m + j] != white[i][j]) count++;
        }
    }
    return count;
}

int bf(int n, int m) {
    int count = 0;
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if (d[n + i][m + j] != black[i][j]) count++;
        }
    }
    return count;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> d[i][j];
        }
    }

    int answer = 99999;
    for (int i = 0; i <= n - 8; i++) {
        for (int j = 0; j <= m - 8; j++) {
            int w = wf(i, j);
            int b = bf(i, j);
            int mcount = min(w, b);
            if (mcount < answer) answer = mcount;
        }
    }
    cout << answer;
	return 0;
}