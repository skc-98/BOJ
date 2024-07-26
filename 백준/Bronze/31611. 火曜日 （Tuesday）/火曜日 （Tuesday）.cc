#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	if (n % 7 == 2) cout << 1;
	else cout << 0;
	return 0;
}