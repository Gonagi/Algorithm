// 별 찍기 - 11
// 2448

/*
#include <iostream>
#include <vector>

std::vector<std::vector<char>> triangle;

void print(int x, int y, int n);

int main()
{
  std::ios_base::sync_with_stdio(false);
  std::cin.tie();
  std::cout.tie();

  int N;
  std::cin >> N;

  triangle.resize(N);
  for (int idx = 0; idx < N; idx++)
    triangle[idx].resize(2 * N - 1, ' ');

  print(0, N - 1, N);

  for (int y = 0; y < N; y++)
  {
    for (int x = 0; x < 2 * N - 1; x++)
    {
      std::cout << triangle[y][x];
    }
    std::cout << '\n';
  }
  return 0;
}

void print(int x, int y, int n)
{
  if (n == 3)
  {
    triangle[x][y] = '*';
    triangle[x + 1][y - 1] = '*';
    triangle[x + 2][y - 2] = '*';
    triangle[x + 2][y - 1] = '*';
    triangle[x + 2][y] = '*';
    triangle[x + 2][y + 1] = '*';
    triangle[x + 2][y + 2] = '*';
    triangle[x + 1][y + 1] = '*';
  }
  else
  {
    print(x, y, n / 2);
    print(x + n / 2, y - n / 2, n / 2);
    print(x + n / 2, y + n / 2, n / 2);
  }
}
*/