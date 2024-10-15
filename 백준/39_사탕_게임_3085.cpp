// 사탕 게임
// 3085

/*
#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

struct Direction
{
  int y, x;
};
Direction dir[4] = {{1, 0}, {0, 1}};
int N, result;

bool isMovable(Direction dir);
void changeColor(std::vector<std::vector<char>> board, Direction cur);
int countMax(std::vector<std::vector<char>> board);

int main()
{
  std::vector<std::vector<char>> board;
  std::string str;

  std::cin >> N;

  board.resize(N, std::vector<char>(N, ' '));

  for (int y = 0; y < N; y++)
  {
    std::cin >> str;
    for (int x = 0; x < N; x++)
      board[y][x] = str.at(x);
  }

  for (int y = 0; y < N; y++)
  {
    for (int x = 0; x < N; x++)
    {
      Direction cur{y, x};
      changeColor(board, cur);
    }
  }
  std::cout << result << '\n';
  return 0;
}

bool isMovable(Direction dir)
{
  if (dir.y < 0 || dir.y >= N || dir.x < 0 || dir.x >= N)
    return false;
  return true;
}

void changeColor(std::vector<std::vector<char>> board, Direction cur)
{
  for (int d = 0; d < 2; d++)
  {
    Direction next{cur.y + dir[d].y, cur.x + dir[d].x};
    if (!isMovable(next))
      continue;

    std::swap(board[cur.y][cur.x], board[next.y][next.x]);
    if (board[cur.y][cur.x] == board[next.y][next.x])
      continue;
    result = std::max(result, countMax(board));
    std::swap(board[cur.y][cur.x], board[next.y][next.x]);
  }
}

int countMax(std::vector<std::vector<char>> board)
{
  int count = 1, max = 0;

  for (int y = 0; y < N; y++)
  {
    for (int x = 0; x < N - 1; x++)
    {
      if (board[y][x] == board[y][x + 1])
      {
        count++;
        if (max < count)
          max = count;
      }
      else
        count = 1;
    }
    count = 1;
  }

  for (int x = 0; x < N; x++)
  {
    for (int y = 0; y < N - 1; y++)
    {
      if (board[y][x] == board[y + 1][x])
      {
        count++;
        if (max < count)
          max = count;
      }
      else
        count = 1;
    }
    count = 1;
  }

  return max;
}
*/