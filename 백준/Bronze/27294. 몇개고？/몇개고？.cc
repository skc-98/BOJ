#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	if (n >= 12 && n <= 16 && m == 0) cout << 320;
	else cout << 280;

	return 0;
}