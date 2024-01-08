// 연구소
// 14502

/*
#include <iostream>
#include <queue>
#include <vector>

struct Direction
{
  int y, x;
};
Direction dir[4] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

void combi(int start, std::vector<Direction> vec);
void solve(std::vector<Direction> vec);
bool isMovable(Direction dir);

int N, M, max;
std::vector<std::vector<int>> map(9, std::vector<int>(9));
std::vector<std::vector<int>> visitied(9, std::vector<int>(9, 0));
std::vector<Direction> emptyVec;
std::queue<Direction> virusQue;

int main()
{
  std::cin >> N >> M;
  for (int y = 0; y < N; y++)
  {
    for (int x = 0; x < M; x++)
    {
      std::cin >> map[y][x];
      if (map[y][x] == 0)
        emptyVec.push_back({y, x});
      else if (map[y][x] == 2)
        virusQue.push({y, x});
    }
  }
  std::vector<Direction> vec;
  combi(-1, vec);

  std::cout << max << '\n';

  return 0;
}

void combi(int start, std::vector<Direction> vec)
{
  if (vec.size() == 3)
  {
    solve(vec);
    return;
  }

  for (int idx = start + 1; idx < emptyVec.size(); idx++)
  {
    vec.push_back(emptyVec.at(idx));
    combi(idx, vec);
    vec.pop_back();
  }
}

void solve(std::vector<Direction> vec)
{
  int count = 0;

  std::vector<std::vector<int>> sMap = map;

  for (int idx = 0; idx < vec.size(); idx++)
    sMap[vec.at(idx).y][vec.at(idx).x] = 1;

  std::queue<Direction> sVirusQue = virusQue;
  std::vector<std::vector<int>> sVisitied = visitied;
  while (!sVirusQue.empty())
  {
    Direction cur = sVirusQue.front();
    sVirusQue.pop();
    sVisitied[cur.y][cur.x] = 1;

    for (int d = 0; d < 4; d++)
    {
      Direction next({cur.y + dir[d].y, cur.x + dir[d].x});
      if (!isMovable(next))
        continue;
      if (sVisitied[next.y][next.x])
        continue;
      if (sMap[next.y][next.x] == 0)
      {
        sMap[next.y][next.x] = 2;
        sVisitied[next.y][next.x] = 1;
        sVirusQue.push(next);
      }
    }
  }
  for (int y = 0; y < N; y++)
  {
    for (int x = 0; x < M; x++)
    {
      if (sMap[y][x] == 0)
        count++;
    }
  }
  if (max < count)
    max = count;
}

bool isMovable(Direction dir)
{
  if (dir.y < 0 || dir.x < 0 || dir.y >= N || dir.x >= M)
    return false;
  return true;
}
*/