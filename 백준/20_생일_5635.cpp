// 생일
// 5635

/*
#include <iostream>
#include <string>

struct Info
{
  std::string name;
  int day;
  int month;
  int year;

  Info operator>(const Info &var) const
  {
    if (year < var.year)
      return var;
    else if (year == var.year)
    {
      if (month < var.month)
        return var;
      else if (month == var.month)
      {
        if (day < var.day)
          return var;
      }
    }
    return *this;
  }

  Info operator<(const Info &var) const
  {
    if (year > var.year)
      return var;
    else if (year == var.year)
    {
      if (month > var.month)
        return var;
      else if (month == var.month)
      {
        if (day > var.day)
          return var;
      }
    }
    return *this;
  }
};

int main()
{
  int n, day, month, year;
  std::string name;
  struct Info bigAge, littleAge;

  std::cin >> n;

  for (int idx = 0; idx < n; idx++)
  {
    std::cin >> name >> day >> month >> year;
    struct Info info
    {
      name, day, month, year
    };
    if (idx == 0)
    {
      bigAge = info;
      littleAge = info;
    }
    else
    {
      bigAge = bigAge.operator<(info);
      littleAge = littleAge.operator>(info);
    }
  }
  std::cout << littleAge.name << '\n';
  std::cout << bigAge.name << '\n';
  return 0;
}
*/

/*
#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

int main()
{
  int n;
  std::cin >> n;

  std::vector<
      std::pair<std::pair<int, int>, std::pair<int, std::string>>>
      v(n);

  for (int idx = 0; idx < n; idx++)
  {
    std::cin >> v[idx].second.second >> v[idx].second.first >>
        v[idx].first.second >> v[idx].first.first;
  }

  std::sort(v.begin(), v.end());

  std::cout << v[n - 1].second.second << '\n'
            << v[0].second.second << '\n';
  return 0;
}
*/