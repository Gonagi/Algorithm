/*
// 레이저 통신
// 6087

#include <algorithm>
#include <iostream>
#include <queue>
#include <string>
#include <vector>

struct Direction
{
  int y, x, d = -1;
};
Direction dir[4] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

std::vector<Direction> C;
std::vector<std::vector<char>> map;
int W, H, result = 987654321;

void input();
void solve();
bool movable(int y, int x);

int main()
{
  input();
  solve();
  std::cout << result << '\n';
  return 0;
}

void input()
{
  std::string str;
  std::cin >> W >> H;
  for (int y = 0; y < H; y++)
  {
    std::vector<char> map_x;
    std::cin >> str;

    for (int x = 0; x < W; x++)
    {
      if (str[x] == 'C')
      {
        str[x] = '*';
        C.push_back({y, x});
      }
      map_x.push_back(str[x]);
    }
    map.push_back(map_x);
  }
  map[C[1].y][C[1].x] = '.';
}

void solve()
{
  //   std::vector<std::vector<std::vector<bool>>> visited(H,
  //                                                       std::vector<std::vector<bool>>(W, std::vector<bool>(4,
  //                                                       false)));
  //   std::vector<std::vector<std::vector<int>>> count(H, std::vector<std::vector<int>>(W, std::vector<int>(4, 0)));
  bool visited[101][101][4] = {false};
  int count[101][101][4] = {0};

  std::queue<Direction> que;
  que.push({C[0].y, C[0].x, -1});
  for (int d = 0; d < 4; d++)
  {
    visited[C[0].y][C[0].x][d] = true;
    count[C[0].y][C[0].x][d] = 0;
  }

  while ((!que.empty()))
  {
    Direction cur = que.front();
    que.pop();

    for (int d = 0; d < 4; d++)
    {
      Direction next{cur.y + dir[d].y, cur.x + dir[d].x};
      if (movable(next.y, next.x) && map[next.y][next.x] != '*')
      {
        if (cur.d == -1) // 처음 C
        {
          count[next.y][next.x][d] = 1;
          visited[next.y][next.x][d] = true;
          que.push({next.y, next.x, d});
        }
        else if (cur.d != d) // 방향 다를때
        {
          if (!visited[next.y][next.x][d]) // 처음 방문하면
          {
            count[next.y][next.x][d] = count[cur.y][cur.x][cur.d] + 1;
            visited[next.y][next.x][d] = true;
            que.push({next.y, next.x, d});
          }
          // 방문한적 있고 '이번 방문 + 1'보다 '다음 방문'의 거울 개수가 적은경우
          // 이번 방문에 거울 설치해 90도 꺾음 VS 90도 꺾여진 다음 방문의 거울 개수
          else if (count[next.y][next.x][d] > count[cur.y][cur.x][cur.d] + 1)
          {
            count[next.y][next.x][d] = count[cur.y][cur.x][cur.d] + 1;
            que.push({next.y, next.x, d});
          }
        }

        else // 방향 같을 때
        {
          if (!visited[next.y][next.x][d]) // 처음 방문하면
          {
            count[next.y][next.x][d] = count[cur.y][cur.x][cur.d];
            visited[next.y][next.x][d] = true;
            que.push({next.y, next.x, d});
          }
          // 방문한적 있고 '이번 방문'보다 '다음 방문'의 거울 개수가 적은경우
          // 이번 방문에 거울 개수 VS 다음 방문의 거울 개수
          else if (count[next.y][next.x][d] > count[cur.y][cur.x][cur.d])
          {
            count[next.y][next.x][d] = count[cur.y][cur.x][cur.d];
            que.push({next.y, next.x, d});
          }
        }
      }
    }
  }

  for (int d = 0; d < 4; d++)
  {
    if (visited[C[1].y][C[1].x][d]) // 도달한 방문만 고려
      result = std::min(result, count[C[1].y][C[1].x][d]);
  }
  result--;
}

bool movable(int y, int x)
{
  if (y < 0 || y >= H || x < 0 || x >= W)
    return false;
  return true;
}
*/