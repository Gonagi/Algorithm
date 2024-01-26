// 배열 복원하기
// 16967

/*
#include <iostream>
#include <vector>

std::vector<std::vector<int>> vec, A;

int main()
{
  int H, W, X, Y;

  std::cin >> H >> W >> X >> Y;
  vec.resize(H + X);
  A.resize(H);
  for (int idx = 0; idx < H + X; idx++)
  {
    if (idx < H)
      A[idx].resize(W, 0);
    vec[idx].resize(W + Y, 0);
  }

  for (int y = 0; y < H + X; y++)
  {
    for (int x = 0; x < W + Y; x++)
    {
      std::cin >> vec[y][x];
      if (y < H && x < W)
        A[y][x] = vec[y][x];
    }
  }

  for (int y = 0; y < H; y++)
  {
    for (int x = 0; x < W; x++)
    {
      if (y + X < H && x + Y < W)
        A[y + X][x + Y] -= A[y][x];
      std::cout << A[y][x] << ' ';
    }
    std::cout << '\n';
  }
  return 0;
}
*/