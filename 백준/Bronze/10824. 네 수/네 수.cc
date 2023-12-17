#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string a, b, c, d;
	cin >> a >> b >> c >> d;

	string ab = ""; ab += a; ab += b;
	string cd = ""; cd += c; cd += d;

	long long t = stoll(ab) + stoll(cd);
	cout << t;

	return 0;
}