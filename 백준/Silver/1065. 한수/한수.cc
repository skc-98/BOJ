#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	int answer = 0;
	vector<int> v;
	for (int i = 1; i <= n; i++) {
		int num = i;
		while (1) {
			if (num <= 0) break;
			v.push_back(num % 10);
			num = num / 10;
		}
		if (v.size() < 3) {
			answer++;
			v.clear();
			continue;
		}
		reverse(v.begin(), v.end());
		if (v.size() >= 3) {
			int state = 0;
			int t = v[1] - v[0];
			for (int j = 1; j < v.size() - 1; j++) {
				if (v[j + 1] - v[j] != t) {
					state = 1;
				}
			}
			if (state == 0) {
				answer++;
			}
		}
		v.clear();
	}
	cout << answer;
	return 0;
}