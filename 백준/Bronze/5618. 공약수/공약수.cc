#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	int min = 9999999999;
	vector<int> v(n);
	for (int i = 0; i < n; i++) {
		cin >> v[i];
		if (min > v[i]) min = v[i];
	}

	for (int i = 1; i <= min; i++) {
		bool check = 0;
		for (int j = 0; j < v.size(); j++) {
			if (v[j] % i != 0) check = 1;
		}
		if (!check) cout << i << '\n';
	}
	return 0;
}