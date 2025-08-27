#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

bool cmp(const pair<int,int> a, const pair<int,int> b){
    if(a.second==b.second) return a.first < b.first;
    return a.second>b.second;
}

int main()
{
    cin.tie(NULL); cout.tie(NULL);
    int n;
    cin >> n;
    
    vector<pair<int,int>> v;
    for(int i=0; i<n; i++){
        int a,b;
        cin >>a>>b;
        v.push_back(make_pair(a,b));
    }
    
    sort(v.begin(), v.end(), cmp);
    
    int minTime=v[0].second;
    for(int i=0; i<n; i++){
        if(v[i].second<minTime) minTime=v[i].second;
        minTime-=v[i].first;
    }
    
    if(minTime<0) cout << -1;
    else cout << minTime;
    return 0;
}