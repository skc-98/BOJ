#include<iostream>
#include<cmath>
using namespace std;

int d[101][101];
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int n, m;
    cin >> n >> m;
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> d[i][j];
        }
    }
    
    int ans = 0;
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(d[i][j] == 0) continue;

            // 모든 면이 드러났을 경우
            ans += d[i][j] * 6;
            
            // 같은 칸에서 위로 쌓인 큐브 겹치는 면 제거
            ans -= (d[i][j] - 1) * 2;

            // 이웃한 칸과 겹치는 면 제거
            if(i > 0) ans -= min(d[i][j], d[i-1][j]);
            if(i < n-1) ans -= min(d[i][j], d[i+1][j]);
            if(j > 0) ans -= min(d[i][j], d[i][j-1]);
            if(j < m-1) ans -= min(d[i][j], d[i][j+1]);
        }
    }

    cout << ans << '\n';
    return 0;
}