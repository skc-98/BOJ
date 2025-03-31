#include<iostream>
#include<cmath>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int n,w,h;
    cin >>n>>w>>h;
    
    double maxLen=sqrt(w*w+h*h);
    for(int i=0; i<n; i++){
        int a;
        cin >> a;
        if(a<=maxLen) cout << "DA" << '\n';
        else cout << "NE" << '\n';
    }
    return 0;
}