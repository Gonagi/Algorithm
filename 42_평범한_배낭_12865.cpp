// 평범한 배낭
// 12865

/*
#include <algorithm>
#include <iostream>
#include <utility>
#include <vector>

#define MAX_N 100
#define MAX_K 100000

int main()
{
  int N, K, W, V, max = 0;
  std::vector<std::pair<int, int>> vec;
  std::vector<std::vector<int>> DP;

  vec.resize(MAX_N + 1);
  DP.resize(MAX_N + 1);
  for (int idx = 0; idx <= MAX_N + 1; idx++)
    DP[idx].resize(MAX_K + 1, 0);

  std::cin >> N >> K;

  for (int idx = 1; idx <= N; idx++)
    std::cin >> vec[idx].first >> vec[idx].second;

  for (int n = 1; n <= N; n++)
  {
    for (int k = 1; k <= K; k++)
    {
      if (k < vec[n].first)
        DP[n][k] = DP[n - 1][k];
      else
        DP[n][k] =
            std::max(DP[n - 1][k],
                     DP[n - 1][k - vec[n].first] + vec[n].second);
    }
  }
  std::cout << DP[N][K] << '\n';

  return 0;
}
*/