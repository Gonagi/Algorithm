/*
// 로봇 청소기
// 4991
#include <algorithm>
#include <iostream>
#include <limits.h>
#include <queue>
#include <vector>
struct Direction
{
  int y, x;
};
Direction dir[4] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
Direction start;

int h, w;
char map[20][20];
void input(std::vector<Direction> &dirty);
void BFS(std::vector<std::vector<int>> &count, int y, int x);
bool movable(Direction next);

int main()
{
  while (1)
  {
    std::cin >> w >> h;
    if (w == 0 && h == 0)
      break;

    std::vector<Direction> dirty;
    std::vector<int> start_to_dirty;
    int result = INT_MAX;
    input(dirty);
    std::vector<std::vector<int>> count(h, std::vector<int>(w, INT_MAX));
    BFS(count, start.y, start.x);

    for (int idx = 0; idx < dirty.size(); idx++)
      start_to_dirty.push_back(count[dirty[idx].y][dirty[idx].x]);

    std::vector<std::vector<int>> dirty_to_dirty;
    std::vector<int> dirty_index;
    for (int from = 0; from < dirty.size(); from++)
    {
      std::vector<std::vector<int>> count(h, std::vector<int>(w, INT_MAX));
      std::vector<int> dirty_to_dirty_x;
      BFS(count, dirty[from].y, dirty[from].x);
      for (int to = 0; to < dirty.size(); to++)
      {
        if (from == to)
          dirty_to_dirty_x.push_back(0);
        else
          dirty_to_dirty_x.push_back(count[dirty[to].y][dirty[to].x]);
      }
      dirty_to_dirty.push_back(dirty_to_dirty_x);
      dirty_index.push_back(from);
    }

    int sum;
    do
    {
      sum = start_to_dirty[dirty_index[0]];

      for (int idx = 0; idx < dirty.size() - 1; idx++)
      {
        if (dirty_to_dirty[dirty_index[idx]][dirty_index[idx + 1]] == INT_MAX)
        {
          sum = -1;
          break;
        }
        sum += dirty_to_dirty[dirty_index[idx]][dirty_index[idx + 1]];
      }

      if (sum == -1)
        continue;
      result = std::min(result, sum);
    } while (std::next_permutation(dirty_index.begin(), dirty_index.end()));
    if (result == INT_MAX)
      result = -1;
    std::cout << result << '\n';
  }
  return 0;
}

void input(std::vector<Direction> &dirty)
{
  int num;
  for (int y = 0; y < h; y++)
  {
    for (int x = 0; x < w; x++)
    {
      std::cin >> map[y][x];
      if (map[y][x] == 'o')
      {
        map[y][x] = '.';
        start.y = y;
        start.x = x;
      }
      else if (map[y][x] == '*')
        dirty.push_back({y, x});
    }
  }
}

void BFS(std::vector<std::vector<int>> &count, int y, int x)
{
  std::queue<Direction> que;
  que.push({y, x});
  count[y][x] = 0;

  while (!que.empty())
  {
    Direction cur = que.front();
    que.pop();

    for (int d = 0; d < 4; d++)
    {
      Direction next{cur.y + dir[d].y, cur.x + dir[d].x};
      if (movable(next) && map[next.y][next.x] != 'x' && count[cur.y][cur.x] + 1 < count[next.y][next.x])
      {
        count[next.y][next.x] = count[cur.y][cur.x] + 1;
        que.push(next);
      }
    }
  }
}

bool movable(Direction next)
{
  if (next.y < 0 || next.y >= h || next.x < 0 || next.x >= w)
    return false;
  return true;
}
*/