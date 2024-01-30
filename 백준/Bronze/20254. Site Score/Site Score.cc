#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int a, b, c, d;
	cin >> a >> b >> c >> d;
	cout << d * 6 + 14 * c + 24 * b + 56 * a;

	return 0;
}