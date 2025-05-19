#include <iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    long long n,k;
    while((cin >>n>>k)){
        long long ans=0;
        long long stamp=0;
        while(n>0){
            ans+=n;
            stamp+=n;
            n=stamp/k;
            stamp=stamp%k;
        }
        
        cout << ans << '\n';
    }
    return 0;
}