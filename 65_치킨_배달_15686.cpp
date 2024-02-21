// 치킨 배달
// 15686

/*
#include <algorithm>
#include <iostream>
#include <vector>
#define Max 50

struct Direction
{
  int y, x;
};
std::vector<std::vector<int>> map;
std::vector<Direction> hVec, cVec;
std::vector<bool> vec;
int N, M, result = 1000000000;
int cal(int y, int x);

int main()
{
  int sum = 0;
  map.resize(Max + 1);

  for (int idx = 0; idx < Max + 1; idx++)
    map[idx].resize(Max + 1, 0);

  std::cin >> N >> M;

  for (int y = 1; y <= N; y++)
  {
    for (int x = 1; x <= N; x++)
    {
      std::cin >> map[y][x];
      if (map[y][x] == 1)
        hVec.push_back({y, x});
      else if (map[y][x] == 2)
        cVec.push_back({y, x});
    }
  }

  vec.resize(cVec.size(), 1);
  for (int idx = 0; idx < M; idx++)
    vec[idx] = 0;

  do
  {
    sum = 0;
    for (int i = 0; i < hVec.size(); i++)
      sum += cal(hVec[i].y, hVec[i].x);
    result = result < sum ? result : sum;
  } while (std::next_permutation(vec.begin(), vec.end()));

  std::cout << result << '\n';

  return 0;
}

int cal(int y, int x)
{
  int yDistance, xDistance, min = 1000000000;
  for (int idx = 0; idx < cVec.size(); idx++)
  {
    if (vec[idx] != 0)
      continue;
    yDistance = y < cVec[idx].y ? cVec[idx].y - y : y - cVec[idx].y;
    xDistance = x < cVec[idx].x ? cVec[idx].x - x : x - cVec[idx].x;
    min = yDistance + xDistance < min ? yDistance + xDistance : min;
  }
  return min;
}
*/