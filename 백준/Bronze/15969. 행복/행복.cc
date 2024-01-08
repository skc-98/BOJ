#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	int max = 0;
	int min = 99999;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		if (max < a) max = a;
		if (min > a) min = a;
	}

	cout << max - min;
	return 0;
}