#include<iostream>
using namespace std;

long long gcd(const long long& a, const long long& b) {
	if (b == 0)return a;
	else return gcd(b, a % b);
}

long long lcm(const long long& a, const long long& b) {
	return a * b / gcd(a, b);
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	long long n, m;
	cin >> n >> m;
	cout << lcm(n, m);

	return 0;
}