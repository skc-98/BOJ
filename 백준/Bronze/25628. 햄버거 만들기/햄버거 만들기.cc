#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	int a = n / 2;
	if (a > m) cout << m;
	else cout << a;

	return 0;
}