#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int a, b;
	cin >> a >> b;

	if (a > b) cout << 1;
	else if (a == b) cout << 0;
	else if (a < b) cout << -1;

	return 0;
}