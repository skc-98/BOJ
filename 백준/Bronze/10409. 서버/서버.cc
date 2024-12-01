#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, time;
	cin >> n >> time;

	bool check = 1;
	int ans = 0;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		if (time >= a && check) {
			time -= a;
			ans++;
		}
		else check = 0;
	}
	cout << ans;
	return 0;
}