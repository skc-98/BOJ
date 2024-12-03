#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int tc = 1;
	while (1) {
		int n, m;
		cin >> n >> m;
		if (n == 0 && m == 0) break;

		bool dead = 0;
		while (1) {
			char a;
			int w;
			cin >> a >> w;
			if (a == '#' && w == 0) break;
			if (a == 'E') m -= w;
			if (a == 'F') m += w;
			if (m <= 0) dead = true;
		}
		if (dead) cout << tc << " RIP" << '\n';
		else if (m > (n / 2) && m < (n * 2)) cout << tc << " :-)" << '\n';
		else cout << tc << " :-(" << '\n';
		tc++;
	}

	return 0;
}