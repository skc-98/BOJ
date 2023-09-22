#include<iostream>
#include<deque>
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

		deque<char> alpha;
		for (int i = 1; i <= n; i++) {
			char a;
			cin >> a;
			alpha.push_back(a);
		}

		deque<char> ans;
		ans.push_back(alpha[0]);
		alpha.pop_front();
		for (int i = 0; i < alpha.size(); i++) {
			if (alpha[i] <= ans[0]) {
				ans.push_front(alpha[i]);
			}
			else {
				ans.push_back(alpha[i]);
			}
		}

		for (int i = 0; i < ans.size(); i++) {
			cout << ans[i];
		}
		cout << '\n';
	}
	return 0;
}