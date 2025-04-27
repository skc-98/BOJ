#include <iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int t;
    cin >> t;
    
    int n;
    cin >>n;
    
    int sum=0;
    for(int i=0; i<n; i++){
        int a;
        cin >>a;
        sum+=a;
    }
    
    if(sum>=t) cout << "Padaeng_i Happy";
    else cout << "Padaeng_i Cry";
    return 0;
}