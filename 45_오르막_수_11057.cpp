// 오르막 수
// 11057

/*
#include <iostream>
#include <vector>

int main()
{
  std::vector<std::vector<long long>> DP;
  long long sum = 0;
  int N;

  DP.resize(10001);
  for (int idx = 0; idx < 10001; idx++)
    DP[idx].resize(11, 1);

  std::cin >> N;

  for (int i = 2; i <= N; i++)
    for (int j = 1; j < 10; j++)
      DP[i][j] = (DP[i - 1][j] + DP[i][j - 1]) % 10007;

  for (int idx = 0; idx < 10; idx++)
    sum = (sum + DP[N][idx]) % 10007;

  std::cout << sum << '\n';
  return 0;
}
*/