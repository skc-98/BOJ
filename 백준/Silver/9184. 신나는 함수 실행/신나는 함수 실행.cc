#include<iostream>
using namespace std;

int d[51][51][51];

int w(int a, int b, int c) {
	if (d[a][b][c] != 0) return d[a][b][c];
	if (a <= 0 || b <= 0 || c <= 0) return d[a][b][c] = 1;
	if (a > 20 || b > 20 || c > 20) return d[a][b][c] = w(20, 20, 20);
	if (a < b && b < c) return d[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
	return d[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int a, b, c;
	while (1) {
		cin >> a >> b >> c;
		if (a == -1 && b == -1 && c == -1) break;

		if(a<=0 || b<=0 || c<=0) cout << "w(" << a << ", " << b << ", " << c << ") = " << 1 << '\n';
		else {
			w(a, b, c);
			cout << "w(" << a << ", " << b << ", " << c << ") = " << d[a][b][c] << '\n';
		}
	}
	return 0;
}