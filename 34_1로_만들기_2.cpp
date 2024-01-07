// 1로 만들기 2
// 12852

/*
#include <iostream>
#include <queue>
#include <utility>
#include <vector>

int main()
{
  int N;
  std::cin >> N;

  std::queue<std::pair<std::vector<int>, int>> que;
  std::vector<int> vec(1, N), curVec;
  int curCount, curNum;
  que.push({vec, 0});

  while (!que.empty())
  {
    curVec = que.front().first;
    curCount = ++que.front().second;
    curNum = curVec.at(curVec.size() - 1);

    if (curNum % 3 == 0)
    {
      curVec.push_back(curNum / 3);
      que.push({curVec, curCount});
      if (curNum / 3 == 1)
        break;
    }
    curVec = que.front().first;

    if (curNum % 2 == 0)
    {
      curVec.push_back(curNum / 2);
      que.push({curVec, curCount});
      if (curNum / 2 == 1)
        break;
    }
    curVec = que.front().first;

    if (curNum > 1)
    {
      curVec.push_back(curNum - 1);
      que.push({curVec, curCount});
      if (curNum - 1 == 1)
        break;
    }
    que.pop();
  }

  if (N == 1)
    std::cout << 0 << '\n';
  else
    std::cout << curCount << '\n';
  for (int idx = 0; idx < curVec.size(); idx++)
    std::cout << curVec.at(idx) << ' ';
  std::cout << '\n';
  return 0;
}
*/

/*
#include <algorithm>
#include <iostream>
#include <vector>

int main()
{
  int N;
  std::cin >> N;
  std::vector<int> vec(N + 1, 1000001);

  vec.at(1) = 1;

  for (int idx = 2; idx <= N; idx++)
  {
    if (idx % 3 == 0)
      vec.at(idx) = std::min(vec.at(idx), vec.at(idx / 3));
    if (idx % 2 == 0)
      vec.at(idx) = std::min(vec.at(idx), vec.at(idx / 2));
    vec.at(idx) = std::min(vec.at(idx), vec.at(idx - 1)) + 1;
  }

  std::cout << vec.at(N) - 1 << '\n';

  while (N != 1)
  {
    std::cout << N << ' ';

    if (N % 3 == 0 && vec.at(N) == vec.at(N / 3) + 1)
      N /= 3;
    else if (N % 2 == 0 && vec.at(N) == vec.at(N / 2) + 1)
      N /= 2;
    else if (vec.at(N) == vec.at(N - 1) + 1)
      N--;
  }
  std::cout << 1 << '\n';

  return 0;
}
*/