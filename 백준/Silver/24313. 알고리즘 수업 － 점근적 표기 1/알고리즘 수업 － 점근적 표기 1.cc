#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int a1, a0, c, n0;
	cin >> a1 >> a0;
	cin >> c;
	cin >> n0;
	int f = a1 * n0 + a0;
	int g = c * n0;

	if (f <= g && c - a1 >= 0) cout << 1;
	else cout << 0;

	return 0;
}