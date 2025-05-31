#include<iostream>
#include<vector>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int n;
    cin >>n;
    
    vector<int> v;
    for(int i=0; i<n; i++){
        int a;
        cin >>a;
        v.push_back(a);
    }
    
    int m;
    cin >>m;
    
    int ans=0;
    for(int i=0; i<m; i++){
        int a;
        cin >>a;
        ans+=v[a-1];
    }
    
    cout << ans;
    return 0;
}