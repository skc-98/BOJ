#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    vector<int> v(4);
    for(int i=0; i<4; i++){
        cin >> v[i];
    }
    sort(v.begin(), v.end());
    
    cout << v[2]*v[0];
    return 0;
}