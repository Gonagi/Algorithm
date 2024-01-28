// 강의실 배정
// 11000

/*
#include <algorithm>
#include <functional>
#include <iostream>
#include <queue>
#include <utility>
#include <vector>

int main()
{
  int N, s, t, count = 0;
  std::vector<std::pair<int, int>> vec;
  vec.reserve(200001);
  std::priority_queue<int, std::vector<int>, std::greater<int>> pQue;

  std::ios_base::sync_with_stdio(false);
  std::cin.tie();
  std::cout.tie();

  std::cin >> N;

  for (int idx = 0; idx < N; idx++)
  {
    std::cin >> s >> t;
    vec.push_back({s, t});
  }

  std::sort(vec.begin(), vec.end());

  for (int idx = 0; idx < N; idx++)
  {
    pQue.push(vec.at(idx).second);

    if (pQue.top() <= vec.at(idx).first)
      pQue.pop();
  }

  std::cout << pQue.size() << '\n';
  return 0;
}
*/