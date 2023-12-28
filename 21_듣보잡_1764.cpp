// 듣보잡
// 1764

/*
#include <algorithm>
#include <iostream>
#include <map>
#include <string>
#include <vector>

int main()
{
  int N, M;
  std::string str;
  std::vector<std::string> result;
  std::map<std::string, int> map;

  std::cin >> N >> M;

  for (int idx = 0; idx < N + M; idx++)
  {
    std::cin >> str;
    map[str]++;
    if (map[str] > 1)
      result.push_back(str);
  }

  std::sort(result.begin(), result.end());

  std::cout << result.size() << '\n';
  for (auto iter : result)
    std::cout << iter << '\n';
  return 0;
}
*/