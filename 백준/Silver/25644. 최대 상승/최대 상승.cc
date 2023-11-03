#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	int max = 0;
	int min = 0;
	int result = 0;

	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		if (i == 0) {
			min = a;
			continue;
		}
		if (min > a) min = a;
		else if (min < a) {
			max = a;
			if (result < (max - min)) result = max - min;
		}
	}
	cout << result;
	return 0;
}