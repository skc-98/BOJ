#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	int a, b, c;
	cin >> a >> b >> c;

	int count = 0;
	if (a < n) count += a;
	else count += n;

	if (b < n)count += b;
	else count += n;

	if (c < n) count += c;
	else count += n;

	cout << count;
	return 0;
}