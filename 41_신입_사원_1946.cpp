// 신입 사원
// 1946

/*
#include <algorithm>
#include <iostream>
#include <utility>
#include <vector>

int selectPeople(int N);

int main()
{
  int T, N;

  std::cin >> T;

  for (int idx = 0; idx < T; idx++)
  {
    std::cin >> N;
    int result = selectPeople(N);
    std::cout << result << '\n';
  }

  return 0;
}

int selectPeople(int N)
{
  int document, interview, count = 1;
  std::vector<std::pair<int, int>> vec;
  std::vector<int> lowRating;

  vec.reserve(100001);
  lowRating.reserve(100001);
  for (int idx = 0; idx < N; idx++)
  {
    std::cin >> document >> interview;
    vec.push_back({document, interview});
  }
  std::sort(vec.begin(), vec.end());

  int low = 100001;
  for (int idx = 0; idx < N; idx++)
  {
    if (low > vec.at(idx).second)
      low = vec.at(idx).second;

    lowRating.push_back(low);
  }

  for (int idx = 0; idx < N - 1; idx++)
  {
    if (vec.at(idx + 1).second < lowRating.at(idx))
      count++;
  }
  return count;
}
*/