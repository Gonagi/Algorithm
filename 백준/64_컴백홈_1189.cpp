// 컴백 홈
// 1189

/*
#include <iostream>
#include <vector>
#define Max 5

std::vector<std::vector<char>> map;
std::vector<std::vector<bool>> visited;

struct Direction
{
  int y, x;
};
Direction dir[4] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
int R, C, K, result;

void DFS(int y, int x, int count);
bool isMovable(int y, int x);

int main()
{

  map.resize(Max + 1);
  visited.resize(Max + 1);
  for (int idx = 0; idx <= Max; idx++)
  {
    map[idx].resize(Max + 1);
    visited[idx].resize(Max + 1, false);
  }

  std::cin >> R >> C >> K;

  for (int y = 1; y <= R; y++)
    for (int x = 1; x <= C; x++)
      std::cin >> map[y][x];

  DFS(R, 1, 1);

  std::cout << result << '\n';
  return 0;
}

void DFS(int y, int x, int count)
{
  if (count == K)
  {
    if (y == 1 && x == C)
      result++;
    return;
  }

  visited[y][x] = true;

  for (int d = 0; d < 4; d++)
  {
    Direction next{y + dir[d].y, x + dir[d].x};
    if (!isMovable(next.y, next.x))
      continue;
    if (visited[next.y][next.x])
      continue;
    visited[next.y][next.x] = true;
    DFS(next.y, next.x, count + 1);
    visited[next.y][next.x] = false;
  }
}

bool isMovable(int y, int x)
{
  if (y <= 0 || y > R || x <= 0 || x > C)
    return false;
  if (map[y][x] == 'T')
    return false;
  return true;
}
*/