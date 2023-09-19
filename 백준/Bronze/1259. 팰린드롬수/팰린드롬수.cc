#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	while (1) {
		int n;
		cin >> n;
		vector<int> v;
		if (n == 0) break;
		else {
			while (1) {
				v.push_back(n % 10);
				n /= 10;
				if (n == 0) break;
			}
			vector<int> v2 = v;
			reverse(v.begin(), v.end());

			int state = 0;
			for (int i = 0; i < v.size(); i++) {
				if (v[i] != v2[i]) {
					state = 1;
					break;
				}
			}
			if (state == 1) cout << "no" << '\n';
			else if (state == 0) cout << "yes" << '\n';
		}
	}

	return 0;
}