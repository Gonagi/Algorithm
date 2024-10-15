// 이동하기
// 11048

/*
#include <algorithm>
#include <iostream>
#include <vector>
#define MAX 1000

int N, M;
std::vector<std::vector<int>> map, max;

int main()
{
  std::ios_base::sync_with_stdio(false);
  std::cin.tie();
  std::cout.tie();

  map.resize(MAX + 1);
  max.resize(MAX + 1);
  for (int idx = 0; idx < MAX + 1; idx++)
  {
    map[idx].resize(MAX + 1, 0);
    max[idx].resize(MAX + 1, 0);
  }

  std::cin >> N >> M;

  for (int y = 1; y <= N; y++)
    for (int x = 1; x <= M; x++)
    {
      std::cin >> map[y][x];
      max[y][x] = map[y][x];
    }

  for (int y = 1; y <= N; y++)
    for (int x = 1; x <= M; x++)
      max[y][x] = std::max(std::max(map[y][x] + max[y][x - 1],
                                    map[y][x] + max[y - 1][x - 1]),
                           map[y][x] + max[y - 1][x]);

  std::cout << max[N][M] << '\n';

  return 0;
}
*/