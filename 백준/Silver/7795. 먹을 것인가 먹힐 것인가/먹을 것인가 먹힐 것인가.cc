#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int tc;
	cin >> tc;

	for (int i = 0; i < tc; i++) {
		int a, b;
		cin >> a >> b;

		vector<int> v;
		for (int j = 0; j < a; j++) {
			int num;
			cin >> num;
			v.push_back(num);
		}
		sort(v.begin(), v.end());

		vector<int> v2;
		for (int j = 0; j < b; j++) {
			int num;
			cin >> num;
			v2.push_back(num);
		}
		sort(v2.begin(), v2.end());

		int count = 0;
		for (int j = 0; j < v.size(); j++) {
			for (int k = 0; k < v2.size(); k++) {
				if (v[j] <= v2[k]) break;
				count++;
			}
		}

		cout << count << '\n';
	}

	return 0;
}