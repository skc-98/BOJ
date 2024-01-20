#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s;
	cin >> s;
	int n;
	cin >> n;

	int count = 0;
	for (int i = 1; i <= n; i++) {
		string a;
		cin >> a;
		if (s == a) count++;
	}
	cout << count;
	return 0;
}