#include <iostream>
#include <string>
using namespace std;

int main()
{
    string a;
    cin >> a;
    for (int i = 0; i < a.length(); i++) {
        if (a[i] >= 'a' && a[i] <= 'z') a[i] -= 32;
        else if (a[i] >= 'A' && a[i] <= 'Z') a[i] += 32;
    }
    cout << a;
    return 0;
}