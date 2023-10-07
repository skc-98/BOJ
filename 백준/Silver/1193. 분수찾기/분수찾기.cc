#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	int a = 1, sum = 1, order = 1;
	while (1) {
		if (sum >= n) break;
		a += 1;
		sum += a;
	}
	order = n - (sum - a);
	if (a % 2 == 1) cout << (a - order + 1) << '/' << order;
	else cout << order << '/' << (a - order + 1);
	return 0;
}