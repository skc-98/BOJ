#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int a, b;
	cin >> a >> b;
	string sa, sb;
	sa = to_string(a);
	sb = to_string(b);

	int max;
	for (int i = 0; i < sa.length(); i++) {
		if (sa[i] == '5') sa[i] = '6';
	}
	for (int i = 0; i < sb.length(); i++) {
		if (sb[i] == '5') sb[i] = '6';
	}
	max = stoi(sa) + stoi(sb);

	int min;
	for (int i = 0; i < sa.length(); i++) {
		if (sa[i] == '6') sa[i] = '5';
	}
	for (int i = 0; i < sb.length(); i++) {
		if (sb[i] == '6') sb[i] = '5';
	}
	min = stoi(sa) + stoi(sb);
	
	cout << min << " " << max;
	return 0;
}