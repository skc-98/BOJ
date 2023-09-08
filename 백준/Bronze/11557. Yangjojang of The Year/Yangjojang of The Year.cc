#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int tc;
	cin >> tc;
	for (int i = 1; i <= tc; i++) {
		int n;
		cin >> n;
		int max = 0;
		string maxname;
		for (int i = 1; i <= n; i++) {
			string a;
			int b;
			cin >> a >> b;
			if (b > max) {
				max = b;
				maxname = a;
			}
		}
		cout << maxname << '\n';
	}
	return 0;
}