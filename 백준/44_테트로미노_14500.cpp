// 테트로미노
// 14500

/*
#include <iostream>
#include <vector>

#define MAX 500
int N, M, max;
std::vector<std::vector<int>> paper;
std::vector<std::vector<bool>> visitied;
struct Direction
{
  int y, x;
};
Direction dir[4] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

void DFS(Direction cur, int sum, int count);
void checkH(Direction cur);
void H1(Direction cur);
void H2(Direction cur);
void H3(Direction cur);
void H4(Direction cur);
bool isMovable(Direction next);

int main()
{
  Direction cur;
  paper.resize(MAX + 1);
  visitied.resize(MAX + 1);
  for (int idx = 0; idx < MAX + 1; idx++)
  {
    paper[idx].resize(MAX + 1, 0);
    visitied[idx].resize(MAX + 1, false);
  }

  std::cin >> N >> M;
  for (int y = 0; y < N; y++)
    for (int x = 0; x < M; x++)
      std::cin >> paper[y][x];

  for (int y = 0; y < N; y++)
  {
    for (int x = 0; x < M; x++)
    {
      cur.y = y;
      cur.x = x;
      visitied[cur.y][cur.x] = true;
      DFS(cur, paper[cur.y][cur.x], 0);
      visitied[cur.y][cur.x] = false;
      checkH(cur);
    }
  }

  std::cout << max << '\n';

  return 0;
}

void DFS(Direction cur, int sum, int count)
{
  if (count == 3)
  {
    max = std::max(max, sum);
    return;
  }
  for (int d = 0; d < 4; d++)
  {
    Direction next{cur.y + dir[d].y, cur.x + dir[d].x};
    if (!isMovable(next))
      continue;
    if (visitied[next.y][next.x])
      continue;
    sum += paper[next.y][next.x];
    visitied[next.y][next.x] = true;
    DFS(next, sum, count + 1);
    sum -= paper[next.y][next.x];
    visitied[next.y][next.x] = false;
  }
  return;
}

void checkH(Direction cur)
{
  H1(cur);
  H2(cur);
  H3(cur);
  H4(cur);
}

void H1(Direction cur)
{
  int Hmax = 0;
  if (isMovable(cur))
    Hmax += paper[cur.y][cur.x];
  if (isMovable({cur.y + 1, cur.x}))
    Hmax += paper[cur.y + 1][cur.x];
  if (isMovable({cur.y + 1, cur.x + 1}))
    Hmax += paper[cur.y + 1][cur.x + 1];
  if (isMovable({cur.y + 2, cur.x}))
    Hmax += paper[cur.y + 2][cur.x];
  max = std::max(max, Hmax);
  return;
}

void H2(Direction cur)
{
  int Hmax = 0;
  if (isMovable(cur))
    Hmax += paper[cur.y][cur.x];
  if (isMovable({cur.y - 1, cur.x + 1}))
    Hmax += paper[cur.y - 1][cur.x + 1];
  if (isMovable({cur.y, cur.x + 1}))
    Hmax += paper[cur.y][cur.x + 1];
  if (isMovable({cur.y, cur.x + 2}))
    Hmax += paper[cur.y][cur.x + 2];
  max = std::max(max, Hmax);
  return;
}

void H3(Direction cur)
{
  int Hmax = 0;
  if (isMovable(cur))
    Hmax += paper[cur.y][cur.x];
  if (isMovable({cur.y - 1, cur.x + 1}))
    Hmax += paper[cur.y - 1][cur.x + 1];
  if (isMovable({cur.y, cur.x + 1}))
    Hmax += paper[cur.y][cur.x + 1];
  if (isMovable({cur.y + 1, cur.x + 1}))
    Hmax += paper[cur.y + 1][cur.x + 1];
  max = std::max(max, Hmax);
  return;
}

void H4(Direction cur)
{
  int Hmax = 0;
  if (isMovable(cur))
    Hmax += paper[cur.y][cur.x];
  if (isMovable({cur.y, cur.x + 1}))
    Hmax += paper[cur.y][cur.x + 1];
  if (isMovable({cur.y + 1, cur.x + 1}))
    Hmax += paper[cur.y + 1][cur.x + 1];
  if (isMovable({cur.y, cur.x + 2}))
    Hmax += paper[cur.y][cur.x + 2];
  max = std::max(max, Hmax);
  return;
}

bool isMovable(Direction next)
{
  if (next.y < 0 || next.x < 0 || next.y >= N || next.x >= M)
    return false;
  return true;
}
*/