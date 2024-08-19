#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int sum = 0;
	int a;
	while (cin >> a) {
		sum += a;
	}
	cout << sum;
	return 0;
}