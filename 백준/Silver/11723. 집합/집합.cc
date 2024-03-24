#include<iostream>
#include<string>
using namespace std;

int d[21] = { 0, };
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		string s;
		cin >> s;
		if (s == "all") {
			for (int j = 1; j <= 20; j++) d[j] = 1;
		}
		else if (s == "empty") {
			for (int j = 1; j <= 20; j++) d[j] = 0;
		}
		else if (s == "add") {
			int a;
			cin >> a;
			d[a] = 1;
		}
		else if (s == "remove") {
			int a;
			cin >> a;
			d[a] = 0;
		}
		else if (s == "check") {
			int a;
			cin >> a;
			cout << d[a] << '\n';
		}
		else if (s == "toggle") {
			int a;
			cin >> a;
			d[a] = !d[a];
		}
	}
	return 0;
}