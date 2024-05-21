#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<int> v;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}

	vector<int> v2;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		v2.push_back(a);
	}

	if (v == v2) {
		cout << 1;
		return 0;
	}

	int tmp;
	for (int i = 0; i < n - 1; i++) {
		for (int j = 0; j < n - i - 1; j++) {
			if (v[j] > v[j + 1]) {
				tmp = v[j];
				v[j] = v[j + 1];
				v[j + 1] = tmp;
				if (v[j] == v2[j]) {
					if (v == v2) {
						cout << 1;
						return 0;
					}
				}
			}
		}
	}
	cout << 0;
	return 0;
}