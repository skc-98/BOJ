#include <iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int n,m;
    cin >>n>>m;
    
    if(n==m) cout << n;
    else{
        if(n>m) cout << n;
        else cout << m;
    }
    return 0;
}