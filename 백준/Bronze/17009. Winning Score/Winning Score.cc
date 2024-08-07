#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int suma = 0;
	for (int i = 3; i >= 1; i--) {
		int a;
		cin >> a;
		suma += (a * i);
	}

	int sumb = 0;
	for (int i = 3; i >= 1; i--) {
		int a;
		cin >> a;
		sumb += (a * i);
	}

	if (suma == sumb) cout << "T";
	else if (suma > sumb) cout << "A";
	else if (suma < sumb) cout << "B";
	return 0;
}