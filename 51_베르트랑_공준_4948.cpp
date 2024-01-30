// 베르트랑 공준
// 4948

/*
#include <iostream>

bool isPrime(int num);

int main()
{
  int n = 1;

  while (1)
  {
    int count = 0;
    std::cin >> n;
    if (n == 0)
      break;
    for (int num = n + 1; num <= 2 * n; num++)
    {
      if (isPrime(num))
        count++;
    }
    std::cout << count << '\n';
  }

  return 0;
}

bool isPrime(int num)
{
  for (int cur = 2; cur * cur <= num; cur++)
  {
    if (num % cur == 0)
      return false;
  }
  return true;
}
*/