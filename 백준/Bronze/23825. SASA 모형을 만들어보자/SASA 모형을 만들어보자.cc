#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	int count = 0;
	if (n / 2 > 0 && m / 2 > 0) {
		int a = n / 2;
		int b = m / 2;
		if (a > b) count = b;
		else count = a;
	}
	cout << count;
	return 0;
}