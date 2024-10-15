/*
// 토마토
// 7576

#include <algorithm>
#include <iostream>
#include <queue>
#include <vector>

struct Direction
{
  int y, x;
};
Direction dir[4] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
std::queue<Direction> que;
int M, N, result;

void input(std::vector<std::vector<int>> &Box);
void solve(std::vector<std::vector<int>> &Box);
void check(std::vector<std::vector<int>> &Box);
bool movable(std::vector<std::vector<int>> &Box, Direction next);

int main()
{
  std::vector<std::vector<int>> Box;

  input(Box);
  solve(Box);
  check(Box);
  std::cout << result << '\n';
  return 0;
}

void input(std::vector<std::vector<int>> &Box)
{
  int num;
  std::cin >> M >> N;
  Box = std::vector<std::vector<int>>(N, std::vector<int>(M, 0));

  for (int y = 0; y < N; y++)
  {
    for (int x = 0; x < M; x++)
    {
      std::cin >> Box[y][x];
      if (Box[y][x] == 1)
        que.push({y, x});
    }
  }
}

void solve(std::vector<std::vector<int>> &Box)
{
  while (!que.empty())
  {
    Direction cur = que.front();
    que.pop();

    for (int d = 0; d < 4; d++)
    {
      Direction next{cur.y + dir[d].y, cur.x + dir[d].x};
      if (movable(Box, next))
      {
        que.push(next);
        Box[next.y][next.x] = Box[cur.y][cur.x] + 1;
      }
    }
  }
}

void check(std::vector<std::vector<int>> &Box)
{
  for (int y = 0; y < N; y++)
  {
    for (int x = 0; x < M; x++)
    {
      if (Box[y][x] == 0)
      {
        result = -1;
        return;
      }
      result = std::max(result, Box[y][x] - 1);
    }
  }
}

bool movable(std::vector<std::vector<int>> &Box, Direction next)
{
  if (next.y < 0 || next.y >= N || next.x < 0 || next.x >= M)
    return false;
  if (Box[next.y][next.x] != 0)
    return false;
  return true;
}
*/

/*
// 토마토
// 7576
// check함수 삭제
#include <algorithm>
#include <iostream>
#include <queue>
#include <vector>

struct Direction
{
  int y, x;
};
Direction dir[4] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
std::queue<Direction> que;
int M, N, result, count1, count2;

void input(std::vector<std::vector<int>> &Box);
void solve(std::vector<std::vector<int>> &Box);
bool movable(std::vector<std::vector<int>> &Box, Direction next);

int main()
{
  std::vector<std::vector<int>> Box;

  input(Box);
  solve(Box);
  if (count1 != count2)
    result = 0;
  if (count1 == 0)
    result = 1;
  std::cout << result - 1 << '\n';
  return 0;
}

void input(std::vector<std::vector<int>> &Box)
{
  int num;
  std::cin >> M >> N;
  Box = std::vector<std::vector<int>>(N, std::vector<int>(M, 0));

  for (int y = 0; y < N; y++)
  {
    for (int x = 0; x < M; x++)
    {
      std::cin >> Box[y][x];
      if (Box[y][x] == 1)
        que.push({y, x});
      else if (Box[y][x] == 0)
        count1++;
    }
  }
}

void solve(std::vector<std::vector<int>> &Box)
{
  while (!que.empty())
  {
    Direction cur = que.front();
    que.pop();

    for (int d = 0; d < 4; d++)
    {
      Direction next{cur.y + dir[d].y, cur.x + dir[d].x};
      if (movable(Box, next))
      {
        que.push(next);
        Box[next.y][next.x] = Box[cur.y][cur.x] + 1;
        result = Box[next.y][next.x];
        count2++;
      }
    }
  }
}

bool movable(std::vector<std::vector<int>> &Box, Direction next)
{
  if (next.y < 0 || next.y >= N || next.x < 0 || next.x >= M)
    return false;
  if (Box[next.y][next.x] != 0)
    return false;
  return true;
}
*/