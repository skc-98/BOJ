#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int sum = 0;
	while (1) {
		int a;
		cin >> a;
		if (a == -1) break;
		sum += a;
	}
	cout << sum;
	return 0;
}