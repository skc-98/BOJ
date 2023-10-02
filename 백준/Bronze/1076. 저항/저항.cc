#include<iostream>
#include<string>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string a, b, c;
	cin >> a;
	cin >> b;
	cin >> c;

	long long answer = 0;
	
	if (a == "black") answer += (0 * 10);
	else if (a == "brown") answer += (1 * 10);
	else if (a == "red") answer += (2 * 10);
	else if (a == "orange") answer += (3 * 10);
	else if (a == "yellow") answer += (4 * 10);
	else if (a == "green") answer += (5 * 10);
	else if (a == "blue") answer += (6 * 10);
	else if (a == "violet") answer += (7 * 10);
	else if (a == "grey") answer += (8 * 10);
	else if (a == "white") answer += (9 * 10);

	if (b == "black") answer += 0;
	else if (b == "brown") answer += 1;
	else if (b == "red") answer += 2;
	else if (b == "orange") answer += 3;
	else if (b == "yellow") answer += 4;
	else if (b == "green") answer += 5;
	else if (b == "blue") answer += 6;
	else if (b == "violet") answer += 7;
	else if (b == "grey") answer += 8;
	else if (b == "white") answer += 9;

	if (c == "black") answer *= 1;
	else if (c == "brown") answer *= 10;
	else if (c == "red") answer *= 100;
	else if (c == "orange") answer *= 1000;
	else if (c == "yellow") answer *= 10000;
	else if (c == "green") answer *= 100000;
	else if (c == "blue") answer *= 1000000;
	else if (c == "violet") answer *= 10000000;
	else if (c == "grey") answer *= 100000000;
	else if (c == "white") answer *= 1000000000;

	cout << answer;
	return 0;
}