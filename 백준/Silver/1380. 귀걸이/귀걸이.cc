#include<iostream>
#include<vector>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int count = 0;
	while (1) {
		count++;
		int n;
		cin >> n;
		cin.ignore();
		if (n == 0) break;
		vector<pair<string, int>> v;
		for (int i = 0; i < n; i++) {
			string a;
			getline(cin, a);
			v.push_back(make_pair(a, 0));
		}
		for (int i = 0; i < (2 * n) - 1; i++) {
			int a; char b;
			cin >> a >> b;
			if (b == 'A') {
				v[a - 1].second += 1;
			}
			else if (b == 'B') {
				v[a - 1].second += 2;
			}
		}
		for (int i = 0; i < n; i++) {
			if (v[i].second != 3) {
				cout << count << " " << v[i].first << '\n';
			}
		}
	}
	return 0;
}