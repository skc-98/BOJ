#include<iostream>
#include<cmath>
using namespace std;

int d[1001][1001];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	int prox, proy;
	int sungx, sungy;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			cin >> d[i][j];
			if (d[i][j] == 5) {
				prox = i;
				proy = j;
			}
			else if (d[i][j] == 2) {
				sungx = i;
				sungy = j;
			}
		}
	}
	if (sungx > prox) swap(sungx, prox);
	if (sungy > proy) swap(sungy, proy);

	int dx = sungx - prox;
	int dy = sungy - proy;
	if (sqrt(dx * dx + dy * dy) < 5) {
		cout << 0;
		return 0;
	}

	int count = 0;
	for (int i = sungx; i <= prox; i++) {
		for (int j = sungy; j <= proy; j++) {
			if (d[i][j] == 1) count++;
			if (count >= 3) {
				cout << 1;
				return 0;
			}
		}
	}
	cout << 0;
	return 0;
}