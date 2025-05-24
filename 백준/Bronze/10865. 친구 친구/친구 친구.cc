#include<iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int n,m;
    cin >>n>>m;
    
    int d[1000000];
    
    for(int i=0; i<m; i++){
        int a,b;
        cin >>a>>b;
        d[a]++;
        d[b]++;
    }
    for(int i=1; i<=n; i++){
        cout << d[i] << '\n';
    }
    return 0;
}