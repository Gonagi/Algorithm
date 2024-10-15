// 요세푸스 문제
// 1158

/*
#include <iostream>
#include <queue>

int main()
{
  int N, K;
  std::queue<int> circle;

  std::cin >> N >> K;
  for (int idx = 1; idx <= N; idx++)
    circle.push(idx);

  std::cout << '<';
  while (circle.size() != 1)
  {
    for (int idx = 0; idx < K; idx++)
    {
      if (idx == K - 1)
        std::cout << circle.front() << ", ";
      else
        circle.push(circle.front());

      circle.pop();
    }
  }
  std::cout << circle.front() << '>' << '\n';

  return 0;
}
*/