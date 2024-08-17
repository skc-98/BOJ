#include<iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n;
    cin >> n;

    int t = 10;

    while (n >= t) {
        int check = n % t;
        n -= check;
        if (check >= t / 2) {
            n += t;
        }
        t *= 10;
    }
    cout << n;
    return 0;
}