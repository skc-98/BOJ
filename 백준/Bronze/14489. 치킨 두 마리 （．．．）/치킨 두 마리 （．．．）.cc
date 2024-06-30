#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	long long a, b, n;
	cin >> a >> b;
	cin >> n;
	if (a + b >= n * 2) cout << (a + b) - (n * 2);
	else cout << a + b;

	return 0;
}