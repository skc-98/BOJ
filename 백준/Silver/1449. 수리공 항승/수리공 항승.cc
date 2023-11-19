#include<iostream>
using namespace std;

int d[3000] = { 0, };
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	for (int i = 1; i <= n; i++) {
		int a;
		cin >> a;
		d[a] = 1;
	}

	int count = 0;
	for (int i= 1; i < 1001; i++) {
		if (d[i] == 1) {
			count++;
			for (int j = i; j < i + m; j++) {
				d[j] = 0;
			}
		}
	}

	cout << count;
	return 0;
}