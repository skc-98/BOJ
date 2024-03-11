#include<iostream>
#include<stack>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	int count = 1;
	stack<int> st;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		if (a == count) count++;
		else st.push(a);

		while (st.empty() != true && st.top() == count) {
			count++;
			st.pop();
		}
	}

	if (count - 1 == n) cout << "Nice";
	else cout << "Sad";
	return 0;
}