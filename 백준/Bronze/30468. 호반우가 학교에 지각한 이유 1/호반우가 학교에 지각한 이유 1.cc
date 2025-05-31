#include<iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int a,b,c,d;
    int n;
    cin >>a>>b>>c>>d;
    cin >>n;
    n*=4;
    
    int result=n-(a+b+c+d);
    if(result<0) cout << 0;
    else cout << result;
    return 0;
}