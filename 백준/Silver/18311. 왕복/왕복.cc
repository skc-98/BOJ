#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	long long k;
	cin >> n >> k;

	vector<int> v;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}

	int count = 1;
	for (int i = 0; i < n; i++) {
		if (k - v[i] >= 0) {
			k -= v[i];
			if (i == n - 1) break;
			count++;
		}
		else {
			cout << count;
			return 0;
		}
	}

	if (k > 0) {
		for (int i = n - 1; i >= 0; i--) {
			if (k - v[i] >= 0) {
				k -= v[i];
				count--;
			}
			else break;
		}
	}

	cout << count;
	return 0;
}