// 생태학
// 4358

/*
#include <iostream>
#include <map>
#include <string>

int main()
{
  std::ios_base::sync_with_stdio(false);
  std::cin.tie(NULL);
  std::cout.tie(NULL);

  std::string str;
  std::map<std::string, float> map;
  int count = 0;
  std::cout.precision(4);
  std::cout << std::fixed;

  while (std::getline(std::cin, str))
  {
    if (map.find(str) != map.end())
      map[str] += 1;
    else
      map.insert({str, 1});
    count++;
  }

  for (const auto &[key, value] : map)
  {
    std::cout << key << ' ' << 100 * value / count << '\n';
  }

  return 0;
}
*/