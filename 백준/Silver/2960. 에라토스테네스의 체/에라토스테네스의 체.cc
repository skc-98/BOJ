#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	int n, m;
	cin >> n >> m;

	vector<bool> v(n + 1, false);
	int count = 0;

	for (int i = 2; i <= n; i++) {
		if (v[i] == true) {
			continue;
		}
		for (int j = i; j <= n; j += i) {
			if (v[j] == false) {
				v[j] = true;
				count++;
				if (count == m) {
					cout << j;
					return 0;
				}
			}
		}
	}
	return 0;
}