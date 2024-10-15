// 에라토스테네스의 체
// 2960

/*
#include <iostream>
#include <vector>

int main()
{
  int N, K, count = 0, curNum = 2, curIdx = 2;
  std::vector<int> visited(1002, 0);
  std::cin >> N >> K;

  while (count < K)
  {
    if (curIdx <= N)
    {
      if (!visited.at(curIdx))
      {
        visited.at(curIdx) = 1;
        count++;
        if (count == K)
          break;
      }
      if (curIdx + curNum > N)
        curIdx = ++curNum;
      else
        curIdx += curNum;
    }
  }
  std::cout << curIdx << '\n';

  return 0;
}
*/

/*
#include <iostream>
#include <vector>

int main()
{
  int N, K, count = 0;
  std::vector<int> visited(1002, 0);
  std::cin >> N >> K;

  for (int curIdx = 2; curIdx <= N; curIdx++)
  {
    for (int curNum = curIdx; curNum <= N; curNum += curIdx)
    {
      if (!visited.at(curNum))
      {
        visited.at(curNum) = 1;
        count++;
        if (count == K)
        {
          std::cout << curNum << '\n';
          return 0;
        }
      }
    }
  }
  return 0;
}
*/