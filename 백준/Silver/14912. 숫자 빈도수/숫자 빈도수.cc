#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n, d;
	cin >> n >> d;

	int count = 0;
	for (int i = 1; i <= n; i++) {
		int num = i;
		while (1) {
			if (num % 10 == d) count++;
			num = num / 10;
			if (num == 0) break;
		}
	}

	cout << count;

	return 0;
}