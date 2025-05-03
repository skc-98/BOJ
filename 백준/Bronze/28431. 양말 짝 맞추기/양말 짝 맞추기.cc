#include <iostream>
#include <unordered_map>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    unordered_map<int, int> mp;
    for(int i=0; i<5; i++){
        int a;
        cin >> a;
        mp[a]++;
    }
    
    for(const auto& iter: mp){
        if(iter.second%2==1){
            cout << iter.first;
            break;
        }
    }
    return 0;
}