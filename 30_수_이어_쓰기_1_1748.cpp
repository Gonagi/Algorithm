// 수 이어 쓰기 1
// 1748

/*
#include <cmath>
#include <iostream>
#include <string>

int main()
{
  long long result = 0, N;
  std::cin >> N;

  int numLength = std::to_string(N).size();

  for (int digit = 1; digit <= numLength - 1; digit++)
  {
    result += digit * 9 * std::pow(10, digit - 1);
  }
  result += numLength * (N - std::pow(10, numLength - 1) + 1);

  std::cout << result << '\n';
  return 0;
}
*/

/*
#include <iostream>

int main()
{
  long long result = 0, N;
  std::cin >> N;

  if (N < 10)
  {
    std::cout << N;
    return 0;
  }
  for (int digit = 1; digit <= N; digit *= 10)
    result += N - digit + 1;

  std::cout << result << '\n';

  return 0;
}
*/