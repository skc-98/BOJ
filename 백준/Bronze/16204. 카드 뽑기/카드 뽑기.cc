#include<iostream>
#include<cmath>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int n,m,k;
    cin >>n>>m>>k;
    cout<<min(m,k)+min(n-m,n-k);
    return 0;
}