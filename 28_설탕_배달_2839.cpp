// 설탕 배달
// 2839

/*
#include <iostream>

int main()
{
  int N, fiveCount, fiveMod, result = -1;
  std::cin >> N;

  fiveCount = N / 5;
  fiveMod = N % 5;

  while (fiveCount >= 0)
  {
    if (fiveMod % 3 == 0)
    {
      result = fiveCount + fiveMod / 3;
      break;
    }
    fiveCount--;
    fiveMod = N - 5 * fiveCount;
  }
  std::cout << result << '\n';
  return 0;
}
*/