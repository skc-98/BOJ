#include<iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int a, b;
    cin >> a >> b;
    a += b;
    if (a > 12) {
        a %= 12;
        if (a == 0) a = 12;
    }
    cout << a;
    return 0;
}