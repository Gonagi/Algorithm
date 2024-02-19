// IOIOI
// 5525

/*
#include <iostream>
#include <string>

int N, M;
std::string S;

int main()
{
  std::ios_base::sync_with_stdio(false);
  std::cin.tie(NULL);
  std::cout.tie(NULL);
  int result = 0;

  std::cin >> N >> M >> S;

  for (int idx = 0; idx < M - (2 * N); idx++)
  {
    int count = 0;
    if (S[idx] == 'O')
      continue;
    while (S[idx + 1] == 'O' && S[idx + 2] == 'I')
    {
      count++;
      if (count == N)
      {
        result++;
        count--;
      }
      idx += 2;
    }
  }

  std::cout << result << '\n';
  return 0;
}
*/