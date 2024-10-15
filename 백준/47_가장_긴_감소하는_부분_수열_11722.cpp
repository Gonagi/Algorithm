// 가장 긴 감소하는 부분 수열
// 11722

/*
#include <iostream>
#include <vector>

int main()
{
  std::vector<int> vec, DP;
  int N, max = 0;

  vec.resize(1001, 0);
  DP.resize(1001, 1);
  std::cin >> N;

  for (int idx = 0; idx < N; idx++)
    std::cin >> vec.at(idx);

  for (int idx = 0; idx < N; idx++)
  {
    for (int idx2 = 0; idx2 < idx; idx2++)
    {
      if (vec.at(idx) < vec.at(idx2) && DP[idx] < DP[idx2] + 1)
        DP[idx] = DP[idx2] + 1;
    }
    if (max < DP.at(idx))
      max = DP.at(idx);
  }

  std::cout << max << '\n';
  return 0;
}
*/