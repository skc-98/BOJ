#include<iostream>
using namespace std;

int gold[1001];
int silver[1001];
int bronze[1001];
int crank[1001] = { 0, };

int main()
{
	int n, m, i, j;
	int a, b, c, d;
	int temp;
	cin >> n >> m;
	for (i = 1; i <= n; i++) {
		cin >> a;
		cin >> gold[a] >> silver[a] >> bronze[a];
		crank[i] = i;
	}
	for (i = 1; i <= n; i++) {
		for (j = i; j <= n; j++) {
			if (gold[j] > gold[i]) {
				temp = crank[i];
				crank[i] = crank[j];
				crank[j] = temp;
			}
			if (gold[j] == gold[i] && silver[j] > silver[i]) {
				temp = crank[i];
				crank[i] = crank[j];
				crank[j] = temp;
			}
			if (gold[j] == gold[i] && silver[j] == silver[i] && bronze[j]>bronze[i]) {
				temp = crank[i];
				crank[i] = crank[j];
				crank[j] = temp;
			}
		}
	}
	for (i = 1; i <= n; i++) {
		for (j = i; j <= n; j++) {
			if (gold[j] == gold[i] && silver[j] == silver[i] && bronze[j] == bronze[i]) {
				if (crank[i] < crank[j]) crank[j] = crank[i];
			}
		}
	}
	cout << crank[m];
	return 0;
}