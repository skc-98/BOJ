#include<iostream>
#include<set>
#include<string>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, k;
	cin >> n;
	cin >> k;
	
	vector<int> v;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}
	sort(v.begin(), v.end());

	set<string> st;
	do {
		string s;
		for (int i = 0; i < k; i++) {
			s += to_string(v[i]);
		}
		st.insert(s);
	} while (next_permutation(v.begin(), v.end()));

	cout << st.size() << '\n';
	return 0;
}