#include<iostream>
using namespace std;

bool d[4] = { 0, };
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	int temp;
	d[1] = 1;
	for (int i = 1; i <= n; i++) {
		int a, b;
		cin >> a >> b;
		temp = d[a];
		d[a] = d[b];
		d[b] = temp;
	}

	for (int i = 1; i <= 3; i++) {
		if (d[i] == true) cout << i;
	}

	return 0;
}