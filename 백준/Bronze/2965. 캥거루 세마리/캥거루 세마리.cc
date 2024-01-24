#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int a, b, c;
	cin >> a >> b >> c;

	if (b - a > c - b) {
		cout << b - a - 1;
	}
	else {
		cout << c - b - 1;
	}

	return 0;
}