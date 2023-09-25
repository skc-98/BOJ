#include<iostream>
using namespace std;

int d[101][101];

int main()
{
	int n;
	int i, j, k;
	int a, b;
	int count = 0;
	cin >> n;
	for (i = 1; i <= n; i++) {
		cin >> a >> b;
		for (j = a; j <= a+9; j++) {
			for (k = b; k <= b+9; k++) {
				d[j][k]++;
			}
		}
	}
	for (i = 0; i < 101; i++) {
		for (j = 0; j < 101; j++) {
			if (d[i][j] > 0) count++;
		}
	}
	cout << count;
	return 0;
}