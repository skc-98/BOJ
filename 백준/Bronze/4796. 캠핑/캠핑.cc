#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int a, b, c;
	int count = 0;
	while (1) {
		count++;
		cin >> a >> b >> c;
		if (a == 0 && b == 0 && c == 0) break;
		int answer = 0;
		answer += (c / b) * a;
		if (c % b <= a) answer += c % b;
		else if (c % b > a) answer += a;
		cout << "Case " << count << ": " << answer << '\n';
	}
	return 0;
}