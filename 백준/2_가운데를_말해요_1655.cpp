// 가운데를 말해요
// 1655

/*
#include <algorithm>
#include <iostream>
#include <queue>

int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(NULL);
  std::cout.tie(NULL);

  int N, num;
  std::priority_queue<int> left;
  std::priority_queue<int, std::vector<int>, std::greater<int>> right;

  std::cin >> N;

  for (int idx = 0; idx < N; idx++)
  {
    std::cin >> num;
    if (left.size() == right.size())
      left.push(num);

    else
      right.push(num);

    if (!left.empty() && !right.empty())
    {
      int temp1 = left.top();
      int temp2 = right.top();
      if (temp1 > temp2)
      {
        left.pop();
        right.pop();
        left.push(temp2);
        right.push(temp1);
      }
    }
    std::cout << left.top() << '\n';
  }

  return 0;
}
*/