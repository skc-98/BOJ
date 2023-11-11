#include<iostream>
#include<vector>
using namespace std;

void male(vector<bool>& v, int num) {
	for (int i = num - 1; i < v.size(); i += num) {
		if (v[i] == 0) v[i] = 1;
		else v[i] = 0;
	}
}

void female(vector<bool>& v, int num) {
	num--;
	int count = 0;
	while (num - count >= 0 && num + count < v.size() && v[num - count] == v[num + count]) {
		count++;
	}
	count--;
	for (int i = num - count; i <= num + count; i++) {
		v[i] = !v[i];
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<bool> v;
	for (int i = 1; i <= n; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}

	int m;
	cin >> m;

	for (int i = 1; i <= m; i++) {
		int a, b;
		cin >> a >> b;
		if (a == 1) {
			male(v, b);
		}
		else if (a == 2) {
			female(v, b);
		}
	}

	int count = 0;
	for (int i = 0; i < v.size(); i++) {
		count++;
		cout << v[i] << " ";
		if (count == 20) {
			count = 0;
			cout << '\n';
		}
	}
	return 0;
}