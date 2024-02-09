// 가장 가까운 세 사람의 심리적 거리
// 20529

/*
#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

int cal(int N, const std::vector<std::string> &vec);
int check(const std::string &str1, const std::string &str2,
          const std::string &str3);

int main()
{
  int T, N;
  std::string str;

  std::cin >> T;

  for (int idx = 0; idx < T; idx++)
  {
    std::cin >> N;
    std::vector<std::string> vec(N);

    for (int idx2 = 0; idx2 < N; idx2++)
      std::cin >> vec[idx2];

    std::cout << cal(N, vec) << '\n';
  }
  return 0;
}

int cal(int N, const std::vector<std::string> &vec)
{
  if (N > 32)
    return 0;

  int min = 1000000000;
  for (int idx = 0; idx < N; idx++)
    for (int idx2 = idx + 1; idx2 < N; idx2++)
      for (int idx3 = idx2 + 1; idx3 < N; idx3++)
        min = std::min(min, check(vec[idx], vec[idx2], vec[idx3]));

  return min;
}

int check(const std::string &str1, const std::string &str2,
          const std::string &str3)
{
  int sum = 0;
  for (int idx = 0; idx < 4; idx++)
  {
    if (str1[idx] != str2[idx])
      sum++;
    if (str1[idx] != str3[idx])
      sum++;
    if (str2[idx] != str3[idx])
      sum++;
  }
  return sum;
}
*/