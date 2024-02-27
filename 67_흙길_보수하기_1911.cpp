// 흙길 보수하기
// 1911

/*
#include <algorithm>
#include <iostream>
#include <utility>
#include <vector>
#define Max 1000000000

int main()
{
  std::ios_base::sync_with_stdio(false);
  std::cin.tie(NULL);
  std::cout.tie(NULL);

  std::vector<std::pair<int, int>> load;
  int N, L, start, end, result = 0, cur = 0;

  std::cin >> N >> L;

  for (int idx = 0; idx < N; idx++)
  {
    std::cin >> start >> end;
    load.push_back({start, end});
  }
  std::sort(load.begin(), load.end());

  for (int idx = 0; idx < load.size(); idx++)
  {

    if (cur >= load[idx].second)
      continue;

    cur = std::max(cur, load[idx].first);

    int count = (load[idx].second - cur - 1) / L + 1;

    result += count;
    cur += L * count;
  }

  std::cout << result << '\n';

  return 0;
}
*/