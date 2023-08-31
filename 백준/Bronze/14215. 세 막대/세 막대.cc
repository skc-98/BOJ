#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int d[10];
	for (int i = 1; i <= 3; i++) cin >> d[i];

	int max=0;
	int maxindex = 0;
	for (int i = 1; i <= 3; i++) {
		if (d[i] > max) {
			max = d[i];
			maxindex = i;
		}
	}

	int sum = 0;
	for (int i = 1; i <= 3; i++) {
		if (i != maxindex) sum += d[i];
	}
	if (sum <= max) {
		sum += (max - (max - sum) - 1);
	}
	else {
		sum += max;
	}

	cout << sum;
	return 0;
}