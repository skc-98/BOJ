#include<iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int n,m;
    cin >>n>>m;
    
    int maxh=0;
    for(int i=0; i<n; i++){
        int a;
        cin >>a;
        if(a>maxh) maxh=a;
    }
    
    int maxb=0;
    for(int i=0; i<m; i++){
        int a;
        cin >>a;
        if(a>maxb) maxb=a;
    }
    
    cout << maxh+maxb;
    return 0;
}