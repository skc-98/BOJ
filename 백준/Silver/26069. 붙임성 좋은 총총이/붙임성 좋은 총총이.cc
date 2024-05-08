#include<iostream>
#include<set>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	set<string> st;
	st.insert("ChongChong");
	for (int i = 0; i < n; i++) {
		string a, b;
		cin >> a >> b;
		if (st.count(a) == 0 && st.count(b) != 0) st.insert(a);
		else if (st.count(a) != 0 && st.count(b) == 0) st.insert(b);
	}
	cout << st.size();
	return 0;
}