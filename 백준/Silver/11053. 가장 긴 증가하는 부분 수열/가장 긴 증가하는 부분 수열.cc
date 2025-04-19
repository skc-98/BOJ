#include<iostream>
#include<vector>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int n;
    cin >>n;
    
    vector<int> v(n);
    for(int i=0; i<n; i++){
        cin >> v[i];
    }
    
    vector<int> lis(n, 1);
    
    int ans=1;
    for(int i=0; i<n; i++){
        for(int j=0; j<i; j++){
            if(v[j]<v[i]){
                lis[i] = max(lis[i], lis[j] + 1);
            }
        }
        ans = max(ans, lis[i]);
    }
    
    cout << ans;
    return 0;
}