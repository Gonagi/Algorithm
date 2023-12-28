// 삼삼한 수
// 17252

/*
#include <iostream>
#include <vector>
#define TRUE 1
#define FALSE 0

int main()
{
  std::vector<int> checkExp(20, FALSE);
  int num, powerNum = 1, check = 0;

  std::cin >> num;
  if (num == 0)
  {
    std::cout << "NO" << '\n';
    return 0;
  }

  while (num)
  {
    while (num > (powerNum * 3) && powerNum * 3 > 0)
    {
      powerNum *= 3;
      check++;
    }

    if (checkExp[check])
    {
      std::cout << "NO" << '\n';
      return 0;
    }
    checkExp[check] = TRUE;
    num -= powerNum;
    powerNum = 1;
    check = 0;
  }

  std::cout << "YES" << '\n';

  return 0;
}
*/

// #include <iostream>

// int main()
// {
//   int num;
//   std::cin >> num;

//   if (!num)
//   {
//     std::cout << "NO" << '\n';
//     return 0;
//   }

//   while (num)
//   {
//     if (num % 3 > 1)
//     {
//       std::cout << "NO" << '\n';
//       return 0;
//     }
//     num /= 3;
//   }
//   std::cout << "YES" << '\n';
//   return 0;
// }
