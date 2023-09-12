#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;

	int count = 0;
	count += (n / 64);
	n %= 64;
	count += (n / 32);
	n %= 32;
	count += (n / 16);
	n %= 16;
	count += (n / 8);
	n %= 8;
	count += (n / 4);
	n %= 4;
	count += (n / 2);
	n %= 2;
	count += (n / 1);
	cout << count;

	return 0;
}