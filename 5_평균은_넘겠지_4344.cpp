// 평균은 넘겠지
// 4344

/*
#include <cmath>
#include <iostream>
#include <vector>

int main()
{
  std::vector<double> vec;
  int C;
  double N, num;
  std::cin >> C;

  for (int idx = 0; idx < C; idx++)
  {
    int count = 0;
    double sum = 0, avg = 0;
    std::cin >> N;

    for (int idx2 = 0; idx2 < N; idx2++)
    {
      std::cin >> num;
      vec.push_back(num);
      sum += num;
    }
    avg = sum / N;

    for (int idx2 = 0; idx2 < N; idx2++)
    {
      if (vec[idx2] > avg)
        count++;
    }

    std::cout << std::fixed;
    std::cout.precision(3);

    std::cout << std::round((count) / N * 1000) / 10 << "%\n";
    vec.clear();
    vec.shrink_to_fit();
  }
  return 0;
}
*/