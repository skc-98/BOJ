#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	long long n;
	cin >> n;

	string s = "";
	n--;
	while (n >= 0) {
		if (n % 2 == 0) {
			s = '4' + s;
		}
		else {
			s = '7' + s;
		}
		n = (n / 2) - 1;
	}

	cout << s;
	return 0;
}