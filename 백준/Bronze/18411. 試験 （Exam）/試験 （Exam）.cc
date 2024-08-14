#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    vector<int> v;
    for(int i=0; i<3; i++){
        int a;
        cin >>a;
        v.push_back(a);
    }
    sort(v.begin(), v.end());
    cout << v[1]+v[2];
    return 0;
}