#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	int song = 0;
	int ans = 0;
	while (n > 0) {
		ans++;
		song++;
		if (song > n) song = 1;
		n -= song;
	}
	cout << ans;
	return 0;
}