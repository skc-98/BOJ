#include<iostream>
#include<vector>
#include<algorithm>
#include<climits>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int n,m;
    cin >>n>>m;
    
    vector<int> v;
    for(int i=0; i<n; i++){
        int a;
        cin >>a;
        v.push_back(a);
    }
    
    long long min_value = LLONG_MAX;
    for(int i=0; i<n-1; i++){
        long long cost = (long long)(v[i] + v[i+1]) * m;
        min_value=min(cost,min_value);
    }
    cout << min_value;
    return 0;
}