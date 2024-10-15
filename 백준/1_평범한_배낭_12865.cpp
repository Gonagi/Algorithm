// 평범한 배낭
// 12865

/*
#include <algorithm>
#include <iostream>
#include <utility>
#include <vector>

int max = 0;
std::vector<std::pair<int, int>> vec;

int main()
{
  int N, K, W, V; // 개수, 한계, 무게, 가치
  std::cin >> N >> K;

  for (int idx = 0; idx < N; idx++)
  {
    std::cin >> W >> V;
    vec.push_back({W, V});
  }

  std::vector<std::vector<int>> DP(N + 1, std::vector<int>(K + 1, 0));

  for (int i = 1; i <= N; i++)
  {
    for (int j = 1; j <= K; j++)
    {
      if (j < vec[i - 1].first)
        DP[i][j] = DP[i - 1][j];
      else
      {
        DP[i][j] = std::max(DP[i - 1][j], vec[i - 1].second + DP[i - 1][j - vec[i - 1].first]);
      }
    }
  }

  std::cout << DP[N][K] << '\n';

  return 0;
}
*/

/* 시간초과
#include <algorithm>
#include <iostream>
#include <utility>
#include <vector>

int max = 0;
std::vector<std::pair<int, int>> vec;

int main() {
  int N, K, W, V;  // 개수, 한계, 무게, 가치
  std::cin >> N >> K;

  for (int idx = 0; idx < N; idx++) {
    std::cin >> W >> V;
    vec.push_back({W, V});
  }

  for (int i = 1; i < (1 << vec.size()); i++) {
    int weight_check = 0;
    int value_check = 0;

    for (int j = 0; j < vec.size(); j++) {
      if (i & (1 << j)) {

        if (K >= weight_check + vec[j].first) {
          weight_check += vec[j].first;
          value_check += vec[j].second;
        }
      }
    }

        for (int j = 0; j < vec.size(); j++)
        {
        if (i & (1 << j))
           {
           if (K >= weight_check + vec[j].first)
           {
               weight_check += vec[j].first;
               value_check += vec[j].second;
            }
        }
    }
    if (max < value_check)
      max = value_check;
  }

  std::cout << max << '\n';

  return 0;
}
*/