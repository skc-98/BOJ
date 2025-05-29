#include <iostream>
#include <unordered_set>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    unordered_set<int> st;
    for(int i=2; i<=9; i++){
        for(int j=1; j<=9; j++){
            st.insert(i);
            st.insert(j);
            st.insert(i*j);
        }
    }
    
    int n;
    cin >>n;
    if (st.find(n) != st.end()) cout << 1;
    else cout << 0;
    return 0;
}