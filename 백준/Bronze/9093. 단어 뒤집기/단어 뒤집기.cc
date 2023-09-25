#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	int tc;
	cin >> tc;
	cin.ignore();
	for (int i = 1; i <= tc; i++) {
		string a;
		getline(cin, a);

		vector<char> v;
		for (int j = 0; j < a.size(); j++) {
			v.push_back(a[j]);
			if (j == a.size() - 1) {
				for (int k = v.size() - 1; k >= 0; k--) cout << v[k];
				v.clear();
				cout << " ";
			}
			if (a[j] == ' ') {
				for (int k = v.size() - 2; k >= 0; k--) cout << v[k];
				v.clear();
				cout << " ";
			}
		}
		cout << '\n';
	}
	return 0;
}