#include<iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int a, d, k;
	cin >> a >> d >> k;
    
	if ((k - a) % d == 0) {
        int n = (k - a) / d + 1;
        if (n > 0) cout << n;
        else cout << "X";
    }
    else cout << "X";
	return 0;
}