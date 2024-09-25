#include<iostream>
using namespace std;


int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	if (n > m) {
		cout << n + m + m / 10;
	}
	else {
		cout << m + n + n / 10;
	}
	return 0;
}