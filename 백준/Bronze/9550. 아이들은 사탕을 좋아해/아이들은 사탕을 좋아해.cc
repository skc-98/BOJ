#include <iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int tc;
    cin >>tc;
    
    for(int i=0; i<tc; i++){
        int ans=0;
        int n,k;
        cin >>n>>k;
        
        for(int j=0; j<n; j++){
            int a;
            cin >>a;
            ans+=(a/k);
        }
        cout << ans << '\n';
    }
    return 0;
}