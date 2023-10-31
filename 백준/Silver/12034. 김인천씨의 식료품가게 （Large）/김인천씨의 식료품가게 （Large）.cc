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

	for (int i = 1; i <= tc; i++) {
		int n;
		cin >> n;

		vector<long long> v;
		for (int j = 1; j <= 2 * n; j++) {
			long long a;
			cin >> a;
			v.push_back(a);
		}

		vector<long long> answer;
		for (int j = v.size() - 1; j >= 0; j--) {
			long long key = v[j] * 0.75;
			for (int k = 0; k < v.size(); k++) {
				if (key == v[k]) {
					answer.push_back(key);
					v[k] = -1;
					break;
				}
			}
			if (answer.size() == n) break;
		}
		sort(answer.begin(), answer.end());
		cout << "Case #" << i << ": ";
		for (int j = 0; j < answer.size(); j++) {
			cout << answer[j] << " ";
		}
		cout << '\n';
	}

	return 0;
}