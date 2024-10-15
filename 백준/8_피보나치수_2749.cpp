// 피보나치 수 3
// 2749

/*
#include <iostream>
#include <vector>

struct Matrix
{
  long long A, B, C, D;
};
Matrix result = {1LL, 1LL, 1LL, 0LL}, base = {1LL, 1LL, 1LL, 0LL};

Matrix operator*(Matrix &m1, Matrix &m2);

int main()
{
  long long n;

  std::cin >> n;

  while (n > 0)
  {
    if (n & 1) // 홀수일때
      result = result * base;

    base = base * base;
    n = n >> 1;
  }

  std::cout << result.D << '\n';
  return 0;
}

Matrix operator*(Matrix &m1, Matrix &m2)
{
  Matrix cal;

  cal.A = (m1.A * m2.A + m1.B * m2.C) % 1000000;
  cal.B = (m1.A * m2.B + m1.B * m2.D) % 1000000;
  cal.C = (m1.A * m2.C + m1.C * m2.D) % 1000000;
  cal.D = (m1.B * m2.C + m1.D * m2.D) % 1000000;

  return cal;
}
*/

// 피사노 주기

/*
#include <iostream>

const int mod = 1000000;
const int p = 15 * mod / 10;
int fib[p] = {0};

int main()
{
  long long n;
  std::cin >> n;

  if (n == 0)
    std::cout << 0 << '\n';
  else if (n == 1)
    std::cout << 1 << '\n';

  else
  {
    fib[0] = 0;
    fib[1] = 1;

    if (n < p)
    {
      for (int idx = 2; idx <= n; idx++)
        fib[idx] = (fib[idx - 1] + fib[idx - 2]) % mod;
    }
    else
    {
      for (int idx = 2; idx < p; idx++)
        fib[idx] = (fib[idx - 1] + fib[idx - 2]) % mod;
    }

    std::cout << fib[n % p] << '\n';
  }

  return 0;
}
*/