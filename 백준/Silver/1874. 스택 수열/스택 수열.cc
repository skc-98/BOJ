#include<iostream>
#include<stack>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<int> v;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}

	int index = 0;
	int count = 1;
	stack<int> st;
	vector<char> ans;
	while (index < n) {
		if (st.empty() == false && v[index] == st.top()) {
			ans.push_back('-');
			st.pop();
			index++;
			continue;
		}
		else {
			if (count > n) {
				cout << "NO";
				return 0;
			}
			st.push(count);
			ans.push_back('+');
			count++;
		}
	}

	for (int i = 0; i < ans.size(); i++) {
		cout << ans[i] << '\n';
	}
	return 0;
}