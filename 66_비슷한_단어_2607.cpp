// 비슷한 단어
// 2607
/*
#include <algorithm>
#include <iostream>
#include <string>
#include <vector>
#define Max 26

std::vector<int> alphabet, check;

int main()
{
  std::string str, str2;
  int N, result = 0, count = 0;

  std::cin >> N;
  alphabet.resize(Max, 0);

  std::cin >> str;
  for (int i = 0; i < str.size(); i++)
    alphabet['Z' - str[i]]++;

  for (int idx = 1; idx < N; idx++)
  {
    count = 0;
    check = alphabet;

    std::cin >> str2;

    for (int i = 0; i < str2.size(); i++)
    {
      if (check['Z' - str2[i]] > 0)
      {
        check['Z' - str2[i]]--;
        count++;
      }
    }

    if (str.size() == str2.size())
    {
      if (count == str.size() || count == str.size() - 1)
        result++;
    }

    else if (str.size() - 1 == str2.size() && count == str.size() - 1)
      result++;

    else if (str.size() + 1 == str2.size() && count == str.size())
      result++;
  }
  std::cout << result << '\n';
  return 0;
}
*/