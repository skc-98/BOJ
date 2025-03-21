#include<iostream>
#include<string>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int n;
    cin >>n;
    
    int ans=0;
    for(int i=1; i<=n; i++){
        string number=to_string(i);
        for(int j=0; j<number.length(); j++){
            if(number[j]=='3' || number[j]=='6' || number[j]=='9') ans++;
        }
    }
    
    cout << ans;
    return 0;
}