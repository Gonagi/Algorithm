// 1, 2, 3 더하기
// 9095

/*
#include <iostream>
#include <vector>

int main()
{
  int T, n;
  std::vector<int> vec(12, 1);
  vec.at(2) = 2;
  vec.at(3) = 4;

  for (int idx = 4; idx <= 10; idx++)
    vec.at(idx) = vec.at(idx - 3) + vec.at(idx - 2) + vec.at(idx - 1);

  std::cin >> T;

  for (int idx = 0; idx < T; idx++)
  {
    std::cin >> n;
    std::cout << vec.at(n) << '\n';
  }
  return 0;
}
*/