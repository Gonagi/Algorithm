// 팰린드롬 만들기
// 1254

/*
#include <iostream>
#include <string>

int main()
{
  std::string S;
  std::cin >> S;

  for (int size = S.size();; size++)
  {
    int count = 0;
    for (int cur = 0; cur < size / 2; cur++)
    {
      if (size != S.size() && size - cur - 1 >= S.size())
      {
        count++;
        continue;
      }
      if (S.at(cur) != S.at(size - cur - 1))
        break;
      count++;
    }
    if (count == size / 2)
    {
      std::cout << size << '\n';
      return 0;
    }
  }
  return 0;
}
*/