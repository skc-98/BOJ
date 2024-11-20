#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	int max_v = 0;
	int min_v = 9999999999999;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		if (i != 0) max_v = max(max_v, a - min_v);
		min_v = min(min_v, a);
		cout << max_v << " ";
	}

	return 0;
}