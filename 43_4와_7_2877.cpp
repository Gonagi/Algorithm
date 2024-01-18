// 4와 7
// 2877

/*
#include <algorithm>
#include <iostream>

int main()
{
  int K, n = 1, powOfTwo = 1;
  std::vector<int> vec;
  vec.resize(30, 0);
  std::cin >> K;

  while (1)
  {
    powOfTwo *= 2;
    if (K <= 2 * (powOfTwo - 1))
      break;
    n++;
  }
  K -= 2 * (powOfTwo / 2 - 1);
  K--;

  int tmpN = n;

  while (K)
  {
    if (K % 2 == 0)
      vec.at(n) = 0;
    else
      vec.at(n) = 1;
    K /= 2;
    n--;
  }

  for (int idx = 1; idx <= tmpN; idx++)
  {
    if (vec.at(idx) == 0)
      std::cout << 4;
    else
      std::cout << 7;
  }
  std::cout << '\n';

  return 0;
}
*/