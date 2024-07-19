#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;
	int sum = 0;
	sum += (n * 60);
	sum += m;
	cout << sum;
	return 0;
}