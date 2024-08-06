#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, w, h, l;
	cin >> n >> w >> h >> l;
	int max = 1;
	max *= (w / l);
	max *= (h / l);
	if (max > n) cout << n;
	else cout << max;
	return 0;
}