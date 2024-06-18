#include<iostream>
#include<string>
#include<vector>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string a, b;
	cin >> a >> b;

	int al = a.length();
	int bl = b.length();
	vector<int> v(bl, 0);

	int idx = 0;
	for (int i = 1; i < bl; i++) {
		while (idx > 0 && b[idx] != b[i]) idx = v[idx - 1];
		if (b[idx] == b[i]) idx++;
		v[i] = idx;
	}
	idx = 0;
	bool check = false;
	for (int i = 0; i < al; i++) {
		while (idx > 0 && b[idx] != a[i]) {
			idx = v[idx - 1];
		}
		if (b[idx] == a[i]) idx++;
		if (idx == bl) {
			check = true;
			break;
		}
	}
	if (check) cout << 1;
	else cout << 0;
	return 0;
}