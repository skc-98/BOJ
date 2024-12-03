#include<iostream>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<int> v(n);
	for (int i = 0; i < n; i++) {
		cin >> v[i];
	}
	
	int max_hill = 0;
	int begin = v[0];
	for (int i = 1; i < n; i++) {
		if (v[i] > v[i - 1]) continue;
		else {
			max_hill = max(max_hill, v[i - 1] - begin);
			begin = v[i];
		}
	}
	max_hill = max(max_hill, v[n - 1] - begin);
	cout << max_hill;
	return 0;
}