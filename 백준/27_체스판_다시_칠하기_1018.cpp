// 체스판 다시 칠하기
// 1018

/*
#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

int N, M;
int findBFirstMin(std::vector<std::vector<char>> &Board, int y,
                  int x);
int findWFirstMin(std::vector<std::vector<char>> &Board, int y,
                  int x);

int main()
{
  std::vector<std::vector<char>> Board(50, std::vector<char>(50, 0));
  std::string boardX;
  int result = 64;

  std::cin >> N >> M;

  for (int y = 0; y < N; y++)
  {
    std::cin >> boardX;
    for (int x = 0; x < M; x++)
      Board[y][x] = boardX[x];
  }

  for (int y = 0; y <= N - 8; y++)
  {
    for (int x = 0; x <= M - 8; x++)
    {
      result = std::min(findBFirstMin(Board, y, x), result);
      result = std::min(findWFirstMin(Board, y, x), result);
    }
  }
  std::cout << result << '\n';

  return 0;
}

int findBFirstMin(std::vector<std::vector<char>> &Board, int y, int x)
{
  int min = 64, count = 0;

  for (int idxY = 0; idxY < 8; idxY++)
  {
    for (int idxX = 0; idxX < 8; idxX++)
    {
      if ((((y + idxY) % 2 == 0 && (x + idxX) % 2 == 0) ||
           ((y + idxY) % 2 != 0 && (x + idxX) % 2 != 0)) &&
          Board[(y + idxY)][(x + idxX)] != 'B')
        count++;
      else if ((((y + idxY) % 2 == 0 && (x + idxX) % 2 != 0) ||
                ((y + idxY) % 2 != 0 && (x + idxX) % 2 == 0)) &&
               Board[(y + idxY)][(x + idxX)] != 'W')
        count++;
    }
  }
  return count;
}

int findWFirstMin(std::vector<std::vector<char>> &Board, int y, int x)
{
  int min = 64, count = 0;

  for (int idxY = 0; idxY < 8; idxY++)
  {
    for (int idxX = 0; idxX < 8; idxX++)
    {
      if ((((y + idxY) % 2 == 0 && (x + idxX) % 2 == 0) ||
           ((y + idxY) % 2 != 0 && (x + idxX) % 2 != 0)) &&
          Board[(y + idxY)][(x + idxX)] != 'W')
        count++;
      else if ((((y + idxY) % 2 == 0 && (x + idxX) % 2 != 0) ||
                ((y + idxY) % 2 != 0 && (x + idxX) % 2 == 0)) &&
               Board[(y + idxY)][(x + idxX)] != 'B')
        count++;
    }
  }
  return count;
}
*/