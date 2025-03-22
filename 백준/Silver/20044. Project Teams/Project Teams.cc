#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int n;
    cin >>n;
    
    vector<int> v;
    for(int i=0; i<2*n; i++){
        int a;
        cin >>a;
        v.push_back(a);
    }
    sort(v.begin(), v.end());
    
    int ans=9999999;
    
    int start=0,end=(2*n)-1;
    for(int i=0; i<n; i++){
        int sum=v[start+i]+v[end-i];
        if(ans>sum) ans=sum;
    }
    cout << ans;
    return 0;
}