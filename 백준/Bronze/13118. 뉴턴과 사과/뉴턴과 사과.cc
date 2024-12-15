#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	vector<int> v(4);
	for (int i = 0; i < 4; i++) cin >> v[i];
	int x, y, r;
	cin >> x >> y >> r;
	int ans = 0;
	for (int i = 0; i < 4; i++) {
		if (x == v[i]) ans = i + 1;
	}
	cout << ans;
	return 0;
}