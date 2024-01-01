#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int maxidx = 0;
	int max = 0;
	for (int i = 1; i <= 5; i++) {
		int a, b, c, d;
		cin >> a >> b >> c >> d;
		int sum = a + b + c + d;
		if (sum > max) {
			max = sum;
			maxidx = i;
		}
	}

	cout << maxidx << " " << max;
	return 0;
}