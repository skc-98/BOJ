#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	char c;
	cin >> c;
	if (c == 'N') cout << "Naver D2";
	else if (c == 'n') cout << "Naver D2";
	else cout << "Naver Whale";
	return 0;
}