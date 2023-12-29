// 시험 감독
// 13458

/*
#include <iostream>
#include <vector>

int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);

  int N, B, C;
  long long num = 0;
  std::vector<int> A(1000001);

  std::cin >> N;

  for (int idx = 0; idx < N; idx++)
    std::cin >> A[idx];

  std::cin >> B >> C;

  for (int idx = 0; idx < N; idx++)
  {
    A[idx] -= B;
    if (A[idx] >= 1)
    {
      if (A[idx] % C != 0)
        num++;
      num += A[idx] / C;
    }
    num++;
  }

  std::cout << num << '\n';

  return 0;
}
*/