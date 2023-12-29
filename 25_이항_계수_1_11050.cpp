// 이항 계수 1
// 11050

/*
#include <iostream>

int main()
{
  int N, K, result = 1;

  std::cin >> N >> K;

  if (K < N / 2)
  {
    for (int num = N - K + 1; num <= N; num++)
      result *= num;
    for (int num = 1; num <= K; num++)
      result /= num;
  }
  else
  {
    for (int num = K + 1; num <= N; num++)
      result *= num;
    for (int num = 1; num <= N - K; num++)
      result /= num;
  }
  std::cout << result << '\n';
  return 0;
}
*/