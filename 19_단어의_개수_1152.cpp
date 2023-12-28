// 단어의 개수
// 1152

/*
#include <iostream>
#include <string>

int main()
{
  std::string inputStr;
  int idx = 0, nextIdx, count = 1, strSize;
  getline(std::cin, inputStr);
  strSize = inputStr.size();

  while ((nextIdx = inputStr.find(" ", idx)) != std::string::npos)
  {
    idx = nextIdx + 1;
    if (idx == 1)
      count--;
    if (idx == strSize)
      count--;
    count++;
  }

  std::cout << count << '\n';
  return 0;
}
*/