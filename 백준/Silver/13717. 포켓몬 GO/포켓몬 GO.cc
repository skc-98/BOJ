#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	int max = 0;
	int total = 0;
	string name;
	for (int i = 0; i < n; i++) {
		string s;
		int a, b;
		cin >> s;
		cin >> a >> b;

		int cnt = 0;
		while (a <= b) {
			b -= a;
			total++;
			b += 2;
			cnt++;
		}
		if (cnt > max) {
			name = s;
			max = cnt;
		}
	}
	cout << total << '\n';
	cout << name;
	return 0;
}