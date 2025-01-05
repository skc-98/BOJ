#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<int> v(n);
	for (int i = 0; i < n; i++) {
		cin >> v[i];
	}

	int cnt = 0;
	for (int i = n - 1; i >= 1; i--) {
		for (int j = 0; j < i; j++) {
			if (v[j] > v[j + 1]) {
				int temp = v[j];
				v[j] = v[j + 1];
				v[j + 1] = temp;
				cnt++;
				if (cnt == m) {
					if (v[j] > v[j + 1]) cout << v[j + 1] << " " << v[j];
					else cout << v[j] << " " << v[j + 1];
					return 0;
				}
			}
		}
	}
	cout << -1;
	return 0;
}