/*
// 파일 합치기
// 11066

#include <algorithm>
#include <iostream>
#include <limits.h>
#include <vector>

int T, K, min;

int main()
{
  int num;
  std::cin >> T;

  for (int idx = 0; idx < T; idx++)
  {
    std::cin >> K;
    std::vector<int> sum;
    std::vector<std::vector<int>> DP;
    sum.resize(K + 1, 0);
    DP.resize(K + 1, std::vector<int>(K + 1, 0));

    for (int i = 1; i <= K; i++)
    {
      std::cin >> num;
      sum[i] = sum[i - 1] + num;
    }

    for (int i = 1; i < K; i++)
    {
      for (int start = 1; start + i <= K; start++)
      {
        int end = start + i;
        DP[start][end] = INT_MAX;

        for (int mid = start; mid < end; mid++)
        {
          DP[start][end] = std::min(DP[start][end], DP[start][mid] + DP[mid + 1][end] + sum[end] - sum[start - 1]);
        }
      }
    }

    std::cout << DP[1][K] << '\n';
  }

  return 0;
}
*/