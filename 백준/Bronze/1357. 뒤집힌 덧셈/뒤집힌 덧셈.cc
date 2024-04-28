#include<iostream>
#include<string>
#include<algorithm>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	string a = to_string(n);
	string b = to_string(m);

	reverse(a.begin(), a.end());
	reverse(b.begin(), b.end());

	int rn = stoi(a);
	int rm = stoi(b);
	int sum = rn + rm;
	string ssum = to_string(sum);
	reverse(ssum.begin(), ssum.end());
	int rsum = stoi(ssum);
	cout << rsum;
	return 0;
}