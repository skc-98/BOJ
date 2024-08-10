#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int a, b;
	cin >> a >> b;

	int max = min(a - 1, b);
	int maxsize = max * 2 + 1;
	cout << maxsize;
	return 0;
}