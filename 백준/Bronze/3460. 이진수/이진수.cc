#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int tc;
	cin >> tc;

	for (int i = 0; i < tc; i++) {
		int n;
		cin >> n;
		vector<int> v;
		while (1) {
			if (n == 0) break;
			v.push_back(n % 2);
			n /= 2;
		}
		for (int i = 0; i < v.size(); i++) {
			if (v[i] == 1) cout << i << " ";
		}
	}

	return 0;
}