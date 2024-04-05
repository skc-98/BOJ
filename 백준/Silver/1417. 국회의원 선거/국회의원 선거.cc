#include<iostream>
#include<queue>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int n;
    cin >>n;
    
    int dasom;
    cin >>dasom;
    
    if(n==1){
        cout << 0;
        return 0;
    }
    
    priority_queue<int> q;
    for(int i=0; i<n-1; i++){
        int a;
        cin >>a;
        q.push(a);
    }
    
    int count=0;
    while(1){
        if(q.top()<dasom) break;
        else{
            int k=q.top();
            q.pop();
            k--;
            count++;
            dasom++;
            q.push(k);
        }
    }
    cout << count;
    return 0;
}