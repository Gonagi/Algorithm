// 마인크래프트
// 18111

/*
#include <iostream>
#include <vector>

int minHeight = 256, maxHeight, minTimeHeight;
long long minTime = 64000000;

std::vector<std::vector<int>> height(501, std::vector<int>(501));

void input(int &N, int &M, int &B);
void checkHeight(int curHeight, int N, int M, int B);

int main()
{
  int N, M, B;
  input(N, M, B);
  for (int curHeight = maxHeight; curHeight >= minHeight; curHeight--)
    checkHeight(curHeight, N, M, B);

  std::cout << minTime << ' ' << minTimeHeight << '\n';

  return 0;
}

void input(int &N, int &M, int &B)
{
  std::cin >> N >> M >> B;

  for (int y = 0; y < N; y++)
  {
    for (int x = 0; x < M; x++)
    {
      std::cin >> height[y][x];
      if (height[y][x] < minHeight)
        minHeight = height[y][x];
      if (height[y][x] > maxHeight)
        maxHeight = height[y][x];
    }
  }
}

void checkHeight(int curHeight, int N, int M, int B)
{
  long long time = 0;

  for (int y = 0; y < N; y++)
  {
    for (int x = 0; x < M; x++)
    {
      if (curHeight < height[y][x])
      {
        B += (height[y][x] - curHeight);
        time += 2 * (height[y][x] - curHeight);
      }
      else if (curHeight > height[y][x])
      {
        B -= (curHeight - height[y][x]);
        time += (curHeight - height[y][x]);
      }

      if (time > minTime)
        return;
    }
  }
  if (B < 0)
    return;
  if (time < minTime)
  {
    minTime = time;
    minTimeHeight = curHeight;
  }
}
*/