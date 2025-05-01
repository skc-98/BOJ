#include <iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int n,m;
    cin >>n>>m;
    
    int ans=0;
    for(int i=0; i<n; i++){
        string s;
        cin >>s;
        
        int yes=0, no=0;
        for(int j=0; j<s.length(); j++){
            if(s[j]=='O') yes++;
            else no++;
        }
        
        if(yes>no) ans++;
    }
    cout << ans;
    return 0;
}