#include<iostream>
#include<unordered_map>
#include<string>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    long long b,n,m;
    cin >>b>>n>>m;
    
    unordered_map<string, long long> mp;
    for(int i=0; i<n; i++){
        string name;
        long long price;
        cin >> name>> price;
        mp[name]=price;
    }
    
    long long ans=0;
    for(int i=0; i<m; i++){
        string name;
        cin >>name;
        ans+=mp[name];
    }
    if(ans<=b) cout << "acceptable";
    else cout << "unacceptable";
    return 0;
}