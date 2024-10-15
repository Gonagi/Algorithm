// 레벨 햄버거
// 16974

/*
#include <iostream>
#include <vector>

#define Max 50

std::vector<long long> p, burger;
long long count(int level, long long idx);

int main()
{
  std::ios_base::sync_with_stdio(false);
  std::cin.tie(NULL);
  std::cout.tie(NULL);

  int N;
  long long X;
  std::cin >> N >> X;
  p.resize(Max + 1, 0);
  burger.resize(Max + 1, 0);
  p[0] = 1;
  burger[0] = 1;

  for (int idx = 1; idx <= N; idx++)
  {
    p[idx] = p[idx - 1] * 2 + 1;
    burger[idx] = 2 * burger[idx - 1] + 3;
  }

  std::cout << count(N, X) << '\n';
  return 0;
}

long long count(int level, long long idx)
{
  if (level == 0)
    return 1;
  if (idx == 1)
    return 0;
  if (idx == burger[level - 1] + 1)
    return p[level - 1];
  if (idx == burger[level - 1] + 2)
    return p[level - 1] + 1;
  if (idx < burger[level - 1] + 1)
    return count(level - 1, idx - 1);
  if (idx < burger[level - 1] * 2 + 3)
    return p[level - 1] + 1 +
           count(level - 1, idx - burger[level - 1] - 2);
  else
    return 2 * p[level - 1] + 1;
}
*/