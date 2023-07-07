// 이항 계수 3
// 11401

/*
#include <iostream>
#define MOD 1000000007

int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(NULL);
  std::cout.tie(NULL);

  long long result = 1, N, K;

  std::cin >> N >> K;

  for (long long num = K + 1; num <= N; num++)
    result = (result * num) % MOD;

  long long base = 1;
  for (long long num = 1; num <= N - K; num++)
    base = (base * num) % MOD;

  long long exponent = MOD - 2;

  while (exponent)
  {
    if (exponent & 1) // 홀수일때 (exponent % 2 == 1)
      result = (result * base) % MOD;

    base = (base * base) % MOD;
    exponent = (exponent >> 1); // exponent /= 2
  }

  std::cout << result << '\n';

  return 0;
}
*/