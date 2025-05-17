#include <iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int n;
    cin >>n;
    
    int w = 0, h = 0;
    for(int i = 0; i < n; i++) {
        int a, b;
        cin >> a >> b;
        
        if (a < b) {
            if (a > w) w = a;
            if (b > h) h = b;
        } else {
            if (b > w) w = b;
            if (a > h) h = a;
        }
    }
    cout << 1LL* w * h << '\n';
    return 0;
}