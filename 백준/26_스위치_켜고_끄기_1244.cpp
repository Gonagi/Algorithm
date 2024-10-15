// 스위치 켜고 끄기
// 1244

/*
#include <iostream>
#include <vector>

int main()
{
  int switchCount, studentCount, sex, num;

  std::cin >> switchCount;
  std::vector<int> switchStatus(switchCount + 1);

  for (int idx = 1; idx <= switchCount; idx++)
    std::cin >> switchStatus.at(idx);

  std::cin >> studentCount;

  for (int idx = 0; idx < studentCount; idx++)
  {
    std::cin >> sex >> num;
    if (sex == 1)
    {
      for (int curIdx = num; curIdx <= switchCount; curIdx += num)
      {
        if (switchStatus.at(curIdx) == 0)
          switchStatus.at(curIdx) = 1;
        else
          switchStatus.at(curIdx) = 0;
      }
    }
    else
    {
      if (switchStatus.at(num) == 0)
        switchStatus.at(num) = 1;
      else
        switchStatus.at(num) = 0;

      for (int curDistance = 1;; curDistance++)
      {
        if (num + curDistance > switchCount || num - curDistance <= 0)
          break;
        if (switchStatus.at(num + curDistance) !=
            switchStatus.at(num - curDistance))
          break;
        if (switchStatus.at(num + curDistance) == 0)
        {
          switchStatus.at(num + curDistance) = 1;
          switchStatus.at(num - curDistance) = 1;
        }
        else
        {
          switchStatus.at(num + curDistance) = 0;
          switchStatus.at(num - curDistance) = 0;
        }
      }
    }
  }

  for (int idx = 1; idx <= switchCount; idx++)
  {
    if (idx != 1 && (idx - 1) % 20 == 0)
      std::cout << '\n';
    std::cout << switchStatus.at(idx) << ' ';
  }

  return 0;
}
*/