#include<iostream>
#include<vector>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<string> v;
	for (int i = 0; i < n; i++) {
		string a;
		cin >> a;
		v.push_back(a);
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < v[i].length(); j++) {
			if (v[i][j] >= 'A' && v[i][j] <= 'Z') v[i][j] += 32;
		}
	}

	for (int i = 0; i < n; i++) {
		cout << v[i] << '\n';
	}
	return 0;
}