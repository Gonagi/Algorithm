// 영역 구하기
// 2583

/*
#include <algorithm>
#include <iostream>
#include <queue>
#include <vector>

#define Max 100

int N, M, K;
std::vector<std::vector<int>> board;
struct Direction
{
  int y, x;
};
Direction dir[4] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

bool isMovable(Direction next);

int main()
{
  int x1, x2, y1, y2, count = 0, size;
  std::queue<Direction> que;
  std::vector<int> result;

  board.resize(Max + 1);
  for (int idx = 0; idx < Max + 1; idx++)
    board[idx].resize(Max + 1, 1);

  std::cin >> N >> M >> K;
  for (int idx = 0; idx < K; idx++)
  {
    std::cin >> x1 >> y1 >> x2 >> y2;
    for (int y = y1; y < y2; y++)
    {
      for (int x = x1; x < x2; x++)
      {
        board[y][x] = 0;
      }
    }
  }

  for (int y = 0; y < N; y++)
  {
    for (int x = 0; x < M; x++)
    {
      if (board[y][x] == 1)
      {
        size = 1;
        que.push({y, x});

        while ((!que.empty()))
        {
          Direction cur = que.front();
          board[cur.y][cur.x] = 0;
          que.pop();
          for (int d = 0; d < 4; d++)
          {
            Direction next{cur.y + dir[d].y, cur.x + dir[d].x};
            if (!isMovable(next))
              continue;
            board[next.y][next.x] = 0;
            que.push(next);
            size++;
          }
        }
        result.push_back(size);
        count++;
      }
    }
  }

  std::cout << count << '\n';
  std::sort(result.begin(), result.end());
  for (int idx = 0; idx < result.size(); idx++)
    std::cout << result.at(idx) << ' ';

  return 0;
}

bool isMovable(Direction next)
{
  if (next.y < 0 || next.x < 0 || next.y >= N || next.x >= M)
    return false;
  if (board[next.y][next.x] != 1)
    return false;
  return true;
}
*/