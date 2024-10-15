/*
// A
// 13171

#include <iostream>
#define MOD 1000000007

int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(NULL);
  std::cout.tie(NULL);

  long long result = 1, A, X;

  std::cin >> A >> X;

  A %= MOD;

  while (X)
  {
    if (X & 1) // 홀수일때 (exponent % 2 == 1)
      result = (result * A) % MOD;

    A = (A * A) % MOD;
    X = (X >> 1); // exponent /= 2
  }

  std::cout << result << '\n';

  return 0;
}
*/