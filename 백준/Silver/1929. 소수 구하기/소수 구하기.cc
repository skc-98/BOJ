#include<iostream>
#include<cmath>
using namespace std;

int d[1000001] = { 0, };
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n, m;
	cin >> n >> m;

	for (int i = 2; i <= sqrt(m); i++) {
		if (d[i] == 1) continue;
		for (int j = i+i; j <= m; j+=i) {
			d[j] = 1;
		}
	}

	for (int i = n; i <= m; i++) {
		if (i == 1 || d[i]==1) continue;
		cout << i << '\n';
	}

	return 0;
}