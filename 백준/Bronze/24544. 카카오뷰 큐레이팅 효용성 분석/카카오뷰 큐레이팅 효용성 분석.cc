#include <iostream>
#include <vector>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n;
    cin >>n;
    
    int sum=0, sum2=0;
    vector<int> v(n);
    for(int i=0; i<n; i++){
        cin >> v[i];
        sum+=v[i];
    }
    for(int i=0; i<n; i++){
        int a;
        cin >> a;
        if(a==0) sum2+=v[i];
    }
    cout << sum <<'\n' << sum2;
    return 0;
}