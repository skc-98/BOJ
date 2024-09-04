#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int a, b, c;
	cin >> a >> b >> c;
	if (c >= a && c < b) cout << 1;
	else cout << 0;
	return 0;
}