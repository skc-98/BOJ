#include<iostream>
#include<string>
#include<queue>
#include<vector>
using namespace std;

char building[31][31][31]; // 건물의 상태를 저장할 배열 building
int cnt[31][31][31]; // 방문시 이동 거리를 저장할 배열 cnt

int dx[6] = { -1,1,0,0,0,0 }; // x 방향 벡터
int dy[6] = { 0,0,-1,1,0,0 }; // y 방향 벡터
int dz[6] = { 0,0,0,0,-1,1 }; // z 방향 벡터
int main()
{
    ios::sync_with_stdio(false); // 표준 stream 동기화 끄기
    cin.tie(NULL); cout.tie(NULL); // 입출력 동기화 끄기

    while (1) {
        int a, b, c; // a: 빌딩 층수, b: 세로 길이, c: 가로 길이
        cin >> a >> b >> c; // 빌딩 크기 입력
        if (a == 0 && b == 0 && c == 0) break; // 모두 0일시 종료

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                for (int k = 0; k < c; k++) {
                    cnt[i][j][k] = -1; // cnt를 -1로 초기화 해서 방문 여부 확인
                }
            }
        }

        queue<vector<int>> q; // bfs 상태를 저장할 queue
        for (int i = 0; i < a; i++) {
            if(i!=0) cin.ignore(); // 각 층 입력 사이의 줄바꿈 제거
            for (int j = 0; j < b; j++) {
                string s; // 빌딩 상태를 줄단위로 입력
                cin >> s; // 빌딩 상태를 입력
                for (int k = 0; k < c; k++) {
                    building[i][j][k] = s[k]; // 빌딩 상태를 building 배열에 입력
                    if (building[i][j][k] == 'S') { // 입력 중 시작 위치를 찾으면
                        q.push({ i,j,k }); // 시작 지점 큐에 삽입
                        cnt[i][j][k] = 0; // 시작 지점 카운트 0으로 초기화
                    }
                }
            }
        }

        bool check = 0; // 탈출 여부 확인하는 변수
        while (!q.empty() && !check) { // 큐가 빌때까지 bfs 탐색을 진행
            int x = q.front()[0]; // 현재 위치의 x좌표
            int y = q.front()[1]; // 현재 위치의 y좌표
            int z = q.front()[2]; // 현재 위치의 z좌표
            q.pop(); // 방문한 좌표는 제거

            for (int i = 0; i < 6; i++) { // 문제에 주어진 방향은 상, 하, 좌, 우, 위, 아래 6개
                int nx = x + dx[i]; // 탐색 방향에 맞게 x값 조정
                int ny = y + dy[i]; // 탐색 방향에 맞게 y값 조정
                int nz = z + dz[i]; // 탐색 방향에 맞게 z값 조정

                if (nx < 0 || nx >= a || ny < 0 || ny >= b || nz < 0 || nz >= c) continue; // 탐색 범위를 초과하는 좌표는 무시
                if (building[nx][ny][nz] == '#' || cnt[nx][ny][nz] != -1) continue; // 갈 수 없는 곳이거나, 이미 방문했으면 무시

                if (building[nx][ny][nz] == 'E') { // 탈출구를 발견하면
                    cout << "Escaped in " << cnt[x][y][z] + 1 << " minute(s)." << '\n'; // 이동 거리 출력
                    check = 1; // 탈출 여부 갱신
                    break; // 탐색 종료
                }
                cnt[nx][ny][nz] = cnt[x][y][z] + 1; // 이동 거리 1증가
                q.push({ nx,ny,nz }); // 큐에 새로운 좌표 추가
            }
        }
        if (!check) cout << "Trapped!" << '\n'; // 탈출 실패면 Trapped! 출력
    }

    return 0; // 종료
}