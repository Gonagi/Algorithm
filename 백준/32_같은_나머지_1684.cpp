// 같은 나머지
// 1684

/*
#include <algorithm>
#include <iostream>
#include <vector>

int gcd(int x, int y)
{
  while (y)
  {
    int t = x % y;
    x = y;
    y = t;
  }
  return x;
}

int main()
{
  int n, min, num;
  std::vector<int> vec, vec2;

  std::cin >> n;

  for (int idx = 0; idx < n; idx++)
  {
    std::cin >> num;
    vec.push_back(num);
  }

  std::sort(vec.begin(), vec.end());

  for (int idx = 0; idx < vec.size() - 1; idx++)
    vec2.push_back({vec.at(idx + 1) - vec.at(idx)});
  std::sort(vec2.begin(), vec2.end());

  min = vec2.at(0);

  for (int idx = 0; idx < vec2.size(); idx++)
  {
    min = gcd(min, vec2.at(idx));
  }
  std::cout << min << '\n';

  return 0;
}
*/