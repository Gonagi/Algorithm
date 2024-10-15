/*
// 행렬 곱셈 공식
// 11049

#include <algorithm>
#include <iostream>
#include <limits.h>
#include <utility>
#include <vector>

int main()
{
  int N, r, c;
  std::vector<std::pair<int, int>> vec;
  std::vector<std::vector<long long>> DP;
  std::cin >> N;

  vec.resize(N + 2, {0, 0});
  DP.resize(N + 2, (std::vector<long long>(N + 2, 0)));

  for (int idx = 1; idx <= N; idx++)
  {
    std::cin >> r >> c;
    vec[idx] = {r, c};
  }

  for (int idx = 1; idx < N; idx++)
  {
    for (int start = 1; start + idx <= N; start++)
    {
      int end = start + idx;
      DP[start][end] = INT_MAX;

      for (int mid = start; mid <= end; mid++)
      {
        DP[start][end] = std::min(DP[start][end], DP[start][mid] + DP[mid + 1][end] +
                                                      vec[start].first * vec[mid].second * vec[end].second);
      }
    }
  }

  std::cout << DP[1][N] << '\n';
  return 0;
}
*/