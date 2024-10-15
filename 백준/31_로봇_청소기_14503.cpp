// 로봇 청소기
// 14503

/*
#include <iostream>
#include <vector>

struct Direction
{
  int y, x;
};
Direction dir[4] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
Direction cur;
int N, M, curDir, count = 0;
std::vector<std::vector<int>> room(50, std::vector<int>(50, 0));
std::vector<std::vector<int>> visited(50, std::vector<int>(50, 0));

bool isMovable(Direction next);
void dfs(Direction cur, int curDir);

int main()
{

  std::cin >> N >> M;
  std::cin >> cur.y >> cur.x >> curDir;

  for (int y = 0; y < N; y++)
    for (int x = 0; x < M; x++)
      std::cin >> room[y][x];

  visited[cur.y][cur.x] = 1;
  count++;

  dfs(cur, curDir);

  return 0;
}

bool isMovable(Direction next)
{
  if (next.y < 0 || next.y >= N || next.x < 0 || next.x >= M)
    return false;
  return true;
}

void dfs(Direction cur, int curDir)
{
  for (int d = 0; d < 4; d++)
  {
    int nextDir = (curDir + 3 - d) % 4;
    Direction next = {cur.y + dir[nextDir].y, cur.x + dir[nextDir].x};

    if (!isMovable(next))
      continue;
    if (visited[next.y][next.x] != 0)
      continue;
    if (room[next.y][next.x] != 0)
      continue;

    visited[next.y][next.x] = 1;
    count++;
    dfs(next, nextDir);
  }

  int backDir = curDir + 2 < 4 ? curDir + 2 : curDir - 2;
  Direction back = {cur.y + dir[backDir].y, cur.x + dir[backDir].x};
  if (isMovable(back))
  {
    if (room[back.y][back.x] == 1)
    {
      std::cout << count << '\n';
      exit(0);
    }
    dfs(back, curDir);
  }
}
*/