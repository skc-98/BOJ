#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

struct p {
	string name;
	int a, b, c;
};

bool cmp(const p& n, const p& m) {
	if (n.a == m.a) {
		if (n.b == m.b) {
			if (n.c == m.c) {
				return n.name < m.name;
			}
			return n.c > m.c;
		}
		return n.b < m.b;
	}
	return n.a > m.a;
}


int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<p> v(n);
	for (int i = 0; i < n; i++) {
		cin >> v[i].name >> v[i].a >> v[i].b >> v[i].c;
	}
	sort(v.begin(), v.end(), cmp);
	for (int i = 0; i < v.size(); i++) cout << v[i].name << '\n';
	return 0;
}