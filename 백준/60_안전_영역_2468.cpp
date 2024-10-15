// 안전 영역
// 2468

/*
#include <iostream>
#include <queue>
#include <vector>

#define Max 100

int N, max, result;
std::vector<std::vector<int>> vec;
struct Direction
{
  int y, x;
};
Direction dir[4] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

void BFS(int y, int x, int height, int cal,
         std::vector<std::vector<int>> &visitied);
bool isMovable(int y, int x, int height);

int main()
{
  std::ios_base::sync_with_stdio(false);
  std::cin.tie(NULL);
  std::cout.tie(NULL);

  vec.resize(Max + 1);
  for (int idx = 0; idx < Max + 1; idx++)
    vec[idx].resize(Max + 1, 0);

  std::cin >> N;

  for (int y = 0; y < N; y++)
    for (int x = 0; x < N; x++)
    {
      std::cin >> vec[y][x];
      if (max < vec[y][x])
        max = vec[y][x];
    }

  for (int height = 0; height < max; height++)
  {
    std::vector<std::vector<int>> visitied;
    visitied.resize(Max + 1);
    for (int idx = 0; idx < Max + 1; idx++)
      visitied[idx].resize(Max + 1, 0);
    int check = 1;

    for (int y = 0; y < N; y++)
    {
      for (int x = 0; x < N; x++)
      {
        if (!isMovable(y, x, height))
          continue;
        if (visitied[y][x] > 0)
          continue;
        BFS(y, x, height, check, visitied);
        check++;
      }
    }
    if (result < check)
      result = check;
  }
  std::cout << result - 1 << '\n';
  return 0;
}

void BFS(int y, int x, int height, int cal,
         std::vector<std::vector<int>> &visitied)
{
  std::queue<Direction> que;
  que.push({y, x});
  visitied[y][x] = cal;

  while (!que.empty())
  {
    Direction cur = que.front();
    que.pop();

    for (int d = 0; d < 4; d++)
    {
      Direction next{cur.y + dir[d].y, cur.x + dir[d].x};
      if (!isMovable(next.y, next.x, height))
        continue;
      if (visitied[next.y][next.x] > 0)
        continue;
      visitied[next.y][next.x] = cal;
      que.push(next);
    }
  }
}
bool isMovable(int y, int x, int height)
{
  if (y < 0 || y >= N || x < 0 || x >= N)
    return false;
  if (vec[y][x] <= height)
    return false;
  return true;
}
*/