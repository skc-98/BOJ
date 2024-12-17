#include<iostream>
#include <cmath>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, a, b, c, d;
	cin >> n >> a >> b >> c >> d;

	int setx = (n + a - 1) / a * b;
	int sety = (n + c - 1) / c * d;
	cout << min(setx, sety);
	return 0;
}