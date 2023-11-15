#include<iostream>
#include<cmath>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	int sum = 0;
	for (int i = 1; i <= n; i++) {
		int a;
		cin >> a;
		sum += abs(a);
	}
	for (int i = 1; i <= n; i++) {
		int a;
		cin >> a;
		sum += abs(a);
	}
	cout << sum;

	return 0;
}