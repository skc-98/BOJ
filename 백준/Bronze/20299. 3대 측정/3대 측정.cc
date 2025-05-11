#include <iostream>
#include <vector>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int n,k,l;
    cin >>n>>k>>l;
    
    int count=0;
    vector<int> ans;
    
    for(int i=0; i<n; i++){
        int a,b,c;
        cin >>a>>b>>c;
        if(a>=l && b>=l && c>=l && (a+b+c)>=k){
            count++;
            ans.push_back(a);
            ans.push_back(b);
            ans.push_back(c);
        }
    }
    
    cout << count << '\n';
    for(int i=0; i<ans.size(); i++){
        cout << ans[i] << " ";
    }
    return 0;
}